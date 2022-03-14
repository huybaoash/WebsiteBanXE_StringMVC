package com.webbanxe.controller;

import java.io.File;
import java.nio.file.Files;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.webbanxe.model.Account;
import com.webbanxe.model.AccountsDAO;
import com.webbanxe.model.CarConmpany;
import com.webbanxe.model.CarConmpanyDAO;
import com.webbanxe.model.CarType;
import com.webbanxe.model.CarTypeDAO;
import com.webbanxe.model.Contract;
import com.webbanxe.model.HelloWorld;
import com.webbanxe.model.ViewModel.ContractCarDetailsView;
import com.webbanxe.model.ViewModel.ContractCarDetailsViewDAO;
@Controller
public class CarTypeController {
	@RequestMapping(value = { "/cartype-register" }, method = RequestMethod.GET)
    public String cartyperegisterGETPage(Model model, HttpServletRequest request) throws ClassNotFoundException, SQLException {

		HttpSession session = request.getSession();
		Account Account_present = (Account) session.getAttribute("Account_present");

		
		if (Account_present == null) {
			
			
			LoginController loginController = new LoginController();
			return loginController.loginGETPage(model);
		}
		
        return "cartyperegister";
    }
	
	@RequestMapping(value = { "/cartype-register" }, method = RequestMethod.POST)
    public String cartyperegisterPOSTPage(Model model, HttpServletRequest request,@RequestParam("image1") MultipartFile file) throws Exception {

		HttpSession session = request.getSession();
		Account Account_present = (Account) session.getAttribute("Account_present");

		
		if (Account_present == null) {
			
			
			LoginController loginController = new LoginController();
			return loginController.loginGETPage(model);
		}
		
		CarTypeDAO dataCarTypeDAO = new CarTypeDAO();
    	
    	CarType carType = new CarType();
    	
    	
    	String TENLOAIXE = request.getParameter("TENLOAIXE");
    	String HINHANH = saveFile(file, request);
    	
    	carType.setHINHANH(HINHANH);
    	carType.setTENLOAIXE(TENLOAIXE);
    	carType.setTRANGTHAI("Công khai");
    	
    	dataCarTypeDAO.add(carType);
		List<CarType> lstLoaiXE = dataCarTypeDAO.toList();
		model.addAttribute("lstLoaiXE",lstLoaiXE);
    	
    	model.addAttribute("Account_present",Account_present);
    	
        return "cartypelistadmin";
		
        
    }
	
	private String saveFile(MultipartFile multipartFile,HttpServletRequest request) throws Exception {
		String destination = "C:/Users/huyba/eclipse-workspace/WebBanXE/src/main/webapp/WEB-INF/images/cartype/"+ multipartFile.getOriginalFilename();
		
	  
		File file_checkexist = new File(destination); 
		    
		if (file_checkexist.exists()) Files.deleteIfExists(file_checkexist.toPath());
		    
		File file = new File(destination); 
		if (!file.exists()) {
		    file.mkdirs();     
		}
		multipartFile.transferTo(file);
		 
	    
	    return "images/cartype/" + multipartFile.getOriginalFilename();
	}
	
	@RequestMapping(value = { "/cartype-hide" }, method = RequestMethod.GET)
    public String cartypeHideGETtPage(Model model, HttpServletRequest request,@RequestParam int MALOAIXE) throws ClassNotFoundException, SQLException {
		
		HttpSession session = request.getSession();
		Account Account_present = (Account) session.getAttribute("Account_present");

		
		if (Account_present == null) {
			
			
			LoginController loginController = new LoginController();
			return loginController.loginGETPage(model);
		}
		
		CarTypeDAO data_LoaiXE = new CarTypeDAO();
    	
    	CarType loaixe = data_LoaiXE.getCarType(MALOAIXE);
    	loaixe.setTRANGTHAI("Ẩn");
    	data_LoaiXE.update(loaixe);
    	List<CarType> lstLoaiXE = data_LoaiXE.toList();
		model.addAttribute("lstLoaiXE",lstLoaiXE);
    	
    	model.addAttribute("Account_present",Account_present);
    	return "cartypelistadmin";
    }
	
	@RequestMapping(value = { "/cartype-show" }, method = RequestMethod.GET)
    public String cartypeShowGETtPage(Model model, HttpServletRequest request,@RequestParam int MALOAIXE) throws ClassNotFoundException, SQLException {
		
		HttpSession session = request.getSession();
		Account Account_present = (Account) session.getAttribute("Account_present");

		
		if (Account_present == null) {
			
			
			LoginController loginController = new LoginController();
			return loginController.loginGETPage(model);
		}
		
		CarTypeDAO data_LoaiXE = new CarTypeDAO();
    	
    	CarType loaixe = data_LoaiXE.getCarType(MALOAIXE);
    	loaixe.setTRANGTHAI("Công khai");
    	data_LoaiXE.update(loaixe);
    	List<CarType> lstLoaiXE = data_LoaiXE.toList();
		model.addAttribute("lstLoaiXE",lstLoaiXE);
    	
    	model.addAttribute("Account_present",Account_present);
    	return "cartypelistadmin";
    }
	
