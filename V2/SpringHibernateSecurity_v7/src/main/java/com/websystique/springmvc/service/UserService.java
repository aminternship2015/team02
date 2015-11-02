package com.websystique.springmvc.service;

import java.util.List;

import com.websystique.springmvc.model.User;

public interface UserService {
	User findById(int id);

	void saveUser(User User);

	void updateUser(User User);

	void deleteUserByUsername(String username);

	List<User> findAllUsers();

	User findUserByUsername(String username);

	boolean isUserUsernameUnique(Integer id, String username);

	boolean isUserEmailNotNull(Integer id);

	boolean isValidUser(String username);

}
