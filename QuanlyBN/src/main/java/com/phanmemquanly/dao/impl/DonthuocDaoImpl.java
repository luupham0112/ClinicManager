package com.phanmemquanly.dao.impl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;

import com.phanmemquanly.dao.DonthuocDao;
import com.phanmemquanly.domain.Donthuoc;
@Transactional
@Repository
public class DonthuocDaoImpl implements DonthuocDao {
	@Autowired
	private EntityManager entityManager;

	@Override
	public List<Donthuoc> getDonthuoc() {


		Session currentSession = entityManager.unwrap(Session.class);

		// create a query
		Query<Donthuoc> theQuery = currentSession.createQuery("from Donthuoc", Donthuoc.class);

		// execute query and get result list
		List<Donthuoc> donthuocs = theQuery.list();

		// return the results
		return donthuocs;
	}

	@Override
	public Donthuoc getLastDonthuoc() {
		Session currentSession = entityManager.unwrap(Session.class);

		Query<Donthuoc> query = currentSession
				.createQuery("select oh from Donthuoc oh order by oh.idDonthuoc desc", Donthuoc.class);
		query.setMaxResults(1);
		Donthuoc oh = query.uniqueResult();

//		
		currentSession.flush();

		return oh;
	}

	@Override
	public void saveDonthuoc(Donthuoc donthuoc) {
		Session currentSession = entityManager.unwrap(Session.class);

		currentSession.saveOrUpdate(donthuoc);

	}

	@Override
	public Donthuoc getDonthuocById(Integer DonthuocId) {
		Session currentSession = entityManager.unwrap(Session.class);

		Integer id = ((Number) DonthuocId).intValue();
		Donthuoc oh = currentSession.get(Donthuoc.class, id);
		return oh;
	}

	@Override
	public List<Donthuoc> getAllOrders() {
		Session currentSession = entityManager.unwrap(Session.class);

		Query query = currentSession.createQuery("select oh from Donthuoc oh");
		List<Donthuoc> donthuocs = query.list();
		return donthuocs;
	}

//	@Override
//	public List<Donthuoc> getAllOrders(String type) {
//		Session currentSession = entityManager.unwrap(Session.class);
//
//		Query query = currentSession.createQuery("select oh from Donthuoc oh where oh.type in :typeParam");
//		query.setParameter("typeParam", type);
//		List<Donthuoc> Donthuocs = query.list();
//		return Donthuocs;
//	}

	@Override
	public Donthuoc getDonthuocByNumber(String DonthuocNumber) {
		Session currentSession = entityManager.unwrap(Session.class);

		TypedQuery<Donthuoc> theQuery = currentSession
				.createQuery("select c from Donthuoc c where number=:number", Donthuoc.class);
		theQuery.setParameter("number", DonthuocNumber);
		Donthuoc Donthuoc = theQuery.getSingleResult();

		// now retrieve/read from database using the primary key

		return Donthuoc;
	}

}
