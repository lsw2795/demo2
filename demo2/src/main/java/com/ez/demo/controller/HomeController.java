package com.ez.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {
	@RequestMapping("/")
    public String index() { 
		System.out.println("index page!");
		System.out.println("담당자");
        return "index";
    }
	
	@RequestMapping("/test1")
    public String test1() { 
		System.out.println("test1 page!");
        return "test1";
    }
}
