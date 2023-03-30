package com.phanmemquanly.domain;


public class Item {
	private Thuoc thuoc;
	private int soluong;
	public Item(Thuoc thuoc, int soluong) {
		
		this.thuoc = thuoc;
		this.soluong = soluong;
	}
	
	public Item() {
		
	}

	public Thuoc getThuoc() {
		return thuoc;
	}
	public void setThuoc(Thuoc thuoc) {
		this.thuoc = thuoc;
	}
	public int getSoluong() {
		return soluong;
	}
	public void setSoluong(int soluong) {
		this.soluong = soluong;
	}
}
	

