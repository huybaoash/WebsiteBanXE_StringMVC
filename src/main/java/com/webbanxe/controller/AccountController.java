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
import com.webbanxe.model.Customer;
import com.webbanxe.model.CustomerDAO;
import com.webbanxe.model.HelloWorld;
@Controller
public class AccountController {

	@RequestMapping(value = { "/userinfo" }, method = RequestMethod.GET)
    public String userinfoPage(Model model,HttpServletRequest request) throws ClassNotFoundException, SQLException {
		HttpSession session = request.getSession();
		Account Account_present = (Account) session.getAttribute("Account_present");
		Customer Customer_present = (Customer) session.getAttribute("Customer_present");
		
		
		if (Account_present == null) {
			MyController myController = new MyController();
			return myController.homePage(model);
		}
		
		model.addAttribute("Account_present",Account_present);
		model.addAttribute("Customer_present",Customer_present);
		
		return "userinfo";
		
    }
	
	@RequestMapping(value = { "/account-list" }, method = RequestMethod.GET)
    public String accountlistPage(Model model,HttpServletRequest request) {

        return "accountlist";
    }
	
	@RequestMapping(value = { "/userinfo-edit" }, method = RequestMethod.GET)
    public String userinfoeditPage(Model model,HttpServletRequest request) {

        return "userinfoedit";
    }
}
