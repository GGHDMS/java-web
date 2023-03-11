package org.zerock.w2.dao;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.zerock.w2.domain.TodoVO;

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
        TodoVO todoVO = TodoVO.builder()
                .title("Sample Title...")
                .dueDate(LocalDate.now())
                .build();

        todoDAO.insert(todoVO);
    }

    @Test
    public void selectAllTest() throws Exception{
        List<TodoVO> todoVOS = todoDAO.selectAll();
        todoVOS.forEach(System.out::println);
    }

    @Test
    public void deleteOneTest() throws Exception{
        Long tno = 1L;
        todoDAO.deleteOne(tno);
    }

    @Test
    public void updateOneTest() throws Exception{

        TodoVO todoVO = TodoVO.builder()
                .tno(1L)
                .title("Sample Title...")
                .dueDate(LocalDate.now())
                .finished(true)
                .build();

        todoDAO.updateOne(todoVO);
    }
}