package kr.ac.deu.pc.login.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import jakarta.servlet.http.HttpSession;
import kr.ac.deu.pc.login.dto.LoginDTO;
import kr.ac.deu.pc.login.service.LoginServiceImple;

@Controller
public class LoginController {
	
	private LoginServiceImple loginService;
	public LoginController(LoginServiceImple loginService) {
		this.loginService = loginService;
	}
	
	@PostMapping(value="/login")
	public String login(LoginDTO loginDTO, HttpSession session, RedirectAttributes r) {
		boolean result = loginService.login(loginDTO.getId(), loginDTO.getPwd());
		
		if (!result) {
			r.addFlashAttribute("error", "아이디 또는 비번호를 확인해주세요.");
			return "redirect:login";
		} else {
			session.setAttribute("loginId", loginDTO.getId());
			return "redirect:pc";
		}
	}
	
	@GetMapping(value="/login")
	public String chkLogin(HttpSession session) {
		if (session.getAttribute("loginId") != null) {
			return "redirect:pc";
		}
		return "login/login";
	}
	
	@GetMapping(value="/logout")
	public String logout(HttpSession session) {
		session.removeAttribute("loginId");
		return "redirect:login";
	}
}