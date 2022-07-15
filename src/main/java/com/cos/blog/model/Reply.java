package com.cos.blog.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.sql.Timestamp;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
public class Reply {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(nullable = false, length = 200)
    private String content;

    @ManyToOne // Many: Reply, One: Board -> 한 Board가 여러 개의 Reply 작성 가능
    @JoinColumn(name = "boardId")
    private Board board;

    @ManyToOne // Many: Reply, One: User -> 한 User가 여러 개의 Reply 작성 가능
    @JoinColumn(name = "userId")
    private User user;

    @CreationTimestamp
    private Timestamp createDate;
}
