package com.pyyh.login.dao;

import org.springframework.stereotype.Repository;

import com.pyyh.login.pojo.UserPojo;

@Repository
public interface ILoginDao {

	public UserPojo findUserByName(String name);
}
