package com.example.market3.Rapository;

import com.example.market3.Entity.JpaMember;
import com.example.market3.Entity.JpaMemberAuth;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

public interface JPAMemberRepository extends JpaRepository<JpaMember,Long> {

    @Query("select m from JpaMember m where m.userid = :userid")
    Optional<JpaMember>findByUserId(String userid);
}
