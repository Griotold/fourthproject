package com.example.fourthproject.web;

import com.example.fourthproject.config.auth.dto.SessionUser;
import com.example.fourthproject.domain.posts.Posts;
import com.example.fourthproject.service.posts.PostsService;
import com.example.fourthproject.web.dto.PostsListResponseDto;
import com.example.fourthproject.web.dto.PostsResponseDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import javax.servlet.http.HttpSession;
import java.util.List;

@Slf4j
@RequiredArgsConstructor
@Controller
public class IndexController {

    private final PostsService postsService;
    private final HttpSession httpSession;
    @GetMapping("/")
    public String index(Model model) {
        model.addAttribute("posts", postsService.findAllDesc());
        SessionUser user = (SessionUser) httpSession.getAttribute("user");
        if (user != null) {
            model.addAttribute("userName", user.getName());
        }
        return "index";
    }

    @GetMapping("/posts/save") // 등록 화면 불러오기
    public String postsSave() {
        return "posts-save";
    }

    @GetMapping("/posts/update/{id}") // 수정 화면 불러오기
    public String postsUpdate(@PathVariable Long id, Model model) {
        PostsResponseDto dto = postsService.findById(id);
        model.addAttribute("post", dto);

        return "posts-update";
    }
}
