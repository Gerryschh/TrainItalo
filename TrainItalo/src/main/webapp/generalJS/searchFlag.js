function loadFlag(){
	const dep = document.getElementById("dep").value;
	const arr = document.getElementById("arr").value;
	/*prima*/
	const xhttp = new XMLHttpRequest();
	xhttp.onload = function() {
		var result = JSON.parse(this.responseText);
		document.getElementById("depImg").src = result.flags.png;
	}
	xhttp.open("GET", "https://restcountries.com/v2/alpha/" + dep);
  	xhttp.send();
  	
  	/*seconda*/
  	const xhttp2 = new XMLHttpRequest();
	xhttp2.onload = function() {
	    var result2 = JSON.parse(this.responseText);
	    document.getElementById("arrImg").src = result2.flags.png;
	}
	xhttp2.open("GET", "https://restcountries.com/v2/alpha/" + arr);
	xhttp2.send();
}










