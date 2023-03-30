package com.phanmemquanly.service;

import java.util.List;
import java.util.Optional;
import java.util.function.Function;

import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.query.FluentQuery.FetchableFluentQuery;

import com.phanmemquanly.domain.Patient;
import com.phanmemquanly.model.PatientDto;

public interface PatientService {

	void deleteAll();

	void deleteAll(Iterable<? extends Patient> entities);

	void deleteAllById(Iterable<? extends Integer> ids);

	void delete(Patient entity);

	Patient getById(Integer id);

	void deleteById(Integer id);

	long count();

	<S extends Patient, R> R findBy(Example<S> example, Function<FetchableFluentQuery<S>, R> queryFunction);

	void deleteAllInBatch();

	<S extends Patient> long count(Example<S> example);

	void deleteAllByIdInBatch(Iterable<Integer> ids);

	boolean existsById(Integer id);

	void deleteAllInBatch(Iterable<Patient> entities);

	Optional<Patient> findById(Integer id);

	List<Patient> findAllById(Iterable<Integer> ids);
	
	

	List<Patient> findAll();

	Page<Patient> findAll(Pageable pageable);

	List<Patient> findAll(Sort sort);

	<S extends Patient> List<S> saveAll(Iterable<S> entities);

	<S extends Patient> S save(S entity);

	Page<Patient> findByHotenBNContaining(String hotenBN, Pageable pageable);

	List<Patient> findByHotenBNContaining(String hotenBN);

	List<PatientDto> getPatient();

	
}
