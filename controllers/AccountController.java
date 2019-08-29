package com.bitcamp.controllers;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.bitcamp.serviceimpls.AccountServiceImpl;
import com.bitcamp.services.AccountServcice;

@WebServlet("/account.do")
public class AccountController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	protected void doGet
	(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		AccountServcice service = new AccountServiceImpl();
		String money =request.getParameter("money");
		service.createAccount(money);
		
	}

//	protected void doPost(HttpServletRequest request,
//			HttpServletResponse response) 
//			throws ServletException, IOException {
//		doGet(request, response);
	}

