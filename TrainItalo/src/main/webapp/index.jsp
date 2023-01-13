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
<link rel="stylesheet" href="css/style.css">

<title>TrainViewer</title>
</head>
<body class="bg-white">

	<jsp:include page="/menu.jsp"></jsp:include>
	
	<section class="ms-carousel mb-4">
		<div id="carouselExampleAutoplaying" class="carousel slide" id="carousel" data-bs-ride="carousel">
		  <div class="carousel-indicators">
		    <button type="button" data-bs-target="#carouselExampleAutoplaying" data-bs-slide-to="0" class="active" aria-current="true" aria-label="Slide 1"></button>
		    <button type="button" data-bs-target="#carouselExampleAutoplaying" data-bs-slide-to="1" aria-label="Slide 2"></button>
		    <button type="button" data-bs-target="#carouselExampleAutoplaying" data-bs-slide-to="2" aria-label="Slide 3"></button>
		  </div>
		  <div class="carousel-inner">
		    <div class="carousel-item active">
		      <img src="img/hero_desktop_promowe_ventitre_29_12_1366x400.jpg" class="d-block w-100" alt="...">
		    </div>
		    <div class="carousel-item">
		      <img src="img/hero_mobile_offerta_extra_magic_834x550.jpg" class="d-block w-100" alt="...">
		    </div>
		    <div class="carousel-item">
		      <img src="img/hero_mobile_nuove_connessioni_toscana_834x550.jpg" class="d-block w-100" alt="...">
		    </div>
		  </div>
		  <button class="carousel-control-prev" type="button" data-bs-target="#carouselExampleAutoplaying" data-bs-slide="prev">
		    <span class="carousel-control-prev-icon" aria-hidden="true"></span>
		    <span class="visually-hidden">Previous</span>
		  </button>
		  <button class="carousel-control-next" type="button" data-bs-target="#carouselExampleAutoplaying" data-bs-slide="next">
		    <span class="carousel-control-next-icon" aria-hidden="true"></span>
		    <span class="visually-hidden">Next</span>
		  </button>
		</div>
	</section>
	
	<section class="ms-container mb-4">
		<div class="text-center">
			<h2>Offerte</h2>
		
			<p>Scopri le offerte biglietti treno di Italo, risparmia con i codici promo e iscriviti per accedere alle offerte dedicate ai soli clienti Italo Più.</p>
		</div>
		
		<div class="row row-cols-4 justify-content-around">
		
			<div class="card col-4" style="width: 18rem;">
			  <img src="img/gift_card_583x390.jpg" class="card-img-top" alt="...">
			  <div class="card-body">
			    <h5 class="card-title">Iscriviti a Italo Più e scopri le Gift Card, -10% di sconto per te</h5>
			    <p class="card-text">Fino al 9.01.2023 approfitta dello sconto del -10% e regala le Gift Card Italo</p>
			    <a href="#" class="btn ms-btn">Scopri di più</a>
			  </div>
			</div>
			
			<div class="card col-4" style="width: 18rem;">
			  <img src="img/tratta_milano_siena_586x390.jpg" class="card-img-top" alt="...">
			  <div class="card-body">
			    <h5 class="card-title">Collegamenti Milano - Siena da 22,70&#8364;</h5>
			    <p class="card-text">Da Milano a Firenze con Treno Italo Alta Velocità a partire da 12,90&#8364; + treno regionale di Trenitalia da Firenze a Siena a 9,80&#8364;</p>
			    <a href="#" class="btn ms-btn">Acquista subito</a>
			  </div>
			</div>
			
			<div class="card col-4" style="width: 18rem;">
			  <img src="img/carnet_impresa_586x390.jpg" class="card-img-top" alt="...">
			  <div class="card-body">
			    <h5 class="card-title">Carnet Italo Impresa, risparmia sui viaggi di lavoro</h5>
			    <p class="card-text">Massima flessibilità con cambi biglietto gratuiti e illimitati e risparmi fino al 60% sui viaggi di lavoro.</p>
			    <a href="#" class="btn ms-btn">Acquista subito</a>
			  </div>
			</div>
			
			<div class="card col-4" style="width: 18rem;">
			  <img src="img/business_586x390.jpg" class="card-img-top" alt="...">
			  <div class="card-body">
			    <h5 class="card-title">Italo Business Pass, fino al -40% per la tua impresa</h5>
			    <p class="card-text">1.000&#8364; di biglietti Italo al costo di soli 600&#8364;, per viaggiare dove vuoi.</p>
			    <a href="#" class="btn ms-btn">Acquista subito</a>
			  </div>
			</div>
		
		</div>
	</section>
	
	
	
	<section class="ms-container">
	
	<div class="text-center">
		<h2>Novità e informazioni</h2>
	</div>
	
	<div class="ms-news">
	
			<div class="ms-card-container row row-cols-4 justify-content-around">
	        <div class="ms-card col">
	            <div class="face face1">
	                <div class="content">
	                    <img src="img/hotel-solid.png">
	                    <h3>Prenota il tuo hotel con Booking.com</h3>
	                </div>
	            </div>
	            <div class="face face2">
	                <div class="content">
	                    <p>Soggiorna con sconti fino al -50% e guadagna punti Italo Più</p>
	                        <a href="#">Read More</a>
	                </div>
	            </div>
	        </div>
	        <div class="ms-card col">
	            <div class="face face1">
	                <div class="content">
	                    <img src="img/couch-solid.png">
	                    <h3>Scopri le Lounge Italo Club</h3>
	                </div>
	            </div>
	            <div class="face face2">
	                <div class="content">
	                    <p>Comfort e privacy ti aspettano nelle esclusive aree in stazione.</p>
	                        <a href="#">Read More</a>
	                </div>
	            </div>
	        </div>
	        <div class="ms-card col">
	            <div class="face face1">
	                <div class="content">
	                    <img src="img/table-tennis-solid.png">
	                    <h3>Padel Trend Expo ti aspetta a Milano con Italo</h3>
	                </div>
	            </div>
	            <div class="face face2">
	                <div class="content">
	                    <p>Dal 13 al 15 gennaio, la grande community del padel si riunisce all'Allianz MiCo</p>
	                        <a href="#">Read More</a>
	                </div>
	            </div>
	        </div>
	        <div class="ms-card col">
	            <div class="face face1">
	                <div class="content">
	                    <img src="img/train-solid.png">
	                    <h3>Scegli il tuo posto per viaggiare</h3>
	                </div>
	            </div>
	            <div class="face face2">
	                <div class="content">
	                    <p>Scopri come prenotare il tuo posto per viaggiare a bordo di Italo</p>
	                        <a href="#">Read More</a>
	                </div>
	            </div>
	        </div>
	    </div>
    </div>
	
	</section>
	<jsp:include page="/fragments/footer.jsp"></jsp:include>
</body>
</html>