package com.webbanxe.model;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

public class ContractDAO {
	public ConnectionDB db;
    
    public void ConnectionDB() throws ClassNotFoundException, SQLException {
    	db = new ConnectionDB();
    }
    
	public Contract getContract(int Id) throws ClassNotFoundException,SQLException {
		this.ConnectionDB();
		Contract Contract = new Contract();
		String sql = "SELECT * FROM hopdong WHERE MAHD = '" + Id + "'";
		db.rs = db.stmt.executeQuery(sql);
		if(db.rs.next()){
            Contract = new Contract();
            Contract.setMANGUOIBAN(db.rs.getInt("MANGUOIBAN"));
            Contract.setMANGUOIMUA(db.rs.getInt("MANGUOIMUA"));
            Contract.setMAXE(db.rs.getInt("MAXE"));
            Contract.setNOIDUNGHD(db.rs.getString("NOIDUNGHD"));
            Contract.setGIA(db.rs.getDouble("GIA"));
            Contract.setNGAYLAP(db.rs.getDate("NGAYLAP"));
            Contract.setTRANGTHAI(db.rs.getString("TRANGTHAI"));
            Contract.setMAHD(db.rs.getInt("MAHD"));
            Contract.setDIADIEM(db.rs.getString("DIADIEM"));
            
        }
        db.rs.close();
        return Contract;
	}
	
	
	public List<Contract> toList() throws SQLException, ClassNotFoundException {
		this.ConnectionDB();
        List<Contract> contractList = new ArrayList<>();
        
        
        db.rs = db.stmt.executeQuery("SELECT * FROM hopdong");
		while(db.rs.next()){
            Contract contract = new Contract();
            contract.setMAHD(db.rs.getInt("MAHD"));
            contract.setMANGUOIBAN(db.rs.getInt("MANGUOIBAN"));
            contract.setMANGUOIMUA(db.rs.getInt("MANGUOIMUA"));
            contract.setMAXE(db.rs.getInt("MAXE"));
            contract.setNOIDUNGHD(db.rs.getString("NOIDUNGHD"));
            contract.setGIA(db.rs.getDouble("GIA"));
            contract.setNGAYLAP(db.rs.getDate("NGAYLAP"));
            contract.setTRANGTHAI(db.rs.getString("TRANGTHAI"));
            contract.setDIADIEM(db.rs.getString("DIADIEM"));
            contractList.add(contract);
        }
		db.rs.close();
        return contractList;
    }
	
	public List<Contract> toPublicList() throws SQLException, ClassNotFoundException {
		this.ConnectionDB();
        List<Contract> contractList = new ArrayList<>();
        
        
        db.rs = db.stmt.executeQuery("SELECT * FROM `hopdong` WHERE `TRANGTHAI`= 'C??ng khai'");
		while(db.rs.next()){
            Contract contract = new Contract();
            contract.setMAHD(db.rs.getInt("MAHD"));
            contract.setMANGUOIBAN(db.rs.getInt("MANGUOIBAN"));
            contract.setMANGUOIMUA(db.rs.getInt("MANGUOIMUA"));
            contract.setMAXE(db.rs.getInt("MAXE"));
            contract.setNOIDUNGHD(db.rs.getString("NOIDUNGHD"));
            contract.setGIA(db.rs.getDouble("GIA"));
            contract.setNGAYLAP(db.rs.getDate("NGAYLAP"));
            contract.setTRANGTHAI(db.rs.getString("TRANGTHAI"));
            contract.setDIADIEM(db.rs.getString("DIADIEM"));
            contractList.add(contract);
        }
		db.rs.close();
        return contractList;
    }
	
