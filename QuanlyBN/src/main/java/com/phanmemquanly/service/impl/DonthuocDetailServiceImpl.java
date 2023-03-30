package com.phanmemquanly.service.impl;


import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.phanmemquanly.dao.DonthuocDetailDao;
import com.phanmemquanly.domain.DonthuocDetail;
import com.phanmemquanly.model.DonthuocDetailDto;
import com.phanmemquanly.repository.DonthuocDetailRepository;
import com.phanmemquanly.service.DonthuocDetailService;
import com.phanmemquanly.service.mapper.DonthuocDetailMapper;
@Service
public class DonthuocDetailServiceImpl implements DonthuocDetailService {
	DonthuocDetailRepository donthuocDetailRepository;

	public DonthuocDetailServiceImpl(DonthuocDetailRepository donthuocDetailRepository) {
		
		this.donthuocDetailRepository = donthuocDetailRepository;
	}

	@Override
	public List<DonthuocDetail> getDonthuocDetailbyDonthuoc(int IdDonthuoc) {
		return donthuocDetailRepository.getDonthuocDetailbyDonthuoc(IdDonthuoc);
	}

	@Override
	public List<DonthuocDetail> findAll() {
		return donthuocDetailRepository.findAll();
	}
//
	@Override
	public Optional<DonthuocDetail> findById(Integer id) {
		return donthuocDetailRepository.findById(id);
	}

// don thuoc
	@Autowired
	DonthuocDetailDao DonthuocDetailDAO;

	@Autowired
	 DonthuocDetailMapper DonthuocDetailMapper;

	@Override
	public List<DonthuocDetailDto> getDonthuocDetails() {
		List<DonthuocDetail> DonthuocDetails = DonthuocDetailDAO.getDonthuocDeatails();

		List<DonthuocDetailDto> DonthuocDetailDTOList = new ArrayList<DonthuocDetailDto>();

		for (DonthuocDetail ol : DonthuocDetails) {
			DonthuocDetailDTOList.add(DonthuocDetailMapper.mapToDTO(ol));
		}

		return DonthuocDetailDTOList;
	}

	@Override
	public void saveDonthuocDetail(DonthuocDetailDto theDonthuocDetail) {
		DonthuocDetail DonthuocDetail = DonthuocDetailMapper.mapToEntity(theDonthuocDetail);
		DonthuocDetailDAO.saveDonthuocDetail(DonthuocDetail);
	}

	@Override
	public List<DonthuocDetailDto> getOrderLineByOrderHeaderID(int orderHeaderID) {
		List<DonthuocDetail> DonthuocDetails = DonthuocDetailDAO.getOrderLineByOrderHeaderID(orderHeaderID);
		List<DonthuocDetailDto> DonthuocDetailDTOList = new ArrayList<DonthuocDetailDto>();

		for (DonthuocDetail ol : DonthuocDetails) {
			DonthuocDetailDTOList.add(DonthuocDetailMapper.mapToDTO(ol));
		}
		return DonthuocDetailDTOList;
	}
	
	public void deleteDonthuocDetail(int theId) {
		DonthuocDetailDAO.deleteDonthuocDeatil(theId);

		
	}

	
     
	
     
}
