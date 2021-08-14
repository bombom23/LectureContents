package com.example.market3.Rapository;

import com.example.market3.Entity.JpaBoard;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JpaBoardRepository extends JpaRepository<JpaBoard,Long> {
}
