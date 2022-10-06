package com.sparta.naverApi.service;

import com.sparta.naverApi.dto.ItemDto;
import com.sparta.naverApi.dto.ProductMypriceRequestDto;
import com.sparta.naverApi.dto.ProductRequestDto;
import com.sparta.naverApi.dto.ProductResponseDto;
import com.sparta.naverApi.entity.Product;
import com.sparta.naverApi.repository.ProductRepository;
import com.sparta.naverApi.utils.NaverShopSearch;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ProductService {

    private final ProductRepository productRepository;
    private final NaverShopSearch naverShopSearch;

    @Transactional
    public ProductResponseDto create(@RequestBody ProductRequestDto requestDto){
        Product product = productRepository.save(new Product(requestDto));
        return new ProductResponseDto(product);
    }
    @Transactional
    public List<ProductResponseDto> show(){
        return productRepository.findAll().stream()
                .map(ProductResponseDto::new)
                .collect(Collectors.toList());
    }

    @Transactional
    public List<ItemDto> getItems(@RequestParam String query){
        String resultString = naverShopSearch.search(query);
        return naverShopSearch.fromJSONtoItems(resultString);
    }

    @Transactional
    public Long updatePrice(Long id, @RequestBody ProductMypriceRequestDto requestDto){
        Product product = productRepository.findById(id).orElseThrow(
                () -> new IllegalArgumentException("해당 아이디가 존재하지 않습니다.")
        );
        product.update(requestDto);
        return product.getId();
    }
}
