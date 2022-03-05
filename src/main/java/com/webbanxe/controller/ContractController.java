package com.webbanxe.controller;

import java.sql.SQLException;
import java.time.LocalDateTime;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.webbanxe.model.Account;
import com.webbanxe.model.AccountsDAO;
import com.webbanxe.model.HelloWorld;
@Controller
public class ContractController {
	@RequestMapping(value = { "/car-edit" }, method = RequestMethod.GET)
    public String careditPage(Model model) {

        return "caredit";
    }
	
	@RequestMapping(value = { "/contract-details" }, method = RequestMethod.GET)
    public String contractdetailsPage(Model model) {

        return "contractdetails";
    }
	
	@RequestMapping(value = { "/contract-edit" }, method = RequestMethod.GET)
    public String contracteditPage(Model model) {

        return "contractedit";
    }
	
	@RequestMapping(value = { "/contract-history" }, method = RequestMethod.GET)
    public String contracthistoryPage(Model model) {

        return "contracthistory";
    }
	
	@RequestMapping(value = { "/contract-register" }, method = RequestMethod.GET)
    public String contractregisterPage(Model model) {

        return "contractregister";
    }
	
	@RequestMapping(value = { "/contract-list" }, method = RequestMethod.GET)
    public String contractlistPage(Model model) {

        return "contractlist";
    }
}
