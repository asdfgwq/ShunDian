package com.lanou.service;

import com.lanou.entity.User;

import java.util.List;

public interface UserService {
	

	public User finduNameAndPwd(User user);
	public User finduName(User user);
	public  boolean adduNameAndPwd(User user);
	public  boolean updateUser(User user);
	public User finduPasswordByuName(User user);
	public  List<User> findUser(String uName);
	public  boolean updatePwd(User user);
}
