package com.websystique.springmvc.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.websystique.springmvc.dao.*;
import com.websystique.springmvc.model.User;

@Service("userService")
@Transactional
public class UserServiceImpl implements UserService {

	@Autowired
	private UserDao userDao;

	public User findById(int id) {
		return userDao.findById(id);
	}

	public void saveUser(User user) {
		userDao.saveUser(user);
	}

	public void updateUser(User user) {
		User entity = userDao.findById(user.getUserId());
		if (entity != null) {
			entity.setName(user.getName());
			entity.setUsername(user.getUsername());
			entity.setAdmin(user.getAdmin());
			entity.setEmail(user.getEmail());
			entity.setCreatedAt(user.getCreatedAt());
			entity.setAvatar(user.getAvatar());
		}
	}

	public void deleteUserByUsername(String username) {
		userDao.deleteUserByUsername(username);
	}

	public List<User> findAllUsers() {
		return userDao.findAllUsers();
	}

	public User findUserByUsername(String username) {
		return userDao.findUserByUsername(username);
	}

	public boolean isUserUsernameUnique(Integer id, String username) {
		User user = findUserByUsername(username);
		return (user == null || ((id != null) && (user.getUserId() == id)));
	}

	public boolean isUserEmailNotNull(Integer id) {
		User user = findById(id);
		return (user.getEmail().equals(null));
	}

	public boolean isValidUser(String username) {
		if (findUserByUsername(username).equals(null))
			return false;
		else
			return true;
	}

}
