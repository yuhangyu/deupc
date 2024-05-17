package kr.ac.deu.pc.login.mapper;

import org.apache.ibatis.annotations.Mapper;

import kr.ac.deu.pc.login.dto.LoginDTO;

@Mapper
public interface LoginMapper {
	
	LoginDTO login(String id, String pwd);
	
}
