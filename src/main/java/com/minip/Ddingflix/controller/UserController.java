package com.minip.Ddingflix.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.minip.Ddingflix.model.dto.UserDTO;
import com.minip.Ddingflix.model.dto.UserSessionDTO;
import com.minip.Ddingflix.service.UserService;

import jakarta.servlet.http.HttpSession;

@Controller
public class UserController {

	private final UserService us;

	public UserController(UserService us) {
		this.us = us;
	}

	@PostMapping("/user/login")
	public String login(String userId, String userPwd, HttpSession session, Model model) {
		try {
			UserDTO currentUser = us.login(userId, userPwd);
			UserSessionDTO usd = new UserSessionDTO(currentUser.getUserId(), currentUser.getUserName(),
					currentUser.getUserBalance());
			session.setAttribute("currSession", usd);
		} catch (RuntimeException e) {
			e.printStackTrace();
			model.addAttribute("errorMsg", e.getMessage());
		}
		return "index";
	}

	@GetMapping("/user/logout")
	public String logout(HttpSession session) {

		session.invalidate();

		return "redirect:/";
	}

	@GetMapping("/user/join")
	public String joinForm() {
		return "join";
	}
	
	@PostMapping("/user/insert")
	public String insert(UserDTO user, HttpSession session, Model model) {
		try {
			UserSessionDTO usd = us.insert(user);
			session.setAttribute("currSession", usd);
		} catch (RuntimeException e) {
			e.printStackTrace();
			model.addAttribute("errorMsg", e.getMessage());
		}

		return "index";
	}

	
	@GetMapping("/user/update")
	public String updateCheck(HttpSession session, Model model) {
		UserSessionDTO usd = (UserSessionDTO) session.getAttribute("currSession");
		if (usd == null) {
			model.addAttribute("errorMsg", "로그인이 되어있지 않습니다.");
			return "index";
		} else {
			UserDTO currentUser = us.searchById(usd.getUserId());
			model.addAttribute("currentUser", currentUser);
			return "update";
		}
	}

	@PostMapping("/user/update")
	public String update(UserDTO currentUser, HttpSession session, Model model) {
		try {
			currentUser = us.update(currentUser);
			UserSessionDTO usd = new UserSessionDTO(currentUser.getUserId(), currentUser.getUserName(),
					currentUser.getUserBalance());
			session.setAttribute("currSession", usd);
			model.addAttribute("msg", "회원 정보 수정 완료");
		} catch (RuntimeException e) {
			e.printStackTrace();
			model.addAttribute("errorMsg", e.getMessage());
		}

		return "index";
	}
	
	@GetMapping("/user/withdraw")
	public String deleteCheck(HttpSession session, Model model) {
		UserSessionDTO usd = (UserSessionDTO) session.getAttribute("currSession");
		if (usd == null) {
			model.addAttribute("errorMsg", "로그인이 되어있지 않습니다.");
			return "index";
		} else {
			UserDTO currentUser = us.searchById(usd.getUserId());
			model.addAttribute("currentUser", currentUser);
			return "withdraw";
		}
	}
	

	@PostMapping("/user/delete")
	public String delete(String userPwd, HttpSession session, Model model) {

		UserSessionDTO currSession = (UserSessionDTO) session.getAttribute("currSession");
		int result = 0;

		try {
			result = us.delete(currSession.getUserId(), userPwd);
		} catch (RuntimeException e) {
			e.printStackTrace();
			model.addAttribute("errorMsg", e.getMessage());
		}

		if (result > 0) {
			model.addAttribute("msg", "회원 탈퇴에 성공하셨습니다.");
			session.removeAttribute("currSession");
		}

		return "index";
	}
}