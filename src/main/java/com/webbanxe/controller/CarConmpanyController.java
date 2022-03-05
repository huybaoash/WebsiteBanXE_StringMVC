package com.webbanxe.controller;

import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

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
	
	@RequestMapping(value = { "/carconmany-edit" }, method = RequestMethod.GET)
    public String carconmanyeditPage(Model model) {

        return "carconmpanyedit";
    }
	
	@RequestMapping(value = { "/carconmany-register" }, method = RequestMethod.GET)
    public String carconmanyregisterPage(Model model) {

        return "carconmpanyregister";
    }
}
