package com.phanmemquanly.dao.impl;

import com.phanmemquanly.dao.PatientDao;

import com.phanmemquanly.domain.Patient;

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
public class PatientDaoImpl implements PatientDao {
	@Autowired
	private EntityManager entityManager;
			
	@Override
	public List<Patient> getPatients() {
		
		Session currentSession = entityManager.unwrap(Session.class);
		
		// get the current hibernate session

				
		// create a query
		Query<Patient> theQuery = 
				currentSession.createQuery("from Patient", Patient.class);
		
		// execute query and get result list
		List<Patient> Patients = theQuery.getResultList();
				
		// return the results		
		return Patients;
	}
	
	@Override
	public void savePatient(Patient thePatient) {

		// get current hibernate session
		
		Session currentSession = entityManager.unwrap(Session.class);

		
		// save/update the Patient
		currentSession.saveOrUpdate(thePatient);
		
	}
	
	@Override
	public Patient getPatient(int theId) {

		// get the current hibernate session
		
		Session currentSession = entityManager.unwrap(Session.class);

		
		// now retrieve/read from database using the primary key
		Patient thePatient = currentSession.get(Patient.class, theId);
		
		return thePatient;
	}

	@Override
	public void deletePatient(int theId) {

		// get the current hibernate session
		
		Session currentSession = entityManager.unwrap(Session.class);

//		Session currentSession = entityManager.getCurrentSession();
		
		// delete object with primary key
		Query theQuery = 
				currentSession.createQuery("delete from Patient where idBenhNhan=:idBenhNhan");
		theQuery.setParameter("idBenhNhan", theId);
		
		theQuery.executeUpdate();		
	}

	@Override
	public Patient getPatient(String hotenBN) {

		Session currentSession = entityManager.unwrap(Session.class);
		
		TypedQuery<Patient> theQuery = 
				currentSession.createQuery("select c from Patient c where hotenBN=:hotenBN", Patient.class);
		theQuery.setParameter("hotenBN", hotenBN);
		Patient thePatient = theQuery.getSingleResult();
		
		// now retrieve/read from database using the primary key
		
		return thePatient;
	}


}
