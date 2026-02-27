package com.esun.ebank_backend.controller;
import com.esun.ebank_backend.Service.OrderService;
import com.esun.ebank_backend.Service.ProductService;
import com.esun.ebank_backend.entity.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "*")
public class ProductController {

    @Autowired
    private ProductService productService;

    @Autowired
    private OrderService orderService;

    // 檢查 1：確保有這個處理「新增商品」的 POST 映射
    @PostMapping("/products")
    public Product addProduct(@RequestBody Product product) {
        return productService.addProduct(product);
    }

    // 檢查 2：確保有這個處理「建立訂單」的 POST 映射
    @PostMapping("/orders")
    public ResponseEntity<?> createOrder(@RequestBody Map<String, Object> payload) {
        try {
            String memberId = payload.get("memberId").toString();
            String productId = payload.get("productId").toString();
            Integer qty = Integer.parseInt(payload.get("qty").toString());

            orderService.placeOrder(memberId, productId, qty);
            return ResponseEntity.ok("訂單建立成功！");
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("失敗：" + e.getMessage());
        }
    }

    @GetMapping("/products")
    public List<Product> getProducts() {
        return productService.getAllProducts();
    }
}