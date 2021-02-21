package com.bolsaideas.springboot.web.app.controllers;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.bolsaideas.springboot.web.app.model.User;

@Controller
@RequestMapping("/app") // EndPoint for all Routes this controller
public class IndexController {
	//Injection values whit anotation @Value
	@Value("${text.indexcontroller.index.titulo}")
	private String textIndex;
	@Value("${text.indexcontroller.index.profile}")
	private String textProfile;
	@Value("${text.indexcontroller.index.list}")
	private String textList;

	@GetMapping({ "/index", "/", "", "home" })
	public String index(Model m) {
		// ModelMap, Model:
		// model.addAttribute("title", "Hello Spring Framework");
		// Map<String, Object> map.put("title", "Hello Kevin Spring");
		// Model And View, return mv
		// mv.addObject("title", "Hello Kevin Catucuamba");
		// mv.setViewName("index");
		m.addAttribute("title", textIndex);
		return "index";
	}

	@RequestMapping(value = "/test", method = RequestMethod.GET)
	public String test() {
		return "test";
	}

	@RequestMapping("/profile")
	public String profile(Model model) {
		User user = new User("Kevin", "Catucuamba");
		user.setEmail("kdcatucaumbal@utn.edu.ec");
		model.addAttribute("user", user);
		model.addAttribute("title", textProfile.concat(user.getName()));
		return "profile";
	}

	@RequestMapping("/toList")
	public String toList(Model model) {
		// List<User> users = new ArrayList<>();
		model.addAttribute("title", textList);
		// model.addAttribute("users", users);
		return "list";
	}

	@ModelAttribute("users") // users property for all this controller
	public List<User> fillUsers() {
		List<User> users = Arrays.asList(new User("Kevin", "Catucuamba", "kevin@gmail.com"),
				new User("Jack", "Frickson", "jack@gmail.com"), new User("Liani", "Bravo", "liani@gmail.com"),
				new User("Vanessa", "Cruz", "vane@gmail.com"));
		return users;
	}

}
