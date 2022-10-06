package com.sparta.test01.service;


import com.sparta.test01.dto.MemberInfoResponseDto;
import com.sparta.test01.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class MemberService {

    public final MemberRepository memberRepository;


    @Transactional
    public List<MemberInfoResponseDto> findAllMember(){
        return memberRepository.findAll().stream()
                .map(MemberInfoResponseDto::new)
                .collect(Collectors.toList());
    }
    @Transactional
    public List<MemberInfoResponseDto> findMember(Long id){
        return memberRepository.findById(id).stream()
                .map(MemberInfoResponseDto::new)
                .collect(Collectors.toList());
    }
}
