package com.phanmemquanly.service;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import com.phanmemquanly.domain.TiepNhan;

public interface TiepNhanService {

	void deleteAll();

	void deleteAll(Iterable<? extends TiepNhan> entities);

	void deleteAllById(Iterable<? extends Integer> ids);

	TiepNhan getReferenceById(Integer id);

	void delete(TiepNhan entity);

	TiepNhan getById(Integer id);

	void deleteById(Integer id);

	Optional<TiepNhan> findById(Integer id);

	List<TiepNhan> findAllById(Iterable<Integer> ids);

	List<TiepNhan> findAll();

	Page<TiepNhan> findAll(Pageable pageable);

	List<TiepNhan> findAll(Sort sort);

	<S extends TiepNhan> List<S> saveAll(Iterable<S> entities);

	<S extends TiepNhan> S save(S entity);

}
