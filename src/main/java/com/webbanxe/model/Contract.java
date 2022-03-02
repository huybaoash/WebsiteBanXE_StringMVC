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
}
