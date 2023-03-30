package com.phanmemquanly.service.mapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.phanmemquanly.domain.DonthuocDetail;
import com.phanmemquanly.model.DonthuocDetailDto;

@Component
public class DonthuocDetailMapper extends Mapper<DonthuocDetailDto, DonthuocDetail>{
	@Autowired
	private ThuocMapper thuocMapper;
	
	@Override
	public DonthuocDetailDto mapToDTO(DonthuocDetail entity) {
		DonthuocDetailDto dto = new DonthuocDetailDto();
		dto.setDonthuocDetailId(entity.getDonthuocDetailId());
		dto.setThuocdto(thuocMapper.mapToDTO(entity.getThuoc()));
		dto.setSoluong(entity.getSoluong());
		dto.setGiatien(entity.getGiatien());
		dto.setGhichu(entity.getGhichu());
		dto.setTongtien(entity.getTongtien());
		return dto;
	}

	@Override
	public DonthuocDetail mapToEntity(DonthuocDetailDto dto) {
		DonthuocDetail donthuocDetail= new DonthuocDetail();
		donthuocDetail.setDonthuocDetailId(dto.getDonthuocDetailId());
	
		donthuocDetail.setSoluong(dto.getSoluong());
		donthuocDetail.setGiatien(dto.getGiatien());
		donthuocDetail.setGhichu(dto.getGhichu());
	    donthuocDetail.setTongtien(dto.getTongtien());
		return donthuocDetail;

	}

}
