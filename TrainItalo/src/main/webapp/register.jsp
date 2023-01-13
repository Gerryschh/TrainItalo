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
<script src="handlerRegistrazione.js"></script>
<!-- CSS only -->
<link rel="stylesheet" href="../css/style.css">
<title>TrainViewer</title>
</head>
<body class="bg-white">

	<jsp:include page="/menu.jsp"></jsp:include>

	<form id="registration-form" onsubmit="return handleSubmit()"
		action="../RegisterServlet" method="POST">
		<label for="username">Username:</label> 
		<input type="text" id="username" name="username" required> 
		<label for="email">Email:</label> 
		<input type="text" id="email" name="email" required> 
		<label for="password">Password:</label>
		<input type="password" id="password" name="password" required>
		<input type="submit" value="Registrati">
	</form>

</body>
</html>