	public List<Contract> add(Contract contract) throws SQLException, ClassNotFoundException{
		this.ConnectionDB();
		List<Contract> contractList = new ArrayList<>();
		contractList = this.toList();
		contractList.add(contract);
		
		String sql = "INSERT INTO `hopdong` (`MANGUOIBAN`, `MAXE`, `NOIDUNGHD`, `GIA`, `TRANGTHAI`, `DIADIEM`) "
				+ "VALUES (?, ?, ?, ?, ?, ? )";
		PreparedStatement stmt = db.conn.prepareStatement(sql);

        stmt.setInt(1, contract.getMANGUOIBAN());
 
        stmt.setInt(2, contract.getMAXE());
        stmt.setString(3, contract.getNOIDUNGHD());
        stmt.setDouble(4, contract.getGIA());
        
        stmt.setString(5, contract.getTRANGTHAI());
        stmt.setString(6, contract.getDIADIEM());
		stmt.execute();
		stmt.close();
		System.out.println("Th??m th??nh c??ng");
		db.rs.close();
		
		return contractList;
	}
	
	/*
	 * public List<Contract> removeById(int Id) throws SQLException,
	 * ClassNotFoundException{ this.ConnectionDB(); List<Contract> ContractList = new
	 * ArrayList<>(); ContractList = this.toList(); for (int i=0; i<
	 * ContractList.size();i++) { if (ContractList.get(i).getMATK() == Id) {
	 * ContractList.remove(i); String sql =
	 * "DELETE FROM `taikhoan` WHERE `taikhoan`.`MATK` = ?"; PreparedStatement stmt
	 * = db.conn.prepareStatement(sql); stmt.setInt(1, Id); stmt.execute();
	 * System.out.println("X??a th??nh c??ng"); stmt.close();; db.rs.close(); return
	 * ContractList; }
	 * 
	 * }
	 * 
	 * return ContractList; }
	 */
	
	public List<Contract> update (Contract contract) throws SQLException, ClassNotFoundException{
		this.ConnectionDB();
		List<Contract> contractList = new ArrayList<>();
		contractList = this.toList();
		for (int i=0; i< contractList.size();i++) {
			if (contractList.get(i).getMAXE() == contract.getMAXE())
				{
					contractList.get(i).setMANGUOIBAN(contract.getMANGUOIBAN());
					contractList.get(i).setMANGUOIMUA(contract.getMANGUOIMUA());
					contractList.get(i).setMAXE(contract.getMAXE());
					contractList.get(i).setNOIDUNGHD(contract.getNOIDUNGHD());
					contractList.get(i).setGIA(contract.getGIA());
					contractList.get(i).setTRANGTHAI(contract.getTRANGTHAI());
					contractList.get(i).setDIADIEM(contract.getDIADIEM());
					contractList.get(i).setNGAYLAP(contract.getNGAYLAP());

					
					
					String sql = "UPDATE `hopdong` SET `MANGUOIMUA` = ?, `NOIDUNGHD` = ?, `GIA` = ?, `TRANGTHAI` = ?, `DIADIEM` = ? WHERE `hopdong`.`MAHD` = ?";
					PreparedStatement stmt = db.conn.prepareStatement(sql);
		
			        stmt.setInt(1, contract.getMANGUOIMUA());

			        stmt.setString(2, contract.getNOIDUNGHD());
			        stmt.setDouble(3, contract.getGIA());
	
			        stmt.setString(4, contract.getTRANGTHAI());
			        stmt.setString(5, contract.getDIADIEM());
			        stmt.setInt(6, contract.getMAHD());
			        
			        
			        stmt.execute();
			        System.out.println("S???a th??nh c??ng");
			        stmt.close();
			        db.rs.close();
					return contractList;
				}
			
		}
		return contractList;
	}
	
