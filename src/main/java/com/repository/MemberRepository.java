package com.repository;

import com.domain.Member;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

public class MemberRepository {

    //실시간 이용자들의 이름 정보를 저장할 레포지토리
    //웹페이지가 가벼운만큼 정보 저장 기술도 가볍게 제작한다.
    private List<Member> repository = new ArrayList<>();

    //멤버 정보 저장
    public void save(Member member) {
        repository.add(member);
    }

    //멤버 전체 정보 획득
    public List<Member> findAll() {
        return repository;
    }

}
