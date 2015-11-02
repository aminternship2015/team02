package com.websystique.springmvc.service;

import java.util.List;

import com.websystique.springmvc.model.Post;
import com.websystique.springmvc.model.User;

public interface PostService {
	public Post findById(int id);

	void savePost(Post post);

	void updatePost(Post post);
	
	List<Post> AllPosts();

	List<Post> findAllPosts(String username);

	public int findMaxId();

	public int countPosts();

	List<Post> findPostsForPage(int page, String currUser);

	void deletePostById(int idPost);

}
