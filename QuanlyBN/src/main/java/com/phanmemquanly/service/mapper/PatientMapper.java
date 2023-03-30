package com.phanmemquanly.service.mapper;

import org.springframework.stereotype.Component;

import com.phanmemquanly.domain.Patient;
import com.phanmemquanly.model.PatientDto;

@Component
public class PatientMapper extends Mapper<PatientDto, Patient>{
	@Override
	public PatientDto mapToDTO(Patient patient) {
		PatientDto dto = new PatientDto();
		dto.setIdBenhNhan(patient.getIdBenhNhan());
		dto.setHotenBN(patient.getHotenBN());
		dto.setCCCD(patient.getCCCD());
		dto.setNgaysinh(patient.getNgaysinh());
		dto.setGioiTinh(patient.getGioiTinh());
		dto.setTuoi(patient.getTuoi());
		dto.setDiaChi(patient.getDiaChi());
		dto.setQueQuan(patient.getQueQuan());
		dto.setNgheNghiep(patient.getNgheNghiep());
		return dto;
	}

	@Override
	public Patient mapToEntity(PatientDto thePatient) {
		Patient patient= new Patient();
		patient.setIdBenhNhan(thePatient.getIdBenhNhan());
		patient.setHotenBN(thePatient.getHotenBN());
		patient.setCCCD(thePatient.getCCCD());
		patient.setNgaysinh(thePatient.getNgaysinh());
		patient.setGioiTinh(thePatient.getGioiTinh());
		patient.setTuoi(thePatient.getTuoi());
		patient.setDiaChi(thePatient.getDiaChi());
		patient.setQueQuan(thePatient.getQueQuan());
		patient.setNgheNghiep(thePatient.getNgheNghiep());
		return patient;
	}

}
