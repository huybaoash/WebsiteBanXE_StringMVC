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
		
		if (UserName.isEmpty() || UserName == null) validation.add("Tên tài khoản không được để trống !") ;
		if (FullName.isEmpty() || FullName == null) validation.add("Họ tên không được để trống !") ;
		if (Gender.isEmpty() || Gender == null) validation.add("Giới tính phải được chọn !") ;
		if (HomeAdress.isEmpty() || HomeAdress == null) validation.add("Địa chỉ không được để trống !") ;
		if (CMND.isEmpty() || CMND == null) validation.add("Chứng minh nhân dân không được để trống !") ;
		if (PhoneNumber.isEmpty() || PhoneNumber == null) validation.add("Số Điện Thoại không được để trống !") ;
		if (Email.isEmpty() || Email == null) validation.add("Email không được để trống !") ;
		if (Password.isEmpty() || Password == null) validation.add("Mật khẩu không được để trống !") ;
		if (ConfirmPassword.isEmpty() || ConfirmPassword == null) validation.add("Mật khẩu xác nhận không được để trống !") ;
		
		AccountsDAO data_AccountsDAO = new AccountsDAO();
		List<Account> lstAccounts = data_AccountsDAO.toList();
		
		for (Account account : lstAccounts) {
			if (UserName.equals(account.getTENTK()))
				validation.add("Tên tài khoản đã có người dùng !") ;
		}
		
		CustomerDAO data_CustomerDAO = new CustomerDAO();
		List<Customer> lstCustomer = data_CustomerDAO.toList();
		
		for (Customer customer : lstCustomer) {
			if (CMND.equals(customer.getCMND()))
				validation.add("Chứng minh nhân dân đã có người dùng !") ;
			if (PhoneNumber.equals(customer.getSDT()))
				validation.add("Số Điện Thoại đã có người dùng !") ;
			if (Email.equals(customer.getEMAIL()))
				validation.add("Email đã có người dùng !") ;
		}

		if (Password.equals(ConfirmPassword) == false) validation.add("Mật khẩu xác nhận không trùng khớp") ;
		
		if (validation.size() > 0) {
			model.addAttribute("message_validation",validation);
			return "register";
		}
		
		Account account = new Account();
		Customer customer = new Customer();
		
		customer.setCMND(CMND);
		customer.setDIACHI(HomeAdress);
		customer.setEMAIL(Email);
		customer.setGIOITINH(Gender);
		customer.setSDT(PhoneNumber);
		customer.setTENKH(FullName);
		
		data_CustomerDAO.add(customer);
		CustomerDAO newdata_CustomerDAO = new CustomerDAO();
		Customer newCustomer = newdata_CustomerDAO.getCustomerByCMND(CMND);
		
		account.setMAKH(newCustomer.getMAKH());
		account.setTENTK(UserName);
		account.setMATKHAU(Password);
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
