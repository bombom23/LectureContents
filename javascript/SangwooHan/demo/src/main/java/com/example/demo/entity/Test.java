package com.example.demo.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.web.bind.annotation.GetMapping;

@Getter
@Setter
@ToString
public class Test {

    private  int TestNo;
    private  String id;
    private  String pw;

}
