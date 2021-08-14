package com.example.market3.Entity;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;

@Data
@NoArgsConstructor
@Entity
@ToString
public class JpaBoard {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  Long boardNo;

    @Column(length = 20, nullable = false)
    private String  title;
    @Column(length = 20, nullable = false)
    private String id;
    @Column(length = 20, nullable = false)
    private Integer pw;
    @Column(length = 20, nullable = false)
    private String text;
}
