package com.webbanxe.model.ViewModel;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.webbanxe.model.ConnectionDB;


public class ContractCarDetailsViewDAO {
public ConnectionDB db;
    
    public void ConnectionDB() throws ClassNotFoundException, SQLException {
    	db = new ConnectionDB();
    }
    
	public ContractCarDetailsView getByMAHD(int MAHD) throws ClassNotFoundException,SQLException {
		this.ConnectionDB();
		ContractCarDetailsView ContractCarDetailsView = new ContractCarDetailsView();
		String sql = "SELECT * FROM hopdong_xe WHERE MAHD = '" + MAHD + "'";
		db.rs = db.stmt.executeQuery(sql);
		if(db.rs.next()){
            ContractCarDetailsView = new ContractCarDetailsView();
            ContractCarDetailsView.setMAHD(db.rs.getInt("MAHD"));
            ContractCarDetailsView.setMATK(db.rs.getInt("MATK"));
            ContractCarDetailsView.setMAXE(db.rs.getInt("MAXE"));
            ContractCarDetailsView.setMALOAIXE(db.rs.getInt("MALOAIXE"));
            ContractCarDetailsView.setMAHSX(db.rs.getInt("MAHSX"));
            ContractCarDetailsView.setBAOHANH(db.rs.getInt("BAOHANH"));
            ContractCarDetailsView.setNAMSANXUAT(db.rs.getInt("NAMSANXUAT"));
            
            ContractCarDetailsView.setGIA(db.rs.getDouble("GIA"));
            ContractCarDetailsView.setNGAYLAP(db.rs.getDate("NGAYLAP"));
            

            ContractCarDetailsView.setTENTK(db.rs.getString("TENTK"));
            ContractCarDetailsView.setHINHANH(db.rs.getString("HINHANH"));
            ContractCarDetailsView.setTENXE(db.rs.getString("TENXE"));
            ContractCarDetailsView.setTENLOAIXE(db.rs.getString("TENLOAIXE")); 
            ContractCarDetailsView.setTENHSX(db.rs.getString("TENHSX"));
            ContractCarDetailsView.setTRANGTHAI(db.rs.getString("TRANGTHAI"));
            ContractCarDetailsView.setDIADIEM(db.rs.getString("DIADIEM"));
            
            
        }
        db.rs.close();
        return ContractCarDetailsView;
	}
	
	public ContractCarDetailsView getByMAXE(int MAXE) throws ClassNotFoundException,SQLException {
		this.ConnectionDB();
		ContractCarDetailsView ContractCarDetailsView = new ContractCarDetailsView();
		String sql = "SELECT * FROM hopdong_xe WHERE MAXE = '" + MAXE + "'";
		db.rs = db.stmt.executeQuery(sql);
		if(db.rs.next()){
            ContractCarDetailsView = new ContractCarDetailsView();
            ContractCarDetailsView.setMAHD(db.rs.getInt("MAHD"));
            ContractCarDetailsView.setMATK(db.rs.getInt("MATK"));
            ContractCarDetailsView.setMAXE(db.rs.getInt("MAXE"));
            ContractCarDetailsView.setMALOAIXE(db.rs.getInt("MALOAIXE"));
            ContractCarDetailsView.setMAHSX(db.rs.getInt("MAHSX"));
            ContractCarDetailsView.setBAOHANH(db.rs.getInt("BAOHANH"));
            ContractCarDetailsView.setNAMSANXUAT(db.rs.getInt("NAMSANXUAT"));
            
            ContractCarDetailsView.setGIA(db.rs.getDouble("GIA"));
            ContractCarDetailsView.setNGAYLAP(db.rs.getDate("NGAYLAP"));
            

            ContractCarDetailsView.setTENTK(db.rs.getString("TENTK"));
            ContractCarDetailsView.setHINHANH(db.rs.getString("HINHANH"));
            ContractCarDetailsView.setTENXE(db.rs.getString("TENXE"));
            ContractCarDetailsView.setTENLOAIXE(db.rs.getString("TENLOAIXE")); 
            ContractCarDetailsView.setTENHSX(db.rs.getString("TENHSX"));
            ContractCarDetailsView.setTRANGTHAI(db.rs.getString("TRANGTHAI"));
            ContractCarDetailsView.setDIADIEM(db.rs.getString("DIADIEM"));
            
            
        }
        db.rs.close();
        return ContractCarDetailsView;
	}
	
	
	
