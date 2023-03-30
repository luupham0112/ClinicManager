

package com.phanmemquanly.service.impl;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.phanmemquanly.dao.DonthuocDao;
import com.phanmemquanly.dao.DonthuocDetailDao;
import com.phanmemquanly.dao.PatientDao;
import com.phanmemquanly.dao.ThuocDao;
import com.phanmemquanly.domain.Donthuoc;
import com.phanmemquanly.domain.DonthuocDetail;
import com.phanmemquanly.domain.Patient;
import com.phanmemquanly.domain.Thuoc;
import com.phanmemquanly.model.DonthuocDetailDto;
import com.phanmemquanly.model.DonthuocDto;
import com.phanmemquanly.repository.DonthuocDetailRepository;
import com.phanmemquanly.repository.DonthuocRepository;
import com.phanmemquanly.service.DonthuocService;
import com.phanmemquanly.service.mapper.DonthuocDetailMapper;
import com.phanmemquanly.service.mapper.DonthuocMapper;

@Service
public class DonthuocServiceImpl implements DonthuocService {

	@Autowired
    private DonthuocRepository donthuocRepository;

	public DonthuocServiceImpl(DonthuocRepository donthuocRepository) {
		
		this.donthuocRepository = donthuocRepository;
	}

	@Override
	public List<Donthuoc> findAll() {
		return donthuocRepository.findAll();
	}

	@Override
	public Optional<Donthuoc> findById(Integer id) {
		return donthuocRepository.findById(id);
	}
	
	@Override
	public List<Donthuoc> getDonthuocinPatient(int idBenhNhan) {
		return donthuocRepository.getDonthuocinPatient(idBenhNhan);
	}



	// don thuoc
	@Autowired
	private DonthuocDao donthuocDao;

	@Autowired
	private DonthuocDetailDao donthuocDetailDao;

	@Autowired
	private DonthuocMapper donthuocMapper;

	@Autowired
	private DonthuocDetailMapper donthuocDetailMapper;

	@Autowired
	private PatientDao patientDao;

	@Autowired
	private ThuocDao thuocDao;

	@Override
	public List<DonthuocDto> getDonthuocID() {
		List<Donthuoc> donthuocs = donthuocDao.getDonthuoc();

		List<DonthuocDto> donthuocDTOList = new ArrayList<DonthuocDto>();

		for (Donthuoc oh : donthuocs) {
			donthuocDTOList.add(donthuocMapper.mapToDTO(oh));
		}
		return donthuocDTOList;
	}

	@Override
	public String getNextDonthuocNumber() {
		Donthuoc oh = donthuocDao.getLastDonthuoc();
		int nextOrderNumber = 1;
		if (oh != null && oh.getNumber() != null && !oh.getNumber().equals("")) {
			int lastOrderNumber = Integer.parseInt(oh.getNumber());
			nextOrderNumber = ++lastOrderNumber;
		}

		return String.valueOf(nextOrderNumber);
	}

	@Override
	public void saveDonthuoc(DonthuocDto theDonthuoc) {
		Donthuoc donthuoc = null;
		if(theDonthuoc.getIdDonthuoc() <= 0) { // order doesn't exist - create a new order
			// save all the DonthuocDetailItems
			// DonthuocDetailrepository
			Patient patient = patientDao.getPatient(theDonthuoc.getPatientDto().getHotenBN());
			donthuoc = donthuocMapper.mapToEntity(theDonthuoc);
			donthuoc.setPatient(patient);
			donthuocDao.saveDonthuoc(donthuoc);
		}else { // order exists. so use the existing order
			donthuoc = donthuocDao.getDonthuocById(theDonthuoc.getIdDonthuoc());
		}
		
		DonthuocDetailDto newDonthuocDetail = theDonthuoc.getDonthuocDetailDto();
		DonthuocDetail donthuocDetail = donthuocDetailMapper.mapToEntity(newDonthuocDetail);
		Thuoc thuoc = thuocDao.getThuoc(newDonthuocDetail.getThuocdto().getNameThuoc());
		// fetch Thuoc by name from the DB and set it to DonthuocDetail
		donthuocDetail.setDonthuoc(donthuoc);
		donthuocDetail.setThuoc(thuoc);
		donthuocDetail.setGiatien(thuoc.getDongia());
		donthuocDetail.setTongtien(donthuocDetail.getGiatien()*donthuocDetail.getSoluong());
		

		donthuocDetailDao.saveDonthuocDetail(donthuocDetail);


	}

	@Override
	public DonthuocDto getDonthuocById(Integer DonthuocId) {

		Donthuoc donthuoc = donthuocDao.getDonthuocById(DonthuocId);

		return donthuocMapper.mapToDTO(donthuoc);

	}

	@Override
	public List<DonthuocDto> getAllOrders() {

		List<Donthuoc> Donthuocs = donthuocDao.getAllOrders();

		List<DonthuocDto> donthuocDTOList = new ArrayList<DonthuocDto>();

		for (Donthuoc oh : Donthuocs) {
			donthuocDTOList.add(donthuocMapper.mapToDTO(oh));
		}

		return donthuocDTOList;
	}

//	@Override
//	public List<DonthuocDTO> getAllOrders(String type) {
//		List<Donthuoc> Donthuocs = DonthuocDao.getAllOrders(type);
//
//		List<DonthuocDTO> DonthuocDTOList = new ArrayList<DonthuocDTO>();
//
//		for (Donthuoc oh : Donthuocs) {
//			DonthuocDTOList.add(DonthuocMapper.mapToDTO(oh));
//		}
//		return DonthuocDTOList;
//
//	}

	@Override
	public DonthuocDto getDonthuocByNumber(String number) {
		Donthuoc donthuoc = donthuocDao.getDonthuocByNumber(number);
		return donthuocMapper.mapToDTO(donthuoc);
	}

	@Override
	public void checkout(String DonthuocNumber) {
		Donthuoc donthuoc = donthuocDao.getDonthuocByNumber(DonthuocNumber);
		List<DonthuocDetail> donthuocDetailByDonthuocID = donthuocDetailDao.getOrderLineByOrderHeaderID(donthuoc.getIdDonthuoc());
		int finalTotal = 0;
		for(DonthuocDetail line : donthuocDetailByDonthuocID) {
			finalTotal +=line.getTongtien();
		}
		donthuoc.setTongtien(finalTotal);;
		donthuoc.setStatus("Complete");
		donthuocDao.saveDonthuoc(donthuoc);
	}

	@Override
	public void deleteById(Integer id) {
		donthuocRepository.deleteById(id);
	}

	@Override
	public List<Donthuoc> findByBacsi(String bacsi) {
		return donthuocRepository.findByBacsi(bacsi);
	}
	
	
	
   
}
