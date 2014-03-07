package com.config;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/")
public class HelloWorld {

	@RequestMapping(method = RequestMethod.GET)
	public String sayHello(Model model) {
		System.out.println("=====Hiiii=======");
		model.addAttribute("msg", "Hello World");
		return "hello";
	}

}
