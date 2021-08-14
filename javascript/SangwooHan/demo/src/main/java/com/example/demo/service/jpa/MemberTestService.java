package com.example.demo.service.jpa;

import com.example.demo.entity.VueMember;
import com.example.demo.entity.jpa.Member;
import com.example.demo.newcontroller.jpa.MemberRequest.MemberRequest;

import java.util.List;
import java.util.Optional;

public interface MemberTestService {
    public void register(MemberRequest memberRequest) throws Exception;

    public Optional<Member> findByAuth(Long memberNo);

    public boolean login(MemberRequest memberRequest) throws Exception;

    public boolean checkUserIdValidation(String userId) throws Exception;
}
