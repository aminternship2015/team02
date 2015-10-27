package com.websystique.springmvc.dao;

import java.util.List;

import com.websystique.springmvc.model.User;

public interface UserDao {
	User findById(int id);

	void saveUser(User user);

	void deleteUserByUsername(String username);

	List<User> findAllUsers();

	User findUserByUsername(String username);

	boolean isValidUser(String username);

}