	public List<ContractCarDetailsView> toList() throws SQLException, ClassNotFoundException {
		this.ConnectionDB();
        List<ContractCarDetailsView> ContractCarDetailsViewList = new ArrayList<>();
        
        
        db.rs = db.stmt.executeQuery("SELECT * FROM hopdong_xe");
		while(db.rs.next()){
			ContractCarDetailsView ContractCarDetailsView = new ContractCarDetailsView();
			ContractCarDetailsView.setMAHD(db.rs.getInt("MAHD"));
            ContractCarDetailsView.setMATK(db.rs.getInt("MATK"));
            ContractCarDetailsView.setMAXE(db.rs.getInt("MAXE"));
            ContractCarDetailsView.setMALOAIXE(db.rs.getInt("MALOAIXE"));
            ContractCarDetailsView.setMAHSX(db.rs.getInt("MAHSX"));
            ContractCarDetailsView.setBAOHANH(db.rs.getInt("BAOHANH"));
            ContractCarDetailsView.setNAMSANXUAT(db.rs.getInt("NAMSANXUAT"));
            
            ContractCarDetailsView.setGIA(db.rs.getDouble("GIA"));
            ContractCarDetailsView.setNGAYLAP(db.rs.getDate("NGAYLAP"));
            

            ContractCarDetailsView.setTENTK(db.rs.getString("TENTK"));
            ContractCarDetailsView.setHINHANH(db.rs.getString("HINHANH"));
            ContractCarDetailsView.setTENXE(db.rs.getString("TENXE"));
            ContractCarDetailsView.setTENLOAIXE(db.rs.getString("TENLOAIXE")); 
            ContractCarDetailsView.setTENHSX(db.rs.getString("TENHSX"));
            ContractCarDetailsView.setTRANGTHAI(db.rs.getString("TRANGTHAI"));
            ContractCarDetailsView.setDIADIEM(db.rs.getString("DIADIEM"));
            
            ContractCarDetailsViewList.add(ContractCarDetailsView);
        }
		db.rs.close();
        return ContractCarDetailsViewList;
    }
	
	public List<ContractCarDetailsView> toPublicList() throws SQLException, ClassNotFoundException {
		this.ConnectionDB();
        List<ContractCarDetailsView> ContractCarDetailsViewList = new ArrayList<>();
        
        
        db.rs = db.stmt.executeQuery("SELECT * FROM hopdong_xe WHERE `TRANGTHAI`= 'Công khai'");
		while(db.rs.next()){
			ContractCarDetailsView ContractCarDetailsView = new ContractCarDetailsView();
			ContractCarDetailsView.setMAHD(db.rs.getInt("MAHD"));
            ContractCarDetailsView.setMATK(db.rs.getInt("MATK"));
            ContractCarDetailsView.setMAXE(db.rs.getInt("MAXE"));
            ContractCarDetailsView.setMALOAIXE(db.rs.getInt("MALOAIXE"));
            ContractCarDetailsView.setMAHSX(db.rs.getInt("MAHSX"));
            ContractCarDetailsView.setBAOHANH(db.rs.getInt("BAOHANH"));
            ContractCarDetailsView.setNAMSANXUAT(db.rs.getInt("NAMSANXUAT"));
            
            ContractCarDetailsView.setGIA(db.rs.getDouble("GIA"));
            ContractCarDetailsView.setNGAYLAP(db.rs.getDate("NGAYLAP"));
            

            ContractCarDetailsView.setTENTK(db.rs.getString("TENTK"));
            ContractCarDetailsView.setHINHANH(db.rs.getString("HINHANH"));
            ContractCarDetailsView.setTENXE(db.rs.getString("TENXE"));
            ContractCarDetailsView.setTENLOAIXE(db.rs.getString("TENLOAIXE")); 
            ContractCarDetailsView.setTENHSX(db.rs.getString("TENHSX"));
            ContractCarDetailsView.setTRANGTHAI(db.rs.getString("TRANGTHAI"));
            ContractCarDetailsView.setDIADIEM(db.rs.getString("DIADIEM"));
            
            ContractCarDetailsViewList.add(ContractCarDetailsView);
        }
		db.rs.close();
        return ContractCarDetailsViewList;
    }
	
