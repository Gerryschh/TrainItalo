<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

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

<jsp:include page="menu.jsp"></jsp:include>


<%
if(session.getAttribute("email") != null && session.getAttribute("error") != null){
	%>
	<script> alert("Le credenziali inserite sono errate. ");</script>
	<%	
	session.removeAttribute("error");
} 
%>



<section class="ms-container">
		<div class="row justify-content-around">
		
			<div class="card card-login" style="width: 18rem;">
			  <img src="img/ITALO_logo.png" class="card-img-top" alt="...">
			  <div class="card-body">
			  	<form id="login-form" onsubmit="return handleSubmit()" action="LoginServlet" method="POST">
					<label for="email">Email:</label><br/>
					<input type="text" id="email" name="email" required><br/>
					<label for="password">Password:</label><br/>
					<input type="password" id="password" name="password" required><br/>
	
					<input class="btn-user" type="submit" value="Accedi">
				</form>
				
				<span>Se non sei registrato, <a href="/TrainViewer/signup/register.jsp">clicca qui!</a></span>
			  </div>
			</div>
		</div>
</section>




</body>
</html>

	
