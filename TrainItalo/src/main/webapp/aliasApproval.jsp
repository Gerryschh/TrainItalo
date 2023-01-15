<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"
	import="java.util.*,com.beans.*,com.manager.*"%>

<%
AliasManager am = new AliasManager();
Collection<?> aliases = (Collection<?>) am.getAllUnapprovedAliases();
User currentUser = (User) session.getAttribute("user");
if(currentUser != null && currentUser.isAdmin())
{
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Alias Approval</title>
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
</head>
<body class="bg-white">

	<jsp:include page="/menuLogged.jsp"></jsp:include>

	<div class="container">
		<h1 class="py-4 text-center text-white bg-dark">Alias Table</h1>
		<form action="checkAliases" method="GET">
			<table class="table table-dark table-striped">
				<thead>
					<tr>
						<th scope="col">Alias</th>
						<th scope="col">Country</th>
						<th scope="col">Algorithm</th>
						<th scope="col">Approved</th>
					</tr>
				</thead>
				<tbody>
					<tr>
						<%
						if (aliases != null && aliases.size() != 0) {
							Iterator<?> it = aliases.iterator();
							while (it.hasNext()) {
								Alias a = (Alias) it.next();
						%>
						<td><%=a.getCountryAlias()%></td>
						<td><%=a.getCountryName().getCountryName()%></td>
						<td><%=a.getAlgorithm()%></td>
						<td><input type="checkbox" name="checkAlias"
							value="<%=a.getCountryAlias()%>"></td>
					</tr>
					<%
					}
					}
					%>
				</tbody>
			</table>
			<p class="text-center">
				<input class="btn btn-outline-dark" type="submit" value="Approve">
			</p>
		</form>


	</div>
	<jsp:include page="/fragments/footer.jsp"></jsp:include>
	<%
	}
	else {
%>
<jsp:include page="/error404.jsp"></jsp:include>
<%} %>
</body>
</html>