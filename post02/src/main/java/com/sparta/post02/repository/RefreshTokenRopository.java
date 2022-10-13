package com.sparta.post02.repository;

import com.sparta.post02.entity.RefreshToken;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RefreshTokenRopository extends JpaRepository<RefreshToken, Long> {

}
