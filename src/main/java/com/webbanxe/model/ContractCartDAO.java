package com.webbanxe.model;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ContractCartDAO {
public ConnectionDB db;
    
    public void ConnectionDB() throws ClassNotFoundException, SQLException {
    	db = new ConnectionDB();
    }
    
	public ContractCart getContractCart(int Id) throws ClassNotFoundException,SQLException {
		this.ConnectionDB();
		ContractCart contractcart = new ContractCart();
		String sql = "SELECT * FROM giohopdong WHERE Id = '" + Id + "'";
		db.rs = db.stmt.executeQuery(sql);
		if(db.rs.next()){
			contractcart = new ContractCart();
			contractcart.setId(db.rs.getInt("Id"));
            contractcart.setMAHD(db.rs.getInt("MAHD"));
            contractcart.setMATK(db.rs.getInt("MATK")); 
        }
        db.rs.close();
        return contractcart;
	}
	
	
	public List<ContractCart> toList() throws SQLException, ClassNotFoundException {
		this.ConnectionDB();
        List<ContractCart> ContractCartList = new ArrayList<>();
        
        
        db.rs = db.stmt.executeQuery("SELECT * FROM giohopdong");
		while(db.rs.next()){
            ContractCart contractcart = new ContractCart();
            contractcart = new ContractCart();
            contractcart.setId(db.rs.getInt("Id"));
            contractcart.setMAHD(db.rs.getInt("MAHD"));
            contractcart.setMATK(db.rs.getInt("MATK"));  
            ContractCartList.add(contractcart);
        }
		db.rs.close();
        return ContractCartList;
    }
	
	public List<ContractCart> toListByMATK(Account account) throws SQLException, ClassNotFoundException {
		this.ConnectionDB();
        List<ContractCart> ContractCartList = new ArrayList<>();
        
        
        db.rs = db.stmt.executeQuery("SELECT * FROM giohopdong WHERE`MATK` = " + account.getMATK());
		while(db.rs.next()){
            ContractCart contractcart = new ContractCart();
            contractcart = new ContractCart();
            contractcart.setId(db.rs.getInt("Id"));
            contractcart.setMAHD(db.rs.getInt("MAHD"));
            contractcart.setMATK(db.rs.getInt("MATK"));  
            ContractCartList.add(contractcart);
        }
		db.rs.close();
        return ContractCartList;
    }
	
	
	
	public List<ContractCart> add(ContractCart contractcart) throws SQLException, ClassNotFoundException{
		this.ConnectionDB();
		List<ContractCart> ContractCartList = new ArrayList<>();
		ContractCartList = this.toList();
		ContractCartList.add(contractcart);
		
		String sql = "INSERT INTO giohopdong (`MAHD`, `MATK`) VALUES (?, ?)";
		PreparedStatement stmt = db.conn.prepareStatement(sql);

        stmt.setInt(1, contractcart.getMAHD());
        stmt.setInt(2, contractcart.getMATK());
        
		stmt.execute();
		stmt.close();
		System.out.println("Thêm thành công");
		db.rs.close();
		
		
		return ContractCartList;
	}
	
	/*
	 * public List<ContractCart> removeById(int Id) throws SQLException,
	 * ClassNotFoundException{ this.ConnectionDB(); List<ContractCart>
	 * ContractCartList = new ArrayList<>(); ContractCartList = this.toList(); for
	 * (int i=0; i< ContractCartList.size();i++) { if
	 * (ContractCartList.get(i).getMAHSX() == Id) ContractCartList.remove(i); }
	 * 
	 * return ContractCartList; }
	 */
	
	public List<ContractCart> removeByMAHD(ContractCart contractcart) throws SQLException, ClassNotFoundException{
		this.ConnectionDB();
		List<ContractCart> ContractCartList = new ArrayList<>();
		ContractCartList = this.toList();
		
		for (ContractCart contractCart : ContractCartList) {
			if (contractCart.getId() == contractcart.getId()) {
				ContractCartList.remove(contractCart);
				break;
			}
			
		}
		
		String sql = "DELETE FROM `giohopdong` WHERE `giohopdong`.`MAHD` =" + contractcart.getMAHD() + " AND `giohopdong`.`MATK` =" + contractcart.getMATK();
		PreparedStatement stmt = db.conn.prepareStatement(sql);

        
		stmt.execute();
		stmt.close();
		System.out.println("Xóa thành công");
		db.rs.close();
		
		
		return ContractCartList;
	}
	
	public List<ContractCart> removeAllByMATK(Account account) throws SQLException, ClassNotFoundException{
		this.ConnectionDB();
		List<ContractCart> ContractCartList = new ArrayList<>();
		ContractCartList = this.toList();
		
		for (ContractCart contractCart : ContractCartList) {
			if (contractCart.getMATK() == account.getMATK()) {
				ContractCartList.remove(contractCart);
				
			}
			
		}
		
		String sql = "DELETE FROM `giohopdong` WHERE `giohopdong`.`MATK` =" + account.getMATK();
		PreparedStatement stmt = db.conn.prepareStatement(sql);

        
		stmt.execute();
		stmt.close();
		System.out.println("Xóa hết thành công");
		db.rs.close();
		
		
		return ContractCartList;
	}
	
}
