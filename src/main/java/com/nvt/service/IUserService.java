package com.nvt.service;

import com.nvt.model.UserModel;

public interface IUserService {
	UserModel findOne(Integer id);
	UserModel findByEmailAndPassword(String userName, String password);
	Integer register(UserModel userModel);
	Boolean isEmailExist(String email);
	boolean update(UserModel userModel);
}