	public List<ContractCarDetailsView> toListByMATK(int MATK) throws SQLException, ClassNotFoundException {
		this.ConnectionDB();
        List<ContractCarDetailsView> ContractCarDetailsViewList = new ArrayList<>();
        
        
        db.rs = db.stmt.executeQuery("SELECT * FROM hopdong_xe WHERE MATK = " + MATK);
		while(db.rs.next()){
			ContractCarDetailsView ContractCarDetailsView = new ContractCarDetailsView();
			ContractCarDetailsView.setMAHD(db.rs.getInt("MAHD"));
            ContractCarDetailsView.setMATK(db.rs.getInt("MATK"));
            ContractCarDetailsView.setMAXE(db.rs.getInt("MAXE"));
            ContractCarDetailsView.setMALOAIXE(db.rs.getInt("MALOAIXE"));
            ContractCarDetailsView.setMAHSX(db.rs.getInt("MAHSX"));
            ContractCarDetailsView.setBAOHANH(db.rs.getInt("BAOHANH"));
            ContractCarDetailsView.setNAMSANXUAT(db.rs.getInt("NAMSANXUAT"));
            
            ContractCarDetailsView.setGIA(db.rs.getDouble("GIA"));
            ContractCarDetailsView.setNGAYLAP(db.rs.getDate("NGAYLAP"));
            

            ContractCarDetailsView.setTENTK(db.rs.getString("TENTK"));
            ContractCarDetailsView.setHINHANH(db.rs.getString("HINHANH"));
            ContractCarDetailsView.setTENXE(db.rs.getString("TENXE"));
            ContractCarDetailsView.setTENLOAIXE(db.rs.getString("TENLOAIXE")); 
            ContractCarDetailsView.setTENHSX(db.rs.getString("TENHSX"));
            ContractCarDetailsView.setTRANGTHAI(db.rs.getString("TRANGTHAI"));
            ContractCarDetailsView.setDIADIEM(db.rs.getString("DIADIEM"));
            
            ContractCarDetailsViewList.add(ContractCarDetailsView);
        }
		db.rs.close();
        return ContractCarDetailsViewList;
    }
	
