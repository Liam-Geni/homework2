package com.sparta.post02.service;


import com.sparta.post02.dto.TokenDto;
import com.sparta.post02.dto.UserRequestDto;
import com.sparta.post02.dto.UserResponseDto;
import com.sparta.post02.entity.RefreshToken;
import com.sparta.post02.entity.User;
import com.sparta.post02.jwt.provider.JwtProvider;
import com.sparta.post02.repository.RefreshTokenRopository;
import com.sparta.post02.repository.UserRepository;
import jdk.swing.interop.SwingInterOpUtils;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.servlet.http.HttpServletResponse;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    private final RefreshTokenRopository refreshTokenRepository;
    private final AuthenticationManagerBuilder authenticationManagerBuilder;

    private final JwtProvider jwtProvider;

    //회원가입
    public UserResponseDto registerUser(UserRequestDto userRequestDto) throws IllegalAccessException{
        String username = userRequestDto.getUsername();
        String password = userRequestDto.getPassword();
        String samepassword = userRequestDto.getSamepassword();

        Optional<User> found = userRepository.findByUsername(username);
        if(found.isPresent()){
            throw new IllegalAccessException("중복 닉네임 확인!");
        }
        if(!password.equals(samepassword)){
            throw new IllegalAccessException("비밀번호가 서로 다릅니다.");
        }
        password = passwordEncoder.encode(userRequestDto.getPassword());
        UserRequestDto dto = UserRequestDto.builder()
                .username(username)
                .password(password)
                .samepassword(password)
                .build();
        User user = new User(dto);
        userRepository.save(user);

        return new UserResponseDto(user);
    }

    //로그인
    public UserResponseDto login(UserRequestDto userRequestDto, HttpServletResponse httpServletResponse) {

        // 1. Login ID/PW 를 기반으로 AuthenticationToken 생성
        UsernamePasswordAuthenticationToken authenticationToken
                = new UsernamePasswordAuthenticationToken(userRequestDto.getUsername(), userRequestDto.getPassword());

        // 2. 실제로 검증 (사용자 비밀번호 체크) 이 이루어지는 부분
        //    authenticate 메서드가 실행이 될 때 CustomUserDetailsService 에서 만들었던 loadUserByUsername 메서드가 실행됨
        Authentication authentication = authenticationManagerBuilder.getObject().authenticate(authenticationToken);

        TokenDto tokenDto = jwtProvider.generateTokenDto(authentication);

        RefreshToken refreshToken = RefreshToken.builder()
                .key(authentication.getName())
                .value(tokenDto.getRefreshToken())
                .build();

        refreshTokenRepository.save(refreshToken);

        httpServletResponse.addHeader("Access-Token", tokenDto.getGrantType() + " " + tokenDto.getAccessToken());
        httpServletResponse.addHeader("Refresh-Token", tokenDto.getRefreshToken());

        User user = userRepository.findByUsername(userRequestDto.getUsername()
                )
                .orElseThrow(
                        () -> new UsernameNotFoundException("유저를 찾을 수 없습니다.")
                );
        return new UserResponseDto(user);
    }
}
