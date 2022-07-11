package com.domain;

//채팅에 참여하는 유저 클래스
public class Member {

    private String userName;

    public Member() {

    }

    public Member(String userName) {
        this.userName = userName;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }
}
