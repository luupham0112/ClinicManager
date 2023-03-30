package com.phanmemquanly.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import com.phanmemquanly.domain.ServiceExam;
import com.phanmemquanly.repository.ServiceExamRepository;
import com.phanmemquanly.service.ServiceExamService;

@Service
public class ServiceExamServiceImpl implements ServiceExamService {
	ServiceExamRepository serviceExamRepository;

	public ServiceExamServiceImpl(ServiceExamRepository serviceExamRepository) {

		this.serviceExamRepository = serviceExamRepository;
	}

	@Override
	public <S extends ServiceExam> S save(S entity) {
		return serviceExamRepository.save(entity);
	}

	@Override
	public List<ServiceExam> findAll() {
		return serviceExamRepository.findAll();
	}

	@Override
	public Optional<ServiceExam> findById(Integer id) {
		return serviceExamRepository.findById(id);
	}

	@Override
	public void deleteById(Integer id) {
		serviceExamRepository.deleteById(id);
	}

}
