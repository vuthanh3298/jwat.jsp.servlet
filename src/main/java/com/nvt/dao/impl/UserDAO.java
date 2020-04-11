package com.nvt.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.List;

import com.nvt.dao.IUserDAO;
import com.nvt.mapper.UserMapper;
import com.nvt.model.UserModel;
import com.nvt.utils.StringUtil;

public class UserDAO extends AbstractDAO<UserModel> implements IUserDAO  {

	@Override
	public UserModel findByEmailAndPassword(String email, String password) {
		StringBuilder sql = new StringBuilder("SELECT * FROM users AS u");
		sql.append(" INNER JOIN role AS r ON r.id = u.role_id");
		sql.append(" WHERE email = ? AND password = ?");
		List<UserModel> users = query(sql.toString(), new UserMapper(), email, password);
		return users.isEmpty() ? null : users.get(0);
	}

	@Override
	public Integer save(UserModel userModel) {
		String sql = "INSERT INTO users (`email`, `username`, `password`, `phone_number`, `address`, `dob`, `university`, `role_id`, `status`)  VALUES (?,?,?,?,?,?,?,?,?)";
		return insert(sql, userModel.getEmail(), userModel.getUsername(), userModel.getPassword(), userModel.getPhoneNumber(), userModel.getAddress(), userModel.getDob(), userModel.getUniversity(), userModel.getRoleId(), userModel.getStatus());
	}

	@Override
	public Boolean isEmailExist(String email) {
		Connection connection = null;
		PreparedStatement statement = null;
		ResultSet resultSet = null;
		try {
			String sql = "select 1 from users where email = ?";
			connection = getConnection();
			statement = connection.prepareStatement(sql);
			setParameter(statement, email);
			resultSet = statement.executeQuery();
			if(resultSet.next()) {
				return true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		} finally {
			try {
				if (connection != null) {
					connection.close();
				}
				if (statement != null) {
					statement.close();
				}
				if (resultSet != null) {
					resultSet.close();
				}
			} catch (SQLException e) {
				return false;
			}
		}
		return false;
	}

	@Override
	public UserModel findOne(Integer id) {
		String sql = "SELECT * FROM users AS u INNER JOIN role AS r ON r.id = u.role_id WHERE u.id = ?";
		List<UserModel> users = query(sql, new UserMapper(), id);
		return users.isEmpty() ? null : users.get(0);
	}

	@Override
	public boolean update(UserModel userModel) {
		try {
			String sql = null;
			String email = userModel.getEmail();
			String username = userModel.getUsername();
			String password = userModel.getPassword();
			String phone = userModel.getPhoneNumber();
			String address = userModel.getAddress();
			Timestamp dob = userModel.getDob();
			String university = userModel.getUniversity();
			Integer id = userModel.getId();
			if(StringUtil.makeBeautiful(password).isEmpty()) {
				sql = "UPDATE users SET `email` = ?, `username` = ?, `phone_number` = ?, `address` = ?, `dob` = ?, `university` = ? WHERE (`id` = ?)";
				update(sql, email, username, phone, address, dob, university, id);
			} else {
				sql = "UPDATE users SET `email` = ?, `username` = ?, `password` = ?, `phone_number` = ?, `address` = ?, `dob` = ?, `university` = ? WHERE (`id` = ?)";
				update(sql, email, username, password, phone, address, dob, university, id);
			}
			return true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}
}
