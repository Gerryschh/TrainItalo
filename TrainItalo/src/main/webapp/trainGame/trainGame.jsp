<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"
	import="java.util.*,com.beans.*,com.strategy.*,com.manager.*"%>
<%
	UserManager um = new UserManager();
	Collection<?> users = (Collection<?>) um.getAllUsers();
	User currentUser = (User) session.getAttribute("user");
	if(currentUser != null) {
		
				
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
<link rel="stylesheet" href="../css/style.css">
<link rel="stylesheet" href="./general.css">
	
	<!-- SCRIPT -->
	<script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.11.6/dist/umd/popper.min.js" integrity="sha384-oBqDVmMz9ATKxIep9tiCxS/Z9fNfEXiDAYTujMAeBAsjFuCZSmKbSSUnQlmh/jp3" crossorigin="anonymous"></script>
	<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/js/bootstrap.min.js" integrity="sha384-mQ93GR66B00ZXjt0YO5KlohRA5SY2XofN4zfuZxLkoj1gXtW8ANNCe9d5Y3eG5eD" crossorigin="anonymous"></script>
<title>TrainGame</title>
</head>
<body id="b01" onkeydown="checkKeyDown(event);" onkeypress="checkKeyPress(event)">
	<jsp:include page="../menuLogged.jsp"></jsp:include>
	<div id="ms-gioco-section" class="container">
		<input type="button" onclick="play()" value="Play" class="btnPlay" id="playButton"></input>
		<!-- <audio id="myAudio" src="audio1/videoplayback.mp3" loop></audio> -->
		<br><br>
		<span id="punteggio"></span>
		<div>
			<div class="rounded-pill" id="energia" style="width:1px; background-color:rgb(0,0,255)">
				<span>0</span>
			</div>
			<br>

			<div class="rounded-pill" id="tempo" style="width:1000px; background-color:rgb(0,255,0)">
				<span>1000</span>
			</div>
		</div>
		<div id="pianoGioco">
			
		</div>
	</div>
	
	<div id="ms-score-section">
	
		<!-- FORM PER L'INVIO DEL PUNTEGGIO AL DB -->
		<form id="score-form" onsubmit="return handleSubmit()" action="../TrainGameScoreServlet" method="POST">
			<label for="usernameGame">Username: </label><br/>
			<input id="usernameGame" name="usernameGame" value="<%=currentUser.getUserName() %>" ></input><br/>
			<label for="emailUser">Email:</label><br/>
			<input id="emailUser" name="emailUser" value="<%=currentUser.getUserMail() %>"></input><br/>
			<label for="scoreGame">Score:</label><br/>
			<input id="scoreGame" name="scoreGame" value="${scoreGame}"></input><br/>
			<input class="btn-user" type="submit" value="Registra punteggio">
		</form>
		<input type="button" onclick="play()" value="Riprova" class="btnPlay"></input>
		
		
		
		<div class="container">
			<h1 class="py-4 text-center">LEADERBOARD</h1>
			<!-- FORM PER LA VISUALIZZAZIONE DELLA LEADERBOARD. INIZIALMENTE LO SCORE DELL'UTENTE NON è VISIBILE.
			 SE L'UTENTE REGISTRA IL PUNTEGGIO BISOGNA RIAGGIORNARE LA LEADERBOARD -->
				<table class="table table-white table-striped">
					<thead>
						<tr>
							<th scope="col">Player</th>
							<th scope="col">Score</th>
						</tr>
					</thead>
					<tbody>
						<tr>
							<% 
								if(users != null && users.size() != 0) {
									Iterator<?> it = users.iterator();
									while(it.hasNext()) {
										User u = (User) it.next();
							%>
							<td><%=u.getUserName()%></td>
							<td><%=u.getTrainGameScore()%></td>
						</tr>
							<%
									}
	
								}
							%>
							
					</tbody>
				</table>
		</div>
	
	</div>


	<jsp:include page="../fragments/footer.jsp"></jsp:include>

	<script type="text/javascript" src="js/mappa.js"></script>
	<script type="text/javascript" src="js/movimento.js"></script>
	
</body>
</html>
<%
			}
%>
