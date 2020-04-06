package com.nvt.service.impl;

import com.nvt.dao.IUserDAO;
import com.nvt.dao.impl.UserDAO;
import com.nvt.model.UserModel;
import com.nvt.service.IUserService;

public class UserService implements IUserService {

	private IUserDAO userDAO;

	public UserService() {
		userDAO = new UserDAO();
	}
	
	@Override
	public UserModel findByEmailAndPasswordAndStatus(String userName, String password, Integer status) {
		return userDAO.findByEmailAndPasswordAndStatus(userName, password, status);
	}
	
}
