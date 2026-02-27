package com.esun.ebank_backend.repository;

import com.esun.ebank_backend.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<Product, String> {
    // 繼承 JpaRepository 後，基本的 findAll, findById 都可以直接使用
}