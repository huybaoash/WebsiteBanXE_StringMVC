package com.webbanxe.controller;

import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.webbanxe.model.AccountsDAO;
import com.webbanxe.model.CarType;
import com.webbanxe.model.CarTypeDAO;
import com.webbanxe.model.HelloWorld;
import com.webbanxe.model.ViewModel.ContractCarDetailsView;
import com.webbanxe.model.ViewModel.ContractCarDetailsViewDAO;

@Controller
public class MyController {

    @RequestMapping(value = { "/", "/home" }, method = RequestMethod.GET)
    public String homePage(Model model) throws ClassNotFoundException, SQLException {
    	CarTypeDAO data_LoaiXE = new CarTypeDAO();
    	List<CarType> lstLoaiXE = data_LoaiXE.toPublicList();
    	model.addAttribute("lstLoaiXE",lstLoaiXE);
    	
    	ContractCarDetailsViewDAO data_HD = new ContractCarDetailsViewDAO();
    	List<ContractCarDetailsView> lstHD = data_HD.toPublicList();
    	
    	model.addAttribute("lstHD",lstHD);
    	
        return "homePage";
    }

    
    @RequestMapping(value = { "/contactus" }, method = RequestMethod.GET)
    public String contactusPage(Model model) {
        model.addAttribute("address", "Vietnam");
        model.addAttribute("phone", "...");
        model.addAttribute("email", "...");
        return "contactusPage";
    }
    
  
    
    
}