package com.phanmemquanly.service;

import java.util.List;
import java.util.Optional;

import com.phanmemquanly.domain.ServiceExam;

public interface ServiceExamService {

	void deleteById(Integer id);

	Optional<ServiceExam> findById(Integer id);

	List<ServiceExam> findAll();

	<S extends ServiceExam> S save(S entity);

}
