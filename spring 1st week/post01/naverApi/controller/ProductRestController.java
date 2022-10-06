package com.sparta.naverApi.controller;


import com.sparta.naverApi.dto.ProductMypriceRequestDto;
import com.sparta.naverApi.dto.ProductRequestDto;
import com.sparta.naverApi.dto.ProductResponseDto;
import com.sparta.naverApi.repository.ProductRepository;
import com.sparta.naverApi.service.ProductService;
import com.sparta.naverApi.utils.NaverShopSearch;
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
