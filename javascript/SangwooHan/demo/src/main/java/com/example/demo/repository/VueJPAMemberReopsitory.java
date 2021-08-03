package com.example.demo.repository;

import com.example.demo.entity.VueMember;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VueJPAMemberReopsitory extends JpaRepository<VueMember,Long> {
}
