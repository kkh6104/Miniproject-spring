package com.minip.Ddingflix.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.minip.Ddingflix.model.dto.ContentDTO;
import com.minip.Ddingflix.model.mapper.ContentMapper;

import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class ContentController {

	private final ContentMapper mapper;

	@GetMapping("/")
	public String loadPage(Model model, HttpSession session) {
		
		List<ContentDTO> list = mapper.getList();
		session.setAttribute("list", list);
		
		return "index";
	}
}
