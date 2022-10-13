package com.sparta.post02.controller;


import com.sparta.post02.dto.UserRequestDto;
import com.sparta.post02.dto.UserResponseDto;
import com.sparta.post02.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

@RestController
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;
    //회원가입
    @PostMapping("/api/user/signup")
    public UserResponseDto signup(@RequestBody @Valid UserRequestDto userRequestDto) throws IllegalAccessException {
        return userService.registerUser(userRequestDto);
    }

    //로그인
    @PostMapping("/api/user/login")
    public UserResponseDto login(@RequestBody UserRequestDto userRequestDto, HttpServletResponse httpServletResponse){
        return userService.login(userRequestDto, httpServletResponse);

    }
}
