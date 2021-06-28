package com.sample.hellospring;

import com.sample.hellospring.repository.*;
import com.sample.hellospring.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.sql.DataSource;

@Configuration
public class SpringConfig {

    private DataSource dataSource;

    @Autowired
     public SpringConfig(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    @PersistenceContext
    private EntityManager em;

    private MemberRepository memberRepository;

    public SpringConfig(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }


    @Bean
    public MemberService memberService() {
        return new MemberService(memberRepository());
    }

    @Bean
    public MemberRepository memberRepository() {

        // return new MemoryMemberRepository();
        // return new JdbcMemberRepository();
        return new JdbcTemplateMemberRepository(dataSource);
        // return new JpaMemberRepository(em);
    }


}
