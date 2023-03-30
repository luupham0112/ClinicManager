package com.phanmemquanly.service;

import java.util.List;
import java.util.Optional;
import java.util.Set;

import com.phanmemquanly.domain.Donthuoc;
import com.phanmemquanly.domain.DonthuocDetail;
import com.phanmemquanly.domain.Patient;
import com.phanmemquanly.domain.Thuoc;
import com.phanmemquanly.model.DonthuocDto;

public interface DonthuocService {

	void checkout(String DonthuocNumber);

	DonthuocDto getDonthuocByNumber(String number);

	List<DonthuocDto> getAllOrders();

	DonthuocDto getDonthuocById(Integer DonthuocId);

	void saveDonthuoc(DonthuocDto theDonthuoc);

	String getNextDonthuocNumber();

	List<DonthuocDto> getDonthuocID();

	List<Donthuoc> getDonthuocinPatient(int idBenhNhan);

	Optional<Donthuoc> findById(Integer id);

	List<Donthuoc> findAll();

	void deleteById(Integer id);

	List<Donthuoc> findByBacsi(String bacsi);


}
