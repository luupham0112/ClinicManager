package com.phanmemquanly.dao;

import java.util.List;

import com.phanmemquanly.domain.Patient;

public interface PatientDao {

	Patient getPatient(String hotenBN);

	void deletePatient(int theId);

	Patient getPatient(int theId);

	void savePatient(Patient thePatient);

	List<Patient> getPatients();

}
