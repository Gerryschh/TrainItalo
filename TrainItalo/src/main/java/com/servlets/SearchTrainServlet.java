package com.servlets;

import java.io.IOException;
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
import com.beans.Train;
import com.manager.AliasManager;
import com.manager.CountryManager;
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
		HttpSession session = request.getSession(true);

		String factoryName = request.getParameter("train");
		String departure = toCauntryCase(request.getParameter("departure"));
		String arrival = toCauntryCase(request.getParameter("arrival"));
		
		session.setAttribute("train", factoryName);

		CountryManager cm = new CountryManager();
		Country countryDeparture =  cm.getCountry(departure);
		Country countryArrival = cm.getCountry(arrival);
		System.out.println("COUNTRY " + countryDeparture);
		
		if (countryDeparture != null) {
			newDeparture = countryDeparture.getCountryName();
			session.setAttribute("departureAlphaCode", countryDeparture.getAlpha2code().toLowerCase());
			session.setAttribute("statusDeparture", "true");
		} else {
			AliasManager am = new AliasManager();
			List<Alias> listAlias = (List<Alias>) am.getAllAliases(); //take all aliases
			session.setAttribute("statusDeparture", "false");
			for (Alias a : listAlias) {
				if (a.getCountryAlias().equals(departure) && a.isApproved()) { // find it and it is approved
					session.setAttribute("statusDeparture", "true");
					newDeparture = a.getCountryName().getCountryName();
					Country cDeparture = cm.getCountry(a.getCountryName().getCountryName());
					session.setAttribute("departureAlphaCode", cDeparture.getAlpha2code().toLowerCase());
					break;
				} else if (a.getCountryAlias().equals(departure) && !a.isApproved()) { //find it but not approved
					session.setAttribute("statusDeparture", "false");
					newDeparture = a.getCountryName().getCountryName();;
					break;
				}
			}

		}
		
		System.out.println("countryArrival = " + countryArrival);

		if (countryArrival != null) { 
			newArrival = countryArrival.getCountryName();
			session.setAttribute("arrivalAlphaCode", countryArrival.getAlpha2code().toLowerCase());
			session.setAttribute("statusArrival", "true");
		} else {
			/*setta arrivo per il check string*/
			AliasManager am = new AliasManager();
			List<Alias> listAlias = (List<Alias>) am.getAllAliases(); //take all aliases
			session.setAttribute("statusArrival", "false");
			for (Alias a : listAlias) {
				if (a.getCountryAlias().equals(arrival) && a.isApproved()) {
					session.setAttribute("statusArrival", "true");
					newArrival = a.getCountryName().getCountryName();
					Country cArrival = cm.getCountry(a.getCountryName().getCountryName());
					session.setAttribute("arrivalAlphaCode", cArrival.getAlpha2code().toLowerCase());
					break;
				} else if (a.getCountryAlias().equals(arrival) && !a.isApproved()) {
					session.setAttribute("statusArrival", "false");
					newArrival = a.getCountryName().getCountryName();
					break;
				}
			}
		}


		System.out.println("NEW DEP" + newDeparture + "NEW ARR "+ newArrival);
		CheckChain chain = CheckChainBuilder.getChain(s);
		if (newDeparture == null) { // the alias was not found, so execute the checkstring
			session.setAttribute("statusDeparture", "invalidate");
			newDeparture = chain.check(departure);
			System.out.println("DEP DOPO CHECKSTRIN " + departure);
			session.setAttribute("departure", departure);
		} else {
			session.setAttribute("departure", newDeparture);
		}
		
		if (newArrival == null)  {
			session.setAttribute("statusArrival", "invalidate");
			newArrival = chain.check(arrival);
			System.out.println("ARR DOPO CHECKSTRING" + arrival);
			session.setAttribute("arrival", arrival);
		} else {
			session.setAttribute("arrival", newArrival);
		}
	
		TrainManager tm = new TrainManager();
		if(factoryName.equals("none")) {
			Collection<Train> collectionTrains = tm.getTrainsWithoutFactory(newDeparture, newArrival);
			session.setAttribute("trainList", collectionTrains);
		} else {
			Collection<Train> collectionTrains = tm.getTrainsWithParameter(factoryName, newDeparture, newArrival);
			session.setAttribute("trainList", collectionTrains);
		}

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