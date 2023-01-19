function getBandiere() {
	
	var searchedDeparture = document.getElementById("departure").value;
	var searchedArrival = document.getElementById("arrival").value;
	
	alert("partenza" + searchedDeparture);
	alert("arrivo" + searchedArrival);
}

function onLoad(){
	const xhttp = new XMLHttpRequest();
	
	xhttp.onload = function() {
	
		var result = JSON.parse(this.responseText);
		alert(result.name);
		document.getElementById("dep").src = result.flags.png;
		document.getElementById("name").innerHTML = result.name;
	}
	
	xhttp.open("GET", "https://restcountries.com/v2/alpha/us");
	xhttp.send();
}