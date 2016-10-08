package com.ts.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class TastySearchController {

	@RequestMapping(value="/", method=RequestMethod.GET)
	public String getHome(Model model,HttpServletRequest request, HttpServletResponse response,HttpSession session) {
		
		return "index";
	}
}
