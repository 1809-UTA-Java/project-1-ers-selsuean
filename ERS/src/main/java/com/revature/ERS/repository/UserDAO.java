package com.revature.ERS.repository;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.revature.ERS.model.Users;
import com.revature.ERS.util.HibernateUtil;

public class UserDAO {
	
	
	public List<Users> getUsers() {
		
		/**
		 * Session interface has several methods that can be used in saving data to the db:
		 * persist, save, update, merge, saveorupdate
		 * Three main states in Session persistence context:
		 * 	- transient: instance is not and never was attached to a Session; has no corresponding
		 * 				row in database, usually a new object that you have created to save to the db
		 *  - persistent: instance is associated with a unique Session object, when Session is
		 *  			flushed, this entity is guaranteed to have a correponsding consistent
		 *  			record in db
		 *  - detached: instance was once attached to a Session but now is not
		 * 
		 * 
		 * What's inside createQuery is the Hibernate object to be mapped; should be
		 * closer to the class name (instead of the table name)
		 */
		Session session = HibernateUtil.getSession();
		return session.createQuery("from Users").list();
	}
	
	public int insertUser(Users u) {
		
		/**
		 * Transaction is a REST interface in Hibernate that manages
		 * ACID compliant transactions 
		 * atomicity, consistency, isolation, durability
		 * 
		 * session.save(obj) will save the object into the db (move it to a persistent state)
		 */
		Session session = HibernateUtil.getSession();
		Transaction tx = session.beginTransaction();
		int result = (int) session.save(u);
		tx.commit();
		return result;
	}
}