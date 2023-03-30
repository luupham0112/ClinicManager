package com.phanmemquanly.dao.impl;

import com.phanmemquanly.dao.ThuocDao;

import com.phanmemquanly.domain.Thuoc;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;
@Transactional
@Repository
public class ThuocDaoImpl implements ThuocDao {
	@Autowired
	private EntityManager entityManager;

	@Override
	public List<Thuoc> getThuocs() {

		// get the current hibernate session
		Session currentSession = entityManager.unwrap(Session.class);

		// create a query
		Query<Thuoc> theQuery = currentSession.createQuery("from Thuoc", Thuoc.class);

		// execute query and get result list
		List<Thuoc> Thuocs = theQuery.getResultList();

		// return the results
		return Thuocs;
	}

	@Override
	public void saveThuoc(Thuoc theThuoc) {

		// get current hibernate session
		Session currentSession = entityManager.unwrap(Session.class);

		// save/upate the Thuoc ...
		currentSession.saveOrUpdate(theThuoc);

	}

	@Override
	public Thuoc getThuoc(int theId) {

		Session currentSession = entityManager.unwrap(Session.class);

		// now retrieve/read from database using the primary key
		Thuoc theThuoc = currentSession.get(Thuoc.class, theId);

		return theThuoc;

	}

	@Override
	public void deleteThuoc(int theId) {
		// get the current hibernate session

		Session currentSession = entityManager.unwrap(Session.class);

//			

		// delete object with primary key
		Query theQuery = currentSession.createQuery("delete from Thuoc where idThuoc=:idThuoc");
		theQuery.setParameter("idThuoc", theId);

		theQuery.executeUpdate();
	}

	@Override
	public Thuoc getThuoc(String name) {
		Session currentSession = entityManager.unwrap(Session.class);

		TypedQuery<Thuoc> theQuery = currentSession.createQuery("select c from Thuoc c where nameThuoc=:nameThuoc",
				Thuoc.class);
		theQuery.setParameter("nameThuoc", name);
		Thuoc theThuoc = theQuery.getSingleResult();

		// now retrieve/read from database using the primary key

		return theThuoc;
	}


}
