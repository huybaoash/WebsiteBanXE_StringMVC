package com.webbanxe.controller;
import java.sql.SQLException;
import java.time.LocalDateTime;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.webbanxe.model.*;

@Controller
public class HelloWorldController {
	private ConnectionDB conn;

	@GetMapping("/helloworld")
	public String handler(Model model) {
		HelloWorld helloWorld = new HelloWorld();
		helloWorld.setMessage("Hello world example using Spring MVC5 !!!");
		helloWorld.setDateTime(LocalDateTime.now().toString());
		
		try {
			conn = new ConnectionDB();
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		model.addAttribute("helloworld",helloWorld);
		return "helloworld";
	}
}
