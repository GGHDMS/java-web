package org.zerock.jdbcex.dao;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.zerock.jdbcex.domain.TodoVo;

import java.time.LocalDate;
import java.util.List;

class TodoDAOTest {
    private TodoDAO todoDAO;

    @BeforeEach
    public void ready() {
        todoDAO = new TodoDAO();
    }

    @Test
    public void testTime() throws Exception{
        System.out.println(todoDAO.getTime());
    }

    @Test
    public void testTime2() throws Exception{
        System.out.println(todoDAO.getTime2());
    }

    @Test
    public void insertTest() throws Exception{
        TodoVo todoVo = TodoVo.builder()
                .title("Sample Title...")
                .dueDate(LocalDate.now())
                .build();

        todoDAO.insert(todoVo);
    }

    @Test
    public void selectAllTest() throws Exception{
        List<TodoVo> todoVos = todoDAO.selectAll();
        todoVos.forEach(System.out::println);
    }

    @Test
    public void deleteOneTest() throws Exception{
        Long tno = 1L;
        todoDAO.deleteOne(tno);
    }

    @Test
    public void updateOneTest() throws Exception{
        TodoVo todoVo = TodoVo.builder()
                .tno(1L)
                .title("Sample Title...")
                .dueDate(LocalDate.now())
                .finished(true)
                .build();

        todoDAO.updateOne(todoVo);
    }
}