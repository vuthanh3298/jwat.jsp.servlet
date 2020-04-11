package com.nvt.controller.admin;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.nvt.constant.ActionConstant;
import com.nvt.utils.DispatcherUtil;

@WebServlet(urlPatterns = { "/admin/thanh-vien", "/admin/thanh-vien-cho-duyet" })
public class ThanhVienController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		String action = req.getParameter("action");
		if (action != null) {
			if (action.equals(ActionConstant.THANH_VIEN)) {
				getThanhVien(req, res);
			} else if (action.equals(ActionConstant.CHO_DUYET)) {
				getChoDuyet(req, res);
			}
		}
	}

	

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		super.doPost(req, res);
	}

	private void getThanhVien(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		DispatcherUtil.returnViewNameAdminAndSetPageName(req, res, "thanhVien");
	}
	
	private void getChoDuyet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		DispatcherUtil.returnViewNameAdminAndSetPageName(req, res, "ChoDuyet");
	}

}
