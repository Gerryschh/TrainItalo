<%@ page language="java" contentType="text/html; charset=ISO-8859-1"	pageEncoding="ISO-8859-1"	
import="java.util.*,com.beans.*,com.strategy.*"%>

<%
Strategy db = new StrategyDB();
List<TrainFactory> factory = (List<TrainFactory>) db.getAllFactories();%>

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

	<%@include file="/menu.jsp"%>
<h1 class="py-4 text-center">Cerca i treni disponibili</h1>
	<section class="ms-container">
		<div class="row justify-content-around">

			<div class="card">
				<form id="login-form" action="SearchTrainServlet" method="GET">
					<label for="train">Treno: </label>
					<select id="idFactory" name="train">
					<%
					for(int i = 0; i < factory.size(); i++){  %>
					<option value= "<%= i %>"> <%= factory.get(i).getFactoryName() %></option>
						
					<% 
					} 
					%>
					
					</select>
					<label for="departure">Partenza: </label> 
					<input type="text" id="departure" name="departure" required> 
					<label for="arrival">Destinazione: </label> 
					<input type="text" id="arrival" name="arrival" required><br />
					<input class="btn-user" type="submit" value="Cerca">
				</form>
				<%
					List<Train> trains = (List<Train>) session.getAttribute("trainList");
					System.out.println("treni jsp " + trains);
					if (trains != null && trains.size() != 0){ 
						System.out.println("Sono dentro");
					%>
							
							<div class="container">
								<table class="table table-striped">
									<thead>
										<tr>
										<th scope="col">Codice treno</th>
										<tr>
										<%
										for (Train t: trains){ 
												int id = t.getIdTrain(); 
										%>
										
											<td scope="<%= id %>"> <%=t.getIdTrain() %></td>
										<%
										}
										%>
									    </tr>
										<th scope="col">Partenza</th>
										<tr>
										<%
										for (Train t: trains){ 
												int id = t.getIdTrain(); 
										%>
										
											<td scope="<%= id %>"> <%= t.getDeparture()%></td>
										<%
										}
										%>
									    </tr>
										<th scope="col">Ora Partenza</th>
										<tr>
										<%
										for (Train t: trains){ 
												int id = t.getIdTrain(); 
										%>
										
											<td scope="<%= id %>"> <%= t.getDepartureDatetime()%> </td>
										<%
										}
										%>
									    </tr>
										<th scope="col">Destinazione</th>
										<tr>
										<%
										for (Train t: trains){ 
												int id = t.getIdTrain(); 
										%>
										
											<td scope="<%= id %>"> <%= t.getArrival()%></td>
										<%
										}
										%>
									    </tr>
										</tr>
										
									    
									    
									    
									     
									    
									    
									</thead>
									<tbody>
									
					
									</tbody>
								</table>
					
							</div>
					<%
					} else{
						String errorD = (String) session.getAttribute("errorDeparture");
						String errorA = (String) session.getAttribute("errorArrival");
						System.out.println("errore dep in jsp " + errorD);
						System.out.println("errore dep in jsp " + errorA);
						if ((errorD != null) || (errorA != null)){
					%>
					<div class="card">
					<br>
					<br>
					<label> ERRORE! PAESE/I NON TROVATI</label>
					</div>
						<% 
						} else { %>
							<br>
							<br>
							<label> NESSUN TRENO DISPONIBILE</label>
						<% }%>
					<%
					}
					%>
			</div>
		</div>


		<jsp:include page="/fragments/footer.jsp"></jsp:include>
	</section>




</body>
</html>


