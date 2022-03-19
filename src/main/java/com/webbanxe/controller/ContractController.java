package com.webbanxe.controller;

import java.io.File;
import java.nio.file.Files;
import java.sql.SQLException;

import java.util.ArrayList;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;


import com.webbanxe.model.Account;
import com.webbanxe.model.AccountsDAO;
import com.webbanxe.model.Car;
import com.webbanxe.model.CarConmpany;
import com.webbanxe.model.CarConmpanyDAO;
import com.webbanxe.model.CarDAO;
import com.webbanxe.model.CarType;
import com.webbanxe.model.CarTypeDAO;
import com.webbanxe.model.Contract;
import com.webbanxe.model.ContractCart;
import com.webbanxe.model.ContractCartDAO;
import com.webbanxe.model.ContractDAO;
import com.webbanxe.model.Customer;
import com.webbanxe.model.CustomerDAO;

import com.webbanxe.model.ViewModel.ContractCarDetailsView;
import com.webbanxe.model.ViewModel.ContractCarDetailsViewDAO;



@Controller
public class ContractController {
	
	
	
	@RequestMapping(value = { "/car-edit" }, method = RequestMethod.GET)
    public String careditPage(Model model,HttpServletRequest request) {

        return "caredit";
    }
	
	@RequestMapping(value = { "/contract-details" }, method = RequestMethod.GET)
    public String contractdetailsPage(Model model,HttpServletRequest request, @RequestParam int MAHD) throws ClassNotFoundException, SQLException {
		
		HttpSession session = request.getSession();
		Account Account_present = (Account) session.getAttribute("Account_present");
		
		ContractCarDetailsViewDAO data_HD = new ContractCarDetailsViewDAO();
    	ContractCarDetailsView hopdong = data_HD.getByMAHD(MAHD);
    	
    	AccountsDAO data_AccountsDAO = new AccountsDAO();
    	Account Account_selling = data_AccountsDAO.getAccount(hopdong.getMATK());
    	
    	CustomerDAO data_CustomerDAO = new CustomerDAO();
    	Customer Customer_selling = data_CustomerDAO.getCustomer(Account_selling.getMAKH());
    	
    	CarDAO data_CarDAO = new CarDAO();
    	Car Car_selling = data_CarDAO.getCar(hopdong.getMAXE());
    	String noidung = Car_selling.getNOIDUNGXE().replace("\n", "<br />");
    	Car_selling.setNOIDUNGXE(noidung);
    	model.addAttribute("Account_present",Account_present);
    	model.addAttribute("Customer_selling",Customer_selling);
    	
    	model.addAttribute("Car_selling",Car_selling);
    	
		model.addAttribute("hopdong",hopdong);
		
        return "contractdetails";
    }
	
	@RequestMapping(value = { "/contract-edit" }, method = RequestMethod.GET)
    public String contracteditGETPage(Model model,HttpServletRequest request,@RequestParam int MAHD) throws ClassNotFoundException, SQLException {
		
		
		
		HttpSession session = request.getSession();
		Account Account_present = (Account) session.getAttribute("Account_present");
		
		if (Account_present == null ) {
			
			
			LoginController loginController = new LoginController();
			return loginController.loginGETPage(model);
		}
		
		
		
		ContractCarDetailsViewDAO data_HD = new ContractCarDetailsViewDAO();
    	ContractCarDetailsView hopdong = data_HD.getByMAHD(MAHD);
    	
    	if (Account_present.getMATK() != hopdong.getMATK()) {
			
			
			MyController myController = new MyController();
			return myController.homePage(model);
		}
    	
    	if (hopdong.getTRANGTHAI().equals("Hoàn tất giao dịch")) {
			
			
			MyController myController = new MyController();
			return myController.homePage(model);
		}
    	
    	AccountsDAO data_AccountsDAO = new AccountsDAO();
    	Account Account_selling = data_AccountsDAO.getAccount(hopdong.getMATK());
    	
    	CustomerDAO data_CustomerDAO = new CustomerDAO();
    	Customer Customer_selling = data_CustomerDAO.getCustomer(Account_selling.getMAKH());
    	
    	CarDAO data_CarDAO = new CarDAO();
    	Car Car_selling = data_CarDAO.getCar(hopdong.getMAXE());
    	
    	CarTypeDAO dataCarTypeDAO = new CarTypeDAO();
		List<CarType> lstCarType = dataCarTypeDAO.toList();
		
		CarConmpanyDAO dataCarConmpany = new CarConmpanyDAO();
		List<CarConmpany> lstCarConmpany = dataCarConmpany.toList();
		
		ContractDAO dataContractDAO = new ContractDAO();
		Contract hopdongtable = dataContractDAO.getContract(MAHD);
    	
    	model.addAttribute("Account_present",Account_present);
    	model.addAttribute("Customer_present",Customer_selling);
    	
    	model.addAttribute("Car_selling",Car_selling);
    	
		model.addAttribute("hopdong",hopdong);
		model.addAttribute("hopdongtable",hopdongtable);
		
		model.addAttribute("lstCarType",lstCarType);
		model.addAttribute("lstCarConmpany",lstCarConmpany);
		
        return "contractedit";
    }
	
