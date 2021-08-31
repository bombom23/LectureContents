package com.example.market3.Rapository;

import com.example.market3.Entity.JpaButterfly;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import javax.transaction.Transactional;

public interface ButterflyRepository extends JpaRepository<JpaButterfly,Long> {


    @Transactional
    @Modifying
    @Query("UPDATE  JpaButterfly J set J.vuecount = J.vuecount +1 where J.boardNo = :boardNo ")
    void vuecount(@Param("boardNo")Long boardNo);
}