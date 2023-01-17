<nav class="navbar navbar-expand-lg bg-body-tertiary mb-4">
	<div class="container-fluid">
		<a class="navbar-brand" href="/TrainItalo"><span>TrainViewer</span></a>
		<button class="navbar-toggler" type="button" data-bs-toggle="collapse"
			data-bs-target="#navbarNavDropdown" aria-controls="navbarNavDropdown"
			aria-expanded="false" aria-label="Toggle navigation">
			<span class="navbar-toggler-icon"></span>
		</button>
		<div class="collapse navbar-collapse" id="navbarNavDropdown">
		<%
		
		String userName = (String) session.getAttribute("userName");
		Boolean isAdmin = (Boolean) session.getAttribute("isAdmin");
		
		%>
			<ul class="navbar-nav">
				<li class="nav-item"><a class="nav-link" aria-current="page"
					href="/TrainItalo/searchingTrain.jsp"><span>Cerca un Treno</span></a></li>
					
				<li class="nav-item"><a class="nav-link" aria-current="page"
					href="/TrainItalo/trainGame/trainGame.jsp"><span>TrainGame</span></a>
				</li>
			</ul>
			<ul class="navbar-nav flex-row flex-wrap ms-md-auto">
				
					<li class="nav-item nav-link"><span>Benvenuto, <%= userName %></span></li>
					<li class="nav-item nav-link"><div class="vr d-none d-lg-flex h-100 mx-lg-2 text-white"></div><hr class="d-lg-none my-2 text-black-50"></li>
						<div class="btn-group">
						  <button class="btn ms-logout-btn dropdown-toggle" type="button" data-bs-toggle="dropdown" aria-expanded="false">
						    <i class="fas fa-user"></i>
						  </button>
						  <ul class="dropdown-menu dropdown-menu-end">
						    <li><a class="dropdown-item" href="/TrainItalo/userSettings.jsp">User Settings</a></li>
						    <% if (isAdmin) { %> 
						    <li><a class="dropdown-item" href="admin">Admin Page</a></li>
						    <% } %>
						    <li>
						    	<form id="logout-form" action="/TrainItalo/LogoutServlet" method="POST">
								<input class="ms-logout dropdown-item" type="submit" value="Logout"></form></li>
						  </ul>
						</div>
					</li>
				</ul>
		</div>
	</div>
</nav>