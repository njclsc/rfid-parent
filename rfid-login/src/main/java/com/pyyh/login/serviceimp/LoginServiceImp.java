package com.pyyh.login.serviceimp;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSONObject;
import com.pyyh.login.pojo.PostMessagePojo;
import com.pyyh.login.service.ILoginService;
@Service("LoginServiceImp")
public class LoginServiceImp implements ILoginService{

	@Override
	public String loginCheck(String name, String password) {
		// TODO Auto-generated method stub
		Subject subject = SecurityUtils.getSubject();
		UsernamePasswordToken token = new UsernamePasswordToken(name, password);
		subject.login(token);
		PostMessagePojo pmp = new PostMessagePojo();
		pmp.setOperate("loginCheck");
		pmp.setStatus("success");
		pmp.setMessage("登录验证成功");
		return JSONObject.toJSONString(pmp);
	}

}
