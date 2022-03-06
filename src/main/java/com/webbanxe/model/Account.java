package com.webbanxe.model;
import java.io.Serializable;

public class Account implements Serializable {
	private int MATK, MAKH;
	private String TENTK,	MATKHAU,	HINHANH,	TRANGTHAI,	CHUCVU;
	
	public Account() {
		MATK = -1;
		MAKH = -1;
		TENTK = "";
		MATKHAU = "";
		HINHANH = "";
		TRANGTHAI = "Đang hoạt động";
		CHUCVU = "Người dùng";
	}
	
	public Account(int mATK, int mAKH,int mANV ,String tENtk, String mATKHAU,String hINHANH,String tRANGTHAI,String cHUCVU) {
		MATK = mATK;
		MAKH = mAKH;
		TENTK = tENtk;
		MATKHAU = mATKHAU;
		HINHANH = hINHANH;
		TRANGTHAI = tRANGTHAI;
		CHUCVU = cHUCVU;
	}
	
	public int getMATK() {
		return MATK;
	}
	public void setMATK(int mATK) {
		MATK = mATK;
	}
	public int getMAKH() {
		return MAKH;
	}
	public void setMAKH(int mAKH) {
		MAKH = mAKH;
	}
	
	
	public String getTENTK() {
		return TENTK;
	}
	public void setTENTK(String tENTK) {
		TENTK = tENTK;
	}
	public String getMATKHAU() {
		return MATKHAU;
	}
	public void setMATKHAU(String mATKHAU) {
		MATKHAU = mATKHAU;
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
	
	public String getCHUCVU() {
		return CHUCVU;
	}
	public void setCHUCVU(String cHUCVU) {
		CHUCVU = cHUCVU;
	}

}
