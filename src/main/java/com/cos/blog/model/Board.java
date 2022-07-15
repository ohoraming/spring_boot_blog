package com.cos.blog.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.sql.Timestamp;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
public class Board {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id; // primary key

    @Column(nullable = false, length = 100)
    private String title;

    @Lob // 대용량 데이터 <- 섬머노트 라이브러리 사용 대비
    private String content;

    @ColumnDefault("0")
    private int count; // 조회수

    @ManyToOne // Many: Board, One: User -> 한 User가 여러 개의 Board 작성 가능
    @JoinColumn(name = "userId") // 필드명 = userId
    private User user; // FK

    @CreationTimestamp
    private Timestamp createDate;

}
