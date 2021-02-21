package com.bolsaideas.springboot.web.app.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/variables")
public class VariablePathExample {
	
	@GetMapping("/")
	public String index(Model model) {
		model.addAttribute("title", "Send params in the route (@PathVariable)");
		return "variables/index";
	}
	
	@GetMapping("/string/{text}")
	public String variables(@PathVariable String text, Model model) {
		model.addAttribute("title", "Receive params from route (@PathVariable)");
		model.addAttribute("result", "The text sent in the route is: " + text);
		return "variables/view";
	}

	@GetMapping("/string/{text}/{number}")
	public String variables(@PathVariable String text, @PathVariable Integer number, Model model) {
		model.addAttribute("title", "Receive params from route (@PathVariable)");
		model.addAttribute("result", "The text sent in the route is: " + text + "and the number sent is: " + number);
		return "variables/view";
	}

}
