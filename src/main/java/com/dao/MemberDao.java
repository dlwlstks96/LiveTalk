package com.dao;

import com.domain.Member;
import com.repository.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.HashMap;
import java.util.List;

public class MemberDao {

    private MemberRepository memberRepository;

    public MemberDao(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    //멤버 정보 저장
    public Member saveMember(Member member) {
        memberRepository.save(member);
        return member;
    }

    public Boolean findMember(Member member) {
        Boolean findResult = memberRepository.findMember(member);
        if (findResult == true) {
            return true;
        } else {
            return false;
        }
    }

    //레포지토리 전체 정보 반환
    public HashMap<Member, Integer> findAllMember() {
        return memberRepository.findAll();
    }

}
