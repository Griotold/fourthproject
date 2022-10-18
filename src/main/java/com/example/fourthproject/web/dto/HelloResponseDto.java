package com.example.fourthproject.web.dto;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor // 모든 final필드들만 포함된 생성자
public class HelloResponseDto {
    
    private final String name;
    private final int amount;
}
