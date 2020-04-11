package com.nvt.service.impl;

import javax.inject.Inject;

import com.nvt.constant.SystemConstant;
import com.nvt.dao.IUserDAO;
import com.nvt.model.UserModel;
import com.nvt.service.IUserService;

public class UserService implements IUserService {

	@Inject
	IUserDAO userDAO;
	
	@Override
	public UserModel findByEmailAndPassword(String userName, String password) {
		return userDAO.findByEmailAndPassword(userName, password);
	}

	public Integer register(UserModel userModel) {
		userModel.setRoleId(SystemConstant.USER_ROLE_ID);
		userModel.setStatus(SystemConstant.STATUS_APPROVED);
		return userDAO.save(userModel);
	}

	@Override
	public Boolean isEmailExist(String email) {
		return userDAO.isEmailExist(email);
	}

	@Override
	public UserModel findOne(Integer id) {
		return userDAO.findOne(id);
	}

	@Override
	public boolean update(UserModel userModel) {
		return userDAO.update(userModel);
	}
}
