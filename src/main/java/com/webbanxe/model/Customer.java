package com.webbanxe.model;

import java.time.LocalDate;

public class Customer {
	private int MAKH;
	private String TENKH,	CMND,	SDT,	EMAIL,	GIOITINH,	DIACHI;
	
	public Customer() {

		MAKH = -1;
		TENKH = "";
		CMND = "";
		SDT = "";
		EMAIL = "";
		GIOITINH = "";
		DIACHI = "";

	}
	
	public Customer( int mAKH,
	String tENKH,String	cMND,String	sDT,String	eMAIL,String	gIOITINH,String	dIACHI) {
		MAKH = mAKH;
		TENKH = tENKH;
		CMND = cMND;
		SDT = sDT;
		EMAIL = eMAIL;
		GIOITINH = gIOITINH;
		DIACHI = dIACHI;
	}

	public int getMAKH() {
		return MAKH;
	}

	public void setMAKH(int mAKH) {
		MAKH = mAKH;
	}

	public String getTENKH() {
		return TENKH;
	}

	public void setTENKH(String tENKH) {
		TENKH = tENKH;
	}

	public String getCMND() {
		return CMND;
	}

	public void setCMND(String cMND) {
		CMND = cMND;
	}

	public String getSDT() {
		return SDT;
	}

	public void setSDT(String sDT) {
		SDT = sDT;
	}

	public String getEMAIL() {
		return EMAIL;
	}

	public void setEMAIL(String eMAIL) {
		EMAIL = eMAIL;
	}

	public String getGIOITINH() {
		return GIOITINH;
	}

	public void setGIOITINH(String gIOITINH) {
		GIOITINH = gIOITINH;
	}

	public String getDIACHI() {
		return DIACHI;
	}

	public void setDIACHI(String dIACHI) {
		DIACHI = dIACHI;
	}
	
	
		
}
