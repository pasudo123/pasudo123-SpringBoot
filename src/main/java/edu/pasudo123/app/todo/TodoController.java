package edu.pasudo123.app.todo;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
@Slf4j
@RequiredArgsConstructor
public class TodoController {

    private final TodoService todoService;

    @PostMapping("/todos")
    public ResponseEntity<ResponseTodoDto> createTodo(@RequestBody RequestTodoDto requestTodoDto){

        final ResponseTodoDto savedResponseTodoDto = todoService.createTodo(requestTodoDto);

        return ResponseEntity.ok().body(savedResponseTodoDto);
    }

    @GetMapping("/todos")
    public ResponseEntity<List<ResponseTodoDto>> findAll(){

        final List<ResponseTodoDto> savedResponseTodoDtos = todoService.findAll();

        return ResponseEntity.ok().body(savedResponseTodoDtos);

    }

    @PatchMapping("/todos/{id}")
    public void updateTodo(@RequestBody RequestTodoDto requestTodoDto,
                           @PathVariable("id") Long id){

        todoService.updateTodo(id, requestTodoDto);

    }

    @DeleteMapping("/todos/{id}")
    public void deleteTodo(@PathVariable("id") Long id){

        todoService.deleteById(id);

    }

}
