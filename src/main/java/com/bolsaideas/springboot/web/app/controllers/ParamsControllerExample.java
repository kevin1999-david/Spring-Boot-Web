package com.bolsaideas.springboot.web.app.controllers;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/params")
public class ParamsControllerExample {

	@GetMapping({ "/", "" })
	public String index() {
		return "params/index";
	}

	@GetMapping("/string")
	public String param(@RequestParam(value = "text", required = false, defaultValue = "Hello default") String text,
			Model model) {
		model.addAttribute("result", "The text sent is: ".concat(text));
		return "params/view";
	}

	@GetMapping("/mix-params")
	public String param(@RequestParam String greeting, @RequestParam Integer number, Model model) {
		model.addAttribute("result", "The greeting sent is: '" + greeting + "' and the number is '" + number + "'");
		return "params/view";
	}
	
	
	@GetMapping("/mix-params-request")
	public String param(HttpServletRequest request, Model model) {
		String greeting =  request.getParameter("greeting");
		Integer number = null;
		try {
			number =  Integer.parseInt(request.getParameter("number"));
		} catch (NumberFormatException e) {
			number = 0;
		}
		
		model.addAttribute("result", "The greeting sent is: '" + greeting + "' and the number is '" + number + "'");
		return "params/view";
	}
	
}
