package com.webbanxe.model;

import java.time.LocalTime;


public class Contract {
	private int		MAHD,	MANGUOIBAN,		MANGUOIMUA,		MAXE;
	private String	NOIDUNGHD,	TRANGTHAI;
	private double GIA;
	private LocalTime NGAYLAP;
	
	public Contract() {

		MAHD = -1;	
		MANGUOIBAN = -1;	
		MANGUOIMUA	 = -1;
		MAXE	= -1;
		NOIDUNGHD	= "";
		GIA	= -1;
		NGAYLAP	= LocalTime.now();
		TRANGTHAI	= "Công khai";

	}
	
	public Contract( int		mAHD,int	mANGUOIBAN,int		mANGUOIMUA,int		mAXE,
	String	nOIDUNGHD,String	tRANGTHAI,
	double gIA,
	LocalTime nGAYLAP) {
		MAHD = mAHD;	
		MANGUOIBAN = mANGUOIBAN;	
		MANGUOIMUA	 = mANGUOIMUA;
		MAXE	= mAXE;
		NOIDUNGHD	= nOIDUNGHD;
		GIA	= gIA;
		NGAYLAP	= nGAYLAP;
		TRANGTHAI	= tRANGTHAI;
	}

	public int getMAHD() {
		return MAHD;
	}

	public void setMAHD(int mAHD) {
		MAHD = mAHD;
	}

	public int getMANGUOIBAN() {
		return MANGUOIBAN;
	}

	public void setMANGUOIBAN(int mANGUOIBAN) {
		MANGUOIBAN = mANGUOIBAN;
	}

	public int getMANGUOIMUA() {
		return MANGUOIMUA;
	}

	public void setMANGUOIMUA(int mANGUOIMUA) {
		MANGUOIMUA = mANGUOIMUA;
	}

	public int getMAXE() {
		return MAXE;
	}

	public void setMAXE(int mAXE) {
		MAXE = mAXE;
	}

	public String getNOIDUNGHD() {
		return NOIDUNGHD;
	}

	public void setNOIDUNGHD(String nOIDUNGHD) {
		NOIDUNGHD = nOIDUNGHD;
	}

	public String getTRANGTHAI() {
		return TRANGTHAI;
	}

	public void setTRANGTHAI(String tRANGTHAI) {
		TRANGTHAI = tRANGTHAI;
	}

	public double getGIA() {
		return GIA;
	}

	public void setGIA(double gIA) {
		GIA = gIA;
	}

	public LocalTime getNGAYLAP() {
		return NGAYLAP;
	}

	public void setNGAYLAP(LocalTime nGAYLAP) {
		NGAYLAP = nGAYLAP;
	}
	
	
}
