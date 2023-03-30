package com.phanmemquanly.dao;

import java.util.List;

import com.phanmemquanly.domain.DonthuocDetail;

public interface DonthuocDetailDao {

	void deleteDonthuocDeatil(int theId);

	List<DonthuocDetail> getOrderLineByOrderHeaderID(int IdDonthuoc);

	void saveDonthuocDetail(DonthuocDetail donthuocDetail);

	List<DonthuocDetail> getDonthuocDeatails();

}
