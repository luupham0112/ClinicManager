package com.phanmemquanly.service.mapper;

import java.text.SimpleDateFormat;
import java.util.Date;

import java.text.ParseException;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


import com.phanmemquanly.domain.Donthuoc;
import com.phanmemquanly.model.DonthuocDto;


@Component
public class DonthuocMapper extends Mapper<DonthuocDto, Donthuoc>{
	@Autowired
	private PatientMapper patientMapper;

	@Autowired
	private ThuocMapper thuocMapper;

	@Override
	public DonthuocDto mapToDTO(Donthuoc entity) {
		DonthuocDto dto = new DonthuocDto();
		dto.setIdDonthuoc(entity.getIdDonthuoc());
		dto.setTongtien(entity.getTongtien());
		dto.setNumber(entity.getNumber());
		String date = new SimpleDateFormat("yyyy-MM-dd").format(entity.getNgayTao());
		dto.setNgayTao(date);
		dto.setStatus(entity.getStatus());
		dto.setBacsi(entity.getBacsi());
		dto.setPatientDto(patientMapper.mapToDTO(entity.getPatient()));

		return dto;
	}

	@Override
	public Donthuoc mapToEntity(DonthuocDto dto) {
		Donthuoc donthuoc = new Donthuoc();
	
		donthuoc.setIdDonthuoc(dto.getIdDonthuoc());
		donthuoc.setTongtien(dto.getTongtien());
		donthuoc.setNumber(dto.getNumber());
		
		donthuoc.setStatus(dto.getStatus());
		donthuoc.setBacsi(dto.getBacsi());
		try {
			Date date = new SimpleDateFormat("yyyy-MM-dd").parse(dto.getNgayTao());
			donthuoc.setNgayTao(date);
		} catch (ParseException e) {
			e.printStackTrace();
		}

	    donthuoc.setPatient(patientMapper.mapToEntity(dto.getPatientDto()));
	

		return donthuoc;
	}


}
