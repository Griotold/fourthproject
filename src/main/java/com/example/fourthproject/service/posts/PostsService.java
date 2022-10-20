package com.example.fourthproject.service.posts;

import com.example.fourthproject.domain.posts.Posts;
import com.example.fourthproject.domain.posts.PostsRepository;
import com.example.fourthproject.web.dto.PostsResponseDto;
import com.example.fourthproject.web.dto.PostsSaveRequestDto;
import com.example.fourthproject.web.dto.PostsUpdateRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor // Autowired 보다 생성자로 Bean객체를 주입받는 게 좋다.
@Service
public class PostsService {
    private final PostsRepository postsRepository;

    @Transactional
    public Long save(PostsSaveRequestDto requestDto) {
        return postsRepository.save(requestDto.toEntity()).getId();
    }

    @Transactional
    public Long update(Long id, PostsUpdateRequestDto requestDto) {
        // 게시글을 id로 가져오기
        Posts posts = postsRepository.findById(id).orElseThrow(() -> new
                IllegalArgumentException("해당 게시글이 없습니다. id="+ id));

        // 수정요청 DTO로 업데이트하기
        posts.update(requestDto.getTitle(), requestDto.getContent());

        return id;

    }

    public PostsResponseDto findById(Long id) {
        Posts entity = postsRepository.findById(id)
                .orElseThrow(() -> new
                        IllegalArgumentException("해당 게시글이 없습니다. id=" + id));

        return new PostsResponseDto(entity);
    }
}
