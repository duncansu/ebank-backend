-- 1. 商品表 (Product)
CREATE TABLE Product (
    ProductID VARCHAR(10) PRIMARY KEY,
    ProductName NVARCHAR(100) NOT NULL,
    Price INT NOT NULL,
    Quantity INT NOT NULL
);

-- 2. 訂單主表 (Orders)
CREATE TABLE Orders (
    OrderID VARCHAR(20) PRIMARY KEY,
    MemberID VARCHAR(20) NOT NULL,
    Price INT NOT NULL,
    PayStatus INT DEFAULT 0 -- 0:未付款, 1:已付款
);

-- 3. 訂單明細表 (OrderDetail)
CREATE TABLE OrderDetail (
    OrderItemSN INT AUTO_INCREMENT PRIMARY KEY,
    OrderID VARCHAR(20),
    ProductID VARCHAR(10),
    Quantity INT,
    StandPrice INT, -- 單價
    ItemPrice INT,  -- 單項小計
    FOREIGN KEY (OrderID) REFERENCES Orders(OrderID),
    FOREIGN KEY (ProductID) REFERENCES Product(ProductID)
);