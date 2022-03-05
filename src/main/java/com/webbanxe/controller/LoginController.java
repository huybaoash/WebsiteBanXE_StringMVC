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
import com.webbanxe.model.Login;
@Controller
public class LoginController {
	@RequestMapping(value = { "/login" }, method = RequestMethod.GET)
    public String customerlistPage(Model model) {
		Login login = new Login();
		login.setMessage("Hello world example using Spring MVC5 !!! Chào mừng đến với MVC 5 !!! !!!");
		
		
		
		
		model.addAttribute("login",login);
        return "login";
    }
}
