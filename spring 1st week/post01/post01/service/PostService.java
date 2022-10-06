package com.sparta.post01.service;

import com.sparta.post01.dto.PostRequestDto;
import com.sparta.post01.entity.Post;
import com.sparta.post01.repository.PostRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import javax.transaction.Transactional;

@Service
@RequiredArgsConstructor
public class PostService {
    private final PostRepository postRepository;
    @Transactional
    public Long update(Long id, @RequestBody PostRequestDto requestDto){
        Post post = postRepository.findById(id).orElseThrow(
                () -> new IllegalArgumentException("해당 ID가 존재하지 않습니다.")
        );

        post.update(requestDto);
        return post.getId();
    }
}
