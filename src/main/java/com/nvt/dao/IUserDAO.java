package com.nvt.dao;

import com.nvt.model.UserModel;

public interface IUserDAO extends GenericDAO<UserModel> {
	UserModel findByEmailAndPassword(String userName, String password);
	Integer save(UserModel userModel);
	Boolean isEmailExist(String email);
	UserModel findOne(Integer id);
	boolean update(UserModel userModel);
}
