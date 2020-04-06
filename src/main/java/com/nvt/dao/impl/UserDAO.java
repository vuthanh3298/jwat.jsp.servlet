package com.nvt.dao.impl;

import java.util.List;

import com.nvt.dao.IUserDAO;
import com.nvt.mapper.UserMapper;
import com.nvt.model.UserModel;

public class UserDAO extends AbstractDAO<UserModel> implements IUserDAO  {

	@Override
	public UserModel findByEmailAndPasswordAndStatus(String email, String password, Integer status) {
		StringBuilder sql = new StringBuilder("SELECT * FROM users AS u");
		sql.append(" INNER JOIN role AS r ON r.id = u.role_id");
		sql.append(" WHERE email = ? AND password = ? AND status = ?");
		List<UserModel> users = query(sql.toString(), new UserMapper(), email, password, status);
		return users.isEmpty() ? null : users.get(0);
	}
}
