package com.example.demo.repository.jpa;

import com.example.demo.entity.jpa.Member;
import com.example.demo.entity.jpa.MemberAuth;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MemberAuthReopsitory extends JpaRepository<MemberAuth,Long> {
}
