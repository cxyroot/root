package com.google.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class indexContoller {
	@RequestMapping(value="/index.do")
	public String index(){
		return "index";
	}
}
