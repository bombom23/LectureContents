package com.example.market3.Controller1;

import com.example.market3.Entity.JpaBoard;
import com.example.market3.Entity.JpaMember;
import com.example.market3.Service.JpaBoardService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/jpaBoard")
@CrossOrigin(origins = "http://localhost:8080", allowedHeaders = "*")
@Slf4j
public class JpaBoardController {

    @Autowired
    JpaBoardService service;

    @PostMapping("/register")
    public ResponseEntity<JpaBoard> registermembers(@Validated @RequestBody JpaBoard jpaBoard) throws Exception {
        log.info("post register request from vue");

        service.register(jpaBoard);

        return new ResponseEntity<>(jpaBoard, HttpStatus.OK);
    }

    @GetMapping("/boardlists")
    public ResponseEntity<List<JpaBoard>> getListsBoards () throws Exception {
        log.info("getLists(): " + service.boardlist());

        return new ResponseEntity<>(service.boardlist(), HttpStatus.OK);
    }
}
