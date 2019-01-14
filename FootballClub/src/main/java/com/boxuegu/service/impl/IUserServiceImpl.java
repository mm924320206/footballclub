package com.boxuegu.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.boxuegu.dao.IUserDao;
import com.boxuegu.domain.User;
import com.boxuegu.service.IUserService;
@Service("userService")
public class IUserServiceImpl implements IUserService {
	@Autowired
	@Qualifier("userDao")
	private IUserDao userDao;
	@Override
	public User login(User user) {
		
		return userDao.login(user);
	}

}
