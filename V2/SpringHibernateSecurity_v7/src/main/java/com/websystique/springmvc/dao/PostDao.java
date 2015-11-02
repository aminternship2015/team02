package com.websystique.springmvc.dao;

import java.util.List;

import com.websystique.springmvc.model.Post;

public interface PostDao {

	void savePost(Post post);

	List<Post> findAllPosts();
	
	public int findMaxId();
	
	public int countPosts();
	
	List<Post> findPostsForPage(Long page);
	
	
	
	//public List<Post> limitTenPosts(int begin,int end);
}
