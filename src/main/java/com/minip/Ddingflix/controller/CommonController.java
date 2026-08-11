package com.minip.Ddingflix.controller;

import org.springframework.web.bind.annotation.GetMapping;

public class CommonController {

	@GetMapping("/index")
	public String moveMain() {

		return "index";
	}
	
}
