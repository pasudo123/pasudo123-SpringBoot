package edu.pasudo123.app.todo;

import edu.pasudo123.app.util.ModelMapperUtils;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class TodoService {

    private final ModelMapperUtils modelMapperUtils;
    private final TodoRepository todoRepository;

    @Transactional
    ResponseTodoDto createTodo(final RequestTodoDto dto){

        Todo todo = Todo.builder()
                .content(dto.getContent())
                .build();

        Todo savedTodo = todoRepository.save(todo);

        return modelMapperUtils.map(savedTodo, ResponseTodoDto.class);
    }

    @Transactional(readOnly = true)
    List<ResponseTodoDto> findAll(){

        List<Todo> todos = todoRepository.findAll();

        return modelMapperUtils.mapAll(todos, ResponseTodoDto.class);
    }

    @Transactional
    void updateTodo(final Long id, final RequestTodoDto dto){

        Todo foundTodo = todoRepository.findById(id).orElse(null);
        foundTodo.updateContent(dto.getContent());

        Todo updatedTodo = todoRepository.save(foundTodo);

    }

    @Transactional
    void deleteById(final Long id){

        todoRepository.deleteById(id);
    }
}
