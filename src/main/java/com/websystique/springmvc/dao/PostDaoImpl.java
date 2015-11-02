package com.websystique.springmvc.dao;

import java.math.BigInteger;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.criterion.Order;
import org.springframework.stereotype.Repository;

import com.websystique.springmvc.model.Post;

@Repository("postDao")
public class PostDaoImpl extends AbstractDao<Integer, Post> implements PostDao {
	
	public Post findById(int id) {
		return getByKey(id);
	}
	
	public void savePost(Post post) {
		persist(post);
	}

	@SuppressWarnings("unchecked")
	public List<Post> findAllPosts() {
		Criteria criteria = createEntityCriteria();
		return (List<Post>) criteria.list();
	}

	public int findMaxId() {
		Query query = getSession().createSQLQuery(
				"SELECT max(post_id) FROM mydb_test.post");
		Integer max = (Integer) query.uniqueResult();
		if (max == null) {
			return 0;
		}
		return max.intValue();
	}

	public int countPosts() {
		Query query = getSession().createSQLQuery(
				"SELECT count(post_id) FROM mydb_test.post");
		BigInteger count = (BigInteger) query.uniqueResult();
		return count.intValue();
	}

	public List<Post> findPostsForPage(int page) {
		Criteria criteria = getSession().createCriteria(Post.class);
		criteria.addOrder(Order.desc("postId"));
		criteria.setFirstResult((page - 1) * 10);
		criteria.setMaxResults((page - 1) * 10 + 10);
		return criteria.list();
	}
	
	public void deletePostById(int idPost){
		Query query = getSession().createSQLQuery(
				"delete from post where post_id = :post_id");
		query.setInteger("post_id", idPost);
		query.executeUpdate();
		
	}
}
