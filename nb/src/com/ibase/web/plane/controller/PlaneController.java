package com.ibase.web.plane.controller;

import java.io.UnsupportedEncodingException;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ibase.core.http.ResponsePacket4;
import com.ibase.web.plane.domain.Plane;
import com.ibase.web.plane.service.PlaneService;
import com.ibase.web.plane.util.PlaneUtil;
import com.ibase.web.user.domain.User;
import com.ibase.web.user.service.UserService;

@Controller
@RequestMapping(value="/plane")
public class PlaneController {
	@Autowired
	private PlaneService planeService;
	
	@Autowired
	private UserService userService;
	
	/**
     * 分页的传入的   当前页   字段为page.currentPage
     * 分页穿去的   显示条数  字段为page.pageSize
     */
	@RequestMapping(path = "/listPlane")
    @ResponseBody
    public ResponsePacket4 listPlane(Plane plane){
		//添加模糊查询，即加上'%'
    	PlaneUtil.likePro(plane);
    	
    	//查询数据
    	List<Plane> list = planeService.queryPlane(plane);
    	
    	//封装
    	ResponsePacket4 json = new ResponsePacket4(1,"查询成功");
    	json.setListObject(list);
    	json.setPage(plane.getPage());
    	
		return json;
	}
	
	@RequestMapping(path = "/onePlane")
    @ResponseBody
    public ResponsePacket4 onePlane(Plane plane){
		//查询数据
		Plane onePlane = planeService.searchSinglePlane(plane);	
    	
		//封装
		ResponsePacket4 json = new ResponsePacket4(1,"查询成功！");
		json.setObject(json);
		
    	return json;
    }
	
	/**
	 * 测试人员对计划的修改，只能修改人员名称和电话
	 */
	@RequestMapping(path = "/updatePlane")
    @ResponseBody
	public ResponsePacket4 updatePlane(Plane plane) throws UnsupportedEncodingException{
		ResponsePacket4 json = new ResponsePacket4(-1,"修改失败！");
		boolean b=false;
		
		//空值判断
		if(PlaneUtil.isNull(plane)!=null){
			json.setMsg(PlaneUtil.isNull(plane));
			return json;
		}
		
		//测试员的电话和姓名修改了，则修改user表
		b=PlaneUtil.updateUserByPlane(plane,userService);
		
		//修改plane表，测试内容不让修改
		//user修改成功后才可以修改plane表
		if(b){
			b=false;
			plane.setPlane_test_content(null);
			plane.setPlane_Modifier(plane.getUser_id());
			b=planeService.updatePlane(plane);
		}
		
		//都修改成功后封装数据
		if(b){
			json.setCode(1);
			json.setMsg("修改成功！");
		}
		
		return json;
	}
	
	/**
	 * 添加计划
	 */
	@RequestMapping(path = "/addPlane")
    @ResponseBody
	public ResponsePacket4 addPlane(Plane plane,HttpServletRequest request){
		ResponsePacket4 json = new ResponsePacket4(-1,"添加失败！");
		
		//从session中获取user，加入plane中的创建人
		//因为在登陆拦截器中判断过session，所以这里不用在判断
		HttpSession session = request.getSession();
		User user = (User)session.getAttribute("user");
		plane.setPlane_creator(user.getUserId());
		
		//非空验证
		String isNull = PlaneUtil.isNullAdd(plane);
		if(isNull!=null){
			json.setMsg(isNull);
			return json;
		}
		
		//添加
		if(planeService.insertPlane(plane)){
			json.setCode(1);
			json.setMsg("添加成功！");
		}
		
		return json;
	}

	/**
	 * 管理员对计划的修改
	 */
	@RequestMapping(path = "/updatePlaneAdmin")
    @ResponseBody
	public ResponsePacket4 updatePlaneAdmin(Plane plane,HttpServletRequest request){
		ResponsePacket4 json = new ResponsePacket4(-1,"修改失败！");
		
		//从session中获取user，加入plane中的创建人
		//因为在登陆拦截器中判断过session，所以这里不用在判断
		HttpSession session = request.getSession();
		User user = (User)session.getAttribute("user");
		plane.setPlane_Modifier(user.getUserId());
		
		//非空验证
		String isNull = PlaneUtil.isNullUpdate(plane);
		if(isNull!=null){
			json.setMsg(isNull);
			return json;
		}
		
		//测试员的电话和姓名修改了，则修改user表
		PlaneUtil.updateUserByPlane(plane,userService);
		
		//修改
		if(planeService.updatePlane(plane)){
			json.setCode(1);
			json.setMsg("修改成功！");
		}
		return json;
	}
	
	/**
	 * 删除
	 */
	@RequestMapping(path = "/deletePlane")
    @ResponseBody
	public ResponsePacket4 deletePlane(Plane plane){
		ResponsePacket4 json = new ResponsePacket4(-1,"删除失败！");
		
		//非空验证
		String isNull = PlaneUtil.isNull(plane.getPlan_id());
		if(isNull!=null){
			json.setMsg(isNull);
			return json;
		}
		//删除
		if(planeService.deletePlane(plane.getPlan_id())){
			json.setCode(1);
			json.setMsg("删除成功！");
		}		
		
		return json;
	}
}
