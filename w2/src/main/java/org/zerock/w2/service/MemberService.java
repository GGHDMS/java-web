package org.zerock.w2.service;

import lombok.extern.log4j.Log4j2;
import org.modelmapper.ModelMapper;
import org.zerock.w2.dao.MemberDAO;
import org.zerock.w2.domain.MemberVO;
import org.zerock.w2.dto.MemberDTO;
import org.zerock.w2.util.MapperUtil;

import java.sql.SQLException;

@Log4j2
public enum MemberService {
    INSTANCE;

    private MemberDAO dao;
    private ModelMapper modelMapper;

    MemberService() {
        dao = new MemberDAO();
        modelMapper = MapperUtil.INSTANCE.get();
    }

    public MemberDTO login(String mid, String mpw) throws SQLException {
        MemberVO vo = dao.getWithPassword(mid, mpw);
        log.info(vo);
        return modelMapper.map(vo, MemberDTO.class);
    }

    public void updateUUID(String mid, String uuid) throws SQLException {
        dao.updateUUID(mid, uuid);
    }

    public MemberDTO getByUUID(String uuid) throws SQLException {
        return modelMapper.map(dao.selectUUID(uuid), MemberDTO.class);
    }

}
