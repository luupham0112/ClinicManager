package com.phanmemquanly.dao.impl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;

import com.phanmemquanly.dao.DonthuocDetailDao;
import com.phanmemquanly.domain.DonthuocDetail;

@Repository
public class DonthuocDetailDaoImpl implements DonthuocDetailDao {
	@Autowired
	private EntityManager entityManager;
	
	@Override
	public List<DonthuocDetail> getDonthuocDeatails() {
		// get the current hibernate session
				Session currentSession = entityManager.unwrap(Session.class);
						
				// create a query
				Query<DonthuocDetail> theQuery = 
						currentSession.createQuery("from DonthuocDetail", DonthuocDetail.class);
				
				// execute query and get result list
				List<DonthuocDetail> donthuocDetails = theQuery.getResultList();
						
				// return the results		
				return donthuocDetails;
	}

	@Override
	public void saveDonthuocDetail(DonthuocDetail donthuocDetail) {

		
		// get current hibernate session
		Session currentSession = entityManager.unwrap(Session.class);
		
		// save/update the OrderLine
		currentSession.saveOrUpdate(donthuocDetail);
	}
	
	@Override
	public List<DonthuocDetail> getOrderLineByOrderHeaderID(int idDonthuoc) {
		Session currentSession = entityManager.unwrap(Session.class);

		TypedQuery<DonthuocDetail> theQuery = currentSession
				.createQuery("select ol from DonthuocDetail ol where id_donthuoc=:id_donthuoc", DonthuocDetail.class);
		theQuery.setParameter("id_donthuoc", idDonthuoc);
		List<DonthuocDetail> donthuocDetails = theQuery.getResultList();
		
		return donthuocDetails;

	}
	
	@Override
	public void deleteDonthuocDeatil(int theId) {
		// get the current hibernate session

		Session currentSession = entityManager.unwrap(Session.class);

//				Session currentSession = entityManager.getCurrentSession();

		// delete object with primary key
		Query theQuery = currentSession.createQuery("delete from DonthuocDetail where donthuocDetailId=:donthuocDetailId");
		theQuery.setParameter("donthuocDetailId", theId);

		theQuery.executeUpdate();
	}

}
