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

	/*public List<Post> limitTenPosts(int begin,int end) {
		
		Query query = getSession().createSQLQuery(
				"SELECT post_id,post_text FROM post LIMIT :begin, :end");
		query.setParameter("begin", begin);
		query.setParameter("end", end);
		return (List<Post>) query.list();	
		
	}
*/
	public List<Post> findPostsForPage(Long page) {
		Query query = getSession().createSQLQuery(
				"SELECT post_text FROM post LIMIT :begin, :end");
		
		
		query.setParameter("begin", (page-1)*10 + 1);
		
		
	
		query.setParameter("end", (page-1)*10+10);
		
		return (List<Post>) query.list();
		
	}
	

}

