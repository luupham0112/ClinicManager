package com.phanmemquanly.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.phanmemquanly.domain.ServiceExam;


@Repository
public interface ServiceExamRepository extends JpaRepository<ServiceExam, Integer> {
	
}