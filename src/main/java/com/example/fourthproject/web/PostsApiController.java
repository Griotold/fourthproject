package com.example.fourthproject.web;

import com.example.fourthproject.service.posts.PostsService;
import com.example.fourthproject.web.dto.PostsResponseDto;
import com.example.fourthproject.web.dto.PostsSaveRequestDto;
import com.example.fourthproject.web.dto.PostsUpdateRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor // Autowired 보다 생성자로 Bean객체를 주입받는 게 좋다.
@RestController
public class PostsApiController {
    // final로 선언된 모든 필드를 파라미터로 하는 생성자를 @RequiredArgsConstructor가 대신 생성해준다.
    private final PostsService postsService;

    // 게시글 등록
    @PostMapping("/api/v1/posts")
    public Long save(@RequestBody PostsSaveRequestDto requestDto){

        return postsService.save(requestDto);
    }

    // 게시글 수정
    @PutMapping("/api/v1/posts/{id}")
    public Long update(@PathVariable Long id, @RequestBody PostsUpdateRequestDto requestDto) {
        return postsService.update(id, requestDto);
    }

    // 게시글 조회
    @GetMapping("/api/v1/posts/{id}")
    public PostsResponseDto findByid(@PathVariable Long id){
        return postsService.findById(id);
    }

    // 게시글 삭제
    @DeleteMapping("/api/v1/posts/{id}")
    public Long delete(@PathVariable Long id) {
        postsService.delete(id);
        return id;
    }
}
