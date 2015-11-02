package com.websystique.springmvc.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import com.websystique.springmvc.model.User;

@Repository("userDao")
public class UserDaoImpl extends AbstractDao<Integer, User> implements UserDao {

	public User findById(int id) {
		return getByKey(id);
	}

	public void saveUser(User user) {
		persist(user);
	}
	
	public void deleteUserByUsername(String username) {
		Query query = getSession().createSQLQuery(
				"delete from user where username = :username");
		query.setString("username", username);
		query.executeUpdate();

	}

	@SuppressWarnings("unchecked")
	public List<User> findAllUsers() {
		Criteria criteria = createEntityCriteria();
		return (List<User>) criteria.list();
	}

	public User findUserByUsername(String username) {
		Criteria criteria = createEntityCriteria();
		criteria.add(Restrictions.eq("username", username));
		return (User) criteria.uniqueResult();
	}

	public boolean isValidUser(String username) {
		if (findUserByUsername(username).equals(null))
			return false;
		else
			return true;
	}

}
