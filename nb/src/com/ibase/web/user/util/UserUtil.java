package com.ibase.web.user.util;

import com.ibase.core.utils.StringUtil;
import com.ibase.web.user.domain.User;

public class UserUtil {
	/*
	 * 给user属性加上"%"支持模糊查询
	 * 除了id,status
	 */
	public static void likePro(User user){
		if(!StringUtil.isEmpty(user.getUser_code())){
			user.setUser_code("%"+user.getUser_code()+"%");
		}
		if(!StringUtil.isEmpty(user.getName())){
			user.setName("%"+user.getName()+"%");
		}
		if(!StringUtil.isEmpty(user.getPaw())){
			user.setPaw("%"+user.getPaw()+"%");
		}
		if(!StringUtil.isEmpty(user.getUser_phone())){
			user.setUser_phone("%"+user.getUser_phone()+"%");
		}
	}
	
	public static String isNull(User user){
		if(StringUtil.isEmpty(user.getUser_code())){
			return "用户名不能为空！";
		}
		if(StringUtil.isEmpty(user.getName())){
			return "真实姓名不能为空！";
		}
		if(StringUtil.isEmpty(user.getPaw())){
			return "密码不能为空！";
		}
		if(StringUtil.isEmpty(user.getUser_phone())){
			return "电话不能为空！";
		}
		if(!user.getUser_phone().matches("^1[34578]\\d{9}$")){
			return "电话格式不正确！";
		}
		if(StringUtil.isEmpty(user.getStatus())){
			return "角色不能为空！";
		}
		return null;
	}
	
	public static String isNull(User user,String userId){
		if(StringUtil.isEmpty(userId)){
			return "用户id不能为空！";
		}
		
		try {
			if(Long.parseLong(userId)<=0){
				return "请检查用户id是否正确！(必须>0)";
			}
			user.setUserId(Long.parseLong(userId));
		} catch (Exception e) {
			return "请检查用户id是否正确！(只能有数字)";
		}	
		
		if(StringUtil.isEmpty(user.getUser_code())){
			return "用户名不能为空！";
		}
		if(StringUtil.isEmpty(user.getName())){
			return "真实姓名不能为空！";
		}
		if(StringUtil.isEmpty(user.getPaw())){
			return "密码不能为空！";
		}
		if(StringUtil.isEmpty(user.getUser_phone())){
			return "电话不能为空！";
		}
		if(!user.getUser_phone().matches("^1[34578]\\d{9}$")){
			return "电话格式不正确！";
		}
		if(StringUtil.isEmpty(user.getStatus())){
			return "角色不能为空！";
		}
		return null;
	}
	
	public static String isNull(String userId){
		try {
			if(Long.parseLong(userId)<=0){
				return "请检查用户id是否正确！(必须>0)";
			}			
		} catch (Exception e) {
			return "请检查用户id是否正确！(只能有数字)";
		}
		return null;
	}
	
	public static void main(String[] args) {
		User user = new User();
		user.setName("qdd");
		user.setUser_code("qdd");
		user.setPaw("qdd1108");
		user.setUser_phone("18656155909");
		
		System.out.println(isNull(user));
		
		
	}

}
