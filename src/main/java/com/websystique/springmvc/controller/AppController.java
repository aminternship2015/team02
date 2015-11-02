package com.websystique.springmvc.controller;

import java.util.List;
import java.util.Locale;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.joda.time.LocalDate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.MessageSource;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.Validator;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.websystique.springmvc.model.Post;
import com.websystique.springmvc.model.User;
import com.websystique.springmvc.service.PostService;
import com.websystique.springmvc.service.UserService;

@Controller
@RequestMapping("/")
public class AppController {

	Logger logger = LoggerFactory.getLogger(AppController.class);

	@Autowired
	UserService service;

	@Autowired
	PostService postService;

	@Autowired
	MessageSource messageSource;

	@Autowired
	@Qualifier("userFormValidator")
	private Validator validator;

	@RequestMapping(value = { "/showMyPosts" }, method = RequestMethod.GET)
	public String showMyPosts(ModelMap model, HttpSession session) {
		User user = (User) session.getAttribute("currUser");
		if (session.getAttribute("currUser") == null) {
			return "login";
		}

		model.addAttribute("username", user.getUsername());

		List<Post> posts = postService.findAllPosts();
		model.addAttribute("posts", posts);
		model.addAttribute("postLen", posts.size());

		return "showMyPosts";
	}

	@RequestMapping(value = { "/", "/welcome" }, method = RequestMethod.GET)
	public String goWelcome(ModelMap model, HttpSession session) {
		if (session.getAttribute("currUser") == null) {
			return "welcome";
		}
		return "redirect:/myPosts";
	}

	@RequestMapping(value = { "/", "/welcome" }, method = RequestMethod.POST)
	public String goRegistration(ModelMap model) {
		logger.error("redirected to the registration");
		return "registration";
	}

	/*
	 * This method will list all existing employees.
	 */
	@RequestMapping(value = { "/list" }, method = RequestMethod.GET)
	public String listUsers(ModelMap model, HttpSession session) {
		if (session.getAttribute("currUser") == null) {
			return "login";
		} else {
			List<User> users = service.findAllUsers();
			model.addAttribute("users", users);
		}
		return "allusers";
	}

	/*
	 * This method will provide the medium to add a new user.
	 */
	@RequestMapping(value = { "/new" }, method = RequestMethod.GET)
	public String newUser(ModelMap model, HttpSession session) {
		User user = new User();
		user.setCreatedAt(LocalDate.now());
		user.setAdmin("User");
		model.addAttribute("user", user);
		model.addAttribute("edit", false);
		return "registration";
	}

	/*
	 * Binding validator to a concrete model, to avoid binding to post model
	 */

	@InitBinder("user")
	private void initBinder(WebDataBinder binder) {
		binder.setValidator(validator);
	}

	/*
	 * This method will be called on form submission, handling POST request for
	 * saving user in database. It also validates the user input
	 */
	@RequestMapping(value = { "/new" }, method = RequestMethod.POST)
	public String saveUser(@Validated User user, BindingResult result,
			ModelMap model,HttpServletRequest request) {

		//String avatarName = request.getParameter("avatar");
		
		if (result.hasErrors()) {
			return "registration";
		}

		if (!service.isUserUsernameUnique(user.getUserId(), user.getUsername())) {
			FieldError usernameError = new FieldError("user", "username",
					messageSource.getMessage("non.unique.username",
							new String[] { user.getUsername() },

							Locale.getDefault()));

			result.addError(usernameError);

			return "registration";
		}

		//user.setAvatar(avatarName);
		service.saveUser(user);

		model.addAttribute("success", "User " + user.getUsername()
				+ " registered successfully");
		return "login";
	}

	/*
	 * This method will provide the medium to update an existing user.
	 */
	@RequestMapping(value = { "/edit-{username}-user" }, method = RequestMethod.GET)
	public String editUser(@PathVariable String username, ModelMap model) {
		User user = service.findUserByUsername(username);
		model.addAttribute("user", user);
		model.addAttribute("edit", true);
		return "registration";
	}

	/*
	 * This method will be called on form submission, handling POST request for
	 * updating user in database. It also validates the user input
	 */
	@RequestMapping(value = { "/edit-{username}-user" }, method = RequestMethod.POST)
	public String updateUser(@Valid User user, BindingResult result,
			ModelMap model, @PathVariable String username) {

		if (result.hasErrors()) {
			return "registration";
		}

		service.updateUser(user);

		model.addAttribute("success", "User " + user.getUsername()
				+ " updated successfully");
		return "login";
	}

	/*
	 * This method will delete an employee by it's username value.
	 */
	@RequestMapping(value = { "/delete-{username}-user" }, method = RequestMethod.GET)
	public String deleteEmployee(@PathVariable String username) {
		service.deleteUserByUsername(username);
		return "redirect:/list";
	}

}
