package com.nvt.controller.admin;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.nvt.utils.DispatcherUtil;

@WebServlet(urlPatterns = { "/admin/thong-bao-deadline"})
public class ThongBaoVaDeadlineController extends HttpServlet{
	private static final long serialVersionUID = 1L;
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		DispatcherUtil.returnViewNameAdminAndSetPageName(req, res, "ThongBaoVaDeadline");
	}

	

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		super.doPost(req, res);
	}

}
