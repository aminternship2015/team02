package com.websystique.springmvc.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.joda.time.LocalDate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.websystique.springmvc.model.Post;
import com.websystique.springmvc.model.User;
import com.websystique.springmvc.service.PostService;
import com.websystique.springmvc.service.UserService;

@Controller
public class PostController {

	@Autowired
	PostService postService;

	@Autowired
	UserService service;
	
	Logger LOGGER = LoggerFactory.getLogger(AppController.class);

	@RequestMapping(value = { "/myPosts" }, method = RequestMethod.GET)
	public String listPosts(@RequestParam(defaultValue = "1") int page,
			ModelMap model, HttpSession session) {

		LOGGER.info("Post were displayed!!");

		User user = (User) session.getAttribute("currUser");
		String username;
		try {
			username = user.getUsername();
		} catch (NullPointerException e) {
			username = "NULL";
		}
		if (!(session.getAttribute("currUser") == null))

		{
			LOGGER.info("[LOGGER INFO] User " + username + " logged in");
			LOGGER.info("User is trying to make a new post");
			
			user = (User) session.getAttribute("currUser");
			model.addAttribute("username", user.getUsername());
			model.addAttribute("avatar", user.getAvatar());
			LOGGER.info("[AVATAR:] "+user.getAvatar());
			
			List<Post> posts = postService.findPostsForPage(page, user.getUsername());

			int postLength = posts.size();
			LOGGER.info("[LOGGER INFO] POST LENGTH: " + postLength);

			model.addAttribute("page", page);
			model.addAttribute("posts", posts);
			model.addAttribute("pSize", posts.size());
			model.addAttribute("total", postService.countPosts() / 10 + 2);

		} else {

			LOGGER.info("redirected to logged in");
			return "login";
		}
		return "posts";
	}

	@ModelAttribute("myPost")
	public Post getPost() {
		return new Post();
	}

	@RequestMapping(value = { "/savePost" }, method = RequestMethod.POST)
	public String savePost(ModelMap model, HttpServletRequest request,
			HttpSession session) {

		String username;
		String text = request.getParameter("message");
		Post post = new Post();
		User user = (User) session.getAttribute("currUser");

		if (!(session.getAttribute("currUser") == null)) {
			username = user.getUsername();
		} else {
			username = "NULL";
		}

		post.setUsername(username);
		post.setCreatedAt(LocalDate.now());
		post.setPostText(text);
		post.setPostId(postService.findMaxId() + 1);

		LOGGER.info("[LOGGER INFO] Post text: " + post.getPostText());
		LOGGER.info("[LOGGER INFO] Post UserId: " + post.getUsername());
		LOGGER.info("[LOGGER INFO] Post CreatedAt: " + post.getCreatedAt());
		LOGGER.info("[LOGGER INFO] Post ID: " + post.getPostId());

		postService.savePost(post);

		return "redirect:/myPosts";
	}

	

	@RequestMapping(value = "/editPost", method = RequestMethod.GET)
	public String editPost(HttpServletRequest request,
			@RequestParam("idPost") int id,@RequestParam("username") String username, ModelMap model) {

		Post post = postService.findById(id);
		model.addAttribute("post",post);
		
		List<Post> posts = postService.findAllPosts(username);
		
		model.addAttribute("posts", posts);
		model.addAttribute("postLen",posts.size());
		
		
		model.addAttribute("idPost", id);
			
		
		User user = service.findUserByUsername(username);
		model.addAttribute("username",user.getUsername());
		
		return "editPost";
	}
	
	@RequestMapping(value = "/editPost", method = RequestMethod.POST)
	public String saveEditedPost(@Valid Post post,BindingResult result,HttpServletRequest request,ModelMap model){
	
		
		postService.updatePost(post);

		return "redirect:/showMyPosts";
	}

	
	@RequestMapping(value = { "/deletePost" }, method = RequestMethod.GET)
	public String deletePost(@RequestParam("idPost") int idPost) {
		postService.deletePostById(idPost);
		return "redirect:/showMyPosts"; 
	}
	
}
