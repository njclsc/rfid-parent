package com.pyyh.log.controller;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/test")
public class TestController {

	@RequestMapping("x")
	public void test(HttpServletRequest req, HttpServletResponse rep){
		
		System.out.println("阿西吧1");
	}
	@RequestMapping("x1")
	public void test1(HttpServletRequest req, HttpServletResponse rep){
		
		System.out.println("阿西吧1 " + req.getParameter("id"));
	}
	@RequestMapping("x2")
	public void test2(HttpServletRequest req, HttpServletResponse res){
		System.out.println("阿西吧2 " + req.getParameter("name") + "  " + req.getParameter("password"));
	}
}
