<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"
	import="java.util.*,com.beans.*,com.strategy.*, com.manager.*, java.text.*"%>

<%
DateFormat dh = new SimpleDateFormat("HH:mm:ss");
DateFormat dd = new SimpleDateFormat("dd/MM/YYY");
TrainFactoryManager fm = new TrainFactoryManager();
List<TrainFactory> factory = (List<TrainFactory>) fm.getAllFactories();%>

<!DOCTYPE html>
<html>
<head>
	<meta charset="ISO-8859-1">
	<!-- Bootstrap -->
	<link
		href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css"
		rel="stylesheet"
		integrity="sha384-rbsA2VBKQhggwzxH7pPCaAqO46MgnOM80zW1RWuH61DGLwZJEdK2Kadq2F9CUG65"
		crossorigin="anonymous">
	<!-- CSS only -->
	<link rel="stylesheet" href="css/style.css">
	<title>TrainViewer</title>
</head>
<body class="bg-white">

	<%@include file="./menuLogged.jsp"%>
	<h1 class="py-4 text-center">Cerca i treni disponibili</h1>
	<section class="ms-container">
		<div class="row justify-content-around">
			<div class="card searchCard col-lg-3">
				<form id="search-form" action="SearchTrainServlet" method="GET">
					<div class="search-item"> 
						<label class="col-lg-5" for="train">Treno: </label> 
						<select class="col-lg-6" id="idFactory" name="train">
							<option value="none">Nessun treno</option>
							<%
							for(int i = 0; i < factory.size(); i++){  
				 				String factoryName = factory.get(i).getFactoryName();
							%>
				
							<option value="<%=factoryName%>"><%= factoryName %></option>
				
							<% } %>
				
						</select> 
					</div>
					<div class="search-item"> 
						<label class="col-lg-5" for="departure">Partenza: </label> 
						<input class="col-lg-6" type="text" id="departure" name="departure" required> 
					</div>
					<div class="search-item"> 
						<label class="col-lg-5" for="arrival">Destinazione: </label> 
						<input class="col-lg-5" type="text" id="arrival" name="arrival" required>
					</div>
					<div class="search-item"> 
						<input class="btn" type="submit" value="Cerca">
					</div>
				</form>

			</div>
			<%
			String sd = (String) session.getAttribute("statusDeparture");
			String sa = (String) session.getAttribute("statusArrival");
			String departure = (String) session.getAttribute("departure");
			String arrival = (String) session.getAttribute("arrival");
			if (sd != null && sa != null) {
				if (sd.equals("true") && sa.equals("true")) { // se le parole son state approvate allora faccio vedere i paesi 
					Collection<Train> trains = (Collection<Train>) session.getAttribute("trainList");
					if (trains != null && trains.size() != 0){
						List<Train> listTrain = new ArrayList(trains);
			%>
			<div class="trainsContainer col-lg-8">
				<table class="table table-striped">
					<thead>
						<tr>
							<th scope="col">Codice treno</th>
							<th scope="col">Partenza</th>
							<th scope="col">Ora/Data Partenza</th>
							<th scope="col">Arrivo</th>
							<th scope="col">Ora/Data Arrivo</th>
							<th scope="col"></th>
						</tr>
					</thead>
					<tbody>
					<%
					int i = 0;
					while(i < listTrain.size()) {
						Train t = (Train) listTrain.get(i);
						String hourDeparture = dh.format(t.getDepartureDatetime()) + " del " + dd.format(t.getDepartureDatetime());
						String hourArrival = dh.format(t.getArrivalDatetime()) + " del " + dd.format(t.getArrivalDatetime());
					%>
			
						<tr>
						<%
						int id = t.getIdTrain(); 
						%>
							<td scope="<%= id %>"><%= t.getMatTrain() %></td>
							<td scope="<%= id %>"><%= t.getDeparture().getCountryName() %></td>
							<td scope="<%= id %>"><%= hourDeparture %></td>
							<td scope="<%= id %>"><%= t.getArrival().getCountryName() %></td>
							<td scope="<%= id %>"><%= hourArrival %></td>
							<td scope="<%= id %>"><input class="btn" type="button"
							value="Prenota"></td>
							<% i ++; %>
						</tr>
			
					<% } %>
					</tbody>
				</table>
		
		
				<% } else { %>
			<br>
			<br>
			<h3> <label> NESSUN TRENO DISPONIBILE </label> </h3>
			<% 		}
			} else { //se non sono approvati allora chiedo
				if (sd.equals("false")) { %>
			<br>
			<p> Forse cercavi come paese di partenza, <strong> <i> <%= departure %> </i> </strong> ? </p>
			<% } else if(sa.equals("false")) { %>
			<br>
			<p> Forse cercavi come paese di arrivo, <strong> <i><%= arrival %> </i> </strong> ? </p>
			
			<% } else if (sd.equals("invalidate") || sa.equals("invaidate")) { // se sono invalidati (che non esistono negli alias) %>
			<br>
			<br>
			<h3>
				<label> NESSUN TRENO DISPONIBILE </label>
			</h3>
			<% } 
			}
		}%>
			
			<br>
			</div>
		</div>
	
	<jsp:include page="/fragments/footer.jsp"></jsp:include>
	</section>
</body>
</html>


