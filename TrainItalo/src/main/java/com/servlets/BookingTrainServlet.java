package com.servlets;
import java.io.IOException;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.Collection;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ChainResponsibility.CheckChain;
import com.ChainResponsibility.CheckChainBuilder;
import com.beans.Alias;
import com.beans.Country;
import com.beans.Ticket;
import com.beans.Train;
import com.beans.User;
import com.manager.TicketManager;


@WebServlet("/BookingTrainServlet")
public class BookingTrainServlet extends HttpServlet{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	


	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		HttpSession session = request.getSession(true);
		
		int idTrain = Integer.parseInt(request.getParameter("idTrain"));
		
		String userEmail = request.getParameter("userEmail");
		TicketManager tm = new TicketManager();
		Ticket controlTicket = tm.getTicketByEmailIdTrain(userEmail, idTrain);
		System.out.print("TICKETTTT SERVLETT " + controlTicket);
		if (controlTicket == null) {
			Ticket t = new Ticket();
			Train train = new Train();
			train.setIdTrain(idTrain);
			t.setIdTrain(train);
			User u = new User();
			u.setUserMail(userEmail);
			t.setUserMail(u);
			LocalDateTime now = LocalDateTime.now();
			t.setPurchaseDate(Timestamp.valueOf(now));
			
			tm.addTicket(t);
			
			session.setAttribute("statusBooking", "true");
	
			
		} else {
			session.setAttribute("statusBooking", "false");
		}
		
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/searchingTrain.jsp");
			dispatcher.forward(request, response);
	}

		
		
	
	
}
