package com.servlets;

import java.io.IOException;
import java.util.Collection;
import java.util.Iterator;
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

		/*		
		if (countryDeparture != null) {
			newDeparture = countryDeparture.getCountryName();
			session.setAttribute("statusDeparture", "true");
		} else {
			AliasManager am = new AliasManager();
			List<Alias> listAlias = (List<Alias>) am.getAllAliases(); //take all aliases
			session.setAttribute("statusDeparture", "false");
			for (Alias a : listAlias) {
				if (a.getCountryAlias().equals(departure) && a.isApproved()) { // find it and it is approved
					session.setAttribute("statusDeparture", "true");
					newDeparture = a.getCountryName().getCountryName();;
					break;
				} else if (a.getCountryAlias().equals(departure) && !a.isApproved()) { //find it but not approved
					session.setAttribute("statusDeparture", "false");
					newDeparture = a.getCountryName().getCountryName();;
					break;
				}
			}

		}
		 */
		CheckChain chain = CheckChainBuilder.getChain(s);
		AliasManager am = new AliasManager();
		CountryManager cm = new CountryManager();
		Collection<Country> countryList = cm.getAllCountries();
		boolean trovatoDep = false;
		boolean trovatoArr = false;
		
		String departureRes = chain.check(departure);
		String arrivalRes = chain.check(arrival);
		
		if (countryList != null && countryList.size() != 0) {
			Iterator<?> it = countryList.iterator();
			while (it.hasNext()) {
				Country c = (Country) it.next();
				if(c.getCountryName().equals(departureRes)) {
					trovatoDep = true;
				}
				if(c.getCountryName().equals(arrivalRes)) {
					trovatoArr = true;
				}
			}
		}
		
		if(departureRes != null && !trovatoDep) {
			Alias departureBean = am.getAlias(departureRes);
			if(departureBean != null && departureBean.isApproved()) {
				session.setAttribute("statusDeparture", "true");
			} else {
				session.setAttribute("statusDeparture", "false");
			}
		} else if(trovatoDep) {
			session.setAttribute("statusDeparture", "true");
		} else {
			session.setAttribute("statusDeparture", "invalidate");
		}

		
		if(arrivalRes != null && !trovatoArr) {
			Alias arrivalBean = am.getAlias(arrivalRes);
			if(arrivalBean != null && arrivalBean.isApproved()) {
				session.setAttribute("statusArrival", "true");
			} else {
				session.setAttribute("statusArrival", "false");
			}
		} else if(trovatoArr) {
			session.setAttribute("statusArrival", "true");
		} else {
			session.setAttribute("statusArrival", "invalidate");
		}

		TrainManager tm = new TrainManager();
		if(departureRes != null && arrivalRes != null) {
			if(factoryName.equals("none")) {
				Collection<Train> collectionTrains = tm.getTrainsWithoutFactory(departure, arrival);
				session.setAttribute("trainList", collectionTrains);
			} else {
				Collection<Train> collectionTrains = tm.getTrainsWithParameter(factoryName, departure, arrival);
				session.setAttribute("trainList", collectionTrains);
			}
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