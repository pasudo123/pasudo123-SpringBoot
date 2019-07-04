package edu.pasudo123.app.comment;

import lombok.*;

import javax.persistence.*;

/**
 * Created by pasudo123 on 2019-07-03
 * Blog: https://pasudo123.tistory.com/
 * Email: oraedoa@gmail.com
 **/
@Entity
@Table(name = "COMMENT")
@NoArgsConstructor(access = AccessLevel.PACKAGE)
@ToString
@Getter
public class Comment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "CONTENT", nullable = false)
    private String content;

    /**
     * TODO : 작성자, 작성날짜 기입하기
     * JpaAuditing 기능 이용
     */

    @Builder
    public Comment(String content){
        this.content = content;
    }
}
