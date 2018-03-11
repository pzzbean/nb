package com.ibase.core.interceptor;

import java.util.List;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.alibaba.fastjson.JSONObject;
import com.ibase.core.constants.Constant;
import com.ibase.core.http.HttpUtil;


/**
 * 登录拦截器
 * @author admin
 */
public class LoginInterceptor extends HandlerInterceptorAdapter{
		
//    @Override
//    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
//        String url = request.getRequestURL().toString();
//        if(url.indexOf("login")>0)return true;
//        if(url.indexOf(".js")>0)return true;
//        if(url.indexOf("img")>0)return true;
//        if(url.indexOf("css")>0)return true;
//        
//        HttpSession session = request.getSession();
//        //System.out.println(session.getAttribute("user"));
//        if(session.getAttribute("user")==null){
//        	response.sendRedirect("/nb/login.html");
//        	return false;
//        }
//        
//        return true;
//    }
// 
//    @Override
//    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
//    	super.postHandle(request, response, handler, modelAndView);
//    }
}
