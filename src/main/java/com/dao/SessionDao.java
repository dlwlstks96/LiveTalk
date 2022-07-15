package com.dao;

import com.domain.Member;
import com.repository.SessionRepository;

public class SessionDao {

    private SessionRepository sessionRepository;

    public SessionDao(SessionRepository sessionRepository) {
        this.sessionRepository = sessionRepository;
    }

    //멤버 정보 저장
    public String saveSession(String sessionId) {
        sessionRepository.save(sessionId);
        return sessionId;
    }

    public Boolean findSession(String sessionId) {
        Boolean findResult = sessionRepository.findSession(sessionId);
        if (findResult == true) {
            return true;
        } else {
            return false;
        }
    }

}
