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
public class HelloWorldController {
	

	@RequestMapping(value = { "/helloworld" }, method = RequestMethod.GET)
	public String handler(Model model) throws ClassNotFoundException, SQLException {
		HelloWorld helloWorld = new HelloWorld();
		helloWorld.setMessage("Hello world example using Spring MVC5 !!! Chào mừng đến với MVC 5 !!! !!!");
		helloWorld.setDateTime(LocalDateTime.now().toString());
		
	
		AccountsDAO lstAcc = new AccountsDAO();
		helloWorld.setdsTaiKhoan(lstAcc.toList());
		
		System.out.print(helloWorld.message);
		
		model.addAttribute("helloworld",helloWorld);
		return "helloworld";
	}
	
	@RequestMapping(value = { "/helloworld" }, method = RequestMethod.POST)
	public String handler(Model model,HttpServletRequest request) throws ClassNotFoundException, SQLException {
		
		String message = "Hello world example using Spring MVC5 !!! Chào mừng đến với MVC 5 !!! !!!";
		HelloWorld helloWorld = new HelloWorld();
		
		helloWorld.setDateTime(LocalDateTime.now().toString());
		String searchId = request.getParameter("search_account");
		AccountsDAO lstAcc = new AccountsDAO();
		if (searchId == null || searchId.isEmpty() || searchId.isBlank()) {
			System.out.print(helloWorld.message);
			return "helloworld";
		};
		int Id = Integer.parseInt(searchId);
		
		
		
		Account acc = lstAcc.getAccount(Id);
		if (acc != null)
		message += " " + acc.getTENTK();
		else message += " Không tìm được tài khoản !";
		helloWorld.setMessage(message);
		helloWorld.setdsTaiKhoan(lstAcc.toList());
		
		System.out.print(helloWorld.message);
		
		
		model.addAttribute("helloworld",helloWorld);
		return "helloworld";
	}
}
