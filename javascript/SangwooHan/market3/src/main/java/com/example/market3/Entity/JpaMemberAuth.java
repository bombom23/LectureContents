package com.example.market3.Entity;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.util.Date;

@Data
@NoArgsConstructor
@ToString
@Entity
@Table(name = "jpa_member_auth")
public class JpaMemberAuth {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long memberAuthNo;

    @Column(name = "member_no")
    private Long memberNo;

    @Column(length = 64, nullable = false)
    private  String auth;

    @CreationTimestamp
    private Date regDate;

    @UpdateTimestamp
    private Date upDate;

    public JpaMemberAuth(String auth) {
        this.auth = auth;
    }

}
