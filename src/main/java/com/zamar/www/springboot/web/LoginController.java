package com.zamar.www.springboot.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LoginController {

    @GetMapping("/login/oauth2")
    public String login(){
        return "login";
    }
}
