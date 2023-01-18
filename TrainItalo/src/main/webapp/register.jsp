<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

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

<!-- SCRIPT -->
	<script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.11.6/dist/umd/popper.min.js" integrity="sha384-oBqDVmMz9ATKxIep9tiCxS/Z9fNfEXiDAYTujMAeBAsjFuCZSmKbSSUnQlmh/jp3" crossorigin="anonymous"></script>
	<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/js/bootstrap.min.js" integrity="sha384-mQ93GR66B00ZXjt0YO5KlohRA5SY2XofN4zfuZxLkoj1gXtW8ANNCe9d5Y3eG5eD" crossorigin="anonymous"></script>
	
<!-- CSS only -->
<link rel="stylesheet" href="./css/style.css">
<link rel="stylesheet" href="./general.css">

<title>TrainViewer</title>
</head>
<body class="bg-white">

<jsp:include page="/menu.jsp"></jsp:include>




	<section class="ms-container">
		<div class="row justify-content-around">
			<div class="card card-login" style="width: 18rem;">
				<img src="img/ITALO_logo.png" class="card-img-top" alt="...">
				<div class="card-body">
					<form id="registration-form" onsubmit="return handleSubmit()"
						action="RegisterServlet" method="POST">
						<label for="username">Nome:</label><br/>
						<input type="text" id="username" name="username" required><br/>
						<label for="username">Cognome:</label><br/>
						<input type="text" id="surname" name="surname" required><br/>
						<label for="email">Email:</label><br/>
						<input type="text" id="email" name="email" required><br/>
						<label for="password">Password:</label><br/>
						<input type="password" id="password" name="password" required><br/>
						<input class="btn-user" type="submit" value="Registrati">
					</form>

				</div>
			</div>
		</div>
	</section>

</body>
</html>


