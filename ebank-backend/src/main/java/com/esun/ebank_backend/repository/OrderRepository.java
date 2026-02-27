package com.esun.ebank_backend.repository;

import com.esun.ebank_backend.entity.orders;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderRepository extends JpaRepository<orders, String> {

    @Procedure(procedureName = "sp_CreateOrder")
    void callCreateOrder(
            @Param("p_OrderID") String orderId,
            @Param("p_MemberID") String memberId,
            @Param("p_ProductID") String productId,
            @Param("p_Qty") Integer qty
    );
}