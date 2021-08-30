package com.example.market3.Rapository;

import com.example.market3.Entity.JpaMember;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface JPAMemberRepository extends JpaRepository<JpaMember,Long> {

    @Query("select m from JpaMember m where m.userid = :userid")
    Optional<JpaMember>findByUserId(String userid);
}
