package com.example.market3.Rapository;

import com.example.market3.Entity.JpaBeetle;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import javax.transaction.Transactional;

public interface BeetleRepository extends JpaRepository<JpaBeetle,Long> {

    @Transactional
    @Modifying
    @Query("UPDATE  JpaBeetle J set J.vuecount = J.vuecount +1 where J.boardNo = :boardNo ")
    void addvueCount(@Param("boardNo")Long boardNo);
}
