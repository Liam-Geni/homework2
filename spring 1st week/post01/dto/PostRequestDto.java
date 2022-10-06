package com.sparta.post01.dto;


import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class PostRequestDto {
    private LocalDateTime createdAt;
    private LocalDateTime modifiedAt;
    private String title;
    private String content;
    private String author;
    private String password;
}
