package com.ibase.web.user.service.impl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gg.yp.bean.PaginationBean;
import com.ibase.web.user.domain.User;
import com.ibase.web.user.mapper.UserMapper;
import com.ibase.web.user.service.UserService;

@Service
public class UserServiceImpl implements UserService {
	protected final Logger logger = LoggerFactory.getLogger(getClass());
	
	@Autowired
	private UserMapper userMapper;

	@Override
	public boolean insertUser(User user) {
		return userMapper.insertUser(user)>0;
	}

	@Override
	public List<User> userQuery(User user) {
    	int currentPage = user.getPage().getCurrentPage();
    	int pageSize = user.getPage().getPageSize();
    	
		user.getPage().setTotalRows((int)countUser(user));
		user.getPage().setStartNum((currentPage-1)*pageSize);
		user.getPage().setEndIndex(pageSize);
		
		return userMapper.userQuery(user);
	}

	@Override
	public long countUser(User user) {		
		return userMapper.countUser(user);
	}

	@Override
	public User searchSingleUser(User user) {
		/*List<User> list = userQuery(user);
		if(list == null || list.size()<1)
		{
			return null;
		}*/
		User user2 = userMapper.searchSingleUser(user);
	    return user2;
	}

	@Override
	public boolean updateUser(User user) {
		return userMapper.updateUser(user)>=0;
	}

	@Override
	public boolean deleteUser(String userId) {
		// TODO Auto-generated method stub
		return userMapper.deleteUser(userId)>=0;
	}

	@Override
	public User searchUserByUserId(Long userId) {
		return userMapper.searchUserByUserId(userId);
	}

}
