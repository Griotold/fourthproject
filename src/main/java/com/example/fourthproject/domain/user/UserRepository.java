package com.example.fourthproject.domain.user;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    // 소셜 로그인으로 반환되는 값중 이메일을 통해 가입된 유저인지 판단하기 위해
    Optional<User> findByEmail(String email); 
    
}
