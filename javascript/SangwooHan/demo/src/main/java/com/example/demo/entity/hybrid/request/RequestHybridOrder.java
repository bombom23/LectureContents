package com.example.demo.entity.hybrid.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;
import lombok.extern.slf4j.Slf4j;

import javax.persistence.*;

@Slf4j
@Getter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class RequestHybridOrder {

    private String name;
    private Integer cost;


}
