package com.example.market3.Rapository;

import com.example.market3.Entity.JpaDragonfly;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import javax.transaction.Transactional;
import java.util.Optional;

public interface DragonflyRepository extends JpaRepository<JpaDragonfly,Long> {

    @Transactional
    @Modifying
    @Query("UPDATE  JpaDragonfly J set J.vuecount = J.vuecount +1 where J.boardNo = :boardNo ")
    void addvuecount(@Param("boardNo")Long boardNo);

    @Query("select j from JpaDragonfly j where j.title = :title")
    Optional<JpaDragonfly> findBytitle(@Param("title")String title);
}
