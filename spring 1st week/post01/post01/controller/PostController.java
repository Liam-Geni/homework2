package com.sparta.post01.controller;

import com.sparta.post01.util.ResponseMessage;
import com.sparta.post01.util.StatusCode;
import com.sparta.post01.dto.PostRequestDto;
import com.sparta.post01.entity.DefaultRes;
import com.sparta.post01.entity.Post;
import com.sparta.post01.repository.PostRepository;
import com.sparta.post01.service.PostService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class PostController {

    private final PostRepository postRepository;
    private final PostService postService;

    //전체 게시글 조회
    @GetMapping("/api/posts")
    public ResponseEntity getPosts(){
        try{
            return new ResponseEntity<>(DefaultRes.res(StatusCode.OK, ResponseMessage.READ_POST, postRepository.findAll()), HttpStatus.OK);
        }catch(Exception E){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    //id값으로 게시글 조회
    @GetMapping("/api/posts/{id}")
    public ResponseEntity getPostsByid(@PathVariable Long id){
        try{
            return new ResponseEntity<>(DefaultRes.res(StatusCode.OK, ResponseMessage.READ_POST, postRepository.findById(id)), HttpStatus.OK);
        }catch(Exception E){
            return  new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    //게시물 등록
    @PostMapping("/api/posts")
    public ResponseEntity createPosts(@RequestBody PostRequestDto requestDto){//게시물 등록
        try{
            Post post = new Post(requestDto);
            return new ResponseEntity<>(DefaultRes.res(StatusCode.CREATED, ResponseMessage.CREATED_POST, postRepository.save(post)), HttpStatus.OK);
        }catch( Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    //비밀번호 수정
    @PatchMapping("/api/posts/{id}/{password}")
    public ResponseEntity<Post> updatePassword(@PathVariable Long id, @PathVariable String password){
        try{
            Post post = postRepository.findById(id).get();
            post.setPassword(password);
            return new ResponseEntity<Post>(postRepository.save(post), HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    //게시글 수정
    @PutMapping("/api/posts/{id}")
    public Long updatePosts(@PathVariable Long id, @RequestBody PostRequestDto requestDto){
        return postService.update(id, requestDto);
    }

    //게시글 삭제
    @DeleteMapping("/api/posts/{id}")
    public Long deletePosts(@PathVariable Long id){
        postRepository.deleteById(id);
        return id;
    }
}
