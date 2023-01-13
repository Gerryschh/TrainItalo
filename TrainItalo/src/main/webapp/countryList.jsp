<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"
	import="java.util.*,com.beans.*,com.strategy.*"%>

<%

Strategy db = new StrategyDB();
Collection<?> countries = (Collection<?>) db.getAllCountries();

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

<!-- SCRIPT -->
	<script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.11.6/dist/umd/popper.min.js" integrity="sha384-oBqDVmMz9ATKxIep9tiCxS/Z9fNfEXiDAYTujMAeBAsjFuCZSmKbSSUnQlmh/jp3" crossorigin="anonymous"></script>
	<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/js/bootstrap.min.js" integrity="sha384-mQ93GR66B00ZXjt0YO5KlohRA5SY2XofN4zfuZxLkoj1gXtW8ANNCe9d5Y3eG5eD" crossorigin="anonymous"></script>
<title>TrainViewer</title>
</head>
<body class="bg-white">

	<%@include file="/menu.jsp" %>

<!-- <jsp:include page="menu.jsp"></jsp:include> -->

	<!-- Table of countries -->

	<div class="container">

		<h1 class="py-4 text-center">Country Table</h1>

		<table class="table table-white table-striped">
			<thead>
				<tr>
					<th scope="col">Country</th>
					<th scope="col">Alpha Code</th>
				</tr>
			</thead>
			<tbody>
				<tr>
					<% 
			if(countries != null && countries.size() != 0) {
				Iterator<?> it = countries.iterator();
				while(it.hasNext()) {
					Country c = (Country) it.next();
		%>
					<td><%=c.getCountryName()%></td>
					<td><%=c.getAlpha2code()%></td>
				</tr>
				<%
			}
	
		}
		%>

			</tbody>
		</table>


	
	</div>
	<jsp:include page="/fragments/footer.jsp"></jsp:include>
</body>
</html>