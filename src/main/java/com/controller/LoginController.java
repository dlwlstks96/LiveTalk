package com.controller;

import com.domain.Member;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class LoginController {

    @GetMapping("/login")
    public String form() {
        return "loginform";
    }


    @PostMapping("/login")
    public String submit(Member member) {
        System.out.println(member.getUserName());
        return "index";
    }

}
