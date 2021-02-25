package com.pyyh.login.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pyyh.login.service.ILoginService;

@RestController
@RequestMapping("/signin")
public class LoginController {
	@Autowired
	@Qualifier("LoginServiceImp")
	private ILoginService loginService;
	@RequestMapping("login")
	public String loginCheck(HttpServletRequest request, HttpServletResponse response){
		String name = request.getParameter("name");
		String password = request.getParameter("password");
		return loginService.loginCheck(name, password);
	}
}
