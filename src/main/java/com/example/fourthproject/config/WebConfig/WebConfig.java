package com.example.fourthproject.config.WebConfig;

import com.example.fourthproject.config.auth.LoginUserArgumentResolver;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.List;

@RequiredArgsConstructor
@Configuration            // LoginUserArgumentResolver가 스프링에서 인식될 수 있도록
public class WebConfig implements WebMvcConfigurer {

    private final LoginUserArgumentResolver loginUserArgumentResolver;

    @Override
    public void addArgumentResolvers(List<HandlerMethodArgumentResolver> argumentsResolvers) {
        argumentsResolvers.add(loginUserArgumentResolver);
        // HandlerMethodArgumentResolver는 항상 해당 메소드를 통해 추가해야 한다.
    }
}
