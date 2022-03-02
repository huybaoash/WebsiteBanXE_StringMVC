package com.webbanxe.controller;

import java.sql.SQLException;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.webbanxe.model.Index;
@Controller
public class IndexControllder {
	@RequestMapping(value = { "/index" }, method = RequestMethod.GET)
	public String handler(Model model) throws ClassNotFoundException, SQLException {
		Index index = new Index();
		index.setMessage("Hello world example using Spring MVC5 !!! Chào mừng đến với MVC 5 !!! !!!");
		
		
		
		
		model.addAttribute("index",index);
		return "index";
	}
}
