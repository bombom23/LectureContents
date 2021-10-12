package com.example.teamprojectSpring.Repository;

import com.example.teamprojectSpring.Entity.FreeBoard;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TestRepository extends JpaRepository<FreeBoard,Long> {
}
