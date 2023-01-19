<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" import="com.beans.*, com.manager.*, java.util.*, java.text.SimpleDateFormat"%>
	
<%
	User currentUser = (User) session.getAttribute("user");
	if(currentUser != null)
	{
		TicketManager tm = new TicketManager();
		Collection<?> tickets = (Collection<?>) tm.getAllTicketsByMail(currentUser.getUserMail());
		Date birthdate = currentUser.getUserBirthdate();
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		String birthdateString = format.format(birthdate);
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<!-- FONTAWESOME -->
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.4/css/all.min.css" integrity="sha512-1ycn6IcaQQ40/MKBW2W4Rhis/DbILU74C1vSrLJxCq57o941Ym01SwNsOMqvEBFlcgUa6xLiPY/NS5R+E6ztJQ==" crossorigin="anonymous" referrerpolicy="no-referrer" />
<!-- Bootstrap -->
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-rbsA2VBKQhggwzxH7pPCaAqO46MgnOM80zW1RWuH61DGLwZJEdK2Kadq2F9CUG65"
	crossorigin="anonymous">
<!-- CSS only -->
<link rel="stylesheet" href="css/style.css">
<link rel="stylesheet" href="./general.css">

<!-- SCRIPT -->
	<script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.11.6/dist/umd/popper.min.js" integrity="sha384-oBqDVmMz9ATKxIep9tiCxS/Z9fNfEXiDAYTujMAeBAsjFuCZSmKbSSUnQlmh/jp3" crossorigin="anonymous"></script>
	<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/js/bootstrap.min.js" integrity="sha384-mQ93GR66B00ZXjt0YO5KlohRA5SY2XofN4zfuZxLkoj1gXtW8ANNCe9d5Y3eG5eD" crossorigin="anonymous"></script>
<title>User Settings</title>
</head>
<body class="bg-white">
	<jsp:include page="/menuLogged.jsp"></jsp:include>
	
	<h2 class="text-center p-4">USER SETTINGS</h2>
	
	<section class="ms-settings ms-container d-flex row my-4">
		
		<div class="row">
		  <div class="col-4">
		    <div class="list-group ms-setting-list" id="list-tab" role="tablist">
		      <a class="list-group-item list-group-item-action active" id="list-home-list" data-bs-toggle="list" href="#list-home" role="tab" aria-controls="list-home">
			    <div class="d-flex w-100 justify-content-between align-items-center">
			    	<div class="">
				      <h5 class="mb-1">Modifica Profilo</h5>
				      <p class="mb-1">Pagina per la modifica delle infromazioni utente.</p>
				    	<small>Clicca per visualizzare il form</small>
				    </div>
				    <small><i class="fas fa-user"></i></small>
			    </div>
		      </a>
		      <a class="list-group-item list-group-item-action" id="list-profile-list" data-bs-toggle="list" href="#list-profile" role="tab" aria-controls="list-profile">
			    
			    <div class="d-flex w-100 justify-content-between align-items-center">
			    	<div class="">
				      <h5 class="mb-1">Visualizza Biglietti</h5>
				      <p class="mb-1">Pagina per la visualizzazione dei biglietti dello user.</p>
				    	<small>Clicca per visualizzare le lista</small>
				    </div>
				    <small><i class="fas fa-ticket-alt"></i></small>
			    </div>
		      </a>
		      <a class="list-group-item list-group-item-action" id="list-messages-list" data-bs-toggle="list" href="#list-messages" role="tab" aria-controls="list-messages">
			    <div class="d-flex w-100 justify-content-between align-items-center">
			    	<div class="">
				      <h5 class="mb-1">Logout</h5>
				    	<small>Clicca per effettuare il logout</small>
				    </div>
				     <small><i class="fas fa-sign-out-alt"></i></small>
			    </div>
		      </a>
		    </div>
		  </div>
		  <div class="col-8">
		    <div class="tab-content" id="nav-tabContent">
		      <div class="tab-pane fade show active" id="list-home" role="tabpanel" aria-labelledby="list-home-list">
		      	<form action="ModifyProfileServlet" method="POST" class="row g-3">
		      	<div class="col-6">
				    <label for="modifiedUserName" class="form-label">Nome</label>
				    <input type="text" class="form-control" name="modifiedUserName" id="modifiedUserName" value="<%=currentUser.getUserName()%>">
				  </div>
				  <div class="col-6">
				    <label for="modifiedUserSurname" class="form-label">Cognome</label>
				    <input type="text" class="form-control" name="modifiedUserSurname" id="modifiedUserSurname" value="<%=currentUser.getUserSurname()%>">
				  </div>
				  <div class="col-md-6">
				    <label for="email" class="form-label">Email</label>
				    <input type="email" class="form-control" id="email" name="email" value="<%=currentUser.getUserMail()%>" disabled>
				  </div>
				  <div class="col-md-6">
				    <label for="inputPassword4" class="form-label">Password</label>
				    <input type="password" class="form-control" id="inputPassword4" value="*********" disabled>
				  </div>
				  <div class="col-md-12">
				    <label for="modifiedUserBirthDate" class="form-label">Data di nascita</label>
				    <input type="date" class="form-control" name="modifiedUserBirthDate" id="modifiedUserBirthDate" value="<%=birthdateString%>">
				  </div>
				  <div class="col-12 text-center">
				    <button type="submit" class="btn ms-btn">Applica Modifica</button>
				  </div>
				</form>
		      </div>
		      <div class="tab-pane fade" id="list-profile" role="tabpanel" aria-labelledby="list-profile-list">
		      	<table class="table table-striped">
				  <thead>
				    <tr>
				      <th scope="col">#</th>
				      <th scope="col">Mail prenotazione</th>
				      <th scope="col">Paese di partenza</th>
				      <th scope="col">Paese di arrivo</th>
				      <th scope="col">Data di partenza</th>
				      <th scope="col">Data di arrivo</th>
				      <th scope="col">Data d'acquisto</th>
				    </tr>
				  </thead>
				  <tbody>
				    <tr>
				    <%
						if (tickets != null && tickets.size() != 0) {
							Iterator<?> it = tickets.iterator();
							while (it.hasNext()) {
								Ticket t = (Ticket) it.next();
						%>
				      <th scope="row"><%=t.getIdTicket() %></th>
				      <td><%=t.getUserMail().getUserMail() %></td>
				      <td><%=t.getIdTrain().getDeparture().getCountryName() %></td>
				      <td><%=t.getIdTrain().getDepartureDatetime() %></td>
				      <td><%=t.getIdTrain().getArrival().getCountryName() %></td>
				      <td><%=t.getIdTrain().getArrivalDatetime() %></td>
				      <td><%=t.getPurchaseDate()%></td>
				    </tr>
				    <%
					}
					}
					%>
				  </tbody>
				</table>
		      </div>
		      <div class="tab-pane fade" id="list-messages" role="tabpanel" aria-labelledby="list-messages-list">Logout</div>
		    </div>
		  </div>
		</div>
		
		
	</section>
	
	<jsp:include page="/fragments/footer.jsp"></jsp:include>
<%
	}
	else
	{
%>
<jsp:include page="/error404.jsp"></jsp:include>
<%
	}
%>
</body>
</html>