package com.ibase.web.plane.util;

import com.ibase.core.utils.DateUtil;
import com.ibase.core.utils.StringUtil;
import com.ibase.web.plane.domain.Plane;
import com.ibase.web.user.domain.User;
import com.ibase.web.user.service.UserService;

public class PlaneUtil {
	/*
	 * 给plane属性加上"%"支持模糊查询
	 * 除了id,status
	 */
	public static void likePro(Plane plane){
		if(!StringUtil.isEmpty(plane.getPlan_test_engineer())){
			plane.setPlan_test_engineer("%"+plane.getPlan_test_engineer()+"%");
		}
		if(!StringUtil.isEmpty(plane.getPlan_te_phone())){
			plane.setPlan_te_phone("%"+plane.getPlan_te_phone()+"%");
		}
		if(!StringUtil.isEmpty(plane.getPlan_back_engineer())){
			plane.setPlan_back_engineer("%"+plane.getPlan_back_engineer()+"%");
		}
		if(!StringUtil.isEmpty(plane.getPlan_be_phone())){
			plane.setPlan_be_phone("%"+plane.getPlan_be_phone()+"%");
		}
		if(!StringUtil.isEmpty(plane.getPlane_test_content())){
			plane.setPlane_test_content("%"+plane.getPlane_test_content()+"%");
		}
		if(!StringUtil.isEmpty(plane.getPlane_test_time())){
			plane.setPlane_test_time("%"+DateUtil.formatSimpleDate(DateUtil.parseSimpleDate(plane.getPlane_test_time()))+"%");
		}
	}
	
	/**
	 * 根据测试计划里的测试工程师信息修改user表数据
	 * user表里存储的是测试工程师的数据，外加一条管理员数据
	 */
	public static boolean updateUserByPlane(Plane plane,UserService userService){
		User user = new User();
		user.setUserId(plane.getUser_id());
		user.setName(plane.getPlan_test_engineer());
		user.setUser_phone(plane.getPlan_te_phone());
		
		return userService.updateUser(user);
	}
	
	/*
	 * 空值判断
	 */
	public static String isNull(Plane plane){
		if(plane.getPlan_id()<=0)return "plane_id不能为空！";
		if(plane.getUser_id()<=0)return "user_id不能为空！";
		if(StringUtil.isEmpty(plane.getPlan_test_engineer()))return "测试工程师姓名不能空！";
		if(StringUtil.isEmpty(plane.getPlan_te_phone()))return "测试工程师电话不能为空！";
		if(StringUtil.isEmpty(plane.getPlan_back_engineer()))return "后台工程师姓名不能为空！";
		if(StringUtil.isEmpty(plane.getPlan_be_phone()))return "后台工程师电话不能为空！";
		return null;
	}
	public static String isNull(long planeId){
		try {
			String planeIdStr = String.valueOf(planeId);
			if(StringUtil.isEmpty(planeIdStr)){
				return "plane_id不能为空！";
			}
		} catch (Exception e) {
			return "plane_id格式不对（只能为数字）！";
		}
		return null;
	}
	public static String isNullAdd(Plane plane){
		if(plane.getUser_id()<=0)return "user_id(测试工程师id)不能为空！";
		if(StringUtil.isEmpty(plane.getPlan_test_engineer()))return "测试工程师姓名不能空！";
		if(StringUtil.isEmpty(plane.getPlan_te_phone()))return "测试工程师电话不能为空！";
		if(StringUtil.isEmpty(plane.getPlan_back_engineer()))return "后台工程师姓名不能为空！";
		if(StringUtil.isEmpty(plane.getPlan_be_phone()))return "后台工程师电话不能为空！";
		if(StringUtil.isEmpty(plane.getPlane_test_time())) return "测试时间不能为空";
		if(StringUtil.isEmpty(plane.getPlane_test_content())) return "测试内容不能为空";
		return null;
	}
	public static String isNullUpdate(Plane plane){
		if(plane.getPlan_id()<=0)return "plane_id不能为空！";
		if(plane.getUser_id()<=0)return "user_id不能为空！";
		if(StringUtil.isEmpty(plane.getPlan_test_engineer()))return "测试工程师姓名不能空！";
		if(StringUtil.isEmpty(plane.getPlan_te_phone()))return "测试工程师电话不能为空！";
		if(StringUtil.isEmpty(plane.getPlan_back_engineer()))return "后台工程师姓名不能为空！";
		if(StringUtil.isEmpty(plane.getPlan_be_phone()))return "后台工程师电话不能为空！";
		if(StringUtil.isEmpty(plane.getPlane_test_time())) return "测试时间不能为空";
		if(StringUtil.isEmpty(plane.getPlane_test_content())) return "测试内容不能为空";
		return null;
	}
	

}
