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
public class CustomerController {
	@RequestMapping(value = { "/customer-list" }, method = RequestMethod.GET)
    public String customerlistPage(Model model , HttpServletRequest request) {

        return "customerlist";
    }
}