	@RequestMapping(value = { "/contract-edit" }, method = RequestMethod.POST)
    public String contracteditPOSTPage(Model model,HttpServletRequest request,@RequestParam("image1") MultipartFile file) throws Exception {
		
		String mAHD_String = request.getParameter("MAHD");
    	int MAHD = Integer.valueOf(mAHD_String);
		
		HttpSession session = request.getSession();
		Account Account_present = (Account) session.getAttribute("Account_present");
		
		if (Account_present == null ) {
			
			
			LoginController loginController = new LoginController();
			return loginController.loginGETPage(model);
		}
		
		
		
		ContractCarDetailsViewDAO data_HD = new ContractCarDetailsViewDAO();
    	ContractCarDetailsView hopdong = data_HD.getByMAHD(MAHD);
    	
    	if (Account_present.getMATK() != hopdong.getMATK()) {
			
			
			MyController myController = new MyController();
			return myController.homePage(model);
		}
    	
    	if (hopdong.getTRANGTHAI().equals("Hoàn tất giao dịch")) {
			
			
			MyController myController = new MyController();
			return myController.homePage(model);
		}
    	
    	AccountsDAO data_AccountsDAO = new AccountsDAO();
    	Account Account_selling = data_AccountsDAO.getAccount(hopdong.getMATK());
    	
    	CustomerDAO data_CustomerDAO = new CustomerDAO();
    	Customer Customer_selling = data_CustomerDAO.getCustomer(Account_selling.getMAKH());
    	
    	CarDAO data_CarDAO = new CarDAO();
    	
    	
    	CarTypeDAO dataCarTypeDAO = new CarTypeDAO();
		
		
		CarConmpanyDAO dataCarConmpany = new CarConmpanyDAO();
		
		
		ContractDAO dataContractDAO = new ContractDAO();
		
		
		CustomerDAO dataCustomerDAO = new CustomerDAO();
		
		
		List<String> validation = new ArrayList<>();
		
		String TENXE = request.getParameter("TENXE");
		int MALOAIXE = Integer.parseInt(request.getParameter("MALOAIXE"));
		int MAHSX = Integer.parseInt(request.getParameter("MAHSX"));
		String NOIDUNGXE = request.getParameter("NOIDUNGXE");
		String NOIDUNGHD = request.getParameter("NOIDUNGHD");
		
		
		
		int BAOHANH = Integer.parseInt(request.getParameter("BAOHANH")) ;
		int NAMSANXUAT = Integer.parseInt(request.getParameter("NAMSANXUAT"));
		double GIAXE = Double.parseDouble(request.getParameter("GIAXE"));
		String DIADIEM = request.getParameter("DIADIEM");
		String TRANGTHAI = request.getParameter("TRANGTHAI");
		
		
		
		Car Car_selling = data_CarDAO.getCar(hopdong.getMAXE());
		Car_selling.setBAOHANH(BAOHANH);
		
		Car_selling.setMAHSX(MAHSX);
		Car_selling.setMALOAIXE(MALOAIXE);
		Car_selling.setNAMSANXUAT(NAMSANXUAT);
		Car_selling.setNOIDUNGXE(NOIDUNGXE);
		Car_selling.setTENXE(TENXE);
		
		
		
		Contract hopdongtable = dataContractDAO.getContract(MAHD);
		hopdongtable.setDIADIEM(DIADIEM);
		hopdongtable.setGIA(GIAXE);
		hopdongtable.setNOIDUNGHD(NOIDUNGHD);
		hopdongtable.setTRANGTHAI(TRANGTHAI);
		
		if (!file.getOriginalFilename().isEmpty()) {
    		String HINHANH = saveFile(file,hopdongtable, request);
    		Car_selling.setHINHANH(HINHANH);
    	}
		
		
		data_CarDAO.update(Car_selling);
		dataContractDAO.updateByOwner(hopdongtable);
		
		List<CarType> lstCarType = dataCarTypeDAO.toList();
		List<CarConmpany> lstCarConmpany = dataCarConmpany.toList();
		
		Customer Customer_present = dataCustomerDAO.getCustomer(Account_present.getMAKH());
		
    	model.addAttribute("Account_present",Account_present);
    	model.addAttribute("Customer_present",Customer_selling);
    	
    	model.addAttribute("Car_selling",Car_selling);
    	
		model.addAttribute("hopdong",hopdong);
		model.addAttribute("hopdongtable",hopdongtable);
		
		model.addAttribute("lstCarType",lstCarType);
		model.addAttribute("lstCarConmpany",lstCarConmpany);
		
        return "contractedit";
    }
	
