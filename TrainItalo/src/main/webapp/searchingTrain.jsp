<%@ page language="java" contentType="text/html; charset=ISO-8859-1"	pageEncoding="ISO-8859-1"	
import="java.util.*,com.beans.*,com.strategy.*, com.manager.*"%>

<%
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
<script src="handlerLogin.js"></script>
<!-- CSS only -->
<link rel="stylesheet" href="css/style.css">
<title>TrainViewer</title>
</head>
<body class="bg-white">

	<%@include file="./menu.jsp"%>
<h1 class="py-4 text-center">Cerca i treni disponibili</h1>
	<section class="ms-container">
		<div class="row justify-content-around">
			<div class="card">
				<form id="login-form" action="SearchTrainServlet" method="GET">
					<label for="train">Treno: </label>
					<select id="idFactory" name="train">
			         <%
			          for(int i = 0; i < factory.size(); i++){  
			        	  String factoryName = factory.get(i).getFactoryName();
			          %>
			          
			          <option value= "<%=factoryName%>"> <%= factoryName %></option>
			            
			          <% 
			          } 
			          %>
				
					</select>
					<label for="departure">Partenza: </label> 
					<input type="text" id="departure" name="departure" required> 
					<label for="arrival">Destinazione: </label> 
					<input type="text" id="arrival" name="arrival" required><br />
					<br>
					<input class="btn-user" type="submit" value="Cerca">
				</form>
					<%
					String sd = (String) session.getAttribute("statusDeparture");
					String sa = (String) session.getAttribute("statusArrival");
					String dep = (String) session.getAttribute("departure");
					String arr = (String) session.getAttribute("arrival");
					if (sd != null && sa != null) {
						if (sd.equals("true") && sa.equals("true")) { // se le parole son state approvate allora faccio vedere i paesi 
							Collection<Train> trains = (Collection<Train>) session.getAttribute("trainList");
							if (trains != null && trains.size() != 0){
								List<Train> listTrain = new ArrayList(trains);
						%>
								<br>
								<br>
								<br>
								<div class="container">
									<table class="table table-striped">
										<thead>
											<tr>
											<th scope="col">Codice treno</th>
											<th scope="col">Partenza</th>
											<th scope="col">Ora Partenza</th>
											<th scope="col">Arrivo</th>
											<th scope="col">Ora Arrivo</th>
											</tr>
											<%
											int i = 0;
											while(i < listTrain.size()) {
												Train t = (Train) listTrain.get(i);
											%>
												
												<tr>
												<%
												int id = t.getIdTrain(); 
												%>
												<td scope="<%= id %>"> <%= t.getMatTrain() %></td>
												<td scope="<%= id %>"> <%= t.getDeparture() %></td>
											    <td scope="<%= id %>"> <%= t.getDepartureDatetime() %> </td>
											    <td scope="<%= id %>"> <%= t.getArrival() %></td>
											    <td scope="<%= id %>"> <%= t.getArrivalDatetime() %></td>
											    <% i ++; %>
											    </tr>

												
											<% 	
											}
											%>
											
						  
											</thead>
										
										</table>
								
									</div>
							
							
							
							<% } else { %>
								<br>
								<br>
								<h3><label> NESSUN TRENO DISPONIBILE </label></h3>
							<% }%>
							
					<%} else { //se non sono approvati allora chiedo
							if (sd.equals("false")) { %>
								<br>
								<label> Forse cercavi per il paese di partenza, <%= dep %> ? </label>
						<% } else if(sa.equals("false")) { %>
								<br>
							    <label> Forse cercavi per il paese di arrivo, <%= arr %> ? </label>
						
						<% } else if (sd.equals("invalidate") || sa.equals("invaidate")) { // se sono invalidati (che non esistono negli alias) %>
								<br>
								<br>
								<h3> <label> NESSUN TRENO DISPONIBILE </label></h3>
						<% } %>
						
				<%} %>
						
		
						
		<%}%>
					
				
			<br>
			</div>
		</div>

		<br>
		<br>
		<br>
		<jsp:include page="/fragments/footer.jsp"></jsp:include>
	</section>

</body>
</html>


