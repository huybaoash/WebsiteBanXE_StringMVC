package com.webbanxe.model;

public class Car {
	private int MAXE	,BAOHANH		,NAMSANXUAT		,	MALOAIXE	,MAHSX		;
	private String TENXE,	NOIDUNGXE,	HINHANH,	TRANGTHAI;
	private Double GIA;
	
	public Car() {
		MAXE = -1;	
		TENXE	= "";
		NOIDUNGXE	= "";
		HINHANH	= "";
		BAOHANH	= -1;
		GIA	= -1.0;
		NAMSANXUAT	= 0;
		MALOAIXE	= -1;
		MAHSX	= -1;
		TRANGTHAI	= "Công khai";

	}
	
	public Car(int mAXE	,int	bAOHANH		,int	nAMSANXUAT		,int	mALOAIXE	,int	mAHSX		,
	String tENXE,String 	nOIDUNGXE,String 	hINHANH,String 	tRANGTHAI,
	Double gIA) {
		MAXE = mAXE;	
		TENXE	= tENXE;
		NOIDUNGXE	= nOIDUNGXE;
		HINHANH	= hINHANH;
		BAOHANH	= bAOHANH;
		GIA	= gIA;
		NAMSANXUAT	= nAMSANXUAT;
		MALOAIXE	= mALOAIXE;
		MAHSX	= mAHSX;
		TRANGTHAI	= tRANGTHAI;
	}

	public int getMAXE() {
		return MAXE;
	}

	public void setMAXE(int mAXE) {
		MAXE = mAXE;
	}

	public int getBAOHANH() {
		return BAOHANH;
	}

	public void setBAOHANH(int bAOHANH) {
		BAOHANH = bAOHANH;
	}

	public int getNAMSANXUAT() {
		return NAMSANXUAT;
	}

	public void setNAMSANXUAT(int nAMSANXUAT) {
		NAMSANXUAT = nAMSANXUAT;
	}

	public int getMALOAIXE() {
		return MALOAIXE;
	}

	public void setMALOAIXE(int mALOAIXE) {
		MALOAIXE = mALOAIXE;
	}

	public int getMAHSX() {
		return MAHSX;
	}

	public void setMAHSX(int mAHSX) {
		MAHSX = mAHSX;
	}

	public String getTENXE() {
		return TENXE;
	}

	public void setTENXE(String tENXE) {
		TENXE = tENXE;
	}

	public String getNOIDUNGXE() {
		return NOIDUNGXE;
	}

	public void setNOIDUNGXE(String nOIDUNGXE) {
		NOIDUNGXE = nOIDUNGXE;
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

	public Double getGIA() {
		return GIA;
	}

	public void setGIA(Double gIA) {
		GIA = gIA;
	}
	
	
}
