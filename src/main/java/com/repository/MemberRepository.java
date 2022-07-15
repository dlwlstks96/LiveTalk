package com.repository;

import com.domain.Member;

import java.util.HashMap;

public class MemberRepository {

    //실시간 이용자들의 이름 정보를 저장할 레포지토리
    //웹페이지가 가벼운만큼 정보 저장 기술도 가볍게 제작한다.
    //private List<Member> repository = new ArrayList<>();
    private HashMap<Member, Integer> repository = new HashMap<Member, Integer>();

    //멤버 정보 저장
    public void save(Member member) {
        //repository.add(member);
        repository.put(member, 1);
    }

    //멤버 탐색
    public Boolean findMember(Member member) {
        Integer findResult = repository.get(member);
        if (findResult != null) {
            return true;
        } else {
            return false;
        }
    }

    //멤버 전체 정보 획득
    public HashMap<Member, Integer> findAll() {
        //return repository;
        return repository;
    }

}