	@RequestMapping(value = { "/contract-history" }, method = RequestMethod.GET)
    public String contracthistoryPage(Model model , HttpServletRequest request) {

        return "contracthistory";
    }
	
	@RequestMapping(value = { "/contract-register" }, method = RequestMethod.GET)
    public String contractregisterGETPage(Model model , HttpServletRequest request) throws ClassNotFoundException, SQLException {

		HttpSession session = request.getSession();
		Account Account_present = (Account) session.getAttribute("Account_present");

		
		if (Account_present == null) {
			
			
			LoginController loginController = new LoginController();
			return loginController.loginGETPage(model);
		}
		
		else {
			
			CustomerDAO dataCustomerDAO = new CustomerDAO();
			Customer Customer_present = dataCustomerDAO.getCustomer(Account_present.getMAKH());
			
			CarTypeDAO dataCarTypeDAO = new CarTypeDAO();
			List<CarType> lstCarType = dataCarTypeDAO.toList();
			
			CarConmpanyDAO dataCarConmpany = new CarConmpanyDAO();
			List<CarConmpany> lstCarConmpany = dataCarConmpany.toList();
			
			model.addAttribute("Account_present",Account_present);
			model.addAttribute("Customer_present",Customer_present);
			
			model.addAttribute("lstCarType",lstCarType);
			model.addAttribute("lstCarConmpany",lstCarConmpany);
			
			
			
	        return "contractregister";
		}
		
        
    }
	
