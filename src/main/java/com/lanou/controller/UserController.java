package com.lanou.controller;

import com.lanou.entity.User;
import com.lanou.service.UserService;
import com.sun.tools.internal.xjc.reader.xmlschema.bindinfo.BIConversion;
import org.apache.ibatis.logging.stdout.StdOutImpl;
import org.apache.ibatis.reflection.SystemMetaObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("/")
public class UserController {
	
	@Autowired
	private UserService userService;


	//登录
	@RequestMapping("/login.do")
	@ResponseBody
	public boolean login(User user1){
		User users=userService.finduNameAndPwd(user1);
		System.out.println(users);
		boolean result=false;
		if (users!=null){

			return true;
		}
		System.out.println(result);
		return false;
	}

	//注册
	@RequestMapping("/reg.do")
	@ResponseBody
	public boolean reg(User user){
		User user1= userService.finduName(user);
		boolean result=false;
		if (user1==null){
			result=userService.adduNameAndPwd(user);
			return true;
		}
		return result;
	}

	//修改个人信息
	@RequestMapping("/update.do")
	@ResponseBody
	public boolean updateUser(User user){
		boolean result=false;

		 if (userService.updateUser(user)){
		 	return true;
		 }

		return false;
	}
	//修改密码
	@RequestMapping("/updatePwd.do")
	@ResponseBody
	public String findPwdByuNmae(User user){
		User user1= userService.finduPasswordByuName(user);
		Number num=0;
		if (user1.getuPassword().equals(user.getuPassword())){
			return "OK";
		}
		System.out.println(user1);
		return "NO";
	}

}