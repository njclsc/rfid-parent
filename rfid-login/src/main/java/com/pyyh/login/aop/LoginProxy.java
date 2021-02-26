package com.pyyh.login.aop;

import javax.servlet.http.HttpServletRequest;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import com.alibaba.fastjson.JSONObject;
import com.pyyh.login.pojo.PostMessagePojo;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

@Aspect
@Component
public class LoginProxy {
	@Autowired
	@Qualifier("redisSource")
	private JedisPool jedis;
	@Pointcut("execution(public * com.pyyh.login.controller..*.*(..))")
	public void point(){}
	
	@Around("point()")
	public Object around(ProceedingJoinPoint pjp){
		System.out.println(jedis);
		Object object = null;
		try {
			object = pjp.proceed();
			Signature signutare = pjp.getSignature();
			String methodName = signutare.getName();
			if(methodName.equals("loginCheck") && JSONObject.parseObject((String)object).get("status").equals("success")){
				HttpServletRequest req = (HttpServletRequest) pjp.getArgs()[0];
				String name = req.getParameter("name");
				Jedis jds = jedis.getResource();
				jds.set("login->" + name, "true");
				jds.close();
			}
		} catch (Throwable e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			PostMessagePojo pmp = new PostMessagePojo();
			pmp.setOperate("loginCheck");
			pmp.setStatus("fail");
			pmp.setMessage("登录验证失败");
			return JSONObject.toJSONString(pmp);
			
		}
		return object;
	}
//	@AfterThrowing(value = "point()", throwing = "ex")
//	public void _throws(JoinPoint jp, Throwable ex){
//		System.out.println("异常处理点：jp = " + jp.toString());
//		System.out.println("异常处理点：ex = " + ex.toString());
//	}
}
