package com.controller;

import com.dao.MemberDao;
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

        //멤버 정보를 Array List에 저장
        memberDao.saveMember(member);

        // TODO: 추후 검증 과정 추가 및 수정 예정 / 세션이 같을 경우 같은 세션의 멤버 정보 전부를 바꿔버리는 것 오류 수정 필요
        //근데 현재는 같은 컴퓨터로 두 개의 브라우저를 통해 따로 접속하면
        //먼저 접속해있던 같은 컴퓨터의 멤버 정보가 바뀌어 버린다.
        //세션 단위로 저장을 해서 기존의 같은 세션 정보에 영향을 미치는 것 같다.
        //다른 컴퓨터에서 접속했을땐 다르게 저장 되는 것이 확인되었다.
        //저장 결과를 확인하기 위해 레포지토리 전체를 출력
        List<Member> findAllMemberResult = memberDao.findAllMember();
        for(Member nowMember : findAllMemberResult) {
            System.out.println(nowMember.getUserName());
        }

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
