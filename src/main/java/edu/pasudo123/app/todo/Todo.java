package edu.pasudo123.app.todo;

import edu.pasudo123.app.common.TimeEntity;
import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "TODO")
@NoArgsConstructor(access= AccessLevel.PACKAGE)
@Getter
@ToString
public class Todo extends TimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "CONTENT", nullable = false)
    private String content;

    @Builder
    public Todo(String content){
        this.content = content;
    }

    void updateContent(String content){
        this.content = content;
    }
}
