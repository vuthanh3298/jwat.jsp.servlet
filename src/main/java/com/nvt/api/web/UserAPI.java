package com.nvt.api.web;

import java.io.IOException;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.nvt.constant.ActionConstant;
import com.nvt.model.CommonModel;
import com.nvt.service.IUserService;
import com.nvt.utils.HttpUtil;

@WebServlet(urlPatterns = {"/api/users"})
public class UserAPI extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		String action = req.getParameter("action");
		if(action != null) {
			if(action.equals(ActionConstant.CHECK_EMAIL_EXIST)) {
				postCheckEmailExist(req, res);
			}
		}
	}

	@Inject
	IUserService userService;
	
	private void postCheckEmailExist(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		CommonModel model = HttpUtil.of(req.getReader()).toModel(CommonModel.class);
		ObjectMapper mapper = new ObjectMapper();
		if(userService.isEmailExist(model.getEmail())) {
			mapper.writeValue(res.getOutputStream(), 1);
		} else {
			mapper.writeValue(res.getOutputStream(), 0);
		}
	}
}
