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
import com.webbanxe.model.CarConmpany;
import com.webbanxe.model.CarConmpanyDAO;
import com.webbanxe.model.CarType;
import com.webbanxe.model.CarTypeDAO;
import com.webbanxe.model.Customer;
import com.webbanxe.model.CustomerDAO;
import com.webbanxe.model.HelloWorld;
@Controller
public class ContractController {
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
    public String contractregisterPage(Model model , HttpServletRequest request) throws ClassNotFoundException, SQLException {

		HttpSession session = request.getSession();
		Account Account_present = (Account) session.getAttribute("Account_present");

		
		if (Account_present == null) {
			Account account = new Account();
			Customer customer = new Customer();
			
			
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
	
	@RequestMapping(value = { "/contract-list" }, method = RequestMethod.GET)
    public String contractlistPage(Model model , HttpServletRequest request) {

        return "contractlist";
    }
}
