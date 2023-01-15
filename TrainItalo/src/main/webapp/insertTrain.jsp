<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" 
	import="com.manager.*, com.beans.*, java.util.*"%>
	
<%
TrainFactoryManager tfm = new TrainFactoryManager();
Collection<?> factories = (Collection<?>) tfm.getAllFactories();
User currentUser = (User) session.getAttribute("user");
if(currentUser != null && currentUser.isAdmin())
{
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
<link rel="stylesheet" href="./css/style.css">

<!-- SCRIPT -->
	<script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.11.6/dist/umd/popper.min.js" integrity="sha384-oBqDVmMz9ATKxIep9tiCxS/Z9fNfEXiDAYTujMAeBAsjFuCZSmKbSSUnQlmh/jp3" crossorigin="anonymous"></script>
	<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/js/bootstrap.min.js" integrity="sha384-mQ93GR66B00ZXjt0YO5KlohRA5SY2XofN4zfuZxLkoj1gXtW8ANNCe9d5Y3eG5eD" crossorigin="anonymous"></script>
<title>InsertTrain Admin</title>
</head>
<body class="bg-white">
	<jsp:include page="/menuLogged.jsp"></jsp:include>
	<div class="ms-container d-flex justify-content-center">
		<form action="InsertTrainServlet" method="POST" class="row">
	  <div class="col-12">
	    <label for="inputMatricolaTreno" class="col-sm-2 col-form-label">Matricola Treno</label>
	    <div class="col-md-12">
	      <input type="text" class="form-control" id="inputMatricolaTreno" placeholder="HCCCPR" required>
	    </div>
	    <label for="TrainFactoryName" class="col-sm-2 col-form-label">TrainBrand</label>
	    <div class="col-md-12">
	    <select name="TrainFactoryName" id="TrainFactoryName">
	    <%
						if (factories != null && factories.size() != 0) {
							Iterator<?> it = factories.iterator();
							while (it.hasNext()) {
								TrainFactory tf = (TrainFactory) it.next();
						%>
	     <option><%=tf.getFactoryName()%></option>
	     <%
		 }
	     } 
	     %>
	   	</select>
	   	</div>
	    <label for="inputDeparture" class="col-sm-2 col-form-label">Partenza</label>
	    <div class="col-md-12">
	      <input type="text" class="form-control" id="inputDeparture" placeholder="Italia" required>
	    </div>
	    <label for="inputArrival" class="col-sm-2 col-form-label">Arrivo</label>
	    <div class="col-md-12">
	      <input type="text" class="form-control" id="inputArrival" placeholder="Spagna" required>
	    </div>
	    <label for="inputDepartureHour" class="col-sm-2 col-form-label">Data e ora partenza</label>
	    <div class="col-md-12">
	      <input type="datetime-local" class="form-control" id="inputDepartureHour"  min="2023-01-01T00:00" required>
	    </div>
	    <label for="inputArrivalHour" class="col-sm-2 col-form-label">Data e ora Arrivo</label>
	    <div class="col-md-12">
	      <input type="datetime-local" class="form-control" id="inputArrivalHour" min="2023-01-01T00:00" required>
	    </div>
	  </div>
	  <div class="col-12 text-center">
	  <br>
	  <button type="submit" class="btn btn-primary">Add Train</button>
	  </div>
	</form>
</div>
	<br>
	<jsp:include page="/fragments/footer.jsp"></jsp:include>
<%
	}
	else {
%>
<jsp:include page="/error404.jsp"></jsp:include>
<%} %>
</body>
</html>