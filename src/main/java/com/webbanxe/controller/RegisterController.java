package com.webbanxe.controller;

import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.webbanxe.model.Account;
import com.webbanxe.model.AccountsDAO;
import com.webbanxe.model.Customer;
import com.webbanxe.model.CustomerDAO;
import com.webbanxe.model.HelloWorld;
@Controller
public class RegisterController {
		
	@RequestMapping(value = { "/register" }, method = RequestMethod.GET)
    public String registerGETPage(Model model,HttpServletRequest request) throws ClassNotFoundException, SQLException {
		HttpSession session = request.getSession();
		Account Account_present = (Account) session.getAttribute("Account_present");
		if (Account_present != null) {
			MyController myController = new MyController();
			return myController.homePage(model);
		}
		
		Account account = new Account();
		Customer customer = new Customer();
		
		model.addAttribute("customer",customer);
		model.addAttribute("account",account);
		
        return "register";
    }
	
	@RequestMapping(value = { "/register" }, method = RequestMethod.POST)
    public String registerPOSTPage(Model model,HttpServletRequest request) throws ClassNotFoundException, SQLException {
		HttpSession session = request.getSession();
		Account Account_present = (Account) session.getAttribute("Account_present");
		
		
		if (Account_present != null) {
			MyController myController = new MyController();
			return myController.homePage(model);
		}
		
		List<String> validation = new ArrayList<>();
		
		String UserName = request.getParameter("UserName");
		String FullName = request.getParameter("FullName");
		String Gender = request.getParameter("Gender");
		String HomeAdress = request.getParameter("HomeAdress");
		String CMND = request.getParameter("CMND");
		String PhoneNumber = request.getParameter("PhoneNumber");
		String Email = request.getParameter("Email");
		String Password = request.getParameter("Password");
		String ConfirmPassword = request.getParameter("ConfirmPassword");
		
		if (UserName.isEmpty() || UserName == null) validation.add("T??n t??i kho???n kh??ng ???????c ????? tr???ng !") ;
		if (FullName.isEmpty() || FullName == null) validation.add("H??? t??n kh??ng ???????c ????? tr???ng !") ;
		if (Gender == null) validation.add("Gi???i t??nh ph???i ???????c ch???n !") ;
		if (HomeAdress.isEmpty() || HomeAdress == null) validation.add("?????a ch??? kh??ng ???????c ????? tr???ng !") ;
		if (CMND.isEmpty() || CMND == null) validation.add("Ch???ng minh nh??n d??n kh??ng ???????c ????? tr???ng !") ;
		if (PhoneNumber.isEmpty() || PhoneNumber == null) validation.add("S??? ??i???n Tho???i kh??ng ???????c ????? tr???ng !") ;
		if (Email.isEmpty() || Email == null) validation.add("Email kh??ng ???????c ????? tr???ng !") ;
		if (Password.isEmpty() || Password == null) validation.add("M???t kh???u kh??ng ???????c ????? tr???ng !") ;
		if (ConfirmPassword.isEmpty() || ConfirmPassword == null) validation.add("M???t kh???u x??c nh???n kh??ng ???????c ????? tr???ng !") ;
		
		AccountsDAO data_AccountsDAO = new AccountsDAO();
		List<Account> lstAccounts = data_AccountsDAO.toList();
		
		for (Account account : lstAccounts) {
			if (UserName.equals(account.getTENTK()))
				validation.add("T??n t??i kho???n ???? c?? ng?????i d??ng !") ;
		}
		
		CustomerDAO data_CustomerDAO = new CustomerDAO();
		List<Customer> lstCustomer = data_CustomerDAO.toList();
		
		for (Customer customer : lstCustomer) {
			if (CMND.equals(customer.getCMND()))
				validation.add("Ch???ng minh nh??n d??n ???? c?? ng?????i d??ng !") ;
			if (PhoneNumber.equals(customer.getSDT()))
				validation.add("S??? ??i???n Tho???i ???? c?? ng?????i d??ng !") ;
			if (Email.equals(customer.getEMAIL()))
				validation.add("Email ???? c?? ng?????i d??ng !") ;
		}

		if (Password.equals(ConfirmPassword) == false) validation.add("M???t kh???u x??c nh???n kh??ng tr??ng kh???p") ;
		

		Account account = new Account();
		Customer customer = new Customer();
		
		customer.setCMND(CMND);
		customer.setDIACHI(HomeAdress);
		customer.setEMAIL(Email);
		customer.setGIOITINH(Gender);
		customer.setSDT(PhoneNumber);
		customer.setTENKH(FullName);
		
		
		account.setTENTK(UserName);
		account.setMATKHAU(Password);
		
		
		if (validation.size() > 0) {
			model.addAttribute("message_validation",validation);
			model.addAttribute("customer",customer);
			model.addAttribute("account",account);
			return "register";
		}
		
	
		
		data_CustomerDAO.add(customer);
		CustomerDAO newdata_CustomerDAO = new CustomerDAO();
		Customer newCustomer = newdata_CustomerDAO.getCustomerByCMND(CMND);
		
		account.setMAKH(newCustomer.getMAKH());
		data_AccountsDAO.add(account);
		
		model.addAttribute("Account_present",account);
		
		CustomerDAO dataCustomerDAO = new CustomerDAO();
		List<Customer> lstCustomers = dataCustomerDAO.toList();
		
		for (Customer customer_present : lstCustomers) {
			if (account.getMAKH() == customer_present.getMAKH() ) {
				
				
				model.addAttribute("Customer_present",customer_present);
				MyController myController = new MyController();
				return myController.homePage(model);
			}
		}
		
		
		MyController myController = new MyController();
		return myController.homePage(model);
    }
}
