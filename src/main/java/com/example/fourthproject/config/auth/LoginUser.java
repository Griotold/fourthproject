package com.example.fourthproject.config.auth;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.PARAMETER) // 해당 어노테이션은 파라미터에 생성될 수 있다.
@Retention(RetentionPolicy.RUNTIME) // 유지 기간 설정
public @interface LoginUser {
}