	private String saveFile(MultipartFile multipartFile, Contract contract,HttpServletRequest request) throws Exception {
		String destination = "C:/Users/huyba/eclipse-workspace/WebBanXE/src/main/webapp/WEB-INF/images/car/hopdong"+ contract.getMAHD() + "/"  + multipartFile.getOriginalFilename();
		
	  
		File file_checkexist = new File(destination); 
	    
		if (file_checkexist.exists()) Files.deleteIfExists(file_checkexist.toPath());
		    
		File file = new File(destination); 
		if (!file.exists()) {
		    file.mkdirs();     
		}
		multipartFile.transferTo(file);
	    
	    return "images/car/hopdong" + contract.getMAHD() + "/"  + multipartFile.getOriginalFilename();
	}
	
	
	@RequestMapping(value = { "/contract-register" }, method = RequestMethod.POST)
    public String contractregisterPOSTPage(Model model , HttpServletRequest request,@RequestParam("image1") MultipartFile file) throws Exception {

		HttpSession session = request.getSession();
		Account Account_present = (Account) session.getAttribute("Account_present");

		
		if (Account_present == null) {
			
			
			LoginController loginController = new LoginController();
			return loginController.loginGETPage(model);
		}
		
		else {
			
			CustomerDAO dataCustomerDAO = new CustomerDAO();
			Customer Customer_present = dataCustomerDAO.getCustomer(Account_present.getMAKH());
			
			List<String> validation = new ArrayList<>();
			
			String TENXE = request.getParameter("TENXE");
			int MALOAIXE = Integer.parseInt(request.getParameter("MALOAIXE"));
			int MAHSX = Integer.parseInt(request.getParameter("MAHSX"));
			String NOIDUNGXE = request.getParameter("NOIDUNGXE");
			String NOIDUNGHD = request.getParameter("NOIDUNGHD");
			
			
			
			int BAOHANH = Integer.parseInt(request.getParameter("BAOHANH")) ;
			int NAMSANXUAT = Integer.parseInt(request.getParameter("NAMSANXUAT"));
			double GIAXE = Double.parseDouble(request.getParameter("GIAXE"));
			String DIADIEM = request.getParameter("DIADIEM");
			
			
			
			Car carregister = new Car();
			carregister.setBAOHANH(BAOHANH);
			carregister.setGIA(GIAXE);
			carregister.setMAHSX(MAHSX);
			carregister.setMALOAIXE(MALOAIXE);
			carregister.setNAMSANXUAT(NAMSANXUAT);
			carregister.setNOIDUNGXE(NOIDUNGXE);
			carregister.setTENXE(TENXE);
			carregister.setTRANGTHAI("Công khai");
			
			
			
			CarDAO dataCarDAO = new CarDAO();
			dataCarDAO.add(carregister);
			
			int MAXE = dataCarDAO.toList().get(dataCarDAO.toList().size()-1).getMAXE();
 			
			Contract contract = new Contract();
		
			contract.setDIADIEM(DIADIEM);
			contract.setGIA(GIAXE);
			contract.setMANGUOIBAN(Account_present.getMATK());
			contract.setMAXE(MAXE);
			
			contract.setNOIDUNGHD(NOIDUNGHD);
			contract.setTRANGTHAI("Công khai");
			
			ContractDAO dataContractDAO = new ContractDAO();
			dataContractDAO.add(contract);
			
			int MAHD = dataContractDAO.toList().get(dataContractDAO.toList().size()-1).getMAHD();
	       
	        contract.setMAHD(MAHD);
			
			String HINHANH = saveFile(file, contract,request);
			
			carregister.setHINHANH(HINHANH);
			carregister.setMAXE(MAXE);
			dataCarDAO.update(carregister);
					
			System.out.println(HINHANH); 
			
			
	
			CarTypeDAO dataCarTypeDAO = new CarTypeDAO();
			List<CarType> lstCarType = dataCarTypeDAO.toList();
			
			CarConmpanyDAO dataCarConmpany = new CarConmpanyDAO();
			List<CarConmpany> lstCarConmpany = dataCarConmpany.toList();
			
			model.addAttribute("Account_present",Account_present);
			model.addAttribute("Customer_present",Customer_present);
			
			model.addAttribute("lstCarType",lstCarType);
			model.addAttribute("lstCarConmpany",lstCarConmpany);

			
	        return "contractregister";
		}
		
        
    }
	
	@RequestMapping(value = { "/contract-list-searchbycarcompany" }, method = RequestMethod.GET)
    public String contractlistMAHSXPage(Model model , HttpServletRequest request, @RequestParam int MAHSX) throws ClassNotFoundException, SQLException {
		ContractCarDetailsViewDAO data_HD = new ContractCarDetailsViewDAO();
    	List<ContractCarDetailsView> lstHD = data_HD.toListByMAHSX(MAHSX);
    	
    	model.addAttribute("lstHD",lstHD);
        return "contractlist";
    }
	
