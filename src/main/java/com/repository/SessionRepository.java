package com.repository;

import com.domain.Member;

import java.util.HashMap;

public class SessionRepository {

    private HashMap<String, Integer> repository = new HashMap<String, Integer>();

    //세션 정보 저장
    public void save(String sessionId) {
        repository.put(sessionId, 1);
    }

    //세션 탐색
    public Boolean findSession(String sessionId) {
        Integer findResult = repository.get(sessionId);
        if (findResult != null) {
            return true;
        } else {
            return false;
        }
    }

}
