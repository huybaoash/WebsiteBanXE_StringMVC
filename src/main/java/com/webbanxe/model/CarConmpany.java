package com.webbanxe.model;

public class CarConmpany {
	private int MAHSX;
	private String TENHSX,HINHANH,TRANGTHAI;
	
	public CarConmpany() {
		MAHSX = -1;
		TENHSX = "";
		HINHANH = "";
		TRANGTHAI = "Công khai";
	}
	
	public CarConmpany(int mAHSX,String tENHSX,String hINHANH, String tRANGTHAI) {
		MAHSX = mAHSX;
		TENHSX = tENHSX;
		HINHANH = hINHANH;
		TRANGTHAI = tRANGTHAI;
	}
	
	
	public int getMAHSX() {
		return MAHSX;
	}
	public void setMAHSX(int mAHSX) {
		MAHSX = mAHSX;
	}
	public String getTENHSX() {
		return TENHSX;
	}
	public void setTENHSX(String tENHSX) {
		TENHSX = tENHSX;
	}
	public String getHINHANH() {
		return HINHANH;
	}
	public void setHINHANH(String hINHANH) {
		HINHANH = hINHANH;
	}
	public String getTRANGTHAI() {
		return TRANGTHAI;
	}
	public void setTRANGTHAI(String tRANGTHAI) {
		TRANGTHAI = tRANGTHAI;
	}
	
	
}
