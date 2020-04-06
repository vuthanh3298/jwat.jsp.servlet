package com.nvt.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.nvt.model.KhoaHocModel;

public class KhoaHocMapper implements RowMapper<KhoaHocModel>{
	@Override
	public KhoaHocModel mapRow(ResultSet rs) {
		try {
			KhoaHocModel khoaHoc = new KhoaHocModel();
			khoaHoc.setName(rs.getString("name"));
			khoaHoc.setDescription(rs.getString("description"));
			khoaHoc.setStartTime(rs.getTimestamp("start_time"));
			khoaHoc.setEndTime(rs.getTimestamp("end_time"));
			khoaHoc.setNote(rs.getString("note"));
			khoaHoc.setStatus(rs.getBoolean("status"));
			khoaHoc.setRs(rs);
			return khoaHoc;
		} catch (SQLException e) {
			return null;
		}
	}
}
