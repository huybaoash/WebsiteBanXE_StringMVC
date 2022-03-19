package com.webbanxe.model;

public class ContractCart {
	private int Id;
	private int MAHD;
	private int MATK;
	
	public ContractCart() {
		Id = -1;
		MAHD = -1;
		MATK = -1;
	}
	
	

	public ContractCart(int id, int mAHD, int mATK) {
		
		Id = id;
		MAHD = mAHD;
		MATK = mATK;
	}



	public int getId() {
		return Id;
	}

	public void setId(int id) {
		Id = id;
	}

	public int getMAHD() {
		return MAHD;
	}

	public void setMAHD(int mAHD) {
		MAHD = mAHD;
	}

	public int getMATK() {
		return MATK;
	}

	public void setMATK(int mATK) {
		MATK = mATK;
	}
	
	
	
}
