package com.esun.ebank_backend.Service;

import com.esun.ebank_backend.entity.Product;
import com.esun.ebank_backend.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }
    public Product addProduct(Product product) {
        return productRepository.save(product);
    }
}