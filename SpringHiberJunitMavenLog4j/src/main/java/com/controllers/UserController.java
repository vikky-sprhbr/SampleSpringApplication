package com.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * This controller handles / request.
 * 
 * @author Vikky
 * 
 */
@Controller
// this annotation makes this class to a spring Controller
@RequestMapping("/")
// this mapping maps to '/' url pattern in class level, means all the request
// methods what are have in this class, will also maps to '/'.

public class UserController {
	// this is GET method of '/' url pattern
		@RequestMapping(method = RequestMethod.GET)
		public String viewHome(Model model) {

			System.out.println("Heloooooooooooooo");

			/**
			 * add message whatever you want to available in jsp(view) you can
			 * access this message by key, i.e. msg for example: ${msg}
			 */
			model.addAttribute("msg", "Hello World from Your Name");

			/**
			 * Finally return the view name, it will converted to:
			 * /WEB-INF/views/hello.jsp (which is complete location of jsp(view))
			 */
			return "helloWorld";
		}

}
