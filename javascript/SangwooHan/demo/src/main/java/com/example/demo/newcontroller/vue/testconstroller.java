package com.example.demo.newcontroller.vue;

import com.example.demo.entity.Monster;
import com.example.demo.entity.Test;
import com.example.demo.newcontroller.jpa.MemberRequest.MemberRequest;
import com.example.demo.service.VueMonsterService;
import com.example.demo.service.testService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@Slf4j
@Controller
@RequestMapping("/sibal")
public class testconstroller {

    @Autowired
    private testService service;

    @PostMapping("/register")
    public ResponseEntity<Test> registerMonster(@Validated @RequestBody Test test) throws Exception {
        log.info("post register request from vue");

        service.register(test);

        return new ResponseEntity<>(test, HttpStatus.OK);
    }
}
