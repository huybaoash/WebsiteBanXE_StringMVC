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
@Controller
public class CarConmpanyController {
	@RequestMapping(value = { "/carconmpany-list" }, method = RequestMethod.GET)
    public String carconmanylistPage(Model model) throws ClassNotFoundException, SQLException {
		CarConmpanyDAO data_HangXE = new CarConmpanyDAO();
    	List<CarConmpany> lstHangXE = data_HangXE.toList();
    	model.addAttribute("lstHangXE",lstHangXE);
    	
        return "carconmpanylist";
    }
	
	@RequestMapping(value = { "/carconmpany-list-admin" }, method = RequestMethod.GET)
    public String carconmanylistAdmin(Model model , HttpServletRequest request) throws ClassNotFoundException, SQLException {
		
		HttpSession session = request.getSession();
		Account Account_present = (Account) session.getAttribute("Account_present");

		
		if (Account_present == null) {
			
			
			LoginController loginController = new LoginController();
			return loginController.loginGETPage(model);
		}
		
		CarConmpanyDAO data_HangXE = new CarConmpanyDAO();
    	List<CarConmpany> lstHangXE = data_HangXE.toList();
    	model.addAttribute("lstHangXE",lstHangXE);
    	
    	model.addAttribute("Account_present",Account_present);
    	
        return "carconmpanylistadmin";
    }
	
	@RequestMapping(value = { "/carconmany-hide" }, method = RequestMethod.GET)
    public String carconmanyeHideGETPage(Model model, HttpServletRequest request,@RequestParam int MAHSX) throws ClassNotFoundException, SQLException {
		HttpSession session = request.getSession();
		Account Account_present = (Account) session.getAttribute("Account_present");

		
		if (Account_present == null) {
			
			
			LoginController loginController = new LoginController();
			return loginController.loginGETPage(model);
		}
		
		CarConmpanyDAO data_HangXE = new CarConmpanyDAO();
    	
    	CarConmpany hsx = data_HangXE.getCarConmpany(MAHSX);
    	hsx.setTRANGTHAI("Ẩn");
    	data_HangXE.update(hsx);
    	List<CarConmpany> lstHangXE = data_HangXE.toList();
		model.addAttribute("lstHangXE",lstHangXE);
    	
    	model.addAttribute("Account_present",Account_present);
    	return "carconmpanylistadmin";
    }
	
	@RequestMapping(value = { "/carconmany-show" }, method = RequestMethod.GET)
    public String carconmanyeShowGETPage(Model model, HttpServletRequest request,@RequestParam int MAHSX) throws ClassNotFoundException, SQLException {
		HttpSession session = request.getSession();
		Account Account_present = (Account) session.getAttribute("Account_present");

		
		if (Account_present == null) {
			
			
			LoginController loginController = new LoginController();
			return loginController.loginGETPage(model);
		}
		
		CarConmpanyDAO data_HangXE = new CarConmpanyDAO();
    	
    	CarConmpany hsx = data_HangXE.getCarConmpany(MAHSX);
    	hsx.setTRANGTHAI("Công khai");
    	data_HangXE.update(hsx);
    	List<CarConmpany> lstHangXE = data_HangXE.toList();
		model.addAttribute("lstHangXE",lstHangXE);
    	
    	model.addAttribute("Account_present",Account_present);
    	return "carconmpanylistadmin";
    }
	
	@RequestMapping(value = { "/carconmany-edit" }, method = RequestMethod.GET)
    public String carconmanyeditGETPage(Model model, HttpServletRequest request,@RequestParam int MAHSX) throws ClassNotFoundException, SQLException {
		HttpSession session = request.getSession();
		Account Account_present = (Account) session.getAttribute("Account_present");

		
		if (Account_present == null) {
			
			
			LoginController loginController = new LoginController();
			return loginController.loginGETPage(model);
		}
		
		CarConmpanyDAO data_HangXE = new CarConmpanyDAO();
    	
    	CarConmpany hsx = data_HangXE.getCarConmpany(MAHSX);
    	model.addAttribute("hsx",hsx);
    	model.addAttribute("MAHSX",MAHSX);
    	
    	model.addAttribute("Account_present",Account_present);
    	
        return "carconmpanyedit";
    }
	
