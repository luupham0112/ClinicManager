package com.phanmemquanly.service.mapper;

import org.springframework.stereotype.Component;

import com.phanmemquanly.domain.Thuoc;
import com.phanmemquanly.model.ThuocDto;
@Component
public class ThuocMapper extends Mapper<ThuocDto, Thuoc> {
	@Override
	public ThuocDto mapToDTO(Thuoc e) {
		ThuocDto dto = new ThuocDto();
		dto.setIdThuoc(e.getIdThuoc());;
		dto.setNameThuoc(e.getNameThuoc());
		dto.setLoaiThuoc(e.getLoaiThuoc());
		dto.setDonvi(e.getDonvi());
		dto.setSoluong(e.getSoluong());
		dto.setDongia(e.getDongia());
		dto.setDongGoi(e.getDongGoi());
		dto.setDangThuoc(e.getDangThuoc());
		dto.setPhuongThuc(e.getPhuongThuc());
		dto.setThuocNgoai(e.getThuocNgoai());

		return dto;
	}

	@Override
	public Thuoc mapToEntity(ThuocDto theThuoc) {
		Thuoc thuoc = new Thuoc();

		thuoc.setIdThuoc(theThuoc.getIdThuoc());
		thuoc.setNameThuoc(theThuoc.getNameThuoc());
		thuoc.setLoaiThuoc(theThuoc.getLoaiThuoc());
		thuoc.setDonvi(theThuoc.getDonvi());
		thuoc.setSoluong(theThuoc.getSoluong());
		thuoc.setDongia(theThuoc.getDongia());
		thuoc.setDongGoi(theThuoc.getDongGoi());
		thuoc.setDangThuoc(theThuoc.getDangThuoc());
		thuoc.setPhuongThuc(theThuoc.getPhuongThuc());
		thuoc.setThuocNgoai(theThuoc.getThuocNgoai());
		
		return thuoc;
	}


}
