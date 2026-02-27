package com.esun.ebank_backend.Service;

import com.esun.ebank_backend.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Service
public class OrderService {

    @Autowired
    private OrderRepository orderRepository;

    /**
     * 處理新增訂單的邏輯
     * @Transactional 確保 Procedure 執行失敗時會自動 Rollback，避免資料錯亂
     */
    @Transactional(rollbackFor = Exception.class)
    public void placeOrder(String memberId, String productId, Integer qty) {

        // 1. 生成訂單編號 (格式參考圖片：Ms + 時間戳記)
        String orderId = "Ms" + LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyyMMddHHmmss"));

        // 2. 呼叫 Repository 中的預存程序
        // 這會同時處理：檢查庫存、扣庫存、新增 Orders、新增 OrderDetail
        orderRepository.callCreateOrder(orderId, memberId, productId, qty);
    }
}