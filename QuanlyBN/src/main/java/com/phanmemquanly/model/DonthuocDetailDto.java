package com.phanmemquanly.model;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DonthuocDetailDto   implements Serializable {
	private int idDonthuocDetail;
	private int idDonthuoc;
	private int idThuoc;
	private int soluong;
	private String ghichu;
	private String nameThuoc;
	private String donvi;
	private String phuongthuc;

}
