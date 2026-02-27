package com.esun.ebank_backend.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "Orders")
@Data
public class orders {

    @Id
    @Column(name = "OrderID")
    private String orderId;

    @Column(name = "MemberID")
    private String memberId;

    @Column(name = "Price")
    private Integer price;

    @Column(name = "PayStatus")
    private Integer payStatus; // 0 未付款, 1 已付款
}