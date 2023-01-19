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
@WebServlet("/TrainGameScoreServlet")
public class TrainGameScoreServlet extends HttpServlet{

	public TrainGameScoreServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		UserManager um = new UserManager();
		String emailUser = request.getParameter("emailUser");
		String scoreGame = request.getParameter("scoreGame");
		int scoreGame2 = Integer.parseInt(scoreGame);
		HttpSession session = request.getSession(true);
		
		um.updateScoreWhenHigher(emailUser, scoreGame2);
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/trainGame/trainGame.jsp");
		dispatcher.forward(request, response);
		
	}


}