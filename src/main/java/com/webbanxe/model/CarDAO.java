package com.webbanxe.model;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CarDAO {
	public ConnectionDB db;
    
    public void ConnectionDB() throws ClassNotFoundException, SQLException {
    	db = new ConnectionDB();
    }
    
	public Car getCar(int Id) throws ClassNotFoundException,SQLException {
		this.ConnectionDB();
		Car car = new Car();
		String sql = "SELECT * FROM xe WHERE MAXE = '" + Id + "'";
		db.rs = db.stmt.executeQuery(sql);
		if(db.rs.next()){
            car = new Car();
            car.setTENXE(db.rs.getString("TENXE"));
            car.setHINHANH(db.rs.getString("HINHANH"));
            car.setNOIDUNGXE(db.rs.getString("NOIDUNGXE"));
            car.setTRANGTHAI(db.rs.getString("TRANGTHAI"));
            car.setBAOHANH(db.rs.getInt("BAOHANH"));
            car.setGIA(db.rs.getDouble("GIA"));
            car.setNAMSANXUAT(db.rs.getInt("NAMSANXUAT"));
            car.setMALOAIXE(db.rs.getInt("MALOAIXE"));
            car.setMAHSX(db.rs.getInt("MAHSX"));
            car.setMAXE(db.rs.getInt("MAXE"));
            
        }
        db.rs.close();
        return car;
	}
	
	
	public List<Car> toList() throws SQLException, ClassNotFoundException {
		this.ConnectionDB();
        List<Car> carList = new ArrayList<>();
        
        
        db.rs = db.stmt.executeQuery("SELECT * FROM taikhoan");
		while(db.rs.next()){
            Car car = new Car();
            car.setMAXE(db.rs.getInt("MAXE"));
            car.setTENXE(db.rs.getString("TENXE"));
            car.setHINHANH(db.rs.getString("HINHANH"));
            car.setNOIDUNGXE(db.rs.getString("NOIDUNGXE"));
            car.setTRANGTHAI(db.rs.getString("TRANGTHAI"));
            car.setBAOHANH(db.rs.getInt("BAOHANH"));
            car.setGIA(db.rs.getDouble("GIA"));
            car.setNAMSANXUAT(db.rs.getInt("NAMSANXUAT"));
            car.setMALOAIXE(db.rs.getInt("MALOAIXE"));
            car.setMAHSX(db.rs.getInt("MAHSX"));
            carList.add(car);
        }
		db.rs.close();
        return carList;
    }
	
	public List<Car> add(Car car) throws SQLException, ClassNotFoundException{
		this.ConnectionDB();
		List<Car> carList = new ArrayList<>();
		carList = this.toList();
		carList.add(car);
		
		String sql = "INSERT INTO `xe` (`MAXE`, `TENXE`, `NOIDUNGXE`, `HINHANH`, `BAOHANH`, `GIA`, `NAMSANXUAT`, `MALOAIXE`, `MAHSX`, `TRANGTHAI`) "
				+ "VALUES (NULL, '?', '?', '?', '?', '?', '?', '?', '?', 'Công khai')";
		PreparedStatement stmt = db.conn.prepareStatement(sql);

        stmt.setString(1, car.getTENXE());
        stmt.setString(2, car.getNOIDUNGXE());
        stmt.setString(3, car.getHINHANH());
        stmt.setInt(4, car.getBAOHANH());
        stmt.setDouble(5, car.getGIA());
        stmt.setInt(6, car.getNAMSANXUAT());
        stmt.setInt(7, car.getMALOAIXE());
        stmt.setInt(8, car.getMAHSX());
		stmt.execute();
		stmt.close();
		System.out.println("Thêm thành công");
		db.rs.close();
		
		return carList;
	}
	
	/*
	 * public List<Car> removeById(int Id) throws SQLException,
	 * ClassNotFoundException{ this.ConnectionDB(); List<Car> CarList = new
	 * ArrayList<>(); CarList = this.toList(); for (int i=0; i<
	 * CarList.size();i++) { if (CarList.get(i).getMATK() == Id) {
	 * CarList.remove(i); String sql =
	 * "DELETE FROM `taikhoan` WHERE `taikhoan`.`MATK` = ?"; PreparedStatement stmt
	 * = db.conn.prepareStatement(sql); stmt.setInt(1, Id); stmt.execute();
	 * System.out.println("Xóa thành công"); stmt.close();; db.rs.close(); return
	 * CarList; }
	 * 
	 * }
	 * 
	 * return CarList; }
	 */
	
	public List<Car> update (Car car) throws SQLException, ClassNotFoundException{
		List<Car> carList = new ArrayList<>();
		carList = this.toList();
		for (int i=0; i< carList.size();i++) {
			if (carList.get(i).getMAXE() == car.getMAXE())
				{
					carList.get(i).setTENXE(car.getTENXE());
					carList.get(i).setNOIDUNGXE(car.getNOIDUNGXE());
					carList.get(i).setBAOHANH(car.getBAOHANH());
					carList.get(i).setHINHANH(car.getHINHANH());
					carList.get(i).setGIA(car.getGIA());
					carList.get(i).setTRANGTHAI(car.getTRANGTHAI());
					carList.get(i).setNAMSANXUAT(car.getNAMSANXUAT());
					carList.get(i).setMALOAIXE(car.getMALOAIXE());
					carList.get(i).setMAHSX(car.getMAHSX());
					
					
					String sql = "UPDATE `xe` SET `TENXE` = '?', `NOIDUNGXE` = '?', `HINHANH` = '?', `BAOHANH` = '?', `GIA` = '?', `NAMSANXUAT` = '?', `MALOAIXE` = '?', `MAHSX` = '?', `TRANGTHAI` = '?' WHERE `xe`.`MAXE` = ?";
					PreparedStatement stmt = db.conn.prepareStatement(sql);
					stmt.setString(1, car.getTENXE());
			        stmt.setString(2, car.getNOIDUNGXE());
			        stmt.setString(3, car.getHINHANH());
			        stmt.setInt(4, car.getBAOHANH());
			        stmt.setDouble(5, car.getGIA());
			        stmt.setInt(6, car.getNAMSANXUAT());
			        stmt.setInt(7, car.getMALOAIXE());
			        stmt.setInt(8, car.getMAHSX());
			        stmt.setString(9, car.getTRANGTHAI());
			        stmt.setInt(10, car.getMAXE());
			        
			        
			        stmt.execute();
			        System.out.println("Sửa thành công");
			        stmt.close();
			        db.rs.close();
					return carList;
				}
			
		}
		return carList;
	}
}
