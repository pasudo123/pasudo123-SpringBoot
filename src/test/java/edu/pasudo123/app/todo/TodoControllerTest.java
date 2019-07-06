package edu.pasudo123.app.todo;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.Matchers.is;
import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(TodoController.class)
@Slf4j
public class TodoControllerTest {

    @Autowired
    private ObjectMapper objectMapper;

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private TodoService todoService;

    @Test
    public void Todo_등록_API_Test() throws Exception {

        RequestTodoDto requestTodoDto = new RequestTodoDto();
        requestTodoDto.setContent("테스트 코드 작성하기");

        ResponseTodoDto responseTodoDto = new ResponseTodoDto();
        responseTodoDto.setId(1L);
        responseTodoDto.setContent("테스트 코드 작성하기");
        responseTodoDto.setCreateDate(LocalDateTime.now());
        responseTodoDto.setUpdateDate(LocalDateTime.now());

        /**
         * [ 문제점 1 ]
         * - status 200 이 안 떨어지고 클라이언트 syntax 문제로 400 이 나온다. 왜 그런것일까?
         *
         * [ Solution ]
         * - content 메소드를 삽입하고 내부적으로 ObjectMapper 를 이용하여 Object 를 json 화 시켜야 한다.
         *
         * [ 문제점 2 ]
         * - 이제 내용이 안 찍혀 나온다. 무슨 문제일까 (post 인데 리턴값이 있어서 그런걸까?)
         *
         * [ Solution ]
         * - @EqualsAndHashCode 어노테이션을 RequestTodoDto 와 ResponseTodoDto 에 각각 붙이니 해결
         */

        // given
        given(todoService.createTodo(requestTodoDto)).willReturn(responseTodoDto);

        MvcResult result = mockMvc.perform(post("/api/todos")
                    .content(objectMapper.writeValueAsString(requestTodoDto))
                    .contentType(MediaType.APPLICATION_JSON_UTF8))
                .andExpect(status().isOk())
                .andDo(print())
                .andReturn();
        
    }

    @Test
    public void Todo_조회_API_테스트() throws Exception {

        List<ResponseTodoDto> responseTodoDtoList = new ArrayList<>();

        ResponseTodoDto responseTodoDto = new ResponseTodoDto();
        responseTodoDto.setId(1L);
        responseTodoDto.setContent("테스트 코드 작성하기");
        responseTodoDto.setCreateDate(LocalDateTime.now());
        responseTodoDto.setUpdateDate(LocalDateTime.now());

        responseTodoDtoList.add(responseTodoDto);

        given(todoService.findAll()).willReturn(responseTodoDtoList);

        MvcResult result = mockMvc.perform(get("/api/todos"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].content", is(responseTodoDto.getContent())))
                .andDo(print())
                .andReturn();

        log.debug(result.getResponse().getContentAsString());
    }
}
