package com.websystique.springmvc.dao;

import java.util.List;

import com.websystique.springmvc.model.Post;

public interface PostDao {
	Post findById(int id);

	void savePost(Post post);

	List<Post> findAllPosts();
	
	public int findMaxId();
	
	public int countPosts();
	
	List<Post> findPostsForPage(int page);
	
	void deletePostById(int idPost);
	
	
	//public List<Post> limitTenPosts(int begin,int end);
}