	public List<Contract> updateByOwner (Contract contract) throws SQLException, ClassNotFoundException{
		this.ConnectionDB();
		List<Contract> contractList = new ArrayList<>();
		contractList = this.toList();
		for (int i=0; i< contractList.size();i++) {
			if (contractList.get(i).getMAXE() == contract.getMAXE())
				{
					contractList.get(i).setMANGUOIBAN(contract.getMANGUOIBAN());
					contractList.get(i).setMANGUOIMUA(contract.getMANGUOIMUA());
					contractList.get(i).setMAXE(contract.getMAXE());
					contractList.get(i).setNOIDUNGHD(contract.getNOIDUNGHD());
					contractList.get(i).setGIA(contract.getGIA());
					contractList.get(i).setTRANGTHAI(contract.getTRANGTHAI());
					contractList.get(i).setDIADIEM(contract.getDIADIEM());
					contractList.get(i).setNGAYLAP(contract.getNGAYLAP());

					
					
					String sql = "UPDATE `hopdong` SET `NOIDUNGHD` = ?, `GIA` = ?, `TRANGTHAI` = ?, `DIADIEM` = ? WHERE `hopdong`.`MAHD` = ?";
					PreparedStatement stmt = db.conn.prepareStatement(sql);
		
			   

			        stmt.setString(1, contract.getNOIDUNGHD());
			        stmt.setDouble(2, contract.getGIA());
	
			        stmt.setString(3, contract.getTRANGTHAI());
			        stmt.setString(4, contract.getDIADIEM());
			        stmt.setInt(5, contract.getMAHD());
			        
			        
			        stmt.execute();
			        System.out.println("S???a th??nh c??ng");
			        stmt.close();
			        db.rs.close();
					return contractList;
				}
			
		}
		return contractList;
	}
	
	public List<Contract> updateStatus (Contract contract) throws SQLException, ClassNotFoundException{
		this.ConnectionDB();
		List<Contract> contractList = new ArrayList<>();
		contractList = this.toList();
		for (int i=0; i< contractList.size();i++) {
			if (contractList.get(i).getMAXE() == contract.getMAXE())
				{
					contractList.get(i).setMANGUOIBAN(contract.getMANGUOIBAN());
					contractList.get(i).setMANGUOIMUA(contract.getMANGUOIMUA());
					contractList.get(i).setMAXE(contract.getMAXE());
					contractList.get(i).setNOIDUNGHD(contract.getNOIDUNGHD());
					contractList.get(i).setGIA(contract.getGIA());
					contractList.get(i).setTRANGTHAI(contract.getTRANGTHAI());
					contractList.get(i).setDIADIEM(contract.getDIADIEM());
					contractList.get(i).setNGAYLAP(contract.getNGAYLAP());

					
					
					String sql = "UPDATE `hopdong` SET `TRANGTHAI` = ? WHERE `hopdong`.`MAHD` = ?";
					PreparedStatement stmt = db.conn.prepareStatement(sql);
		
			   

			        
	
			        stmt.setString(1, contract.getTRANGTHAI());
			        
			        stmt.setInt(2, contract.getMAHD());
			        
			        
			        stmt.execute();
			        System.out.println("S???a th??nh c??ng");
			        stmt.close();
			        db.rs.close();
					return contractList;
				}
			
		}
		return contractList;
	}
	
	public List<Contract> updateBuyer (Contract contract) throws SQLException, ClassNotFoundException{
		this.ConnectionDB();
		List<Contract> contractList = new ArrayList<>();
		contractList = this.toList();
		for (int i=0; i< contractList.size();i++) {
			if (contractList.get(i).getMAXE() == contract.getMAXE())
				{
					contractList.get(i).setMANGUOIBAN(contract.getMANGUOIBAN());
					contractList.get(i).setMANGUOIMUA(contract.getMANGUOIMUA());
					contractList.get(i).setMAXE(contract.getMAXE());
					contractList.get(i).setNOIDUNGHD(contract.getNOIDUNGHD());
					contractList.get(i).setGIA(contract.getGIA());
					contractList.get(i).setTRANGTHAI(contract.getTRANGTHAI());
					contractList.get(i).setDIADIEM(contract.getDIADIEM());
					contractList.get(i).setNGAYLAP(contract.getNGAYLAP());

					
					
					String sql = "UPDATE `hopdong` SET `TRANGTHAI` = ?,`MANGUOIMUA` = ? WHERE `hopdong`.`MAHD` = ?";
					PreparedStatement stmt = db.conn.prepareStatement(sql);
		
			   

			        
	
			        stmt.setString(1, contract.getTRANGTHAI());
			        stmt.setInt(2, contract.getMANGUOIMUA());
			        
			        stmt.setInt(3, contract.getMAHD());
			        
			        
			        stmt.execute();
			        System.out.println("S???a th??nh c??ng");
			        stmt.close();
			        db.rs.close();
					return contractList;
				}
			
		}
		return contractList;
	}
}
