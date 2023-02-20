package com.phanmemquanly.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.phanmemquanly.domain.Patient;

@Repository
public interface PatientRepository extends JpaRepository<Patient, Integer>{
	List<Patient> findByHotenBNContaining(String hotenBN);
	Page<Patient> findByHotenBNContaining(String hotenBN, Pageable pageable);

}
