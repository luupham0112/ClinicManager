package com.phanmemquanly.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;

import com.phanmemquanly.domain.DonthuocDetail;
import com.phanmemquanly.model.DonthuocDetailDto;
import com.phanmemquanly.service.mapper.DonthuocDetailMapper;

public interface DonthuocDetailService {

	void deleteDonthuocDetail(int theId);

	List<DonthuocDetailDto> getOrderLineByOrderHeaderID(int orderHeaderID);

	void saveDonthuocDetail(DonthuocDetailDto theDonthuocDetail);

	List<DonthuocDetailDto> getDonthuocDetails();

	Optional<DonthuocDetail> findById(Integer id);

	List<DonthuocDetail> findAll();

	List<DonthuocDetail> getDonthuocDetailbyDonthuoc(int IdDonthuoc);

	

//	void deleteById(Integer id);
//
//	Optional<DonthuocDetail> findById(Integer id);
//
//	List<DonthuocDetail> findAll();
//
//	<S extends DonthuocDetail> S save(S entity);
//
//	List<DonthuocDetail> getDonthuocDetailbyDonthuoc(int IdDonthuoc);
	
	// don thuoc
	


	

}
