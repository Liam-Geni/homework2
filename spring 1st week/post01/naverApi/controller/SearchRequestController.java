package com.sparta.naverApi.controller;



import com.sparta.naverApi.dto.ItemDto;
import com.sparta.naverApi.service.ProductService;
import com.sparta.naverApi.utils.NaverShopSearch;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequiredArgsConstructor
@RestController
public class SearchRequestController {

    private final NaverShopSearch naverShopSearch;
    private final ProductService productService;


    @GetMapping("/api/search")
    public List<ItemDto> getItems(@RequestParam String query){
        return productService.getItems(query);
    }

}
