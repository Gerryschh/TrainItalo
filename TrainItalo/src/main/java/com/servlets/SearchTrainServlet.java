package com.servlets;

import java.io.IOException;
import java.util.Collection;
import java.util.List;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ChainResponsibility.CheckChain;
import com.ChainResponsibility.CheckChainBuilder;
import com.beans.Train;
import com.strategy.Strategy;
import com.strategy.StrategyDB;

@WebServlet("/SearchTrainServlet")
public class SearchTrainServlet extends HttpServlet{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public SearchTrainServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		StrategyDB s= new StrategyDB();
		//Map<String, List<String>> map= s.dataMap();
		CheckChain chain=CheckChainBuilder.getChain(s);
		
		String id = request.getParameter("train");
		System.out.println("ID " + id);
		
		int idFactory = Integer.parseInt(id);
		
		String departure = request.getParameter("departure");
		System.out.println("DEP " + departure);
		String arrival = request.getParameter("arrival");
		System.out.println("ARR " + arrival);
		String correctDeparture = chain.check(departure);
		System.out.println("STR CORRETTA PART " + correctDeparture);
		String correctArrival = arrival;
		//String correctArrival = chain.check(arrival);
		//System.out.println("STR CORRETTA ARRIV " + correctArrival);
		
		HttpSession session = request.getSession(true);
		
		if(correctDeparture == null) {
			session.setAttribute("errorDeparture", "Paese di partenza inesistente");
		}
		
		if(correctArrival == null) {
			session.setAttribute("errorArrival", "Paese di arrivo inesistente");
		}
		
		if(correctDeparture != null && correctArrival != null) {
			List<Train> collectionTrains = (List<Train>) s.getTrainsWithParameter(idFactory, correctDeparture, correctArrival);
			//System.out.println("LIST TRENI SERVLET " +collectionTrains);
			session.setAttribute("trainList", collectionTrains);
			
		}
		
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/searchingTrain.jsp");
		dispatcher.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}


}