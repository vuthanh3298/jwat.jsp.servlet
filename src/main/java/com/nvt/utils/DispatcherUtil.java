package com.nvt.utils;

import java.io.IOException;
import java.util.ResourceBundle;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.nvt.constant.SystemConstant;

public class DispatcherUtil {
	public static ResourceBundle resourceBundle = ResourceBundle.getBundle("page_name");

	public static void returnViewNameAdminAndSetPageName(HttpServletRequest req, HttpServletResponse res, String pageName) throws ServletException, IOException {
		req.setAttribute(SystemConstant.PAGE_NAME, resourceBundle.getString(pageName));
		RequestDispatcher rd = req.getRequestDispatcher("/views/admin/" + pageName + ".jsp");
		rd.forward(req, res);
	}

	public static void returnViewName(HttpServletRequest req, HttpServletResponse res, String pageName) throws ServletException, IOException {
		RequestDispatcher rd = req.getRequestDispatcher("/views" + pageName + ".jsp");
		rd.forward(req, res);
	}
	
	public static void redirect(HttpServletRequest req, HttpServletResponse res, String url) throws ServletException, IOException {
		res.sendRedirect(req.getContextPath() + url);
	}
}
