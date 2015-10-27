package com.websystique.springmvc.dao;

import java.math.BigInteger;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.springframework.stereotype.Repository;

import com.websystique.springmvc.model.Post;

@Repository("postDao")
public class PostDaoImpl extends AbstractDao<Integer, Post> implements PostDao {

	public void savePost(Post post) {
		persist(post);

	}

	@SuppressWarnings("unchecked")
	public List<Post> findAllPosts() {
		Criteria criteria = createEntityCriteria();
		return (List<Post>) criteria.list();
	}

	
	
	public int findMaxId(){
		Query query = getSession().createSQLQuery(
				"SELECT max(post_id) FROM mydb_test.post");
		Integer max = (Integer) query.uniqueResult();
		if (max == null) {
			return 0;
		}
		
		return max.intValue();
		
	}
	
	public int countPosts(){
		Query query = getSession().createSQLQuery(
				"SELECT count(post_id) FROM mydb_test.post");
		BigInteger count =  (BigInteger) query.uniqueResult();
		return count.intValue();
		//return 0;
	}

	@Override
	public List<Post> findPostsForPage(Long page) {
		// TODO Auto-generated method stub
		return null;
	}
}

