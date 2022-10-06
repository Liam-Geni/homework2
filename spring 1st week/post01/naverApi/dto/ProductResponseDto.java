package com.sparta.naverApi.dto;


import com.sparta.naverApi.entity.Product;
import lombok.Getter;

@Getter
public class ProductResponseDto {
    private String title;
    private String image;
    private String link;
    private int lprice;

    public ProductResponseDto(Product product){
        this.title = product.getTitle();
        this.image = product.getImage();
        this.link = product.getLink();
        this.lprice = product.getLprice();
    }
}
