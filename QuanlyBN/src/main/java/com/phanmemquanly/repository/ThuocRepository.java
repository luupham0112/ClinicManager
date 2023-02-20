package com.phanmemquanly.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.phanmemquanly.domain.Thuoc;

import java.util.List;
@Repository
public interface ThuocRepository extends JpaRepository<Thuoc, Integer> {
	List<Thuoc> findByNameThuocContaining(String nameThuoc);
	Page<Thuoc> findByNameThuocContaining(String nameThuoc, Pageable pageable);
}
