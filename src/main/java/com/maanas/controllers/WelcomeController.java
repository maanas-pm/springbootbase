package com.maanas.controllers;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.maanas.daos.UserDao;

@Controller
public class WelcomeController {

	@Autowired
	private UserDao userdao;
	
	@Value("${welcome.message:test}")
	private String message = "Hello World";

	@RequestMapping("/")
	public String welcome(Map<String, Object> model) {
		model.put("message", this.message);
		return "welcome";
	}
	
	@RequestMapping("/user_list.html")
    public ModelAndView getListUsersView() {
        ModelMap model = new ModelMap();
        model.addAttribute("users", userdao.findAll());
        return new ModelAndView("user_list", model);
    }
}
