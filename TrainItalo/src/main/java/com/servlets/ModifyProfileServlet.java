package com.servlets;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

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
		HttpSession session = request.getSession(true);
		String name = (String) request.getParameter("modifiedUserName");
		System.out.println(name);
		String surname = (String) request.getParameter("modifiedUserSurname");
		System.out.println(surname);
		String birthdateString = request.getParameter("modifiedUserBirthDate");
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		Date birthdate = null;
		try {
			birthdate = format.parse(birthdateString);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		User u = (User) session.getAttribute("user");
		if(u != null) {
			String email = u.getUserMail();
			
			um.updateUser(email, name, surname, birthdate);
			u.setUserName(name);
			u.setUserSurname(surname);
			u.setUserBirthdate(birthdate);
			session.setAttribute("user", u);
			session.setAttribute("userName", name);
			session.setAttribute("modifiedUserBirthDate", birthdateString);
		}
		
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/userSettings.jsp");
		dispatcher.forward(request, response);		
	}
}
