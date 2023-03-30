package com.phanmemquanly.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.phanmemquanly.domain.KhamBenh;


@Repository
public interface KhamBenhRepository extends JpaRepository<KhamBenh, Integer> {
   List<KhamBenh> findAllByPatient(int id);
   @Query(value = "select p from KhamBenh p inner join Patient c on c.id = p.patient.id where c.id = ?1 ")
   List<KhamBenh> getKhambenhinPatient(int idBenhNhan);
   List<KhamBenh> findByIdKhamBenhContaining(int idKhambenh);
	Page<KhamBenh> findByIdKhamBenhContaining(int idKhambenh, Pageable pageable);
	List<KhamBenh> findByBacSiContaining(String bacSi);

}