	public List<ContractCarDetailsView> toListByMALOAIXE(int MALOAIXE) throws SQLException, ClassNotFoundException {
		this.ConnectionDB();
        List<ContractCarDetailsView> ContractCarDetailsViewList = new ArrayList<>();
        
        
        db.rs = db.stmt.executeQuery("SELECT * FROM hopdong_xe WHERE MALOAIXE = " + MALOAIXE);
		while(db.rs.next()){
			ContractCarDetailsView ContractCarDetailsView = new ContractCarDetailsView();
			ContractCarDetailsView.setMAHD(db.rs.getInt("MAHD"));
            ContractCarDetailsView.setMATK(db.rs.getInt("MATK"));
            ContractCarDetailsView.setMAXE(db.rs.getInt("MAXE"));
            ContractCarDetailsView.setMALOAIXE(db.rs.getInt("MALOAIXE"));
            ContractCarDetailsView.setMAHSX(db.rs.getInt("MAHSX"));
            ContractCarDetailsView.setBAOHANH(db.rs.getInt("BAOHANH"));
            ContractCarDetailsView.setNAMSANXUAT(db.rs.getInt("NAMSANXUAT"));
            
            ContractCarDetailsView.setGIA(db.rs.getDouble("GIA"));
            ContractCarDetailsView.setNGAYLAP(db.rs.getDate("NGAYLAP"));
            

            ContractCarDetailsView.setTENTK(db.rs.getString("TENTK"));
            ContractCarDetailsView.setHINHANH(db.rs.getString("HINHANH"));
            ContractCarDetailsView.setTENXE(db.rs.getString("TENXE"));
            ContractCarDetailsView.setTENLOAIXE(db.rs.getString("TENLOAIXE")); 
            ContractCarDetailsView.setTENHSX(db.rs.getString("TENHSX"));
            ContractCarDetailsView.setTRANGTHAI(db.rs.getString("TRANGTHAI"));
            ContractCarDetailsView.setDIADIEM(db.rs.getString("DIADIEM"));
            
            ContractCarDetailsViewList.add(ContractCarDetailsView);
        }
		db.rs.close();
        return ContractCarDetailsViewList;
    }
	
	public List<ContractCarDetailsView> toListByMAHSX(int MAHSX) throws SQLException, ClassNotFoundException {
		this.ConnectionDB();
        List<ContractCarDetailsView> ContractCarDetailsViewList = new ArrayList<>();
        
        
        db.rs = db.stmt.executeQuery("SELECT * FROM hopdong_xe WHERE MAHSX = " + MAHSX);
		while(db.rs.next()){
			ContractCarDetailsView ContractCarDetailsView = new ContractCarDetailsView();
			ContractCarDetailsView.setMAHD(db.rs.getInt("MAHD"));
            ContractCarDetailsView.setMATK(db.rs.getInt("MATK"));
            ContractCarDetailsView.setMAXE(db.rs.getInt("MAXE"));
            ContractCarDetailsView.setMALOAIXE(db.rs.getInt("MALOAIXE"));
            ContractCarDetailsView.setMAHSX(db.rs.getInt("MAHSX"));
            ContractCarDetailsView.setBAOHANH(db.rs.getInt("BAOHANH"));
            ContractCarDetailsView.setNAMSANXUAT(db.rs.getInt("NAMSANXUAT"));
            
            ContractCarDetailsView.setGIA(db.rs.getDouble("GIA"));
            ContractCarDetailsView.setNGAYLAP(db.rs.getDate("NGAYLAP"));
            

            ContractCarDetailsView.setTENTK(db.rs.getString("TENTK"));
            ContractCarDetailsView.setHINHANH(db.rs.getString("HINHANH"));
            ContractCarDetailsView.setTENXE(db.rs.getString("TENXE"));
            ContractCarDetailsView.setTENLOAIXE(db.rs.getString("TENLOAIXE")); 
            ContractCarDetailsView.setTENHSX(db.rs.getString("TENHSX"));
            ContractCarDetailsView.setTRANGTHAI(db.rs.getString("TRANGTHAI"));
            ContractCarDetailsView.setDIADIEM(db.rs.getString("DIADIEM"));
            
            ContractCarDetailsViewList.add(ContractCarDetailsView);
        }
		db.rs.close();
        return ContractCarDetailsViewList;
    }
	
