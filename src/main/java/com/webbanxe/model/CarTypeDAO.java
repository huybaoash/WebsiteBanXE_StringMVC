package com.webbanxe.model;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CarTypeDAO {
public ConnectionDB db;
    
    public void ConnectionDB() throws ClassNotFoundException, SQLException {
    	db = new ConnectionDB();
    }
    
	public CarType getCarType(int Id) throws ClassNotFoundException,SQLException {
		this.ConnectionDB();
		CarType carcomp = new CarType();
		String sql = "SELECT * FROM loaixe WHERE MALOAIXE = '" + Id + "'";
		db.rs = db.stmt.executeQuery(sql);
		if(db.rs.next()){
			carcomp = new CarType();
			carcomp.setMALOAIXE(db.rs.getInt("MALOAIXE"));
            carcomp.setTENLOAIXE(db.rs.getString("TENLOAIXE"));
            carcomp.setHINHANH(db.rs.getString("HINHANH"));
            carcomp.setTRANGTHAI(db.rs.getString("TRANGTHAI"));       
        }
        db.rs.close();
        return carcomp;
	}
	
	
	public List<CarType> toList() throws SQLException, ClassNotFoundException {
		this.ConnectionDB();
        List<CarType> carTypeList = new ArrayList<>();
        
        
        db.rs = db.stmt.executeQuery("SELECT * FROM loaixe");
		while(db.rs.next()){
            CarType carcomp = new CarType();
            carcomp = new CarType();
			carcomp.setMALOAIXE(db.rs.getInt("MALOAIXE"));
            carcomp.setTENLOAIXE(db.rs.getString("TENLOAIXE"));
            carcomp.setHINHANH(db.rs.getString("HINHANH"));
            carcomp.setTRANGTHAI(db.rs.getString("TRANGTHAI"));
            carTypeList.add(carcomp);
        }
		db.rs.close();
        return carTypeList;
    }
	
	public List<CarType> add(CarType carcomp) throws SQLException, ClassNotFoundException{
		this.ConnectionDB();
		List<CarType> carTypeList = new ArrayList<>();
		carTypeList = this.toList();
		carTypeList.add(carcomp);
		
		String sql = "INSERT INTO hangsanxuat (`MALOAIXE`, `TENLOAIXE`, `HINHANH`, `TRANGTHAI`) VALUES (NULL, '?', '?', 'Công khai')";
		PreparedStatement stmt = db.conn.prepareStatement(sql);

        stmt.setString(1, carcomp.getTENLOAIXE());
        stmt.setString(2, carcomp.getHINHANH());
        
		stmt.execute();
		stmt.close();
		System.out.println("Thêm thành công");
		db.rs.close();
		
		
		return carTypeList;
	}
	
	/*
	 * public List<CarType> removeById(int Id) throws SQLException,
	 * ClassNotFoundException{ this.ConnectionDB(); List<CarType>
	 * carTypeList = new ArrayList<>(); carTypeList = this.toList(); for
	 * (int i=0; i< carTypeList.size();i++) { if
	 * (carTypeList.get(i).getMAHSX() == Id) carTypeList.remove(i); }
	 * 
	 * return carTypeList; }
	 */
	
	public List<CarType> update (CarType carcomp) throws SQLException, ClassNotFoundException{
		List<CarType> carTypeList = new ArrayList<>();
		carTypeList = this.toList();
		for (int i=0; i< carTypeList.size();i++) {
			if (carTypeList.get(i).getMALOAIXE() == carcomp.getMALOAIXE())
				{
					carTypeList.get(i).setTENLOAIXE(carcomp.getTENLOAIXE());
					carTypeList.get(i).setHINHANH(carcomp.getHINHANH());
					carTypeList.get(i).setTRANGTHAI(carcomp.getTRANGTHAI());
					
					
					String sql = "UPDATE `loaixe` SET `TENLOAIXE` = '?', `HINHANH` = '?', `TRANGTHAI` = '?' WHERE `loaixe`.`MALOAIXE` = ?";
					PreparedStatement stmt = db.conn.prepareStatement(sql);
			        stmt.setString(1, carcomp.getTENLOAIXE());
			        stmt.setString(2, carcomp.getHINHANH());
			        stmt.setString(3, carcomp.getTRANGTHAI());
			        stmt.setInt(4, carcomp.getMALOAIXE());
			        
			        stmt.execute();
			        System.out.println("Sửa thành công");
			        stmt.close();
			        db.rs.close();
					return carTypeList;
				}
			
		}
		return carTypeList;
	}
}
