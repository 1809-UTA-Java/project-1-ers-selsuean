package com.revature.ERS.repository;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
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

	public Reimbursement thisReimbursement(int reimbID) {
		Reimbursement exist = null;

		List<Reimbursement> reimb = new ArrayList<>();
		Session session = HibernateUtil.getSession();
		reimb = session.createQuery("from Reimbursement where rID = :rIDVar").setInteger("rIDVar", reimbID).list();
		if (!reimb.isEmpty()) {
			exist = reimb.get(0);
		}
		return exist;
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
		int maxID = 0;
		Query query = session.createQuery("select max(rID) from Reimbursement");
		if (query.uniqueResult() != null) {
			maxID = (int) query.uniqueResult();
		}

		return maxID + 1;
	}

	public int nextReimbursementTypeID() {
		Session session = HibernateUtil.getSession();
		int maxID = 0;
		Query query = session.createQuery("select max(rID) from ReimbursementType");
		if (query.uniqueResult() != null) {
			maxID = (int) query.uniqueResult();
		}

		return maxID + 1;
	}

	public int nextReimbursementStatusID() {
		Session session = HibernateUtil.getSession();
		int maxID = 0;
		Query query = session.createQuery("select max(rID) from ReimbursementStatus");
		if (query.uniqueResult() != null) {
			maxID = (int) query.uniqueResult();
		}

		return maxID + 1;
	}

	public void actionReimbursement(int id, String action) {
		Session session = HibernateUtil.getSession();
		Transaction tx = session.beginTransaction();
		Query query = session.createQuery("update ReimbursementStatus set rStatus = :actionVar where rID = :idVar")
				.setString("actionVar", action).setInteger("idVar", id);
		query.executeUpdate();
		tx.commit();
		// update ReimbursementStatus set rStatus = :actionVar where rID = :idVar
	}
	
	public void saveImage(int id) throws IOException {
		Session session = HibernateUtil.getSession();
		Transaction tx = session.beginTransaction();
		
		File imagePath = new File("image.jpg");
		
		/** CONVERTS IMAGE TO BYTES 	 */
		byte[] imageToByte = new byte[(int)imagePath.length()];
		
		/** CREATE INPUT OBJECT   */
		FileInputStream inputStream = new FileInputStream(imagePath);
		
		/** INPUT STREAM READS FILE    */
		inputStream.read(imageToByte);
		inputStream.close();
		
		Query query = session.createQuery("update Reimbursements set image := imageVar where rID = :idVar")
				.setBinary("imageVar", imageToByte).setInteger("idVar", id);
		query.executeUpdate();
		tx.commit();
	}

}
