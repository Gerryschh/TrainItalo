<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" import="com.beans.*"%>
	
<%
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
<link rel="stylesheet" href="./general.css">

<!-- SCRIPT -->
	<script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.11.6/dist/umd/popper.min.js" integrity="sha384-oBqDVmMz9ATKxIep9tiCxS/Z9fNfEXiDAYTujMAeBAsjFuCZSmKbSSUnQlmh/jp3" crossorigin="anonymous"></script>
	<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/js/bootstrap.min.js" integrity="sha384-mQ93GR66B00ZXjt0YO5KlohRA5SY2XofN4zfuZxLkoj1gXtW8ANNCe9d5Y3eG5eD" crossorigin="anonymous"></script>
<title>Admin Page</title>
</head>
<body class="bg-white ms-admin-page-body">
	<jsp:include page="/menuLogged.jsp"></jsp:include>
	<div class="ms-container">
		<h2 class="text-center text-white mb-4">ADMIN PAGE ACTIONS</h2>
		<section class="d-flex justify-content-around align-items-center">
			<div id="ms-card-admin" class="card justify-content-around align-items-center">
			  <div class="card-body ms-card-admin d-flex align-items-center">
			    <p class="card-text" id="adminText">Scorri sulla lista delle azioni dell'admin per poter vedere cosa puoi fare.</p>
			    <span class="ms-arrow"><i class="fas fa-arrow-right"></i></span>
			  </div>
			</div>
			<div class="ms-list-admin d-flex justify-content-center align-items-center">
				<ul class="ul-list-admin">
					<li class="li-list-admin" onmouseover="hoverFunction(0)" style="--i:4;"><a href="checkAliases"><span><i class="fas fa-check-square"></i></span>Alias Approval</a></li>
					<li class="li-list-admin" onmouseover="hoverFunction(1)" style="--i:3;"><a href="preInsertTrain"><span><i class="fas fa-train"></i></span>Insert a Train</a></li>
					<li class="li-list-admin" onmouseover="hoverFunction(2)" style="--i:2;"><a href="countryList"><span><i class="fas fa-globe-europe"></i></span>Country List</a></li>
					<li class="li-list-admin" onmouseover="hoverFunction(3)" style="--i:1;"><a href="trainList"><span><i class="fas fa-list"></i></span>Train List</a></li>
				</ul>
			</div>
		</section>
		
	</div>
	<jsp:include page="/fragments/footer.jsp"></jsp:include>
<%
	}
	else {
%>
<jsp:include page="/error404.jsp"></jsp:include>
<%
} 
%>

<script type="text/javascript" src="./generalJS/general.js"></script>
</body>
</html>