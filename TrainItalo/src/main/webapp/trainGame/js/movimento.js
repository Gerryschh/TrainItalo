//gestione dell'evento onkeydown:
function checkKeyDown(e) {
	e = e || window.event;
	switch (e.keyCode) {
		case 39: destra(); break;
		case 40: giu(); break;
		case 37: sinistra(); break;
		case 38: su(); break;
	}
	//alert ("The Unicode character code is (key down): " + e.keyCode);   
}

// gestione dell'evento onkey press:
function checkKeyPress(event) {
	var chCode = ('charCode' in event) ? event.charCode : event.keyCode;

	switch (chCode) {
		case 100: destra(); break;
		case 115: giu(); break;
		case 97: sinistra(); break;
		case 119: su(); break;
	}
	//alert ("The Unicode character code is (key press): " + chCode);   
}

var biglietto = new Audio("audio1/ka-ching.mp3");
var nemico = new Audio("audio1/kids.mp3");
Audio.prototype.rewindAndPlay = function () {
	this.currentTime = 0.0;
	this.play();
}

function controllaCella(x, y) {
	controllaGameOver(x, y);
	const val = piano[x][y];
	switch (val) {
		case MURO:
			return false;
			break;
		case PILLOLA:
			incrementaEnergia();
			biglietto.rewindAndPlay();
			generaOggetto(PILLOLA);
			testa++;
			piano[x][y] = testa;
			disegnaCella(ominoX, ominoY);  // cancella la testa ridisegnado ciò che c'è nel piano
			ominoX = x;
			ominoY = y;
			disegnaCellaSpeciale(x, y, omino) // disegna la testa nella nuova posizione
			return false;
			break;
		case NEMICO:
			nemico.rewindAndPlay();
			nemicoColpito();
			return false;
			break;
		default:
			if (val > 0) { // toccato il serpente
				alert("Ti sei mangiato le mani, eheheh");
				gameOver();
				return false;
			}
			 else {
				piano[x][y] = testa + 1;
				return true;
			}
	}
}

function gameOver(){
	document.getElementById("punteggio").innerHTML = "Ecco il tuo punteggio:" + energiaWidth;
	document.getElementById("pianoGioco").innerHTML = "hai perso!"; 
	// musichetta di gameOver
	piano = null;
	document.getElementById("ms-gioco-section").setAttribute("d-none");
	document.getElementById("ms-score-section").removeAttribute("d-none");
	clearInterval(timer1); 
	clearInterval(timer2); 
	clearInterval(timerTempo); 
} 


function sposta(daX, daY, aX, aY) {

	if (controllaCella(aX, aY)) {

		var daSrc = "c" + daX + "_" + daY;
		var aSrc = "c" + aX + "_" + aY;

		console.log(daSrc + " " + aSrc);

		for (var i = 0; i < R; i++) {
			for (var j = 0; j < C; j++) {
				if (piano[i][j] > 0) {
					piano[i][j] = piano[i][j] - 1;
					disegnaCella(i, j);
				}
			}
		}
		// cancella l'omino e disegna lo sfondo
		ominoX = aX;
		ominoY = aY;
		mostraMatriceHTML();
		disegnaCellaSpeciale(ominoX, ominoY, omino);
		//disegnaPiano();        // migliorabile 
	}
}

function su() {
	var newX = (ominoX - 1 + R) % R;
	direzione = "N";
	sposta(ominoX, ominoY, newX, ominoY);
}
function giu() {
	var newX = (ominoX + 1 + R) % R;
	direzione = "S";
	sposta(ominoX, ominoY, newX, ominoY);
}

function sinistra() {
	var newY = (ominoY - 1 + C) % C;
	direzione = "W";
	sposta(ominoX, ominoY, ominoX, newY);
}

function destra() {
	var newY = (ominoY + 1 + C) % C;
	direzione = "E";
	sposta(ominoX, ominoY, ominoX, newY);
}

function controllaGameOver(x, y) {
	var check = true;

	check = check && (piano[(ominoX - 1 + R) % R][y] > 0||piano[(ominoX - 1 + R) % R][y] ==NEMICO); // su
	check = check && (piano[(ominoX + 1 + R) % R][y] > 0||piano[(ominoX + 1 + R) % R][y] ==NEMICO); // giu
	check = check && (piano[x][(ominoY - 1 + C) % C] > 0||piano[x][(ominoY - 1 + C) % C] ==NEMICO); // sinistra	
	check = check && (piano[x][(ominoY + 1 + C) % C] > 0||piano[x][(ominoY + 1 + C) % C] ==NEMICO); // destra		
	// check= check &&  (piano[ominoX][ominoY]==NEMICO);
	if (check) {
		alert("Game Over");
	}
}

// costruttore: 
function OggettoInMovimento(x, y, punti, direzione, nome) {
	this.punti = punti;
	this.dir = direzione; // orizzontale
	this.incrementa = true;
	this.x = x;
	this.y = y;
	this.nome = nome;
}


OggettoInMovimento.prototype.muovi = function () {

	//var id = "c" + this.x + "_" + this.y; 
	//var e = document.getElementById(id).src = pathImg + SFONDO + ".jpg" ; 	
	piano[this.x][this.y] = SFONDO;
	disegnaCella(this.x, this.y);
	if (this.dir) {
		if (this.incrementa) { this.x = this.x + 1; }
		else { this.x = this.x - 1; }
		if (this.x == R - 1) { this.incrementa = false; }
		if (this.x == 0) { this.incrementa = true; }
	} else {
		if (this.incrementa) { this.y = this.y + 1; }
		else { this.y = this.y - 1; }
		if (this.y == C - 1) { this.incrementa = false; }
		if (this.y == 0) { this.incrementa = true; }
	}
	piano[this.x][this.y] = NEMICO;
	disegnaCella(this.x, this.y);
	mostraMatriceHTML();
	var id = "c" + this.x + "_" + this.y;
}


var om1 = new OggettoInMovimento(5, 5, 10, true, "blu");
setInterval("om1.muovi()", 600);

var om2 = new OggettoInMovimento(5, 5, 10, false, "blu");
setInterval("om2.muovi()", 600);