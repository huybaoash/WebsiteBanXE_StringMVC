package com.webbanxe.model;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CarConmpanyDAO {
	public ConnectionDB db;
    
    public void ConnectionDB() throws ClassNotFoundException, SQLException {
    	db = new ConnectionDB();
    }
    
	public CarConmpany getCarConmpany(int Id) throws ClassNotFoundException,SQLException {
		this.ConnectionDB();
		CarConmpany carcomp = new CarConmpany();
		String sql = "SELECT * FROM hangsanxuat WHERE MAHSX = '" + Id + "'";
		db.rs = db.stmt.executeQuery(sql);
		if(db.rs.next()){
			carcomp = new CarConmpany();
			carcomp.setMAHSX(db.rs.getInt("MAHSX"));
            carcomp.setTENHSX(db.rs.getString("TENHSX"));
            carcomp.setHINHANH(db.rs.getString("HINHANH"));
            carcomp.setTRANGTHAI(db.rs.getString("TRANGTHAI"));       
        }
        db.rs.close();
        return carcomp;
	}
	
	
	public List<CarConmpany> toList() throws SQLException, ClassNotFoundException {
		this.ConnectionDB();
        List<CarConmpany> carConmpanyList = new ArrayList<>();
        
        
        db.rs = db.stmt.executeQuery("SELECT * FROM hangsanxuat");
		while(db.rs.next()){
            CarConmpany carcomp = new CarConmpany();
            carcomp = new CarConmpany();
			carcomp.setMAHSX(db.rs.getInt("MAHSX"));
            carcomp.setTENHSX(db.rs.getString("TENHSX"));
            carcomp.setHINHANH(db.rs.getString("HINHANH"));
            carcomp.setTRANGTHAI(db.rs.getString("TRANGTHAI"));
            carConmpanyList.add(carcomp);
        }
		db.rs.close();
        return carConmpanyList;
    }
	
	public List<CarConmpany> add(CarConmpany carcomp) throws SQLException, ClassNotFoundException{
		this.ConnectionDB();
		List<CarConmpany> carConmpanyList = new ArrayList<>();
		carConmpanyList = this.toList();
		carConmpanyList.add(carcomp);
		
		String sql = "INSERT INTO hangsanxuat (`MAHSX`, `TENHSX`, `HINHANH`, `TRANGTHAI`) VALUES (NULL, '?', '?', 'Công khai')";
		PreparedStatement stmt = db.conn.prepareStatement(sql);

        stmt.setString(1, carcomp.getTENHSX());
        stmt.setString(2, carcomp.getHINHANH());
        
		stmt.execute();
		stmt.close();
		System.out.println("Thêm thành công");
		db.rs.close();
		
		
		return carConmpanyList;
	}
	
	/*
	 * public List<CarConmpany> removeById(int Id) throws SQLException,
	 * ClassNotFoundException{ this.ConnectionDB(); List<CarConmpany>
	 * carConmpanyList = new ArrayList<>(); carConmpanyList = this.toList(); for
	 * (int i=0; i< carConmpanyList.size();i++) { if
	 * (carConmpanyList.get(i).getMAHSX() == Id) carConmpanyList.remove(i); }
	 * 
	 * return carConmpanyList; }
	 */
	
	public List<CarConmpany> update (CarConmpany carcomp) throws SQLException, ClassNotFoundException{
		List<CarConmpany> carConmpanyList = new ArrayList<>();
		carConmpanyList = this.toList();
		for (int i=0; i< carConmpanyList.size();i++) {
			if (carConmpanyList.get(i).getMAHSX() == carcomp.getMAHSX())
				{
					carConmpanyList.get(i).setTENHSX(carcomp.getTENHSX());
					carConmpanyList.get(i).setHINHANH(carcomp.getHINHANH());
					carConmpanyList.get(i).setTRANGTHAI(carcomp.getTRANGTHAI());
					
					
					String sql = "UPDATE `hangsanxuat` SET `TENHSX` = '?', `HINHANH` = '?', `TRANGTHAI` = '?' WHERE `hangsanxuat`.`MAHSX` = ?";
					PreparedStatement stmt = db.conn.prepareStatement(sql);
			        stmt.setString(1, carcomp.getTENHSX());
			        stmt.setString(2, carcomp.getHINHANH());
			        stmt.setString(3, carcomp.getTRANGTHAI());
			        stmt.setInt(4, carcomp.getMAHSX());
			        
			        stmt.execute();
			        System.out.println("Sửa thành công");
			        stmt.close();
			        db.rs.close();
					return carConmpanyList;
				}
			
		}
		return carConmpanyList;
	}
	
}
