package com.nvt.service;

import com.nvt.model.UserModel;

public interface IUserService {
	UserModel findByEmailAndPasswordAndStatus(String userName, String password, Integer status);
}
