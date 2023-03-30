package com.phanmemquanly.dao;

import java.util.List;

import com.phanmemquanly.domain.Donthuoc;

public interface DonthuocDao {

	Donthuoc getDonthuocByNumber(String DonthuocNumber);

	List<Donthuoc> getAllOrders();

	Donthuoc getDonthuocById(Integer DonthuocId);

	void saveDonthuoc(Donthuoc donthuoc);

	Donthuoc getLastDonthuoc();

	List<Donthuoc> getDonthuoc();

}
