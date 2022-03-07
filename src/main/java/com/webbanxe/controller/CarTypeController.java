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
public class CarTypeController {
	@RequestMapping(value = { "/cartype-register" }, method = RequestMethod.GET)
    public String cartyperegisterPage(Model model) throws ClassNotFoundException, SQLException {

		
        return "cartyperegister";
    }
	
	@RequestMapping(value = { "/cartype-edit" }, method = RequestMethod.GET)
    public String cartypeeditPage(Model model) {

        return "cartypeedit";
    }
	
	@RequestMapping(value = { "/cartype-list" }, method = RequestMethod.GET)
    public String cartypelistPage(Model model) throws ClassNotFoundException, SQLException {
		CarTypeDAO data_LoaiXE = new CarTypeDAO();
    	List<CarType> lstLoaiXE = data_LoaiXE.toList();
    	model.addAttribute("lstLoaiXE",lstLoaiXE);
    	
        return "cartypelist";
    }

}
