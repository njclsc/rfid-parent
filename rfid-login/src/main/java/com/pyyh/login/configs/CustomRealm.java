package com.pyyh.login.configs;

import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;

import com.pyyh.login.dao.ILoginDao;
import com.pyyh.login.pojo.UserPojo;

public class CustomRealm extends AuthorizingRealm{
	@Autowired
	private ILoginDao loginDao;
	@Override
	protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken arg0) throws AuthenticationException {
		// TODO Auto-generated method stub
		String name = (String)arg0.getPrincipal();
		UserPojo up = loginDao.findUserByName(name);
		if(up != null){
			SimpleAuthenticationInfo authen = new SimpleAuthenticationInfo(up.getName(), up.getPassword(), this.getName());
			return authen;
		}else{
			return null;
		}
	}

}
