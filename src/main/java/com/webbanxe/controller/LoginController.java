package com.webbanxe.controller;

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

import com.webbanxe.model.Account;
import com.webbanxe.model.AccountsDAO;
import com.webbanxe.model.HelloWorld;
import com.webbanxe.model.Login;
@Controller
public class LoginController {
	
	public static Account Account_present = null; 
	
	@RequestMapping(value = { "/login" }, method = RequestMethod.GET)
    public String customerlistPage(Model model) throws ClassNotFoundException, SQLException {
		if (Account_present != null) {
			MyController myController = new MyController();
			return myController.homePage(model);
		}
        return "login";
    }
	
	@RequestMapping(value = { "/login" }, method = RequestMethod.POST)
    public String customerlistPage(Model model,HttpServletRequest request) throws ClassNotFoundException, SQLException {
		if (Account_present != null) {
			MyController myController = new MyController();
			return myController.homePage(model);
		}
		
		String UserName = request.getParameter("UserName");
		String Password = request.getParameter("Password");
		
		
		AccountsDAO data_listAccountsDAO = new AccountsDAO();
		List<Account> lstAccount = data_listAccountsDAO.toList();
		for (Account account : lstAccount) {
			if (account.getTENTK().equals(UserName)&& account.getMATKHAU().equals(Password)) {
				Account_present = account;
	
				model.addAttribute("Account_present",Account_present);
				MyController myController = new MyController();
				return myController.homePage(model);
			}
		}
		
		model.addAttribute("message_account","Sai tên đăng nhập hoặc tài khoản !");
        return "login";
    }
	
	@RequestMapping(value = { "/sign-out" }, method = RequestMethod.GET)
    public String signoutGETPage(Model model ,HttpServletRequest request) throws ClassNotFoundException, SQLException {
		Account_present = null;
		HttpSession session = request.getSession();
		session.removeAttribute("Account_present");
		model.addAttribute("Account_present",Account_present);
       
		MyController myController = new MyController();
		return myController.homePage(model);
    }
	
	@RequestMapping(value = { "/sign-out" }, method = RequestMethod.POST)
    public String signoutPOSTPage(Model model,HttpServletRequest request) throws ClassNotFoundException, SQLException {
		Account_present = null;
		
		HttpSession session = request.getSession();
		session.removeAttribute("Account_present");
		model.addAttribute("Account_present",Account_present);
		
		
		MyController myController = new MyController();
		return myController.homePage(model);
    }
	
	
}
