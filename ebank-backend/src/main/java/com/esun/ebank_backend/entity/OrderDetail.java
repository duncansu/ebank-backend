package com.esun.ebank_backend.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "OrderDetail")
@Data
public class OrderDetail {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "OrderItemSN")
    private Integer orderItemSN;

    @Column(name = "OrderID")
    private String orderId;

    @Column(name = "ProductID")
    private String productId;

    private Integer quantity;
    private Integer standPrice;
    private Integer itemPrice;
}