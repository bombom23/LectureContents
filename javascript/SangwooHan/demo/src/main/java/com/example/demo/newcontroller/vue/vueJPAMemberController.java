package com.example.demo.newcontroller.vue;

import com.example.demo.entity.VueMember;
import com.example.demo.service.vueMemberTestService;
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
@RequestMapping("/vueJpaTest")
@CrossOrigin(origins = "http://localhost:8080", allowedHeaders = "*")
@Slf4j
public class vueJPAMemberController {
    @Autowired
    vueMemberTestService service;

    @PostMapping("/register")
    public ResponseEntity<VueMember> registermembers(@Validated @RequestBody VueMember vueMember) throws Exception {
        log.info("post register request from vue");

        service.register(vueMember);

        return new ResponseEntity<>(vueMember, HttpStatus.OK);
    }
}
