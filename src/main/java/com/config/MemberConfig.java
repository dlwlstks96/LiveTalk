package com.config;

import com.dao.MemberDao;
import com.repository.MemberRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MemberConfig {

    @Bean
    public MemberRepository memberRepository() {
        return new MemberRepository();
    }

    @Bean
    public MemberDao memberDao() {
        MemberDao memberDao = new MemberDao(memberRepository());
        return memberDao;
    }

}
