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
		Strategy s = new StrategyDB(); // per la checkChain
		Map<String, List<String>> map= s.dataMap();
		HttpSession session = request.getSession(true);
		
		String factoryName = request.getParameter("train");
		
		
		String departure = toCauntryCase(request.getParameter("departure"));
		String arrival = toCauntryCase(request.getParameter("arrival"));
		
		
		AliasManager am = new AliasManager();
		List<Alias> listAlias = (List<Alias>) am.getAllAliases(); //take all aliases
		for (Alias a : listAlias) {
			if (a.getCountryAlias().equals(departure) && a.isApproved()) { // find it and it is approved
				session.setAttribute("statusDeparture", "true");
				newDeparture = departure;
				continue;
			} else if (a.getCountryAlias().equals(departure) && !a.isApproved()) { //find it but not approved
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
		
		CheckChain chain = CheckChainBuilder.getChain(s);
		if (newDeparture == null) { // the alias was not found, so execute the checkstring
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
	
	//increase the initial letters of the word also composed
	public String toCauntryCase(String country) {
	    String[] arr = country.split(" ");
	    StringBuffer sb = new StringBuffer();

	    for (int i = 0; i < arr.length; i++) {
	        sb.append(Character.toUpperCase(arr[i].charAt(0)))
	            .append(arr[i].substring(1)).append(" ");
	    }          
	    return sb.toString().trim();
	}  


}