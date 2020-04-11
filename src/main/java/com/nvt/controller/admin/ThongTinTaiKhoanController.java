package com.nvt.controller.admin;

import java.io.IOException;
import java.util.ResourceBundle;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.nvt.constant.SystemConstant;
import com.nvt.model.UserModel;
import com.nvt.service.IUserService;
import com.nvt.utils.DispatcherUtil;
import com.nvt.utils.FormUtil;
import com.nvt.utils.SessionUtil;
@WebServlet(urlPatterns = { "/admin/thong-tin-tai-khoan"})
public class ThongTinTaiKhoanController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	@Inject
	IUserService userService;
	
	ResourceBundle resourceBundle = ResourceBundle.getBundle("message");
	
	private void setMessage(HttpServletRequest req) {
		String message = req.getParameter("message");
		if (message != null) {
			String alert = req.getParameter("alert");
			req.setAttribute("message", resourceBundle.getString(message));
			req.setAttribute("alert", alert);
		}
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		setMessage(req);
		DispatcherUtil.returnViewNameAdminAndSetPageName(req, res, "ThongTinTaiKhoan");
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		UserModel userModel = FormUtil.toModel(UserModel.class, req);
		if(userService.update(userModel)) {
			UserModel user = userService.findOne(userModel.getId());
			SessionUtil.getInstance().putValue(req, SystemConstant.MODEL, user);
			DispatcherUtil.redirect(req, res, "/admin/thong-tin-tai-khoan?message=update_thanh_cong&alert=success");
		} else {
			DispatcherUtil.redirect(req, res, "/admin/thong-tin-tai-khoan?message=update_that_bai&alert=warning");
		}
	}
}
