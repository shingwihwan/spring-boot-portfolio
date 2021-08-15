package com.zamar.www.springboot.web;

import com.zamar.www.springboot.config.auth.LoginUser;
import com.zamar.www.springboot.config.auth.dto.SessionUser;
import com.zamar.www.springboot.service.PostsService;
import com.zamar.www.springboot.web.dto.PostsResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import javax.servlet.http.HttpSession;

@RequiredArgsConstructor
@Controller
public class IndexController {

    private final PostsService postsService;
    private final HttpSession httpSession;

    @GetMapping("/")
    public String index(Model model, @LoginUser SessionUser user){
        model.addAttribute("posts", postsService.findAllDesc());
        if(user != null){
            model.addAttribute("userName", user.getName());
        }
        return "indexTest";
    }

    @GetMapping("/posts/update/{id}")
    public String postsUpdate(@PathVariable Long id, Model model, @LoginUser SessionUser user){

        String path;

        if(user != null){
            PostsResponseDto dto = postsService.findById(id);
            model.addAttribute("post", dto);
            path = "posts-update";
        } else {
            path = "/";
        }

        return path;
    }

    @GetMapping("/posts/save")
    public String postsSave(Model model, @LoginUser SessionUser user){
        if(user != null) {
            model.addAttribute("userName", user.getName());
        }
        return "posts-save";
    }

    @GetMapping("/post")
    public String post(Model model) {
        model.addAttribute("posts", postsService.findAllDesc());
        return "post";
    }

}
