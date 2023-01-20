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
		String username = request.getParameter("username");
		String surname = request.getParameter("surname");
		HttpSession session = request.getSession(true);
		
		if(email != null && password != null && username != null && surname != null) {
			User u = new User();
			u.setUserMail(email);
			u.setUserPassword(password);
			u.setUserName(username);
			u.setUserSurname(surname);
			u.setAdmin(false);
			u.setTrainGameScore(0);
			um.addUser(u);
			
			session.setAttribute("user", u);
			session.setAttribute("userName", username);
			session.setAttribute("isAdmin", false);

			RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/index.jsp");
			dispatcher.forward(request, response);
		} else {
			session.setAttribute("error", "");
			
			RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/register.jsp");
			dispatcher.forward(request, response);
		}
	}
	
	
}