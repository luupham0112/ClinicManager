package com.phanmemquanly.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.phanmemquanly.domain.Donthuoc;
import com.phanmemquanly.domain.DonthuocDetail;


@Repository
public interface DonthuocDetailRepository  extends JpaRepository<DonthuocDetail, Integer>{
	 @Query(value = "select p from DonthuocDetail p inner join Donthuoc c on c.id = p.donthuoc.id where c.id = ?1 ")
	   List<DonthuocDetail> getDonthuocDetailbyDonthuoc(int IdDonthuoc);
	
}