	@RequestMapping(value = { "/carconmany-edit" }, method = RequestMethod.POST)
    public String carconmanyPOSTPage(Model model, HttpServletRequest request,@RequestParam("image1") MultipartFile file) throws Exception {
		System.out.println( file.getOriginalFilename()+ "hahahhahahahahhaha");
		HttpSession session = request.getSession();
		Account Account_present = (Account) session.getAttribute("Account_present");

		
		if (Account_present == null) {
			
			
			LoginController loginController = new LoginController();
			return loginController.loginGETPage(model);
		}
		
		CarConmpanyDAO data_CarConmpanyDAO = new CarConmpanyDAO();
		String MAHSX_String = request.getParameter("MAHSX");
    	int MAHSX = Integer.valueOf(MAHSX_String);
		CarConmpany hsx = data_CarConmpanyDAO.getCarConmpany(MAHSX);
		
    	if (!file.getOriginalFilename().isEmpty()) {
    		String HINHANH = saveFile(file, request);
    		hsx.setHINHANH(HINHANH);
    	}
    	
    	String TENHSX = request.getParameter("TENHSX");
    	
    	
    	
    	hsx.setTENHSX(TENHSX);
    	
    	data_CarConmpanyDAO.update(hsx);
    	
    	List<CarConmpany> lstHangXE = data_CarConmpanyDAO.toList();
		model.addAttribute("lstHangXE",lstHangXE);
    	
    	model.addAttribute("Account_present",Account_present);
    	return "carconmpanylistadmin";
    }
	
	@RequestMapping(value = { "/carconmany-register" }, method = RequestMethod.GET)
    public String carconmanyregisterGETPage(Model model, HttpServletRequest request) throws ClassNotFoundException, SQLException {
		HttpSession session = request.getSession();
		Account Account_present = (Account) session.getAttribute("Account_present");

		
		if (Account_present == null) {
			
			
			LoginController loginController = new LoginController();
			return loginController.loginGETPage(model);
		}
		
        return "carconmpanyregister";
    }
	
	@RequestMapping(value = { "/carconmany-register" }, method = RequestMethod.POST)
    public String carconmanyregisterPOSTPage(Model model, HttpServletRequest request,@RequestParam("image1") MultipartFile file) throws Exception {
		HttpSession session = request.getSession();
		Account Account_present = (Account) session.getAttribute("Account_present");

		
		if (Account_present == null) {
			
			
			LoginController loginController = new LoginController();
			return loginController.loginGETPage(model);
		}
		
		CarConmpanyDAO data_HangXE = new CarConmpanyDAO();
    	
    	CarConmpany hsx = new CarConmpany();
    	
    	
    	String TENHSX = request.getParameter("TENHSX");
    	String HINHANH = saveFile(file, request);
    	
    	hsx.setHINHANH(HINHANH);
    	hsx.setTENHSX(TENHSX);
    	hsx.setTRANGTHAI("Công khai");
    	
    	data_HangXE.add(hsx);
		List<CarConmpany> lstHangXE = data_HangXE.toList();
		model.addAttribute("lstHangXE",lstHangXE);
    	
    	model.addAttribute("Account_present",Account_present);
        return "carconmpanylistadmin";
    }
	
	private String saveFile(MultipartFile multipartFile,HttpServletRequest request) throws Exception {
		String destination = "C:/Users/huyba/eclipse-workspace/WebBanXE/src/main/webapp/WEB-INF/images/carconmpany/"+ multipartFile.getOriginalFilename();
		
	  
	    File file_checkexist = new File(destination); 
	    
	    if (file_checkexist.exists()) Files.deleteIfExists(file_checkexist.toPath());
	    
	    File file = new File(destination); 
	    if (!file.exists()) {
	    	file.mkdirs();     
	}
	    multipartFile.transferTo(file);
	    
	    return "images/carconmpany/" + multipartFile.getOriginalFilename();
	}
	
	@RequestMapping(value = { "/carconmany-details" }, method = RequestMethod.GET)
    public String carconmpanydetails(Model model , HttpServletRequest request,@RequestParam int MAHSX) throws ClassNotFoundException, SQLException {
		
		HttpSession session = request.getSession();
		Account Account_present = (Account) session.getAttribute("Account_present");

		
		if (Account_present == null) {
			
			
			LoginController loginController = new LoginController();
			return loginController.loginGETPage(model);
		}
		
		CarConmpanyDAO data_HangXE = new CarConmpanyDAO();
    	
    	CarConmpany hsx = data_HangXE.getCarConmpany(MAHSX);
    	model.addAttribute("hsx",hsx);
    	
    	model.addAttribute("Account_present",Account_present);
    	
        return "carconmpanydetails";
    }

}
