package com.nvt.dao;

import com.nvt.model.UserModel;

public interface IUserDAO extends GenericDAO<UserModel> {
	UserModel findByEmailAndPasswordAndStatus(String userName, String password, Integer status);
}
