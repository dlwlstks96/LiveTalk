package com.controller;

import com.domain.Member;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class LoginController {

    //첫 입장 시 로그인 폼 출력
    @GetMapping("/")
    public String handleMain() {
        return "loginform";
    }

    //입력 정보 받은 후 mainchat으로 리다이렉트
    @PostMapping("/")
    public String submit(Member member) {
        System.out.println(member.getUserName());
        return "redirect:mainchat";
    }

    //mainchat 요청 시 메인 채팅룸 출력
    @GetMapping("/mainchat")
    public String handleMainchat() {
        return "mainchat";
    }

}
