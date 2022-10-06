package com.sparta.memo.dto;


import com.sparta.memo.entity.Memo;

public class MemoUsernameResponseDto {
    private String username;

    public MemoUsernameResponseDto(Memo memo){
        this.username = memo.getUsername();
    }

    public String getUsername(){
        return this.username;
    }
}
