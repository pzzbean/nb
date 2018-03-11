package com.ibase.web.user.mapper;

import java.util.List;

import com.ibase.web.user.domain.User;

public interface UserMapper {
	int insertUser(User user);
	
    List<User> userQuery(User user);
	
	long countUser(User user);
	
	int updateUser(User user);
	
	int deleteUser(String userId);

	User searchSingleUser(User user);
	
	public User searchUserByUserId(Long userId);
}
