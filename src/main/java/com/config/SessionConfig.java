package com.config;

import com.dao.MemberDao;
import com.dao.SessionDao;
import com.repository.MemberRepository;
import com.repository.SessionRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SessionConfig {

    @Bean
    public SessionRepository sessionRepository() {
        return new SessionRepository();
    }

    @Bean
    public SessionDao sessionDao() {
        SessionDao sessionDao = new SessionDao(sessionRepository());
        return sessionDao;
    }

}
