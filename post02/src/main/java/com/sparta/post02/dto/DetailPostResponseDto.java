package com.sparta.post02.dto;

import com.sparta.post02.entity.Post;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class DetailPostResponseDto {
    private Long id;
    private String title;
    private String author;
    private String contents;
    private LocalDateTime createAt;
    private LocalDateTime modifiedAt;

    public DetailPostResponseDto(Post post){
        this.id = post.getId();
        this.title = post.getTitle();
        this.author = post.getUser().getUsername();
        this.contents = post.getContents();
        this.createAt = post.getCreatedAt();
        this.modifiedAt = post.getModifiedAt();
    }
}
