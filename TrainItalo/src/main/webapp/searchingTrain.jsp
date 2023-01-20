<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"
	import="java.util.*,com.beans.*,com.strategy.*, com.manager.*, java.text.*"%>

<%
User currentUser = (User) session.getAttribute("user");
if(currentUser != null)
{

DateFormat dh = new SimpleDateFormat("HH:mm:ss");
DateFormat dd = new SimpleDateFormat("dd/MM/YYY");
TrainFactoryManager fm = new TrainFactoryManager();
List<TrainFactory> factory = (List<TrainFactory>) fm.getAllFactories();%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<!-- FONTAWESOME -->
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.4/css/all.min.css"
	integrity="sha512-1ycn6IcaQQ40/MKBW2W4Rhis/DbILU74C1vSrLJxCq57o941Ym01SwNsOMqvEBFlcgUa6xLiPY/NS5R+E6ztJQ=="
	crossorigin="anonymous" referrerpolicy="no-referrer" />

<!-- Bootstrap -->
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-rbsA2VBKQhggwzxH7pPCaAqO46MgnOM80zW1RWuH61DGLwZJEdK2Kadq2F9CUG65"
	crossorigin="anonymous">
<!-- SCRIPT -->
<script
	src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.11.6/dist/umd/popper.min.js"
	integrity="sha384-oBqDVmMz9ATKxIep9tiCxS/Z9fNfEXiDAYTujMAeBAsjFuCZSmKbSSUnQlmh/jp3"
	crossorigin="anonymous"></script>
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/js/bootstrap.min.js"
	integrity="sha384-mQ93GR66B00ZXjt0YO5KlohRA5SY2XofN4zfuZxLkoj1gXtW8ANNCe9d5Y3eG5eD"
	crossorigin="anonymous"></script>
<script src="./generalJS/searchFlag.js"></script>
<!-- CSS only -->
<link rel="stylesheet" href="css/style.css">
<title>TrainViewer</title>
</head>
<body class="bg-white" onload="loadFlag()">

	<jsp:include page="/menuLogged.jsp"></jsp:include>

	<h1 class="py-4 text-center">Cerca i treni disponibili</h1>
	<section class="ms-container">
		<div class="row justify-content-around">
			<div class="searchCard col-lg-3">
				<div class="card">
					<form id="search-form" action="SearchTrainServlet" method="GET">
						<div class="search-item">
							<label class="col-lg-5" for="train">Treno: </label> <select
								class="inputText col-lg-6" id="idFactory" name="train">
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
							<label class="col-lg-5" for="departure">Partenza: </label> <input
								class="inputText col-lg-6" type="text" id="departure"
								name="departure" required>
						</div>
						<div class="search-item">
							<label class="col-lg-5" for="arrival">Destinazione: </label> <input
								class="inputText col-lg-6" type="text" id="arrival"
								name="arrival" required>
						</div>
						<div class="search-item">
							<input class="btn" type="submit" value="Cerca">
						</div>
					</form>

				</div>
			</div>
			<div class="trainsContainer col-lg-9">
				<%
				String sd = (String) session.getAttribute("statusDeparture");
				String sa = (String) session.getAttribute("statusArrival");
				String departure = (String) session.getAttribute("departure");
				String arrival = (String) session.getAttribute("arrival");
				
				System.out.println("SD -------> " + sd);
				System.out.println("SA -------> " + sa);
				if (sd != null && sa != null) {
					String booking = (String) session.getAttribute("statusBooking");
					System.out.println("BOOKING " + booking);
					if (booking != null) {
						if (booking.equals("true")) { %>
				<div class="ticketInfo col-lg-3">
					<h4><label> BIGLIETTO PRENOTATO </label></h4>		
				</div>
					<% 
						} else { %>
				<div class="warningInfo col-lg-8">
					<h4><label> NON PUOI PRENOTARE, HAI GIA PRENOTATO QUESTO BIGLIETTO </label></h4>	
				</div>
					<% 
						}
						session.setAttribute("statusBooking", null);
					}
					
					if (sd.equals("true") && sa.equals("true")) { // se le parole son state approvate allora faccio vedere i paesi 
						Collection<Train> trains = (Collection<Train>) session.getAttribute("trainList");
						if (trains != null && trains.size() != 0){
							List<Train> listTrain = new ArrayList(trains);
				%>

				<div class="d-none">
					<input id="dep" type="hidden" value="<%=session.getAttribute("departureAlphaCode") %>">
					<input id="arr" type="hidden" value="<%=session.getAttribute("arrivalAlphaCode") %>">
				</div>
				<table class="table table-striped" >
				
					<thead>
						<tr>
							<th scope="col">Codice treno</th>
							<% String factoryName = (String) session.getAttribute("train");
							if (factoryName.equals("none")){ %>
							<th scope="col"></th>
							<% } %>
							<th scope="col">Partenza <img id ="depImg" src= "" width="30" height="30" alt=""></th>
							<th scope="col">Ora/Data Partenza</th>
							<th scope="col">Arrivo <img id ="arrImg" src= "" width="30" height="30" alt=""></th>
							<th scope="col">Ora/Data Arrivo</th>
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
						
						String idString = String.valueOf(id);
						%>
							<td scope="<%= id %>"><%= t.getMatTrain() %></td>
							<% if (factoryName.equals("none")) { 
								if (t.getFactory().getFactoryName().equals("FrecciaRossa")){ %>
							<td><img src="./img/LogoFactory/frecciarossa.png" width="105"
								height="105" alt=""></td>
							<% } else if (t.getFactory().getFactoryName().equals("TreNord")) {%>
							<td><img src="./img/LogoFactory/trenord.png" width="100"
								height="100" alt=""></td>
							<%} else { %>
							<td><img src="./img/LogoFactory/italo.png" width="80"
								height="100" alt=""></td>
								<%} %>

							<%} %>
							<td scope="<%= id %>"><%= t.getDeparture().getCountryName() %></td>
							<td scope="<%= id %>"><%= hourDeparture %></td>
							<td scope="<%= id %>"><%= t.getArrival().getCountryName() %></td>
							<td scope="<%= id %>"><%= hourArrival %></td>
							
							<% if(t.getMatTrain().contains("C")) {%>
							<td scope="<%= id %>"><input id="<%= id %>" class="btn" type="button" value="Prenota" disabled></td>
							<% } else { %>
							<td scope="<%= id %>"><a href="/TrainItalo/BookingTrainServlet?idTrain=<%=idString%>&userEmail=<%=currentUser.getUserMail()%> "><input id="<%= id %>" class="btn"
							type="button" value="Prenota"></a></td>
							<% } %>
							<% i ++; %>
						</tr>

						<% } %>
					</tbody>
				</table>

				<% } else { %>

				<div class="noTrainMsg">
					<h3>
						<label> Nessun treno disponibile per la tratta <%= departure %> - <%= arrival %></label>
					</h3>
				</div>

				<% 		}
			} else { //se non sono approvati allora chiedo
				if (sd.equals("false")) { %>
				<div class="warningInfo col-lg-6">
					<h5>
						
						Forse cercavi come paese di partenza, <strong> <i> <%= departure %>
						</i>
						</strong> ?
					</h5>
				</div>

				<% } 
				if(sa.equals("false")) { %>
				<div class="warningInfo col-lg-6">
					<h5>
						
						Forse cercavi come paese di arrivo, <strong> <i><%= arrival %>
						</i>
						</strong> 
					</h5>
				</div>
				<% }%>
				<% }%>
				<% 
				if(sd == null || sd.equals("invalidate")){ %>

					<div class="noTrainMsg warningInfo col-lg-6">
						<h3> Il paese di partenza inserito non e' stato trovato </h3>
					</div>

				<% 	
					
				}
				
				if(sa == null || sa.equals("invalidate")){%>

				<div class="noTrainMsg warningInfo col-lg-6">
					<h3> Il paese di arrivo inserito non e' stato trovato </h3>
				</div>

				<% 	
					
				}
				%>
				<% } %>
				
			</div>
		</div>

	</section>
	<jsp:include page="/fragments/footer.jsp"></jsp:include>
	<%
	} else {
		%>
	<jsp:include page="/error404.jsp"></jsp:include>
	<%
	}
%>
</body>
</html>