	@RequestMapping(value = { "/cartype-edit" }, method = RequestMethod.GET)
    public String cartypeediGETtPage(Model model, HttpServletRequest request,@RequestParam int MALOAIXE) throws ClassNotFoundException, SQLException {
		
		HttpSession session = request.getSession();
		Account Account_present = (Account) session.getAttribute("Account_present");

		
		if (Account_present == null) {
			
			
			LoginController loginController = new LoginController();
			return loginController.loginGETPage(model);
		}
		
		CarTypeDAO data_LoaiXE = new CarTypeDAO();
    	
    	CarType loaixe = data_LoaiXE.getCarType(MALOAIXE);
    	model.addAttribute("loaixe",loaixe);
    	model.addAttribute("MALOAIXE",MALOAIXE);
    	model.addAttribute("Account_present",Account_present);
		
        return "cartypeedit";
    }
	@RequestMapping(value = { "/cartype-edit" }, method = RequestMethod.POST)
    public String cartypeeditPOSTPage(Model model, HttpServletRequest request,@RequestParam("image1") MultipartFile file) throws Exception {
		
		HttpSession session = request.getSession();
		Account Account_present = (Account) session.getAttribute("Account_present");

		
		if (Account_present == null) {
			
			
			LoginController loginController = new LoginController();
			return loginController.loginGETPage(model);
		}
		
		CarTypeDAO data_LoaiXE = new CarTypeDAO();
    	String mALOAIXE_String = request.getParameter("MALOAIXE");
    	int MALOAIXE = Integer.valueOf(mALOAIXE_String);
    	CarType loaixe = data_LoaiXE.getCarType(MALOAIXE);
    	
    	if (!file.getOriginalFilename().isEmpty()) {
    		String HINHANH = saveFile(file, request);
    		loaixe.setHINHANH(HINHANH);
    	}
    	
    	String TENLOAIXE = request.getParameter("TENLOAIXE");
    	
    	
    	
    	loaixe.setTENLOAIXE(TENLOAIXE);
    	
    	data_LoaiXE.update(loaixe);
    	
    	List<CarType> lstLoaiXE = data_LoaiXE.toList();
		model.addAttribute("lstLoaiXE",lstLoaiXE);
    	
    	model.addAttribute("Account_present",Account_present);
    	return "cartypelistadmin";
    }
	
	@RequestMapping(value = { "/cartype-list" }, method = RequestMethod.GET)
    public String cartypelistPage(Model model) throws ClassNotFoundException, SQLException {
		CarTypeDAO data_LoaiXE = new CarTypeDAO();
    	List<CarType> lstLoaiXE = data_LoaiXE.toList();
    	model.addAttribute("lstLoaiXE",lstLoaiXE);
    	
        return "cartypelist";
    }
	
	@RequestMapping(value = { "/cartype-list-admin" }, method = RequestMethod.GET)
    public String cartypelist(Model model , HttpServletRequest request) throws ClassNotFoundException, SQLException {
		
		HttpSession session = request.getSession();
		Account Account_present = (Account) session.getAttribute("Account_present");

		
		if (Account_present == null) {
			
			
			LoginController loginController = new LoginController();
			return loginController.loginGETPage(model);
		}
		
		CarTypeDAO data_LoaiXE = new CarTypeDAO();
    	List<CarType> lstLoaiXE = data_LoaiXE.toList();
    	model.addAttribute("lstLoaiXE",lstLoaiXE);
    	
    	model.addAttribute("Account_present",Account_present);
    	
        return "cartypelistadmin";
    }
	
	@RequestMapping(value = { "/cartype-details" }, method = RequestMethod.GET)
    public String cartypedetails(Model model , HttpServletRequest request,@RequestParam int MALOAIXE) throws ClassNotFoundException, SQLException {
		
		HttpSession session = request.getSession();
		Account Account_present = (Account) session.getAttribute("Account_present");

		
		if (Account_present == null) {
			
			
			LoginController loginController = new LoginController();
			return loginController.loginGETPage(model);
		}
		
		CarTypeDAO data_LoaiXE = new CarTypeDAO();
    	
    	CarType loaixe = data_LoaiXE.getCarType(MALOAIXE);
    	model.addAttribute("loaixe",loaixe);
    	
    	model.addAttribute("Account_present",Account_present);
    	
        return "cartypedetails";
    }

}
