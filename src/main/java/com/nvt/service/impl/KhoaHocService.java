package com.nvt.service.impl;

import java.util.List;

import javax.inject.Inject;

import com.nvt.dao.IKhoaHocDAO;
import com.nvt.model.KhoaHocModel;
import com.nvt.service.IKhoaHocService;

public class KhoaHocService implements IKhoaHocService {

	@Inject IKhoaHocDAO khoaHoc;
	
	@Override
	public List<KhoaHocModel> findAll() {
		return khoaHoc.findAll();
	}

}
