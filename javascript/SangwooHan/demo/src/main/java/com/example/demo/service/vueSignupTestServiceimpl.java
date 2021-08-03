package com.example.demo.service;

import com.example.demo.entity.Signup;
import com.example.demo.repository.vueSignupTestRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

@Service
@Lazy
@Slf4j
public class vueSignupTestServiceimpl implements vueSignupTestService{
    @Autowired
    vueSignupTestRepository repository;
    @Override
    public void register(Signup signup) throws Exception {
    repository.save(signup);
    }
}
