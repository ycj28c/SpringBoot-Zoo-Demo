package com.xxx.firstboot.web;

public class UserService {

	public User getUser(String username, String password) {
		User testUser = new User();
		testUser.setName("li");
		testUser.setPassword("yang");
		return testUser;
	}

}
