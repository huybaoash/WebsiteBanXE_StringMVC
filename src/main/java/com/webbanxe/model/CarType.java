package com.webbanxe.model;

public class CarType {
	private int MALOAIXE;
	private String TENLOAIXE,HINHANH,TRANGTHAI;
	
	public CarType() {
		MALOAIXE = -1;
		TENLOAIXE = "";
		HINHANH = "";
		TRANGTHAI = "Công khai";
	}
	
	public CarType(int mALOAIXE,String tENLOAIXE,String hINHANH, String tRANGTHAI) {
		MALOAIXE = mALOAIXE;
		TENLOAIXE = tENLOAIXE;
		HINHANH = hINHANH;
		TRANGTHAI = tRANGTHAI;
	}
	
	public int getMALOAIXE() {
		return MALOAIXE;
	}
	public void setMALOAIXE(int mALOAIXE) {
		MALOAIXE = mALOAIXE;
	}
	public String getTENLOAIXE() {
		return TENLOAIXE;
	}
	public void setTENLOAIXE(String tENLOAIXE) {
		TENLOAIXE = tENLOAIXE;
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
