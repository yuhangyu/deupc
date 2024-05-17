package kr.ac.deu.pc.login.service;

import org.springframework.stereotype.Service;

import kr.ac.deu.pc.login.dto.LoginDTO;
import kr.ac.deu.pc.login.mapper.LoginMapper;

@Service
public class LoginServiceImple implements LoginService {

	private LoginMapper loginMapper;
	public LoginServiceImple(LoginMapper loginMapper) {
		this.loginMapper = loginMapper;
	}
	
	@Override
	public boolean login(String id, String pwd) {
		LoginDTO loginDTO = loginMapper.login(id, pwd);
		return loginDTO != null;
	}
	
}
