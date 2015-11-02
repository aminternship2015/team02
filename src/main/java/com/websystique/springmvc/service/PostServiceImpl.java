package com.websystique.springmvc.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.websystique.springmvc.dao.PostDao;
import com.websystique.springmvc.model.Post;
import com.websystique.springmvc.model.User;

@Service("postService")
@Transactional
public class PostServiceImpl implements PostService {

	@Autowired
	private PostDao postDao;

	public Post findById(int id) {
		return postDao.findById(id);
	}

	public void savePost(Post post) {
		postDao.savePost(post);
	}

	public List<Post> findAllPosts(String username) {
		return postDao.findAllPosts(username);
	}
	
	public List<Post> AllPosts(){
		return postDao.AllPosts();
	}

	public int findMaxId() {
		return postDao.findMaxId();
	}

	public int countPosts() {
		return postDao.countPosts();
	}

	public List<Post> findPostsForPage(int page, String currUser) {
		return postDao.findPostsForPage(page, currUser);
	}

	public void updatePost(Post post) {
		Post entity = postDao.findById(post.getPostId());
		if (entity != null) {
			entity.setPostText(post.getPostText());
			// entity.setCreatedAt(post.getCreatedAt());
		}

	}

	public void deletePostById(int idPost) {
		postDao.deletePostById(idPost);
	}
}
