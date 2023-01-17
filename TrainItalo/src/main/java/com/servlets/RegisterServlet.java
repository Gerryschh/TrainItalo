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

@WebServlet("/RegisterServlet")
public class RegisterServlet extends HttpServlet{
	
	public RegisterServlet() {
		super();
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		UserManager um = new UserManager();
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		String name = request.getParameter("name");
		String surname = request.getParameter("surname");
		User u = new User();
		u.setUserMail(email);
		u.setUserPassword(password);
		u.setUserName(name);
		u.setUserSurname(surname);
		u.setAdmin(false);
		um.addUser(u);
		HttpSession session = request.getSession(true);
		session.setAttribute("email", email);
		session.setAttribute("name", name);
		session.setAttribute("surname", surname);
		session.setAttribute("isAdmin", false);
		
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/index.jsp");
		dispatcher.forward(request, response);
	}
	
	
}