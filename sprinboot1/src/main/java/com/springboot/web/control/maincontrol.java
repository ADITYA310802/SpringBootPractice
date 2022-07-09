package com.springboot.web.control;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
public class maincontrol {
	
	
	@RequestMapping("/")
	public String home()
	{
		System.out.println("home jsp started");
		return "home";
	}
	
	@RequestMapping("/contact")
	public String contact()
	{
		System.out.println("conatact page");
		
		return "contact";
	}

}
