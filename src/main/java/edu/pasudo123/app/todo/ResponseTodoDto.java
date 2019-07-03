package edu.pasudo123.app.todo;

import lombok.*;

import java.time.LocalDateTime;

@Setter
@Getter
@NoArgsConstructor
@ToString
@EqualsAndHashCode
public class ResponseTodoDto {

    private Long id;
    private String content;
    private LocalDateTime createDate;
    private LocalDateTime updateDate;

}
