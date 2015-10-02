package com.endava.models.entities;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
			
		Users user = new Users();
		//user.setUserId(2);
//		user.setName("FirstUser");
//		user.setUsername("LittleBaby");
//		user.setAdmin("admin");
//		user.setPassword("1234");
//		user.setCreatedAt("2012-10-23 23:59");
		//Posts post = new Posts(1,1,"jfflsflslksklf","2012-10-23 23:59");
		Relations relation = new Relations(1,2);
		
		
		
		SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		session.save(relation);		
		session.getTransaction().commit();
		session.flush();
		session.close();
	}

}

//<property name="hibernate.hbm2ddl.auto">create-drop</property>