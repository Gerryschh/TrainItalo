function getBandiere() {
	
	var searchedDeparture = document.getElementById("departure").value;
	var searchedArrival = document.getElementById("arrival").value;
	
	alert("partenza" + searchedDeparture);
	alert("arrivo" + searchedArrival);
}
/*
function onLoad(){
	const dep = document.getElementById("dep").value;
	const arr = document.getElementById("arr").value;
	
	System.out.println("ALPHA CODEE JS= " + alphaCode);
	const xhttp = new XMLHttpRequest();
	
	xhttp.onload = function() {
	
		var result = JSON.parse(this.responseText);
		//alert(result.name);
		return result.flag.png;
	}
	
	xhttp.open("GET", "https://restcountries.com/v2/alpha/" + dep);
	xhttp.open("GET", "https://restcountries.com/v2/alpha/" + arr);
	xhttp.send();
}

function setFlag(){
	document.getElementById("dep").src = onLoad(alpha);
}
*/

function onLoad(alphaCode){
	const xhttp = new XMLHttpRequest();
	
	xhttp.onload = function() {
	
		var result = JSON.parse(this.responseText);
		//alert(result.name);
		document.getElementById("dep").src = result.flags.png;
		document.getElementById("arr").src = result.flags.png;
		//document.getElementById("name").innerHTML = result.name;
	}
	
	xhttp.open("GET", "https://restcountries.com/v2/alpha/" + alphaCode);
	xhttp.send();
}
