package edu.pasudo123.app.todo;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@NoArgsConstructor
@ToString
public class RequestTodoDto {

    private Long id;
    private String content;

}
