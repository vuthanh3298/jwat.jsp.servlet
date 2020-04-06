package com.nvt.dao.impl;

import java.util.List;

import com.nvt.dao.IKhoaHocDAO;
import com.nvt.mapper.KhoaHocMapper;
import com.nvt.model.KhoaHocModel;

public class KhoaHocDAO extends AbstractDAO<KhoaHocModel> implements IKhoaHocDAO {
	
	@Override
	public List<KhoaHocModel> findAll() {
		String sql = "select * from courses";
		List<KhoaHocModel> dsKhoaHoc = query(sql, new KhoaHocMapper());
		return dsKhoaHoc;
	}

}
