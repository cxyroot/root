package com.google.service.impl;

import com.google.service.UserService;

public class UserServiceImpl implements UserService {
	@Override
	public void saveUser() {
		System.out.println("com.google.service.impl.UserServiceImpl#saveUser");
	}
}
