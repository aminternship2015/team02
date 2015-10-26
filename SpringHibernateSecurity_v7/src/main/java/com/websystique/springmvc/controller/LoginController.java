package com.websystique.springmvc.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.websystique.springmvc.model.User;
import com.websystique.springmvc.service.UserService;

@Controller
public class LoginController {

	Logger logger = LoggerFactory.getLogger(LoginController.class);
	
	@Autowired
	UserService service;
	
	@RequestMapping(value = { "/login" }, method = RequestMethod.GET)
	public String login() {
		return "login";
	}
	
	@RequestMapping(value = { "/userCheck" }, method = RequestMethod.POST)
	public String userCheck(ModelMap model, HttpServletRequest request,HttpSession session ) {
		String username = request.getParameter("username");
		User user = service.findUserByUsername(username);
		logger.error("Login beggins");
		//model.addAttribute("name", user.getUsername());
		
		try {
			if (!(user.getUsername().equals(null))
					&& !(user.getPassword().equals(null))) {
						session.setAttribute("currUser", user);					
												
			}
		} catch (Exception e) {
			model.addAttribute("message", "Username or password is wrong");

			return "/login";
		}
		
		
		return "redirect:/myPosts";	
		
		}
	
	@RequestMapping(value = { "/logout" }, method = {RequestMethod.POST, RequestMethod.GET})
	public String logout(ModelMap model, HttpServletRequest request,HttpSession session ) {
		logger.error("User was logged out!!1");
		session.setAttribute("currUser", null);		
		return "redirect:/welcome";
	}
	
	
}
