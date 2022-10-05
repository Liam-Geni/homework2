package com.sparta.week04.controller;


import com.sparta.week04.dto.ProductMypriceRequestDto;
import com.sparta.week04.dto.ProductRequestDto;
import com.sparta.week04.dto.ProductResponseDto;
import com.sparta.week04.entity.Product;
import com.sparta.week04.repository.ProductRepository;
import com.sparta.week04.service.ProductService;
import com.sparta.week04.utils.NaverShopSearch;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class ProductRestController {

    private final ProductRepository productRepository;
    private final ProductService productService;

    private final NaverShopSearch naverShopSearch;

    @GetMapping("/api/products")
    public List<ProductResponseDto> getProducts(){


        return productService.show();
    }

    @PostMapping("/api/products")
    public ProductResponseDto createProduct(@RequestBody ProductRequestDto requestDto){
        return productService.create(requestDto);
    }

    @PutMapping("/api/products/{id}")
    public Long updatePrice(@PathVariable Long id, @RequestBody ProductMypriceRequestDto requestDto){
        return productService.updatePrice(id, requestDto);
    }
}
