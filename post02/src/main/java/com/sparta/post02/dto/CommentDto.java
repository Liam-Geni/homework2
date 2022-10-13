package com.sparta.post02.dto;

import com.sparta.post02.entity.User;
import lombok.Getter;

@Getter
public class CommentDto {
    private User user;
    private String comment;
    private Long postId;
}
