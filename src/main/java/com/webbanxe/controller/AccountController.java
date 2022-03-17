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
import org.springframework.web.bind.annotation.RequestParam;

import com.webbanxe.model.Account;
import com.webbanxe.model.AccountsDAO;
import com.webbanxe.model.CarConmpany;
import com.webbanxe.model.CarConmpanyDAO;
import com.webbanxe.model.Customer;
import com.webbanxe.model.CustomerDAO;
import com.webbanxe.model.HelloWorld;
@Controller
public class AccountController {

	@RequestMapping(value = { "/userinfo" }, method = RequestMethod.GET)
    public String userinfoPage(Model model,HttpServletRequest request) throws ClassNotFoundException, SQLException {
		
		HttpSession session = request.getSession();
		Account Account_present = (Account) session.getAttribute("Account_present");
	
		
		
		if (Account_present == null) {
			MyController myController = new MyController();
			return myController.homePage(model);
		}
		
		CustomerDAO dataCustomerDAO = new CustomerDAO();
		Customer Customer_present = dataCustomerDAO.getCustomer(Account_present.getMAKH());
		
		model.addAttribute("Account_present",Account_present);
		model.addAttribute("Customer_present",Customer_present);
		
		return "userinfo";
		
    }
	
	@RequestMapping(value = { "/otheruserinfo" }, method = RequestMethod.GET)
    public String otheruserinfoPage(Model model,HttpServletRequest request, @RequestParam int MATK) throws ClassNotFoundException, SQLException {
		
		HttpSession session = request.getSession();
		Account Account_present = (Account) session.getAttribute("Account_present");
		AccountsDAO datAccountsDAO = new AccountsDAO();
		Account account = datAccountsDAO.getAccount(MATK);
		
		CustomerDAO dataCustomerDAO = new CustomerDAO();

		
		Customer Customer_present = dataCustomerDAO.getCustomer(Account_present.getMAKH());
		Customer customer = dataCustomerDAO.getCustomer(account.getMAKH());
		if (Account_present == null) {
			MyController myController = new MyController();
			return myController.homePage(model);
		}
		
		model.addAttribute("Account_present",Account_present);
		model.addAttribute("Customer_present",Customer_present);
		model.addAttribute("account",account);
		model.addAttribute("customer",customer);
		
		return "otheruserinfo";
		
    }
	
	@RequestMapping(value = { "/account-lock" }, method = RequestMethod.GET)
    public String accountlockPage(Model model,HttpServletRequest request,@RequestParam int MATK) throws ClassNotFoundException, SQLException {

		HttpSession session = request.getSession();
		Account Account_present = (Account) session.getAttribute("Account_present");

		
		if (Account_present == null) {
			
			
			LoginController loginController = new LoginController();
			return loginController.loginGETPage(model);
		}
		
		AccountsDAO data_accAccountsDAO = new AccountsDAO();
		Account account = data_accAccountsDAO.getAccount(MATK);
		
		account.setTRANGTHAI("Đã khóa");
		data_accAccountsDAO.update(account);
		
		
    	List<Account> lstAccounts = data_accAccountsDAO.toList();
    	model.addAttribute("lstAccounts",lstAccounts);
    	
    	model.addAttribute("Account_present",Account_present);
    	
        
		
        return "accountlist";
    }
	
	@RequestMapping(value = { "/account-unlock" }, method = RequestMethod.GET)
    public String accountunlockPage(Model model,HttpServletRequest request,@RequestParam int MATK) throws ClassNotFoundException, SQLException {

		HttpSession session = request.getSession();
		Account Account_present = (Account) session.getAttribute("Account_present");

		
		if (Account_present == null) {
			
			
			LoginController loginController = new LoginController();
			return loginController.loginGETPage(model);
		}
		
		AccountsDAO data_accAccountsDAO = new AccountsDAO();
		Account account = data_accAccountsDAO.getAccount(MATK);
		
		account.setTRANGTHAI("Đang hoạt động");
		data_accAccountsDAO.update(account);
		
		
    	List<Account> lstAccounts = data_accAccountsDAO.toList();
    	model.addAttribute("lstAccounts",lstAccounts);
    	
    	model.addAttribute("Account_present",Account_present);
    	
        
		
        return "accountlist";
    }
	
