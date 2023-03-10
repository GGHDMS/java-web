package org.zerock.jdbcex.service;

import lombok.extern.log4j.Log4j2;
import org.modelmapper.ModelMapper;
import org.zerock.jdbcex.dao.TodoDAO;
import org.zerock.jdbcex.domain.TodoVO;
import org.zerock.jdbcex.dto.TodoDTO;
import org.zerock.jdbcex.util.MapperUtil;

import java.sql.SQLException;
import java.util.List;
import java.util.stream.Collectors;

@Log4j2
public enum TodoService {
    INSTANCE;

    private TodoDAO dao;
    private ModelMapper modelMapper;

    TodoService() {
        dao = new TodoDAO();
        modelMapper = MapperUtil.INSTANCE.get();
    }

    public void register(TodoDTO todoDTO) throws SQLException {
        TodoVO todoVo = modelMapper.map(todoDTO, TodoVO.class);

//        System.out.println("todoVo = " + todoVo);
        log.info(todoVo);

        dao.insert(todoVo); //int 를 반환하므로 이를 이용해서 예외 처리도 가능
    }

    public List<TodoDTO> listAll() throws SQLException {
        List<TodoVO> voList = dao.selectAll();

        log.info("voList.............................");
        log.info(voList);

        return voList.stream()
                .map(vo -> modelMapper.map(vo, TodoDTO.class))
                .collect(Collectors.toList());
    }

    public TodoDTO get(Long tno) throws SQLException {
        log.info("tno: " + tno);
        return modelMapper.map(dao.selectOne(tno), TodoDTO.class);
    }

    public void remove(Long tno) throws SQLException {
        log.info("tno: " + tno);
        dao.deleteOne(tno);
    }

    public void modify(TodoDTO todoDTO) throws SQLException {
        log.info("todoDTO: " + todoDTO);

        dao.updateOne(modelMapper.map(todoDTO, TodoVO.class));
    }
}
