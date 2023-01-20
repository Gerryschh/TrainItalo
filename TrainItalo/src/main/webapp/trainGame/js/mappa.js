// posizione iniziale dell'omino
var ominoX = 0;
var ominoY = 0;

// valore iniziale dell'energia
var energia = 0;

// costanti e parametri per la configurazione del gioco
var PILLOLA = -10;
var NEMICO = -15;
var SFONDO = 0;
var MURO = -20;

var omino = "testa";
var testa = 1;
var direzione = "E";

var pathImg = "/TrainItalo/img/";

// dichiarazione variabili di lavoro
var i = 0;
var j = 0;
var countPillole = 0;

// numero di righe e numero di colonne
var R = 10;
var C = 20;

// definizione id matrice, come array di array
var piano = new Array();

var timer1; 
var timer2; 
var timerTempo; 


function mostraMatriceHTML() {
	var s = '<table border="1" width="50%" heigth="50%">';

	for (var i = 0; i < R; i++) {
		s = s + "<tr>";
		for (var j = 0; j < C; j++) {
			s = s + '<td width="5%" align="center">' + piano[i][j] + '</td>';
		}
		s = s + "</tr>";
	}
	s = s + "</table>";
	document.getElementById("messaggioDebug").innerHTML = s;
}


function play() {
	// var audio = document.getElementById("myAudio");
	// audio.play();
	document.getElementById("frontLeaderboard").style.visibility = "hidden";
	document.getElementById("playButton").disabled = true;
	const pianoDiGioco = document.getElementById("pianoGioco");
	pianoDiGioco.innerHTML = "";
	for (var i = 0; i < R; i++) {
		piano[i] = new Array(); // ogni riga contiene un array: si ha così una matrice
		for (var j = 0; j < C; j++) {
			piano[i][j] = SFONDO; // si assegna un valore di default a tutte le celle
			console.log(piano[i][j]);
		}
	}
	ominoX = 0;
	ominoY = 0;
	testa = 1;
	piano[0][2] = PILLOLA;
	piano[0][4] = PILLOLA;
	piano[0][6] = PILLOLA;
	piano[0][0] = 1;
	piano[8][8] = MURO;
	disegnaPiano();

	timer1 = setInterval("om1.muovi()", 400);
    timer2 = setInterval("om2.muovi()", 600);
    timerTempo = setInterval("timer()", 50); 
}

function disegnaPiano() {
	for (var i = 0; i < R; i++) {
		for (var j = 0; j < C; j++) {
			disegnaCella(i, j);
		}
		const pianoDiGioco = document.getElementById("pianoGioco");
		const br = document.createElement("br");
		pianoDiGioco.append(br);
	}
	// disegna l'omino in una data posizione
	 disegnaCellaSpeciale(ominoX, ominoY, omino);
}

function generaOggetto(valOggetto) {
	// si genera un indice di riga casuale tra 0 e R
	var r = Math.random();
	rx = Math.floor(r * R);
	// si genera un indice di colonna casuale tra 0 e C
	var c = Math.random();
	ry = Math.floor(c * C);
	// utilizzando rx e rc si ha una posizione casuale nel piano di gioco
	if (piano[rx][ry] == SFONDO) {
		piano[rx][ry] = valOggetto; //posiziona oggetto nella matrice
	}
	else {
		//alert("generazione sopra il serpente!");
		generaOggetto(valOggetto);
	}
	// in rx, ry c'è un nuovo valore quindi meglio ridisegnare la cella
	disegnaCella(rx, ry);
}

function disegnaCella(i, j) {
	var id = "c" + i + "_" + j;
	var src = "";
	if (piano[i][j] > 0) {
		src = pathImg + 1 + ".png";
	} else if (piano[i][j] == PILLOLA) {
		src = pathImg + "ticket" + ".png";
	} else if (piano[i][j] == -20) {
		src = pathImg + 3 + ".png";
	}
	else if(piano[i][j] ==NEMICO){
		src = pathImg + 2 + ".png";
	}
	else {
		src = pathImg + "binario1" + ".png";
	}
	const pianoDiGioco = document.getElementById("pianoGioco");
	if (document.getElementById(id)==null) {
		let cella = document.createElement("img");
		cella.src = src;
		cella.id = id;
		pianoDiGioco.append(cella);
	} else {
		let cellaMod = document.getElementById(id);
		cellaMod.src = src;
	}

}

function disegnaCellaSpeciale(i, j, valore) {
	const id = "c" + i + "_" + j;
	const src = pathImg + valore + direzione + ".png";
	console.log(id + " " + src);
	document.getElementById(id).src = src;
} 

let barraWidth = 1000; 

function timer(){
	
	if (barraWidth > 0){
		
		barraWidth-=2; 
    
	    document.getElementById("tempo").innerHTML = barraWidth;
		document.getElementById("tempo").style.width = barraWidth + "px"; 
	
		if (barraWidth < 300 && barraWidth>100) {
			var s = document.getElementById("tempo").style; 
			s.backgroundColor = "#FFA500"; 
		
		} else if (barraWidth <= 100 && barraWidth>0) {
			var s = document.getElementById("tempo").style; 
			s.backgroundColor = "#FF0000"; 
		}
	}
	else if (barraWidth<=0) {
		gameOver(); 
	}
	
	
}

var energiaWidth = 0; 

function incrementaEnergia(){
    energiaWidth = (energiaWidth + 20); 
	barraWidth = (barraWidth + 50);
	if (barraWidth > 1000) {
		barraWidth = 1000;
	}
    
    document.getElementById("energia").innerHTML = energiaWidth;
	document.getElementById("energia").style.width = energiaWidth + "px"; 

}

function nemicoColpito(){

	if (energiaWidth != 0){
		energiaWidth = (energiaWidth - 20)%800; 
	}
    
    document.getElementById("energia").innerHTML = energiaWidth;
	document.getElementById("energia").style.width = energiaWidth + "px"; 

}