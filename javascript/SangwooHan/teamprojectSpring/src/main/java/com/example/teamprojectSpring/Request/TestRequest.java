package com.example.teamprojectSpring.Request;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Data
@Slf4j
@NoArgsConstructor
public class TestRequest {

    private String userid;
    private String title;
    private String text;
    private String img;


}
