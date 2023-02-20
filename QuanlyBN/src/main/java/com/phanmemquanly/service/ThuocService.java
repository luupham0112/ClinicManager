package com.phanmemquanly.service;

import java.util.List;
import java.util.Optional;
import java.util.function.Function;

import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.query.FluentQuery.FetchableFluentQuery;

import com.phanmemquanly.domain.Thuoc;

public interface ThuocService {

	void deleteAll();

	void deleteAll(Iterable<? extends Thuoc> entities);

	void deleteAllById(Iterable<? extends Integer> ids);

	Thuoc getReferenceById(Integer id);

	void delete(Thuoc entity);

	Thuoc getById(Integer id);

	void deleteById(Integer id);

	long count();

	<S extends Thuoc, R> R findBy(Example<S> example, Function<FetchableFluentQuery<S>, R> queryFunction);

	Thuoc getOne(Integer id);

	void deleteAllInBatch();

	<S extends Thuoc> boolean exists(Example<S> example);

	void deleteAllByIdInBatch(Iterable<Integer> ids);

	boolean existsById(Integer id);

	void deleteAllInBatch(Iterable<Thuoc> entities);

	Optional<Thuoc> findById(Integer id);

	List<Thuoc> findAllById(Iterable<Integer> ids);

	List<Thuoc> findAll();

	<S extends Thuoc> List<S> saveAllAndFlush(Iterable<S> entities);

	<S extends Thuoc> S saveAndFlush(S entity);

	Page<Thuoc> findAll(Pageable pageable);

	void flush();

	List<Thuoc> findAll(Sort sort);

	<S extends Thuoc> List<S> saveAll(Iterable<S> entities);

	<S extends Thuoc> S save(S entity);

	List<Thuoc> findByNameThuocContaining(String namThuoc);

	Page<Thuoc> findByNameThuocContaining(String namThuoc, Pageable pageable);

	

}
