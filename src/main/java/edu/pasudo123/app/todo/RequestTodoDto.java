package edu.pasudo123.app.todo;

import lombok.*;

@Setter
@Getter
@NoArgsConstructor
@ToString
@EqualsAndHashCode
public class RequestTodoDto {

    private Long id;
    private String content;

}
