package com.phanmemquanly.service;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import com.phanmemquanly.domain.User;

public interface UserService {

	void deleteAll();

	void deleteAll(Iterable<? extends User> entities);

	void delete(User entity);

	void deleteById(String id);

	Optional<User> findById(String id);

	List<User> findAllById(Iterable<String> ids);

	List<User> findAll();

	Page<User> findAll(Pageable pageable);

	List<User> findAll(Sort sort);

	<S extends User> List<S> saveAll(Iterable<S> entities);

	<S extends User> S save(S entity);

	List<User> findByUserNameContaining(String userName);

}
