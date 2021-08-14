package com.example.demo.repository;

import com.example.demo.entity.Monster;
import com.example.demo.entity.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class TestRepository {


    @Autowired
    private  JdbcTemplate jdbcTemplate;
    public void create(Test test) throws Exception {
        String query = "insert into test (id, pw) " +
                "values (?, ?)";

        jdbcTemplate.update(query, test.getId(), test.getPw());
    }


}
