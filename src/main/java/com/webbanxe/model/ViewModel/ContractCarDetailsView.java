package com.webbanxe.model.ViewModel;

import java.sql.Date;
import java.time.LocalDate;

import com.webbanxe.model.Car;
import com.webbanxe.model.Contract;

public class ContractCarDetailsView {
	private int MATK,MAXE,MAHD,MALOAIXE,MAHSX,BAOHANH,NAMSANXUAT;
	private String TENTK,DIADIEM,TRANGTHAI,HINHANH,TENLOAIXE,TENHSX,TENXE;
	private Double GIA;
	private Date NGAYLAP;
	
	
	public ContractCarDetailsView() {
		
		MATK = -1;
		MAXE = -1;
		MAHD = -1;
		MALOAIXE = -1;
		MAHSX = -1;
		BAOHANH = -1;
		NAMSANXUAT = -1;
		TENTK = "";
		DIADIEM = "";
		TRANGTHAI = "";
		HINHANH = "";
		TENLOAIXE = "";
		TENXE ="";
		TENHSX = "";
		GIA = 0.0;
		NGAYLAP = Date.valueOf(LocalDate.now());
	}
	
	
	
	public ContractCarDetailsView(int mATK, int mAXE,int nAMSANXUAT, int mAHD, int mALOAIXE, int mAHSX, int bAOHANH, String tENTK,
			String dIADIEM, String tRANGTHAI, String hINHANH, String tENLOAIXE, String tENHSX,String tENXE, Double gIA,
			Date nGAYLAP) {
		
		MATK = mATK;
		MAXE = mAXE;
		MAHD = mAHD;
		MALOAIXE = mALOAIXE;
		MAHSX = mAHSX;
		BAOHANH = bAOHANH;
		NAMSANXUAT = nAMSANXUAT;
		TENTK = tENTK;
		TENXE = tENXE;
		DIADIEM = dIADIEM;
		TRANGTHAI = tRANGTHAI;
		HINHANH = hINHANH;
		TENLOAIXE = tENLOAIXE;
		TENHSX = tENHSX;
		GIA = gIA;
		NGAYLAP = nGAYLAP;
	}

	

	public int getNAMSANXUAT() {
		return NAMSANXUAT;
	}



	public void setNAMSANXUAT(int nAMSANXUAT) {
		NAMSANXUAT = nAMSANXUAT;
	}



	public String getTENXE() {
		return TENXE;
	}



	public void setTENXE(String tENXE) {
		TENXE = tENXE;
	}



	public int getMAXE() {
		return MAXE;
	}



	public void setMAXE(int mAXE) {
		MAXE = mAXE;
	}



	public int getMATK() {
		return MATK;
	}
	public void setMATK(int mATK) {
		MATK = mATK;
	}
	public int getMAHD() {
		return MAHD;
	}
	public void setMAHD(int mAHD) {
		MAHD = mAHD;
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
	public int getBAOHANH() {
		return BAOHANH;
	}
	public void setBAOHANH(int bAOHANH) {
		BAOHANH = bAOHANH;
	}
	public String getTENTK() {
		return TENTK;
	}
	public void setTENTK(String tENTK) {
		TENTK = tENTK;
	}
	public String getDIADIEM() {
		return DIADIEM;
	}
	public void setDIADIEM(String dIADIEM) {
		DIADIEM = dIADIEM;
	}
	public String getTRANGTHAI() {
		return TRANGTHAI;
	}
	public void setTRANGTHAI(String tRANGTHAI) {
		TRANGTHAI = tRANGTHAI;
	}
	public String getHINHANH() {
		return HINHANH;
	}
	public void setHINHANH(String hINHANH) {
		HINHANH = hINHANH;
	}
	public String getTENLOAIXE() {
		return TENLOAIXE;
	}
	public void setTENLOAIXE(String tENLOAIXE) {
		TENLOAIXE = tENLOAIXE;
	}
	public String getTENHSX() {
		return TENHSX;
	}
	public void setTENHSX(String tENHSX) {
		TENHSX = tENHSX;
	}
	public Double getGIA() {
		return GIA;
	}
	public void setGIA(Double gIA) {
		GIA = gIA;
	}
	public Date getNGAYLAP() {
		return NGAYLAP;
	}
	public void setNGAYLAP(Date nGAYLAP) {
		NGAYLAP = nGAYLAP;
	}
	
	
}
