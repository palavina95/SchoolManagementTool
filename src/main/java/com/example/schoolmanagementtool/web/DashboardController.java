package com.example.schoolmanagementtool.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class DashboardController {
	
	// Login
    @RequestMapping(value="/dashboard")
    public String login() {	
        return "dashboard";
    }

}
