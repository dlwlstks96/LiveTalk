package com.controller;

import com.dao.MemberDao;
import com.dao.SessionDao;
import com.domain.Member;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
@SessionAttributes("member")
public class LoginController {

    @Autowired
    private MemberDao memberDao;

    @Autowired
    private SessionDao sessionDao;

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

        HttpSession session = request.getSession();
        String sessionId = session.getId();
        System.out.println(sessionId);
        //세션 정보 이용해 중복 로그인인지 확인
        Boolean findSessionResult = sessionDao.findSession(sessionId);
        if (findSessionResult == true) {
            System.out.println("중복 로그인 불가");
            return "redirect:loginform";
        } else {
            sessionDao.saveSession(sessionId);
        }

        //이미 존재하는 멤버 정보인지 확인
        Boolean findMemberResult = memberDao.findMember(member);
        if (findMemberResult == true) {
            System.out.println("이미 존재하는 회원입니다.");
            return "redirect:loginform";
        } else {
            System.out.println("로그인 성공");
            memberDao.saveMember(member);
        }

        // TODO: 세션이 끊겼을 때는 끊긴 세션 정보를 삭제하고, 해당 멤버 정보도 삭제해야 한다.

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
