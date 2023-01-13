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
<!-- CSS only -->
<link rel="stylesheet" href="./css/style.css">

<!-- SCRIPT -->
	<script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.11.6/dist/umd/popper.min.js" integrity="sha384-oBqDVmMz9ATKxIep9tiCxS/Z9fNfEXiDAYTujMAeBAsjFuCZSmKbSSUnQlmh/jp3" crossorigin="anonymous"></script>
	<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/js/bootstrap.min.js" integrity="sha384-mQ93GR66B00ZXjt0YO5KlohRA5SY2XofN4zfuZxLkoj1gXtW8ANNCe9d5Y3eG5eD" crossorigin="anonymous"></script>
<title>InsertTrain Admin</title>
</head>
<body class="bg-white">
	<jsp:include page="/menu.jsp"></jsp:include>
	<div class="ms-container d-flex justify-content-center">
		<form action="InsertTrainServlet" method="POST" class="row">
	  <div class="col-12">
	    <label for="inputMatricolaTreno" class="col-sm-2 col-form-label" placeholder="HCCCPR">Matricola Treno</label>
	    <div class="col-sm-10">
	      <input type="text" class="form-control" id="inputMatricolaTreno">
	    </div>
	    <label for="inputDeparture" class="col-sm-2 col-form-label" placeholder="Italia">Partenza</label>
	    <div class="col-sm-10">
	      <input type="text" class="form-control" id="inputDeparture">
	    </div>
	    <label for="inputArrival" class="col-sm-2 col-form-label" placeholder="Spagna">Arrivo</label>
	    <div class="col-sm-10">
	      <input type="text" class="form-control" id="inputArrival">
	    </div>
	  </div>
	  <fieldset class="row mb-3">
	    <legend class="col-form-label col-sm-2 pt-0">Train Brand</legend>
	    <div class="col-sm-10">
	      <div class="form-check">
	        <input class="form-check-input" type="radio" name="gridRadios" id="gridRadios1" value="option1" checked>
	        <label class="form-check-label" for="gridRadios1">
	          TreNord
	        </label>
	      </div>
	      <div class="form-check">
	        <input class="form-check-input" type="radio" name="gridRadios" id="gridRadios2" value="option2">
	        <label class="form-check-label" for="gridRadios2">
	          FrecciaRossa
	        </label>
	      </div>
	    </div>
	  </fieldset>
	  <div class="col-12">
	  <button type="submit" class="btn btn-primary">Add Train</button>
	  </div>
	</form>
</div>
	<jsp:include page="/fragments/footer.jsp"></jsp:include>
</body>
</html>