package com.revature.ERS.repository;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.revature.ERS.model.Users;
import com.revature.ERS.util.HibernateUtil;

public class UserDAO {
	
	
	public List<Users> getUsers() {
		Session session = HibernateUtil.getSession();
		return session.createQuery("from Users").list();
	}
	
	public int insertUser(Users u) {
		Session session = HibernateUtil.getSession();
		Transaction tx = session.beginTransaction();
		int result = (int) session.save(u);
		tx.commit();
		return result;
	}
}