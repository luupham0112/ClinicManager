package com.phanmemquanly.service;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import com.phanmemquanly.domain.KhamBenh;

public interface KhamBenhService {

	Page<KhamBenh> findByIdKhamBenhContaining(int idKhambenh, Pageable pageable);

	List<KhamBenh> findByIdKhamBenhContaining(int idKhambenh);

	List<KhamBenh> getKhambenhinPatient(int idBenhNhan);

	void deleteAll(Iterable<? extends KhamBenh> entities);

	void delete(KhamBenh entity);

	KhamBenh getById(Integer id);

	void deleteById(Integer id);

	long count();

	void deleteAllInBatch();

	<S extends KhamBenh> long count(Example<S> example);

	Optional<KhamBenh> findById(Integer id);

	List<KhamBenh> getAllKhamBenhByPatientId(int id);

	List<KhamBenh> findAllById(Iterable<Integer> ids);

	List<KhamBenh> findAllByPatient(int id);

	List<KhamBenh> findAll();

	<S extends KhamBenh> S save(S entity);

	Page<KhamBenh> findAll(Pageable pageable);

	List<KhamBenh> findByBacSi(String bacsi);

	
}
