package com.ibase.web.user.service;

import java.util.List;

import com.gg.yp.bean.PaginationBean;
import com.ibase.web.user.domain.User;

public interface UserService {
	boolean insertUser(User user);
	
	User searchSingleUser(User user);
	
    List<User> userQuery(User user);
	
	long countUser(User user);
	
	boolean updateUser(User user);
	
	boolean deleteUser(String userId);
	
	public User searchUserByUserId(Long userId);
}
