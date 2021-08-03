package com.example.demo.entity;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;

@Data
@NoArgsConstructor
@Entity
@ToString
public class Signup {
    @Id// PRI key을 준다.
    @GeneratedValue(strategy = GenerationType.IDENTITY) //auto incre 역할
    private Long memberNo;

    @Column(length = 20, nullable = false) // 20을 넘을수없다 // 널이 될수없다.
    private String id;

    @Column(length = 20, nullable = false)
    private String pw;

    @Column(length = 500, nullable = false)
    private String email;

    @Column(length = 2000, nullable = false)
    private String address;
}
