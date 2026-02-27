DELIMITER //

CREATE PROCEDURE sp_CreateOrder(
    IN p_OrderID VARCHAR(20),
    IN p_MemberID VARCHAR(20),
    IN p_ProductID VARCHAR(10),
    IN p_Qty INT
)
BEGIN
    DECLARE v_Price INT;
    DECLARE v_Stock INT;
    
    -- 啟動事務
    START TRANSACTION;

    -- 1. 取得商品單價與目前庫存
    SELECT Price, Quantity INTO v_Price, v_Stock FROM Product WHERE ProductID = p_ProductID FOR UPDATE;

    -- 2. 檢查庫存是否充足
    IF v_Stock >= p_Qty THEN
        -- 3. 扣除商品庫存
        UPDATE Product SET Quantity = Quantity - p_Qty WHERE ProductID = p_ProductID;

        -- 4. 寫入訂單主檔
        INSERT INTO Orders (OrderID, MemberID, Price, PayStatus) 
        VALUES (p_OrderID, p_MemberID, v_Price * p_Qty, 0);

        -- 5. 寫入訂單明細
        INSERT INTO OrderDetail (OrderID, ProductID, Quantity, StandPrice, ItemPrice)
        VALUES (p_OrderID, p_ProductID, p_Qty, v_Price, v_Price * p_Qty);

        COMMIT;
    ELSE
        -- 庫存不足則回滾
        ROLLBACK;
        SIGNAL SQLSTATE '45000' SET MESSAGE_TEXT = '庫存不足';
    END IF;
END //

DELIMITER ;