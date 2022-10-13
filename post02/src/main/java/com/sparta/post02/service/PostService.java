package com.sparta.post02.service;

import com.sparta.post02.dto.DetailPostResponseDto;
import com.sparta.post02.dto.PostListResponseDto;
import com.sparta.post02.dto.PostRequestDto;
import com.sparta.post02.dto.PostResponseDto;
import com.sparta.post02.entity.Post;
import com.sparta.post02.entity.User;
import com.sparta.post02.repository.PostRepository;
import com.sparta.post02.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class PostService {

    private final UserRepository userRepository;

    private final PostRepository postRepository;

    private User getUser(String username){
        return userRepository.findByUsername(username).orElseThrow(
                () -> new UsernameNotFoundException("해당유저를 찾을 수 없습니다. ")
        );

    }
    //게시글 등록
    public PostResponseDto createPost(PostRequestDto postRequestDto, String username) {
        User user = getUser(username);
        Post post = new Post(postRequestDto, user);
        postRepository.save(post);
        return new PostResponseDto(post);
    }

    //게시글 전체 조회
    public List<PostListResponseDto> getPosts(){
        List<Post> list = postRepository.findAllByOrderByModifiedAtDesc();
        List<PostListResponseDto> pList = new ArrayList<>();
        for(Post post : list){
            PostListResponseDto listDto = PostListResponseDto.builder()
                    .id(post.getId())
                    .title(post.getTitle())
                    .author(post.getUser().getUsername())
                    .createdAt(post.getCreatedAt())
                    .modifiedAt(post.getModifiedAt())
                    .build();
            pList.add(listDto);
        }
        return pList;
    }

    //게시글 조회
    public DetailPostResponseDto getPost(Long id) {
        Post post = postRepository.findById(id).orElseThrow(
                () -> new IllegalArgumentException("해당 유저를 찾을 수 없습니다.")
        );
        return new DetailPostResponseDto(post);
    }

    //게시글 수정
    public PostResponseDto updatePost(Long id, PostRequestDto postRequestDto, String username){
        User user = getUser(username);
        Post post = postRepository.findById(id).orElseThrow(
                () -> new IllegalArgumentException("해당하는 게시글이 없습니다.")
        );
        if(!post.getUser().getUsername().equals(user.getUsername()))
            throw new IllegalArgumentException("작성자만 수정할 수 있습니다.");
        post.update(postRequestDto);
        postRepository.save(post);
        return new PostResponseDto(post);
    }

    //게시글 삭제
    public void deletePost(Long id, String username){
        User user = getUser(username);
        Post post = postRepository.findById(id).orElseThrow(
                () -> new IllegalArgumentException("해당 글이 존재하지 않습니다.")
        );
        if(!post.getUser().getUsername().equals(user.getUsername()))
            throw new IllegalArgumentException("작성자만 삭제할 수 있습니다.");
        postRepository.deleteById(id);
    }
}
