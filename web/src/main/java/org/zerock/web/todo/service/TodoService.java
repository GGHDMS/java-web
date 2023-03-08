package org.zerock.web.todo.service;

import org.zerock.web.todo.dto.TodoDTO;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public enum TodoService { // enum 으로 하면 싱글톤으로 생성 할 수 있다.
    INSTANCE;

    public void register(TodoDTO todoDTO) { // 새로운 todoDTO 객체를 받아서 확인할 수 있는 것을 목표로 작성
        System.out.println("DEBUG............" + todoDTO);
    }

    public List<TodoDTO> getList() { // 10개의 TodoDTO 객체를 만들어서 반환
        List<TodoDTO> todoDTOS = IntStream.range(0, 10).mapToObj(i -> {
            TodoDTO dto = new TodoDTO();
            dto.setTno((long) i);
            dto.setTitle("Todo.." + i);
            dto.setDueDate(LocalDate.now());
            return dto;
        }).collect(Collectors.toList());

        return todoDTOS;
    }

    public TodoDTO get(Long tno) {
        TodoDTO dto = new TodoDTO();
        dto.setTno(tno);
        dto.setTitle("sample Todo");
        dto.setDueDate(LocalDate.now());
        dto.setFinished(true);
        return dto;
    }
}
