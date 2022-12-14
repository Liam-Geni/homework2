package com.sparta.naverApi.entity;

import com.sparta.naverApi.dto.ProductMypriceRequestDto;
import com.sparta.naverApi.dto.ProductRequestDto;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Getter
@NoArgsConstructor
public class Product extends Timestamped{

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(nullable = false)
    private String title;

    @Column(nullable = false)
    private String link;

    @Column(nullable = false)
    private String image;

    @Column(nullable = false)
    private int lprice;

    @Column(nullable = false)
    private int myprice;

    public Product(ProductRequestDto requestDto){
        this.title = requestDto.getTitle();
        this.image = requestDto.getImage();
        this.link = requestDto.getLink();
        this.lprice = requestDto.getLprice();
        this.myprice = 0;
    }

    public Product(ProductMypriceRequestDto requestDto){

        this.myprice = requestDto.getMyprice();
    }

    public void update(ProductMypriceRequestDto requestDto){

        this.myprice = requestDto.getMyprice();
    }
}
