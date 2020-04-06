package com.nvt.controller;

import java.io.IOException;
import java.util.ResourceBundle;

import javax.inject.Inject;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.nvt.constant.ActionConstant;
import com.nvt.constant.SystemConstant;
import com.nvt.constant.UrlConstant;
import com.nvt.form.UserForm;
import com.nvt.model.UserModel;
import com.nvt.service.impl.UserService;
import com.nvt.utils.FormUtil;
import com.nvt.utils.SessionUtil;

@WebServlet(urlPatterns = { "/login", "/register", "/logout", "/check-session" })
public class SigninSignupController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Inject
	UserService userService;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		String action = req.getParameter("action");
		if (action != null) {
			if (action.equals(ActionConstant.REGISTER)) {
				getRegister(req, res);
				return;
			} else if (action.equals(ActionConstant.LOGIN)) {
				getLogin(req, res);
				return;
			} else if (action.equals(ActionConstant.LOGOUT)) {
				getLogout(req, res);
				return;
			} else if (action.equals(ActionConstant.CHECK_SESSION)) {
				getCheckSession(req, res);
				return;
			}
		}
	}

	

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		String action = req.getParameter("action");
		if (action != null) {
			if (action.equals(ActionConstant.LOGIN)) {
				postLogin(req, res);
				return;
			} 
		}
	}
	
	

	ResourceBundle resourceBundle = ResourceBundle.getBundle("message");
	
	private void setMessageLogin(HttpServletRequest req) {
		String message = req.getParameter("message");
		if (message != null) {
			String alert = req.getParameter("alert");
			req.setAttribute("message", resourceBundle.getString(message));
			req.setAttribute("alert", alert);
		}
	}
	
	private void getLogin(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		setMessageLogin(req);
		RequestDispatcher rd = req.getRequestDispatcher("/views/login.jsp");
		rd.forward(req, res);
	}
	
	private void getRegister(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		RequestDispatcher rd = req.getRequestDispatcher("/views/register.jsp");
		rd.forward(req, res);
	}
	
	private void getLogout(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		SessionUtil.getInstance().removeValue(req, "USERMODEL");
		res.sendRedirect(req.getContextPath() + UrlConstant.LOGIN);
	}
	
	private void getCheckSession(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		UserModel userModel = (UserModel) SessionUtil.getInstance().getValue(req, SessionUtil.USERMODEL);
		if (userModel != null) {
			if (userModel.getRole().getCode().equals(SystemConstant.USER_ROLE)) {
				res.sendRedirect(req.getContextPath() + "/trang-chu");
			} else if (userModel.getRole().getCode().equals(SystemConstant.ADMIN_ROLE)) {
				res.sendRedirect(req.getContextPath() + "/admin/trang-chu");
			}
		} else {
			res.sendRedirect(req.getContextPath() + "/login?action=login");
		}
	}
	
	
	
	private void postLogin(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		UserForm userForm = FormUtil.toModel(UserForm.class, req);
		UserModel userModel = userService.findByEmailAndPasswordAndStatus(userForm.getEmail(), userForm.getPassword(), 1);
		if (userModel != null) {
			SessionUtil.getInstance().putValue(req, "USERMODEL", userModel);
			if (userModel.getRole().getCode().equals(SystemConstant.USER_ROLE)) {
				res.sendRedirect(req.getContextPath() + "/trang-chu");
			} else if (userModel.getRole().getCode().equals(SystemConstant.ADMIN_ROLE)) {
				res.sendRedirect(req.getContextPath() + "/admin/trang-chu");
			}
		} else {
			res.sendRedirect(req.getContextPath() + "/login?action=login&message=username_password_invalid&alert=danger");
		}
	}
}