	@RequestMapping(value = { "/contract-list-searchbycartype" }, method = RequestMethod.GET)
    public String contractlistMALOAIXEPage(Model model , HttpServletRequest request, @RequestParam int MALOAIXE) throws ClassNotFoundException, SQLException {
		ContractCarDetailsViewDAO data_HD = new ContractCarDetailsViewDAO();
    	List<ContractCarDetailsView> lstHD = data_HD.toListByMALOAIXE(MALOAIXE);
    	
    	model.addAttribute("lstHD",lstHD);
        return "contractlist";
    }
	
	@RequestMapping(value = { "/contract-list-admin" }, method = RequestMethod.GET)
    public String contractlistAdminPage(Model model , HttpServletRequest request) throws ClassNotFoundException, SQLException {
		
		HttpSession session = request.getSession();
		Account Account_present = (Account) session.getAttribute("Account_present");

		
		if (Account_present == null) {
			
			
			LoginController loginController = new LoginController();
			return loginController.loginGETPage(model);
		}
		
		ContractCarDetailsViewDAO data_HD = new ContractCarDetailsViewDAO();
    	List<ContractCarDetailsView> lstHD = data_HD.toList();
    	
    	model.addAttribute("Account_present",Account_present);
    	model.addAttribute("lstHD",lstHD);
        return "contractlistadmin";
    }
	
	@RequestMapping(value = { "/contract-cart" }, method = RequestMethod.GET)
    public String contractCartGET(Model model , HttpServletRequest request) throws ClassNotFoundException, SQLException {
		
		HttpSession session = request.getSession();
		Account Account_present = (Account) session.getAttribute("Account_present");

		
		if (Account_present == null) {
			
			
			LoginController loginController = new LoginController();
			return loginController.loginGETPage(model);
		}
		
		ContractCartDAO data_Cart = new ContractCartDAO();
    	List<ContractCart> lstCart = data_Cart.toListByMATK(Account_present);
    	
    	ContractCarDetailsViewDAO data_ContractCarDetails = new ContractCarDetailsViewDAO();
    	List<ContractCarDetailsView> lstHD_Temp = data_ContractCarDetails.toList();
    	List<ContractCarDetailsView> lstHD = new ArrayList<>();
    	
    	Double sum = 0.0;
    	
    	for (ContractCarDetailsView hopdong : lstHD_Temp) {
			for (ContractCart giohang : lstCart) {
				if (giohang.getMAHD() == hopdong.getMAHD() && Account_present.getMATK() == giohang.getMATK()) { lstHD.add(hopdong);
					sum += hopdong.getGIA(); 
				}
				
			}
		}
    	
    	model.addAttribute("Account_present",Account_present);
    	model.addAttribute("lstHD",lstHD);
    	model.addAttribute("sum",sum);
        return "contractcart";
    }
	
	@RequestMapping(value = { "/contract-cart" }, method = RequestMethod.POST)
    public String contractCartPOST(Model model , HttpServletRequest request) throws ClassNotFoundException, SQLException {
		
		HttpSession session = request.getSession();
		Account Account_present = (Account) session.getAttribute("Account_present");

		
		if (Account_present == null) {
			
			
			LoginController loginController = new LoginController();
			return loginController.loginGETPage(model);
		}
		
		ContractCartDAO data_Cart = new ContractCartDAO();
    	List<ContractCart> lstCart = data_Cart.toListByMATK(Account_present);
    	
    	ContractCarDetailsViewDAO data_ContractCarDetails = new ContractCarDetailsViewDAO();
    	List<ContractCarDetailsView> lstHD_Temp = data_ContractCarDetails.toList();
    	List<ContractCarDetailsView> lstHD = new ArrayList<>();
    	
    	Double sum = 0.0;
    	
    	for (ContractCarDetailsView hopdong : lstHD_Temp) {
			for (ContractCart giohang : lstCart) {
				if (giohang.getMAHD() == hopdong.getMAHD() && Account_present.getMATK() == giohang.getMATK()) { lstHD.add(hopdong);
					sum += hopdong.getGIA(); 
				}
				
			}
		}
    	
    	model.addAttribute("Account_present",Account_present);
    	model.addAttribute("lstHD",lstHD);
    	model.addAttribute("sum",sum);
        return "contractcart";
    }
}
