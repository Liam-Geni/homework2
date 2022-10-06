package com.sparta.naverApi.repository;

import com.sparta.naverApi.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {

}
