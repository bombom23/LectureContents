package com.example.market3.Entity;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

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
    @Column(length = 2000, nullable = false)
    private String text;

    @CreationTimestamp
    private LocalDateTime createDate;

    @UpdateTimestamp
    private LocalDateTime lastModifiedDate;

    @OneToMany( cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name= "board_no")
    private List<JpaBoardComment> authList = new ArrayList<JpaBoardComment>();

    public  JpaBoard(Long boardNo, String title, String id, String text, LocalDateTime createDate) {
        this.title = title;
        this.id = id;
        this.text = text;
        this.boardNo = boardNo;
        this.createDate = createDate;
    }



    public void addui(JpaBoardComment ui ){authList.add(ui);}
    public void addComments(JpaBoardComment comments ){authList.add(comments);}


    public void clearAuthList() {authList.clear();}



}

