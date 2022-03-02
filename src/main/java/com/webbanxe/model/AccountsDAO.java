package com.webbanxe.model;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.sql.*;


public class AccountsDAO {
	
	public ConnectionDB db;
    
    public void ConnectionDB() throws ClassNotFoundException, SQLException {
    	db = new ConnectionDB();
    }
    
	public Account getAccount(int Id) throws ClassNotFoundException,SQLException {
		this.ConnectionDB();
		Account acc = new Account();
		String sql = "SELECT * FROM taikhoan WHERE MATK = '" + Id + "'";
		db.rs = db.stmt.executeQuery(sql);
		if(db.rs.next()){
            acc = new Account();
            acc.setTENTK(db.rs.getString("TENTK"));
            acc.setHINHANH(db.rs.getString("HINHANH"));
            acc.setMATKHAU(db.rs.getString("MATKHAU"));
            acc.setTRANGTHAI(db.rs.getString("TRANGTHAI"));
            acc.setMAKH(db.rs.getInt("MAKH"));
            acc.setMANV(db.rs.getInt("MANV"));
            acc.setMATK(db.rs.getInt("MATK"));
            
        }
        db.rs.close();
        return acc;
	}
	
	
	public List<Account> toList() throws SQLException, ClassNotFoundException {
		this.ConnectionDB();
        List<Account> accountList = new ArrayList<>();
        
        
        db.rs = db.stmt.executeQuery("SELECT * FROM taikhoan");
		while(db.rs.next()){
            Account acc = new Account();
            acc.setTENTK(db.rs.getString("TENTK"));
            acc.setHINHANH(db.rs.getString("HINHANH"));
            acc.setMATKHAU(db.rs.getString("MATKHAU"));
            acc.setTRANGTHAI(db.rs.getString("TRANGTHAI"));
            acc.setMAKH(db.rs.getInt("MAKH"));
            acc.setMANV(db.rs.getInt("MANV"));
            acc.setMATK(db.rs.getInt("MATK"));
            acc.setCHUCVU(db.rs.getString("CHUCVU"));
            accountList.add(acc);
        }
		db.rs.close();
        return accountList;
    }
	
	public List<Account> add(Account acc) throws SQLException, ClassNotFoundException{
		this.ConnectionDB();
		List<Account> accountList = new ArrayList<>();
		accountList = this.toList();
		accountList.add(acc);
		
		String sql = "INSERT INTO taikhoan (`MATK`, `MAKH`, `MANV`, `TENTK`, `MATKHAU`, `HINHANH`, `CHUCVU`, `TRANGTHAI`) "
				+ "VALUES (NULL, ?, ?, ?, ?, ?, 'Người dùng', 'Công khai')";
		PreparedStatement stmt = db.conn.prepareStatement(sql);

        stmt.setInt(1, acc.getMAKH());
        stmt.setInt(2, acc.getMANV());
        stmt.setString(3, acc.getTENTK());
        stmt.setString(4, acc.getMATKHAU());
        stmt.setString(5, acc.getHINHANH());
		stmt.execute();
		stmt.close();
		System.out.println("Thêm thành công");
		db.rs.close();
		
		return accountList;
	}
	
	/*
	 * public List<Account> removeById(int Id) throws SQLException,
	 * ClassNotFoundException{ this.ConnectionDB(); List<Account> accountList = new
	 * ArrayList<>(); accountList = this.toList(); for (int i=0; i<
	 * accountList.size();i++) { if (accountList.get(i).getMATK() == Id) {
	 * accountList.remove(i); String sql =
	 * "DELETE FROM `taikhoan` WHERE `taikhoan`.`MATK` = ?"; PreparedStatement stmt
	 * = db.conn.prepareStatement(sql); stmt.setInt(1, Id); stmt.execute();
	 * System.out.println("Xóa thành công"); stmt.close();; db.rs.close(); return
	 * accountList; }
	 * 
	 * }
	 * 
	 * return accountList; }
	 */
	
	public List<Account> update (Account acc) throws SQLException, ClassNotFoundException{
		List<Account> accountList = new ArrayList<>();
		accountList = this.toList();
		for (int i=0; i< accountList.size();i++) {
			if (accountList.get(i).getMATK() == acc.getMATK())
				{
					accountList.get(i).setMAKH(acc.getMAKH());
					accountList.get(i).setMANV(acc.getMANV());
					accountList.get(i).setMATKHAU(acc.getMATKHAU());
					accountList.get(i).setHINHANH(acc.getHINHANH());
					accountList.get(i).setCHUCVU(acc.getCHUCVU());
					accountList.get(i).setTRANGTHAI(acc.getTRANGTHAI());
					
					String sql = "UPDATE `taikhoan` SET `MAKH` = '?', `MANV` = '?', `MATKHAU` = '?', `HINHANH` = '?', `CHUCVU` = '?', `TRANGTHAI` = '?' WHERE `taikhoan`.`MATK` = ?";
					PreparedStatement stmt = db.conn.prepareStatement(sql);
			        stmt.setInt(1, acc.getMAKH());
			        stmt.setInt(2, acc.getMANV());
			        stmt.setString(3, acc.getMATKHAU());
			        stmt.setString(4, acc.getHINHANH());
			        stmt.setString(5, acc.getCHUCVU());
			        stmt.setString(6, acc.getTRANGTHAI());
			        stmt.setInt(7, acc.getMATK());
			        stmt.execute();
			        System.out.println("Sửa thành công");
			        stmt.close();
			        db.rs.close();
					return accountList;
				}
			
		}
		return accountList;
	}
	
}
