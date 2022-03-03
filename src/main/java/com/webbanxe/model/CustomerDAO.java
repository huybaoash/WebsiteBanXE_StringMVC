package com.webbanxe.model;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

public class CustomerDAO {
	public ConnectionDB db;
    
    public void ConnectionDB() throws ClassNotFoundException, SQLException {
    	db = new ConnectionDB();
    }
    
	public Customer getCustomer(int Id) throws ClassNotFoundException,SQLException {
		this.ConnectionDB();
		Customer Customer = new Customer();
		String sql = "SELECT * FROM khachhang WHERE MAKH = '" + Id + "'";
		db.rs = db.stmt.executeQuery(sql);
		if(db.rs.next()){
            Customer = new Customer();
            Customer.setMAKH(db.rs.getInt("MAKH"));
            Customer.setTENKH(db.rs.getString("TENKH"));
            Customer.setSDT(db.rs.getString("SDT"));
            Customer.setEMAIL(db.rs.getString("EMAIL"));
            Customer.setGIOITINH(db.rs.getString("GIOITINH"));
            Customer.setDIACHI(db.rs.getString("DIACHI"));
            Customer.setCMND(db.rs.getString("CMND"));
            
        }
        db.rs.close();
        return Customer;
	}
	
	
	public List<Customer> toList() throws SQLException, ClassNotFoundException {
		this.ConnectionDB();
        List<Customer> customerList = new ArrayList<>();
        
        
        db.rs = db.stmt.executeQuery("SELECT * FROM taikhoan");
		while(db.rs.next()){
            Customer Customer = new Customer();
            Customer.setMAKH(db.rs.getInt("MAKH"));
            Customer.setTENKH(db.rs.getString("TENKH"));
            Customer.setSDT(db.rs.getString("SDT"));
            Customer.setEMAIL(db.rs.getString("EMAIL"));
            Customer.setGIOITINH(db.rs.getString("GIOITINH"));
            Customer.setDIACHI(db.rs.getString("DIACHI"));
            Customer.setCMND(db.rs.getString("CMND"));
            
            customerList.add(Customer);
        }
		db.rs.close();
        return customerList;
    }
	
	public List<Customer> add(Customer customer) throws SQLException, ClassNotFoundException{
		this.ConnectionDB();
		List<Customer> customerList = new ArrayList<>();
		customerList = this.toList();
		customerList.add(customer);
		
		String sql = "INSERT INTO `khachhang` (`MAKH`, `TENKH`, `SDT`, `EMAIL`, `GIOITINH`, `DIACHI`, `CMND`) "
				+ "VALUES (NULL, '?', '?', '?', '?', '?', '?')";
		PreparedStatement stmt = db.conn.prepareStatement(sql);


        stmt.setString(1, customer.getTENKH());
        stmt.setString(2, customer.getSDT());
        stmt.setString(3, customer.getEMAIL());
        stmt.setString(4, customer.getGIOITINH());
        stmt.setString(5, customer.getDIACHI());
        stmt.setString(6, customer.getCMND());
		stmt.execute();
		stmt.close();
		System.out.println("Thêm thành công");
		db.rs.close();
		
		return customerList;
	}
	
	/*
	 * public List<Customer> removeById(int Id) throws SQLException,
	 * ClassNotFoundException{ this.ConnectionDB(); List<Customer> CustomerList = new
	 * ArrayList<>(); CustomerList = this.toList(); for (int i=0; i<
	 * CustomerList.size();i++) { if (CustomerList.get(i).getMATK() == Id) {
	 * CustomerList.remove(i); String sql =
	 * "DELETE FROM `taikhoan` WHERE `taikhoan`.`MATK` = ?"; PreparedStatement stmt
	 * = db.conn.prepareStatement(sql); stmt.setInt(1, Id); stmt.execute();
	 * System.out.println("Xóa thành công"); stmt.close();; db.rs.close(); return
	 * CustomerList; }
	 * 
	 * }
	 * 
	 * return CustomerList; }
	 */
	
	public List<Customer> update (Customer customer) throws SQLException, ClassNotFoundException{
		List<Customer> customerList = new ArrayList<>();
		customerList = this.toList();
		for (int i=0; i< customerList.size();i++) {
			if (customerList.get(i).getMAKH() == customer.getMAKH())
				{
				customerList.get(i).setTENKH(customer.getTENKH());
				customerList.get(i).setSDT(customer.getSDT());
				customerList.get(i).setEMAIL(customer.getEMAIL());
				customerList.get(i).setGIOITINH(customer.getGIOITINH());
				customerList.get(i).setDIACHI(customer.getDIACHI());
				customerList.get(i).setCMND(customer.getCMND());

					
					
					String sql = "UPDATE `khachhang` SET `TENKH` = '?', `SDT` = '?', `EMAIL` = '?', `GIOITINH` = '?', `DIACHI` = '?', `CMND` = '?' WHERE `khachhang`.`MAKH` = ?";
					PreparedStatement stmt = db.conn.prepareStatement(sql);
					stmt.setString(1, customer.getTENKH());
			        stmt.setString(2, customer.getSDT());
			        stmt.setString(3, customer.getEMAIL());
			        stmt.setString(4, customer.getGIOITINH());
			        stmt.setString(5, customer.getDIACHI());
			        stmt.setString(6, customer.getCMND());
			        stmt.setInt(7, customer.getMAKH());
			    
			        
			        
			        stmt.execute();
			        System.out.println("Sửa thành công");
			        stmt.close();
			        db.rs.close();
					return customerList;
				}
			
		}
		return customerList;
	}
}
