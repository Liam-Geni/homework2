package com.sparta.test01.dto;

import com.sparta.test01.entity.Member;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class MemberInfoResponseDto {

    private Long id;
    private String name;
    private String email;
    private String pw;

    public MemberInfoResponseDto(Member member){
        this.name = member.getName();
        this.email = member.getEmail();
        this.pw = member.getPw();
    }
}
