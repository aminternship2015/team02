package com.websystique.springmvc.service;

import java.util.List;

import com.websystique.springmvc.model.Post;
import com.websystique.springmvc.model.User;

public interface PostService {
	public Post findById(int id);
	
	void savePost(Post post);
	
	void updatePost(Post post);

	List<Post> findAllPosts();
	
	public int findMaxId();
	
	public int countPosts();
	
	List<Post> findPostsForPage(int page);
	
	//public List<Post> limitTenPosts(int begin,int end);
	
	void deletePostById(int idPost);
	
	
}
