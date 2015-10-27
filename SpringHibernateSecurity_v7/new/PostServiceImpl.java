package com.websystique.springmvc.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.websystique.springmvc.dao.PostDao;
import com.websystique.springmvc.model.Post;

@Service("postService")
@Transactional
public class PostServiceImpl implements PostService {

	@Autowired
	private PostDao postDao;

	public void savePost(Post post) {
		postDao.savePost(post);

	}

	public List<Post> findAllPosts() {
		return postDao.findAllPosts();
	}
	
	public int findMaxId(){
		return postDao.findMaxId();
	}
	
	public int countPosts(){
		return postDao.countPosts();
		
	}

	@Override
	public List<Post> findPostsForPage(Long page) {
		return postDao.findPostsForPage(page);
	}

}
