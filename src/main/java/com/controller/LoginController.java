package com.controller;

import com.domain.Member;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
@SessionAttributes("member")
public class LoginController {

    //첫 입장 시 로그인 폼 출력
    @GetMapping("/")
    public String handleMain() {
        return "loginform";
    }

    //입력 정보 받은 후 mainchat으로 리다이렉트
    //현재 클래스에 SessionAttributes("member") 애노테이션이 붙어있으므로
    //submit 메소드의 @ModelAttribute("member")를 통해 들어온 member 정보는
    //세션 내에 "member"라는 이름으로 저장된다.
    @PostMapping("/")
    public String submit(HttpServletRequest request, @ModelAttribute("member") Member member) {

        //세션에 사용자가 입력한 이름
        HttpSession session = request.getSession();
        Member user = (Member) session.getAttribute("member");

        System.out.println(user.getUserName());
        return "redirect:mainchat";
    }

    //mainchat 요청 시 메인 채팅룸 출력
    @GetMapping("/mainchat")
    public String handleMainchat() {
        return "mainchat";
    }

    //컨트롤러가 호출될 때 세션에서 member 속성을 제공하게끔 아래 코드 추가
    @ModelAttribute("member")
    public Member getMemberSession() {
        return new Member();
    }

}
