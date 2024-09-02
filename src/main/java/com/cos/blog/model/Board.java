package com.cos.blog.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.List;

@Data // getter, setter
@NoArgsConstructor // 인자 없는 생성자
@AllArgsConstructor // 인자 있는 생성자
@Builder
@Entity // DB에 자동으로 create / update
public class Board {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // primary key
    private int id;

    @Column(nullable = false, length = 100) // not null
    private String title;

    @Lob // 대용량 데이터
    private String content;

    private int count; // 조회수 // 미구현

    @Enumerated(EnumType.STRING) // Enum이 String 타입이다.
    private Category category;

    @ManyToOne(fetch = FetchType.EAGER) // JOIN, EAGER : 항상 user도 같이 select함
    @JoinColumn(name="userId")
    private User user;

    @OneToMany(mappedBy = "board", fetch = FetchType.EAGER) // column 생성X
    private List<Reply> Reply;

    @CreationTimestamp
    private Timestamp createDate; // 현재 시간
}