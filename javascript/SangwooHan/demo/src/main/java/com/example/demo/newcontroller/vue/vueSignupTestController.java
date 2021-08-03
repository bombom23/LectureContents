package com.example.demo.newcontroller.vue;

import com.example.demo.entity.Monster;
import com.example.demo.entity.Signup;
import com.example.demo.service.vueSignupTestService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/vuesignupTest")
@CrossOrigin(origins = "http://localhost:8080", allowedHeaders = "*")
@Slf4j
public class vueSignupTestController {
    @Autowired
    vueSignupTestService service;

    @PostMapping("/register")
    public ResponseEntity<Signup> registermembers(@Validated @RequestBody Signup signup) throws Exception {
        log.info("post register request from vue");

        service.register(signup);

        return new ResponseEntity<>(signup, HttpStatus.OK);
    }
}
