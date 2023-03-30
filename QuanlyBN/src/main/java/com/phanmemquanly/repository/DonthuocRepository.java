package com.phanmemquanly.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.phanmemquanly.domain.Donthuoc;
import com.phanmemquanly.domain.KhamBenh;


@Repository
public interface DonthuocRepository extends JpaRepository<Donthuoc, Integer> {
	  @Query(value = "select p from Donthuoc p inner join Patient c on c.id = p.patient.id where c.id = ?1 ")
	   List<Donthuoc> getDonthuocinPatient(int idBenhNhan);
	  
	  List<Donthuoc> findByBacsi(String bacsi);
}
