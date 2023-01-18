package com.servlets;

import java.io.IOException;
import java.sql.Timestamp;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.beans.User;
import com.manager.UserManager;


@WebServlet("/ModifyProfileServlet")
public class ModifyProfileServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	UserManager um = new UserManager();
	
    public ModifyProfileServlet() {
        super();
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String name = (String) request.getAttribute("modifiedUserName");
		String surname = (String) request.getAttribute("modifiedUserSurname");
		Timestamp birthdate = (Timestamp) request.getAttribute("modifiedUserBirthDate");
		User u = (User) request.getAttribute("user");
		
		if(u != null) {
			u.setUserName(name);
			u.setUserSurname(surname);
			u.setUserBirthdate(birthdate);
			um.updateUser(u);
		}
	}
}
