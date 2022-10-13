package com.sparta.post02.controller;


import com.sparta.post02.dto.DetailPostResponseDto;
import com.sparta.post02.dto.PostListResponseDto;
import com.sparta.post02.dto.PostRequestDto;
import com.sparta.post02.dto.PostResponseDto;
import com.sparta.post02.entity.Post;
import com.sparta.post02.security.UserDetailImp;
import com.sparta.post02.security.UserDetailServiceImp;
import com.sparta.post02.service.PostService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class PostController {

    private final PostService postService;

    //글 작성
    @PostMapping("/api/auth/posts")
    public PostResponseDto createPost(@RequestBody PostRequestDto postRequestDto, @AuthenticationPrincipal UserDetailImp userDetail){
        return postService.createPost(postRequestDto, userDetail.getUsername());
    }

    //전체 조회
    @GetMapping("/api/posts")
    public List<PostListResponseDto> getPosts(){
        return postService.getPosts();
    }

    //글상세보기
    @GetMapping("/api/posts/{id}")
    public DetailPostResponseDto getPost(@PathVariable Long id){
        return postService.getPost(id);

    }

    //글 수정
    @PutMapping("/api/auth/posts/{id}")
    public PostResponseDto updatePost(@PathVariable Long id, @RequestBody PostRequestDto postRequestDto, @AuthenticationPrincipal UserDetailImp userDetail){
        return postService.updatePost(id, postRequestDto, userDetail.getUsername());
    }

    @DeleteMapping("/api/auth/posts/{id}")
    public Long deletePost(@PathVariable Long id, @AuthenticationPrincipal UserDetailImp userDetail){
        postService.deletePost(id, userDetail.getUsername());
        return id;
    }
}
