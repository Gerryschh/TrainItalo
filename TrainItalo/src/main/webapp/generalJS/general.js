let departureDate = new Date(document.getElementById("inputDepartureHour").value);
console.log(departureDate);
let arrivalDate = new Date(document.getElementById("inputArrivalHour").value);
console.log(arrivalDate);

function checkArrivalDate(e){
		departureDate = new Date(document.getElementById("inputDepartureHour").value);
		console.log(departureDate);
		arrivalDate = new Date(document.getElementById("inputArrivalHour").value);
		console.log(arrivalDate);
		if(departureDate > arrivalDate){
			console.log("sono nell'if");
			document.getElementById("addTrainButton").disabled = true;
			document.getElementById("warningTrainDate").classList.remove("d-none");
		} else {
			document.getElementById("addTrainButton").disabled = false;
			document.getElementById("warningTrainDate").classList.add("d-none");
		}
}
document.getElementById("inputDepartureHour").addEventListener("check", checkArrivalDate)
document.getElementById("inputArrivalHour").addEventListener("check", checkArrivalDate)


function hoverFunction(index){
	const textArray = [
		"Clicca per andare sulla pagina di approvazione degli alias.", 
		"Clicca per andare sulla pagina di inserimento di un treno.", 
		"Clicca per andare sulla pagina di visualizzazione dei paesi presenti.", 
		"Clicca per andare sulla pagina di visualizzazione della lista dei treni presenti."
		];
	document.getElementById("adminText").innerHTML = textArray[index];

}