package com.sparta.test01.controller;


import com.sparta.test01.dto.MemberInfoResponseDto;
import com.sparta.test01.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class MemberController {

    private final MemberService memberService;

    @GetMapping("/member")
    public List<MemberInfoResponseDto> getMemberList(){

        return memberService.findAllMember();
    }

    @GetMapping("/member/{id}")
    public List<MemberInfoResponseDto> getMemberInfo(@PathVariable Long id){
        return memberService.findMember(id);
    }

}
