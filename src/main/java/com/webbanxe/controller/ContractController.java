package com.webbanxe.controller;

import java.io.BufferedOutputStream;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.security.interfaces.XECKey;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.tiles.request.Request;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.support.ByteArrayMultipartFileEditor;

import com.google.protobuf.Internal.ListAdapter.Converter;
import com.webbanxe.model.Account;
import com.webbanxe.model.AccountsDAO;
import com.webbanxe.model.Car;
import com.webbanxe.model.CarConmpany;
import com.webbanxe.model.CarConmpanyDAO;
import com.webbanxe.model.CarDAO;
import com.webbanxe.model.CarType;
import com.webbanxe.model.CarTypeDAO;
import com.webbanxe.model.Contract;
import com.webbanxe.model.ContractDAO;
import com.webbanxe.model.Customer;
import com.webbanxe.model.CustomerDAO;
import com.webbanxe.model.HelloWorld;
import com.webbanxe.model.MyUploadForm;
import com.webbanxe.model.ViewModel.ContractCarDetailsView;
import com.webbanxe.model.ViewModel.ContractCarDetailsViewDAO;

import net.balusc.http.multipart.MultipartMap;


@Controller
public class ContractController extends HttpServlet {
	
	// Phương thức này được gọi mỗi lần có Submit.
	   @InitBinder
	   public void initBinder(WebDataBinder dataBinder) {
	       Object target = dataBinder.getTarget();
	       if (target == null) {
	           return;
	       }
	       System.out.println("Target=" + target);

	       if (target.getClass() == MyUploadForm.class) {
	 
	           // Đăng ký để chuyển đổi giữa các đối tượng multipart thành byte[]
	           dataBinder.registerCustomEditor(byte[].class, new ByteArrayMultipartFileEditor());
	       }
	   }
	
	@RequestMapping(value = { "/car-edit" }, method = RequestMethod.GET)
    public String careditPage(Model model,HttpServletRequest request) {

        return "caredit";
    }
	
	@RequestMapping(value = { "/contract-details" }, method = RequestMethod.GET)
    public String contractdetailsPage(Model model,HttpServletRequest request) {

        return "contractdetails";
    }
	
	@RequestMapping(value = { "/contract-edit" }, method = RequestMethod.GET)
    public String contracteditPage(Model model,HttpServletRequest request) {

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
}
