package com.example.demo.service;

import com.example.demo.entity.Test;
import com.example.demo.repository.TestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class testServiceimpl implements testService {

    @Autowired
    private TestRepository repository;


    @Override
    public void register(Test test) throws Exception {
        repository.create(test);
    }
}
