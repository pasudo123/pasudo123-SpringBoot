package edu.pasudo123.app.todo;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDateTime;

@Setter
@Getter
@NoArgsConstructor
@ToString
public class ResponseTodoDto {

    private Long id;
    private String content;
    private LocalDateTime createDate;
    private LocalDateTime updateDate;

}
