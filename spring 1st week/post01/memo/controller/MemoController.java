package com.sparta.memo.controller;


import com.sparta.memo.dto.MemoRequestDto;
import com.sparta.memo.dto.MemoResponseDto;
import com.sparta.memo.dto.MemoUsernameResponseDto;
import com.sparta.memo.entity.Memo;
import com.sparta.memo.repository.MemoRepository;
import com.sparta.memo.service.MemoService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
public class MemoController {

    public final MemoRepository memoRepository;
    public final MemoService memoService;

    public MemoController(MemoRepository memoRepository, MemoService memoService) {
        this.memoRepository = memoRepository;
        this.memoService = memoService;
    }

    @GetMapping("/api/memos")
    public List<MemoResponseDto> getMemos(){
        return memoRepository.findAll().stream()
                .map(MemoResponseDto::new)
                .collect(Collectors.toList());
    }
    @GetMapping("/api/memos/user/{id}")
    public List<MemoUsernameResponseDto> getUsername(@PathVariable Long id){
        return memoRepository.findById(id).stream()
                .map(MemoUsernameResponseDto::new)
                .collect(Collectors.toList());
    }

    @GetMapping("/api/memos/{id}")
    public List<MemoResponseDto> getMemo(@PathVariable Long id){
        return memoRepository.findById(id).stream()
                .map(MemoResponseDto::new)
                .collect(Collectors.toList());
    }

    @PostMapping("/api/memos")
    public MemoResponseDto createMemos(@RequestBody MemoRequestDto requestDto){
        Memo memo = memoRepository.save(new Memo(requestDto));
        return new MemoResponseDto(memo);
    }

    @PutMapping("/api/memos/{id}")
    public Long update(@PathVariable Long id, @RequestBody MemoRequestDto requestDto){
        return memoService.update(id, requestDto);
    }

    @DeleteMapping("/api/memos/{id}")
    public Long Delete(@PathVariable Long id){
        memoRepository.deleteById(id);
        return new MemoResponseDto().getId();
    }

}
