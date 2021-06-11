package com.example.demo.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Slf4j
@Controller
public class FirstController {


    @GetMapping("/imageTest")
    public String doImageTest (){
        log.info("doImageTest()");

        return "first/image.html";
    }

    @GetMapping("/fontTest")
    public String doFontTest() {
        log.info("doFontTest()");

        return "first/font.html";
    }

    @GetMapping("/markTest")
    public String doMarkTest() {
        log.info("doMarkTest()");

        return "first/mark";
    }

    @GetMapping("/firstTableTest")
    public String firstTableTest () {
        log.info("firstTableTest()");

        return "first/tableTest1";
    }

    @GetMapping("/secondTableTest")
    public String secondTableTest () {
        log.info("secondTableTest()");

        return "first/tableTest2";
    }

    @GetMapping("/thirdTableTest")
    public String thirdTableTest () {
        log.info("thirdTableTest()");

        return "first/tableTest3";
    }
}
