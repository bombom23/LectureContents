package com.example.teamprojectSpring.Entity;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;

@Data
@NoArgsConstructor
@Entity
@ToString
public class FreeBoard {

    @Id// PRI key을 준다.
    @GeneratedValue(strategy = GenerationType.IDENTITY) //auto incre 역할
    private Long boardNo;

    @Column(length = 20, nullable = false) // 20을 넘을수없다 // 널이 될수없다.
    private String userid;

    @Column(length = 20, nullable = false)
    private String title;

    @Column(length = 500, nullable = true)
    private String img;

    @Column(length = 2000, nullable = false)
    private String text;

    public FreeBoard (String userid, String title, String img, String text) {

        this.userid = userid;
        this.title = title;
        this.img = img;
        this.text = text;

    }
}