	@RequestMapping(value = { "/account-list" }, method = RequestMethod.GET)
    public String accountlistPage(Model model,HttpServletRequest request) throws ClassNotFoundException, SQLException {

		HttpSession session = request.getSession();
		Account Account_present = (Account) session.getAttribute("Account_present");

		
		if (Account_present == null) {
			
			
			LoginController loginController = new LoginController();
			return loginController.loginGETPage(model);
		}
		
		AccountsDAO data_accAccountsDAO = new AccountsDAO();
    	List<Account> lstAccounts = data_accAccountsDAO.toList();
    	model.addAttribute("lstAccounts",lstAccounts);
    	
    	model.addAttribute("Account_present",Account_present);
    	
        
		
        return "accountlist";
    }
	
	@RequestMapping(value = { "/userinfo-edit" }, method = RequestMethod.GET)
    public String userinfoeditGETPage(Model model,HttpServletRequest request) throws ClassNotFoundException, SQLException {
		HttpSession session = request.getSession();
		Account Account_present = (Account) session.getAttribute("Account_present");
		
		if (Account_present == null) {
			MyController myController = new MyController();
			return myController.homePage(model);
		}
		
		CustomerDAO dataCustomerDAO = new CustomerDAO();

		
		Customer Customer_present = dataCustomerDAO.getCustomer(Account_present.getMAKH());
		
		
		
		model.addAttribute("Account_present",Account_present);
		model.addAttribute("Customer_present",Customer_present);
		
        return "userinfoedit";
    }
	
	@RequestMapping(value = { "/userinfo-edit" }, method = RequestMethod.POST)
    public String userinfoeditPOSTPage(Model model,HttpServletRequest request) throws ClassNotFoundException, SQLException {
		HttpSession session = request.getSession();
		Account Account_present = (Account) session.getAttribute("Account_present");
		Customer Customer_present = (Customer) session.getAttribute("Customer_present");
		
		
		if (Account_present == null) {
			MyController myController = new MyController();
			return myController.homePage(model);
		}
		
		List<String> validation = new ArrayList<>();
		
		String FullName = request.getParameter("FullName");
		String Gender = request.getParameter("Gender");
		String HomeAdress = request.getParameter("HomeAdress");
		String CMND = request.getParameter("CMND");
		String PhoneNumber = request.getParameter("PhoneNumber");
		String Email = request.getParameter("Email");
		
		if (FullName.isEmpty() || FullName == null) validation.add("Họ tên không được để trống !") ;
		if (Gender.isEmpty() || Gender == null) validation.add("Giới tính phải được chọn !") ;
		if (HomeAdress.isEmpty() || HomeAdress == null) validation.add("Địa chỉ không được để trống !") ;
		if (CMND.isEmpty() || CMND == null) validation.add("Chứng minh nhân dân không được để trống !") ;
		if (PhoneNumber.isEmpty() || PhoneNumber == null) validation.add("Số Điện Thoại không được để trống !") ;
		if (Email.isEmpty() || Email == null) validation.add("Email không được để trống !") ;

		CustomerDAO data_CustomerDAO = new CustomerDAO();
		List<Customer> lstCustomer = data_CustomerDAO.toList();
		
		for (Customer customer : lstCustomer) {
			if (CMND.equals(customer.getCMND()) && CMND.equals(Customer_present.getCMND()) == false)
				validation.add("Chứng minh nhân dân đã có người dùng !") ;
			if (PhoneNumber.equals(customer.getSDT()) && PhoneNumber.equals(Customer_present.getSDT()) == false)
				validation.add("Số Điện Thoại đã có người dùng !") ;
			if (Email.equals(customer.getEMAIL()) && Email.equals(Customer_present.getEMAIL()) == false)
				validation.add("Email đã có người dùng !") ;
		}
		
		
		Customer customer = new Customer();
		customer.setMAKH(Account_present.getMAKH());
		customer.setCMND(CMND);
		customer.setDIACHI(HomeAdress);
		customer.setEMAIL(Email);
		customer.setGIOITINH(Gender);
		customer.setSDT(PhoneNumber);
		customer.setTENKH(FullName);
		
		
	
		
		if (validation.size() > 0) {
			model.addAttribute("message_validation",validation);
			
			return "userinfoedit";
		}
		
		data_CustomerDAO.update(customer);
		
	
		model.addAttribute("Account_present",Account_present);
		model.addAttribute("Customer_present",customer);
		
        return "userinfo";
    }
}
