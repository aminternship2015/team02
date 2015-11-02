package com.websystique.springmvc.controller;

import java.util.ArrayList;
import java.util.Collections;
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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.websystique.springmvc.model.Post;
import com.websystique.springmvc.model.User;
import com.websystique.springmvc.service.PostService;

@Controller
public class PostController {

	@Autowired
	PostService postService;
	
	Logger logger = LoggerFactory.getLogger(AppController.class);
	
	@RequestMapping(value = { "/myPosts" }, method = RequestMethod.GET)
	public String listPosts(@RequestParam(defaultValue = "1") Long page, ModelMap model,HttpSession session) {
		
		logger.error("Post were displayed!!");
//		String page = request.getParameter("page");
		
//		if (page == null){model.addAttribute("page2","0");}
//		else{
//		model.addAttribute("page2",page);}
		
		
		
		User user = (User) session.getAttribute("currUser");
		String username;
		try{
		username = user.getUsername();}
		catch(NullPointerException e){
			username="NULL";
		}
		
		//logger.error("User " + user.getUsername() + " logged in");
		
			if(!(session.getAttribute("currUser") == null))
	
			{
		logger.info("[LOGGER INFO] User "+username+" logged in");	
		logger.error("User is trying to make a new post");
		user = (User) session.getAttribute("currUser");
		model.addAttribute("username",user.getUsername());
		List<Post> posts = postService.findAllPosts();
		
		//model.addAttribute("sizePages",allListsPost().size());
		
		List<Post> posts2 = postService.findPostsForPage(page);
		
		
			logger.info("------------------------------------------");
			logger.info("[LOGGER INFO] POST "+posts2.get(0).getPostText());
			logger.info("------------------------------------------");
		
		
		Collections.reverse(posts);
		
		
		
		int postLength = postService.countPosts();
		logger.info("[LOGGER INFO] POST LENGTH: "+postLength);	
		
		
		model.addAttribute("page", page);
		model.addAttribute("posts", posts);
		model.addAttribute("total", postService.countPosts()/10 +2);
		
		
//		Post newPost = new Post();
//		newPost.setUserId(2);
//		newPost.setCreatedAt(LocalDate.now());
//		model.addAttribute("newPost", newPost);				
			}else{
		
			logger.error("redirected to logged in");
			return "login";
			}
		return "posts";
	}
	
	@ModelAttribute("myPost")
	public Post getPost() {
		return new Post();
	}

	
	
//	@RequestMapping(value = { "/savePost" }, method = RequestMethod.GET)
//	public String newPost(ModelMap model,HttpSession session) {
//		Post post = new Post();
//		post.setUserId(2);
//		post.setCreatedAt(LocalDate.now());
//		model.addAttribute("newPost", post);
//		return "redirect:/myPosts";
//	}
	
	@RequestMapping(value = { "/savePost" }, method = RequestMethod.POST)
	public String savePost(
			ModelMap model,HttpServletRequest request,HttpSession session) {
		
		String text = request.getParameter("message");
		
//		if (result.hasErrors()) {
//			logger.error(result.getAllErrors().toString());
//			return "registration";
//		}
//		postService.savePost(post);
//		//model.addAttribute("success");
		Post post = new Post();
		User user = (User) session.getAttribute("currUser");
		String username;
		
		if(!(session.getAttribute("currUser") == null))
			
		{username = user.getUsername();}
		else{
			username="NULL";
		}
		
		post.setUsername(username);
		post.setCreatedAt(LocalDate.now());
		post.setPostText(text);
		post.setPostId(postService.findMaxId()+1);
		logger.info("[LOGGER INFO] Post text: "+ post.getPostText());
		logger.info("[LOGGER INFO] Post UserId: "+ post.getUsername());
		logger.info("[LOGGER INFO] Post CreatedAt: "+ post.getCreatedAt());
		logger.info("[LOGGER INFO] Post ID: "+ post.getPostId());
		postService.savePost(post);
		
		
		return "redirect:/myPosts";
	}
	
	/*public List<List<Post>> allListsPost(){
		List <Post> myList = postService.findAllPosts(); 
		ArrayList<ArrayList<Post>> allPosts = new ArrayList<ArrayList<Post>>();
		for(int i=0;i<myList.size();i+=10){
			allPosts.add(new ArrayList(
										(ArrayList)postService.limitTenPosts(i,i+10)
									   )
			);
		}
		return (ArrayList) allPosts;
	}*/
	
	
}
