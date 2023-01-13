package com.servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.beans.User;
import com.manager.UserManager;
import com.strategy.StrategyDB;

@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet{

	public LoginServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		UserManager um = new UserManager();
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		User u = um.getUserByMailAndPsw(email,password);
		HttpSession session = request.getSession(true);
		session.setAttribute("email", email);
		
		if(u != null) {
			session.setAttribute("username", u.getUserName());
			session.setAttribute("isAdmin", u.isAdmin());

			RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/index.jsp");
			dispatcher.forward(request, response);
		} else {
			session.setAttribute("error", "");
			
			RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/login.jsp");
			dispatcher.forward(request, response);
		}
	}


}