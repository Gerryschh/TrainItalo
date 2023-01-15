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
import com.beans.Alias;
import com.beans.Train;
import com.manager.AliasManager;
import com.manager.TrainManager;
import com.strategy.Strategy;
import com.strategy.StrategyDB;

@WebServlet("/SearchTrainServlet")
public class SearchTrainServlet extends HttpServlet{
	private String newDeparture;
	private String newArrival;

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public SearchTrainServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		Strategy s = new StrategyDB();
		Map<String, List<String>> map= s.dataMap();
		CheckChain chain = CheckChainBuilder.getChain(s);
		HttpSession session = request.getSession(true);
		
		String factoryName = request.getParameter("train");
		
		
		String departure = request.getParameter("departure");
		String arrival = request.getParameter("arrival");
		
		
		AliasManager am = new AliasManager();
		List<Alias> listAlias = (List<Alias>) am.getAllAliases(); //prendo tutti gli alias
		System.out.println("LISTA ALIAS" + listAlias);
		for (Alias a : listAlias) {
			System.out.println(a.getCountryAlias());
			if (a.getCountryAlias().equals(departure) && a.isApproved()) { // se lo trovo ed è approvato
				session.setAttribute("statusDeparture", "true");
				newDeparture = departure;
				continue;
			} else if (a.getCountryAlias().equals(departure) && !a.isApproved()) { //se lo trovo ma non è approvato
				session.setAttribute("statusDeparture", "false");
				newDeparture = departure;
				continue;
			} else if (a.getCountryAlias().equals(arrival) && a.isApproved()) {
				session.setAttribute("statusArrival", "true");
				newArrival = arrival;
				continue;
			} else if (a.getCountryAlias().equals(arrival) && !a.isApproved()) {
				session.setAttribute("statusArrival", "false");
				newArrival = arrival;
				continue;
			}
			
		}
		
		if (newDeparture == null) { // se non è stato trovato l'alias eseguo il checkstring
			session.setAttribute("statusDeparture", "invalidate");
			departure = chain.check(departure);
		} else if (newArrival == null)  {
			session.setAttribute("statusArrival", "invalidate");
			arrival = chain.check(arrival);
		}
		session.setAttribute("departure", departure);
		session.setAttribute("arrival", arrival);
		

		TrainManager tm = new TrainManager();
		Collection<Train> collectionTrains = tm.getTrainsWithParameter(factoryName, departure, arrival);
		session.setAttribute("trainList", collectionTrains);
		
		
		
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/searchingTrain.jsp");
		dispatcher.forward(request, response);
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}


}