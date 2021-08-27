package com.example.market3.Rapository;

import com.example.market3.Entity.JpaSkycow;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import javax.transaction.Transactional;

public interface SkycowRepository extends JpaRepository<JpaSkycow,Long> {

    @Transactional
    @Modifying
    @Query("UPDATE  JpaSkycow J set J.vuecount = J.vuecount +1 where J.boardNo = :boardNo ")
    void vuecount(@Param("boardNo")Long boardNo);
}