	public List<ContractCarDetailsView> toListByBAOHANH(int BAOHANH) throws SQLException, ClassNotFoundException {
		this.ConnectionDB();
        List<ContractCarDetailsView> ContractCarDetailsViewList = new ArrayList<>();
        
        
        db.rs = db.stmt.executeQuery("SELECT * FROM hopdong_xe WHERE BAOHANH = " + BAOHANH);
		while(db.rs.next()){
			ContractCarDetailsView ContractCarDetailsView = new ContractCarDetailsView();
			ContractCarDetailsView.setMAHD(db.rs.getInt("MAHD"));
            ContractCarDetailsView.setMATK(db.rs.getInt("MATK"));
            ContractCarDetailsView.setMAXE(db.rs.getInt("MAXE"));
            ContractCarDetailsView.setMALOAIXE(db.rs.getInt("MALOAIXE"));
            ContractCarDetailsView.setMAHSX(db.rs.getInt("MAHSX"));
            ContractCarDetailsView.setBAOHANH(db.rs.getInt("BAOHANH"));
            ContractCarDetailsView.setNAMSANXUAT(db.rs.getInt("NAMSANXUAT"));
            
            ContractCarDetailsView.setGIA(db.rs.getDouble("GIA"));
            ContractCarDetailsView.setNGAYLAP(db.rs.getDate("NGAYLAP"));
            

            ContractCarDetailsView.setTENTK(db.rs.getString("TENTK"));
            ContractCarDetailsView.setHINHANH(db.rs.getString("HINHANH"));
            ContractCarDetailsView.setTENXE(db.rs.getString("TENXE"));
            ContractCarDetailsView.setTENLOAIXE(db.rs.getString("TENLOAIXE")); 
            ContractCarDetailsView.setTENHSX(db.rs.getString("TENHSX"));
            ContractCarDetailsView.setTRANGTHAI(db.rs.getString("TRANGTHAI"));
            ContractCarDetailsView.setDIADIEM(db.rs.getString("DIADIEM"));
            
            ContractCarDetailsViewList.add(ContractCarDetailsView);
        }
		db.rs.close();
        return ContractCarDetailsViewList;
    }
	
	public List<ContractCarDetailsView> toListByNAMSANXUAT(int NAMSANXUAT) throws SQLException, ClassNotFoundException {
		this.ConnectionDB();
        List<ContractCarDetailsView> ContractCarDetailsViewList = new ArrayList<>();
        
        
        db.rs = db.stmt.executeQuery("SELECT * FROM hopdong_xe WHERE NAMSANXUAT = " + NAMSANXUAT);
		while(db.rs.next()){
			ContractCarDetailsView ContractCarDetailsView = new ContractCarDetailsView();
            ContractCarDetailsView.setMAHD(db.rs.getInt("MAHD"));
            ContractCarDetailsView.setMATK(db.rs.getInt("MATK"));
            ContractCarDetailsView.setMAXE(db.rs.getInt("MAXE"));
            ContractCarDetailsView.setMALOAIXE(db.rs.getInt("MALOAIXE"));
            ContractCarDetailsView.setMAHSX(db.rs.getInt("MAHSX"));
            ContractCarDetailsView.setBAOHANH(db.rs.getInt("BAOHANH"));
            ContractCarDetailsView.setNAMSANXUAT(db.rs.getInt("NAMSANXUAT"));
            
            ContractCarDetailsView.setGIA(db.rs.getDouble("GIA"));
            ContractCarDetailsView.setNGAYLAP(db.rs.getDate("NGAYLAP"));
            

            ContractCarDetailsView.setTENTK(db.rs.getString("TENTK"));
            ContractCarDetailsView.setHINHANH(db.rs.getString("HINHANH"));
            ContractCarDetailsView.setTENXE(db.rs.getString("TENXE"));
            ContractCarDetailsView.setTENLOAIXE(db.rs.getString("TENLOAIXE")); 
            ContractCarDetailsView.setTENHSX(db.rs.getString("TENHSX"));
            ContractCarDetailsView.setTRANGTHAI(db.rs.getString("TRANGTHAI"));
            ContractCarDetailsView.setDIADIEM(db.rs.getString("DIADIEM"));
            
            ContractCarDetailsViewList.add(ContractCarDetailsView);
        }
		db.rs.close();
        return ContractCarDetailsViewList;
    }
	
}
