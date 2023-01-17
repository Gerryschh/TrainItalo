<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" 
	import="com.manager.*, com.beans.*, java.util.*, java.text.SimpleDateFormat"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
	
<%
User currentUser = (User) session.getAttribute("user");
if(currentUser != null && currentUser.isAdmin())
{
	TrainFactoryManager tfm = new TrainFactoryManager();
	Collection<?> factories = (Collection<?>) tfm.getAllFactories();
	CountryManager cm = new CountryManager();
	Collection<?> countries = (Collection<?>) cm.getAllCountries();
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
<link rel="stylesheet" href="./general.css">

<!-- SCRIPT -->
	<script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.11.6/dist/umd/popper.min.js" integrity="sha384-oBqDVmMz9ATKxIep9tiCxS/Z9fNfEXiDAYTujMAeBAsjFuCZSmKbSSUnQlmh/jp3" crossorigin="anonymous"></script>
	<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/js/bootstrap.min.js" integrity="sha384-mQ93GR66B00ZXjt0YO5KlohRA5SY2XofN4zfuZxLkoj1gXtW8ANNCe9d5Y3eG5eD" crossorigin="anonymous"></script>
<title>InsertTrain Admin</title>
</head>
<body class="bg-white">
	<jsp:include page="/menuLogged.jsp"></jsp:include>
	<div class="ms-container d-flex justify-content-center my-4">
	<form class="row g-5" action="insertTrain" method="POST">
	  <div class="col-md-8">
    <label for="inputMatricolaTreno" class="form-label">Matricola Treno</label>
    <input type="text" class="form-control" id="inputMatricolaTreno" name="inputMatricolaTreno" placeholder="HCCCPR" required>
  </div>
  <div class="col-md-4">
    <label for="trainFactoryName" class="form-label">Train Brand</label>
    <select id="trainFactoryName" class="form-select" name="trainFactoryName">
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
  <div class="col-md-6">
    <label for="inputDeparture" class="form-label">Partenza</label>
    <select id="inputDeparture" class="form-select" name="inputDeparture">
	    <%
						if (countries != null && countries.size() != 0) {
							Iterator<?> it = countries.iterator();
							while (it.hasNext()) {
								Country c = (Country) it.next();
						%>
	     <option><%=c.getCountryName()%></option>
	     <%
		 }
	     } 
	     %>
    </select>
  </div>
  <div class="col-md-6">
    <label for="inputArrival" class="form-label">Arrivo</label>
    <select id="inputArrival" class="form-select" name="inputArrival">
       <%
						if (countries != null && countries.size() != 0) {
							Iterator<?> it = countries.iterator();
							while (it.hasNext()) {
								Country c = (Country) it.next();
						%>
	     <option><%=c.getCountryName()%></option>
	     <%
		 }
	     } 
	     %>
    </select>
  </div>
  <%
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm");
        Date today = new Date();
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(today);
        calendar.add(Calendar.MINUTE, 30);
        Date later = calendar.getTime();
        %>
        <div class="col-md-6">
          <label for="inputDepartureHour" class="col-sm-2 col-form-label">Data e ora partenza</label>
		    <div>
		      <input onchange="checkArrivalDate()" type="datetime-local" class="form-control" id="inputDepartureHour" name="inputDepartureHour" min="<%=sdf.format(today) %>" value="<%=sdf.format(today) %>" required>
		    </div>
        </div>
		<div class="col-md-6">
			<label for="inputArrivalHour" class="col-sm-2 col-form-label">Data e ora arrivo</label>
		    <div>
		      <input onchange="checkArrivalDate()" type="datetime-local" class="form-control" id="inputArrivalHour" name="inputArrivalHour" min="<%=sdf.format(later) %>" value="<%=sdf.format(later) %>" required>
		    </div>
		</div>
	    <div id="warningTrainDate" class="alert alert-danger d-none" role="alert">
		 	L'inserimento dell'arrivo non pu&ograve; essere precedente alla partenza
		</div>
	  <div class="col-12 text-center">
	    <button id="addTrainButton" type="submit" class="btn ms-btn m-2">Add Train</button>
		  <button type="reset" class="btn ms-btn m-2">Reset Parameters</button>
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
<c:set var="msg" value="${requestScope.msg}"/>
<script>
if("${msg}"!="")
	alert("${msg}");
	
</script>
<script type="text/javascript" src="./generalJS/general.js"></script>

</body>
</html>