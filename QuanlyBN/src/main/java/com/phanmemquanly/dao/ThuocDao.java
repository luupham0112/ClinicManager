package com.phanmemquanly.dao;

import java.util.List;

import com.phanmemquanly.domain.Thuoc;

public interface ThuocDao  {

	Thuoc getThuoc(String name);

	void deleteThuoc(int theId);

	Thuoc getThuoc(int theId);

	void saveThuoc(Thuoc theThuoc);

	List<Thuoc> getThuocs();

}
