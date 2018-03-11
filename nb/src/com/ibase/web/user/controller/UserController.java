package com.ibase.web.user.controller;


import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ibase.core.http.ResponsePacket3;
import com.ibase.core.http.ResponsePacket4;
import com.ibase.core.utils.StringUtil;
import com.ibase.web.user.domain.User;
import com.ibase.web.user.service.UserService;
import com.ibase.web.user.util.UserUtil;


@Controller
@RequestMapping(value="/user")
public class UserController {
	
	//protected final Logger logger = LoggerFactory.getLogger(getClass());
	
	@Autowired
	private UserService userService;

    @RequestMapping(path = "/login")
    @ResponseBody
    public ResponsePacket3 login(User user,HttpServletRequest request){
    	ResponsePacket3 json = new ResponsePacket3(-1,"登陆失败！");
    	System.out.println("=================="+user);
    	//用户民和密码不能为空
    	if(StringUtil.isEmpty(user.getName())){
    		json.setmMessage("用户名不能为空！");
    		return json;
    	}
    	if(StringUtil.isEmpty(user.getPaw())){
    		json.setmMessage("密码不能为空！");
    		return json;
    	}
    	
    	String name = user.getName();
    	String paw = user.getPaw();
    	System.out.println("測試登陸"+name+";"+paw);
    	//检查用户名或密码是否存在
    	User userOne = userService.searchSingleUser(user);
    	System.out.println("測試登陸"+userOne);
    	if(userOne==null){
    		json.setmMessage("用户名或密码错误！");
    		return json;
    	}
    	/*if (userOne.getName().equals("admin")) {
			userOne.setStatus("1");
		}*/
    	List<User> users = new ArrayList<>();
    	User user3 = new User();
    	user3.setName(userOne.getName());
    	user3.setUserId(userOne.getUserId());
    	user3.setPaw(userOne.getPaw());
    	user3.setStatus(userOne.getStatus());
    	user3.setUser_code(userOne.getUser_code());
    	users.add(user3);
    	//以上检查全部通过
    	json.setResultCode(1);
    	json.setmMessage("登陆成功！");
    	json.setDataSource(users);
    	//存入会话
    	HttpSession session = request.getSession();
    	session.setAttribute("user",userOne);
    	
    	return json;
    	
    }
    
    /**
     * 分页的传入的   当前页   字段为page.currentPage
     * 分页传去的   显示条数  字段为page.pageSize
     */
    @RequestMapping(value = "/listUser")
    @ResponseBody
    public ResponsePacket4 listUser(User user){
    	ResponsePacket4 json = new ResponsePacket4(-1,"查询失败！");
    	
    	//添加模糊查询，即加上'%'
    	UserUtil.likePro(user);
    	
    	//查询数据
    	List<User> list = userService.userQuery(user);
    	//System.out.println(((User)list.get(0)).getStatus());
    	json.setCode(1);
    	json.setMsg("查询成功！");
    	json.setListObject(list);
    	json.setPage(user.getPage());//加入分页信息，如totalRow(总记录数)
    	return json;
    }
    
    @RequestMapping(path = "/oneUser")
    @ResponseBody
    public ResponsePacket4 oneUser(User user){
    	ResponsePacket4 json = new ResponsePacket4(-1,"查询失败！");
    	
    	//查询数据
    	User oneUser = userService.searchSingleUser(user);
    	
    	json.setCode(1);
    	json.setMsg("查询成功！");
    	json.setObject(oneUser);
    	return json;
    	
    	
    }
    
    @RequestMapping(path = "/addUser")
    @ResponseBody
    public ResponsePacket4 add(User user){
    	ResponsePacket4 json = new ResponsePacket4(-1,"添加失败！");
    	
    	//非空验证、电话格式验证
    	String isNull = UserUtil.isNull(user);
    	if(isNull!=null){
    		json.setMsg(isNull);
    		return json;
    	}
    	
    	//验证是否有重复用户名
    	User user2 = new User();
    	user2.setUser_code(user.getUser_code());
    	if(userService.searchSingleUser(user2)!=null){
    		json.setMsg("登陆名重复！");
    		return json;
    	}
    	
    	//添加数据
    	if(userService.insertUser(user)){
    		json.setCode(1);
    		json.setMsg("添加成功！");
    	}
    	
    	return json;
    }
    
    @RequestMapping(path = "/updateUser")
    @ResponseBody
    public ResponsePacket4 update(User user,String userId,String user_code2){
    	ResponsePacket4 json = new ResponsePacket4(-1,"修改失败！");
    	
    	//验证(非空验证、电话格式验证、id验证并将userId加入User类中)
    	String isNull = UserUtil.isNull(user,userId);
    	if(isNull!=null){
    		json.setMsg(isNull);
    		return json;
    	}
    	
    	//验证是否有重复用户名
    	if(!user_code2.equals(user.getUser_code())){
    		User user2 = new User();
        	user2.setUser_code(user.getUser_code());
        	if(userService.searchSingleUser(user2)!=null){
        		json.setMsg("登陆名重复！");
        		return json;
        	}
    	}
    	
    	
    	//修改数据
    	if(userService.updateUser(user)){
    		json.setCode(1);
    		json.setMsg("修改成功");
    	}
    	
    	return json;
    }
    
    @RequestMapping(path = "/deleteUser")
    @ResponseBody
    public ResponsePacket4 delete(String userId){
    	ResponsePacket4 json = new ResponsePacket4(-1,"删除失败！");
    	
    	//验证(id验证)
    	String isNull = UserUtil.isNull(userId);
    	if(isNull!=null){
    		json.setMsg(isNull);
    		return json;
    	}
    	
    	//删除数据
    	if(userService.deleteUser(userId)){
    		json.setCode(1);
    		json.setMsg("删除成功！");
    	}
    	
    	return json;
    }
    
}
