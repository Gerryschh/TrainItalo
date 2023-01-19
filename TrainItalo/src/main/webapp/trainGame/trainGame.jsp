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
<link rel="stylesheet" href="/TrainItalo/css/style.css">
<link rel="stylesheet" href="/TrainItalo/general.css">
	
	<!-- SCRIPT -->
	<script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.11.6/dist/umd/popper.min.js" integrity="sha384-oBqDVmMz9ATKxIep9tiCxS/Z9fNfEXiDAYTujMAeBAsjFuCZSmKbSSUnQlmh/jp3" crossorigin="anonymous"></script>
	<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/js/bootstrap.min.js" integrity="sha384-mQ93GR66B00ZXjt0YO5KlohRA5SY2XofN4zfuZxLkoj1gXtW8ANNCe9d5Y3eG5eD" crossorigin="anonymous"></script>
<title>TrainGame</title>
</head>
<body id="b01" onkeydown="checkKeyDown(event);" onkeypress="checkKeyPress(event)">
	<jsp:include page="../menuLogged.jsp"></jsp:include>
	<div id="ms-gioco-section" class="ms-container">
		<div class="text-center">
		
			<input type="button" onclick="play()" value="Play" class="btnPlay" id="playButton"></input>
			<!-- <audio id="myAudio" src="audio1/videoplayback.mp3" loop></audio> -->
			<br><br>
			<span id="punteggio"></span>
			<div id="counterSection" class="text-center d-flex flex-column align-items-center">
				<span>Punteggio:</span>
				<div class="rounded-pill ms-energy" id="energia">
					<span>0</span>
				</div>
	
				<div class="rounded-pill ms-time" id="tempo">
					<span id="valTempo">1000</span>
				</div>
				<br>
			</div>
			<div id="pianoGioco" style="width: 650px;">
				
			</div>
		
		</div>
		
	</div>
	
	<div id="ms-score-section" class="ms-container d-none">
	
		<div class="ms-loseBanner text-center">
			<h2>Mi dispiace <i class="far fa-frown"></i></h4>
			<span>Puoi salvare il tuo punteggio o ricominciare una nuova partita!</span>
		</div>
		
		<div class="d-flex justify-content-around my-5">
			<div class="col-5 card card-login text-center" style="width: 20rem;">
		
				<!-- FORM PER L'INVIO DEL PUNTEGGIO AL DB -->
				<div id="scoreDiv" class="p-2">
					<form id="scoreForm" action="/TrainItalo/TrainGameScoreServlet" method="POST">
						<label for="usernameGame">Username: </label><br/>
						<input id="usernameGame" name="usernameGame" value="<%=currentUser.getUserName() %>" ></input><br/>
						<label for="emailUser">Email:</label><br/>
						<input id="emailUser" name="emailUser" value="<%=currentUser.getUserMail() %>"></input><br/>
						<label for="scoreGame">Score:</label><br/>
						<input id="scoreGame" name="scoreGame" value="${scoreGame}"></input><br/><br/>
						<input class="btnRegScore" type="submit" value="Registra punteggio">
					</form>
					<br/>
					<a type="button" class="btn ms-restartBtn" href="/TrainItalo/trainGame/trainGame.jsp">Riprova</a>
				</div>
			</div>
			
			<div class="col-7" id="leaderboard">
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
		
			
	</div>


	<jsp:include page="../fragments/footer.jsp"></jsp:include>

	<script type="text/javascript" src="/TrainItalo/trainGame/js/mappa.js"></script>
	<script type="text/javascript" src="/TrainItalo/trainGame/js/movimento.js"></script>
	
</body>
</html>
<%
			}
%>
