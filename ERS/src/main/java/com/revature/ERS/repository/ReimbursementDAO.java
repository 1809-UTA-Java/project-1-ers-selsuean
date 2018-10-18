package com.revature.ERS.repository;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.revature.ERS.model.Reimbursement;
import com.revature.ERS.util.HibernateUtil;

public class ReimbursementDAO {
	
	public List<Reimbursement> getReimbursements() {
		Session session = HibernateUtil.getSession();
		return session.createQuery("from Reimbursement").list();
	}
	
	public int addReimbursement(Reimbursement r) {
		Session session = HibernateUtil.getSession();
		Transaction tx = session.beginTransaction();
		int result = (int) session.save(r);
		tx.commit();
		return result;
		
	}
}
