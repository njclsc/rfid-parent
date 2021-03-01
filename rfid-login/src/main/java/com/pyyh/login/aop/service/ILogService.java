package com.pyyh.login.aop.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
@FeignClient(name = "log-server")
public interface ILogService {
	
	@RequestMapping(method = RequestMethod.POST, value="/log-server/test/x")
	public void callLog();
	@RequestMapping(method = RequestMethod.GET, value="/log-server/test/x1?id={id}")
	public void callLog1(@PathVariable("id")String id);
	@RequestMapping(method = RequestMethod.POST, value = "/log-server/test/x2")
	public void callLog2(@RequestParam("name")String name, @RequestParam("password")String password);
}
