package com.revature.ERS.repository;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.revature.ERS.model.Reimbursement;
import com.revature.ERS.util.HibernateUtil;

public class ReimbursementDAO {
	
	public List<Reimbursement> allReimbursements() {
		Session session = HibernateUtil.getSession();
		return session.createQuery("from Reimbursement").list();
	}
	
	
	public int saveReimbursement(Reimbursement r) {
		Session session = HibernateUtil.getSession();
		Transaction tx = session.beginTransaction();
		int result = (int) session.save(r);
		tx.commit();
		return result;
	}
	
	public int nextReimbursementID() {
		Session session = HibernateUtil.getSession();
		Query query = session.createQuery("select max(rID) from Reimbursement");
		int maxID = (int) query.uniqueResult();
		return maxID +1;
	}
	
	public int nextReimbursementTypeID() {
		Session session = HibernateUtil.getSession();
		Query query = session.createQuery("select max(rID) from ReimbursementType");
		int maxID = (int) query.uniqueResult();
		return maxID +1;
	}
	
	public int nextReimbursementStatusID() {
		Session session = HibernateUtil.getSession();
		Query query = session.createQuery("select max(rID) from ReimbursementStatus");
		int maxID = (int) query.uniqueResult();
		return maxID +1;
	}
}
