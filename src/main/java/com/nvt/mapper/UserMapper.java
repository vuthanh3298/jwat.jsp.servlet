package com.nvt.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.nvt.model.RoleModel;
import com.nvt.model.UserModel;

public class UserMapper implements RowMapper<UserModel> {

	@Override
	public UserModel mapRow(ResultSet resultSet) {
		try {
			UserModel user = new UserModel();
			user.setId(resultSet.getInt("id"));
			user.setEmail(resultSet.getString("email"));
			user.setUsername(resultSet.getString("username"));
			user.setPassword(resultSet.getString("password"));
			user.setPhoneNumber(resultSet.getString("phone_number"));
			user.setAddress(resultSet.getString("address"));
			user.setDob(resultSet.getTimestamp("dob"));
			user.setUniversity(resultSet.getString("university"));
			user.setRoleId(resultSet.getInt("role_id"));
			user.setStatus(resultSet.getInt("status"));
			try {
				RoleModel role = new RoleModel();
				role.setCode(resultSet.getString("code"));
				role.setName(resultSet.getString("name"));
				user.setRole(role);
			} catch (Exception e) {
				System.out.print(e.getMessage());
			}
			return user;
		} catch (SQLException e) {
			return null;
		}	
	}
}
