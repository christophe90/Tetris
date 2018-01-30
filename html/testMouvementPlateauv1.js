// départ de la partie
$('#depart').bind('click', depart);

var stop = false;
var clavier = [ [37, 38, 39, 40], [false, false, false, false] ];

// Creation du plateau

var plateau = new Array();

var hauteur = 14;
var largeur = 9;

for (var i=0; i<=hauteur; i++) {
	plateau[i] = new Array();
}

for (var i=0; i<=hauteur; i++) {
	for (var j=0; j<=largeur; j++) {
		plateau[i][j] = 0;
	}
}

// Creation d'un premier tetrimino
var tetrimino1 = new Array();
var tetriHauteur = 1;
var tetriLargeur = 2;
var absTetri = 0;

function depart() {
	tetrimino1 = [[0,1,0],[1,1,1]];

	// Placememt du tetrimino dans le plateau en début de descente 

	for (var i=0; i<=tetriHauteur; i++) {
		for (var j=0; j<=tetriLargeur; j++) {
			plateau[i+absTetri][j] = tetrimino1[i][j];
		}
	}
	
	// Lancement du mouvement
	
	mouvementPiece();
}

// Gestion du clavier (touche down et up)

$(document).keydown(function(e) {
	clavier[e.keyCode] = true;
});


// Mouvement de la piece

function mouvementPiece() { // faire bouger la piece quand pas de clavier
	while (stop ==false) {
		if (clavier[39] == true) // fleche droite
		{
			pieceDroite();
		}
		else if (clavier[37] == true) // fleche gauche
		{
			pieceGauche();
		}
		else if (clavier[38] == true) // fleche haut
		{
		}
		else //if (clavier[40] == true) // fleche bas
		{
			descentePiece(); // implementer une descente plus rapide
		}
		alert(plateau);
	}
}

// Descente du tetrimino

function descentePiece() {
	// mise à zero de l'ancien emplacement du tetrimino
	for (var i=0; i<=tetriHauteur; i++) {
		for (var j=0; j<=tetriLargeur; j++) {
			plateau[i+absTetri][j] = 0; // à modifier car si autre piece dans le voisinage ça ne fonctionne pas
		}
	}
	absTetri += 1; // modif hauteur max du tetrimino
	// placement du nouveau tetrimino
	if (absTetri + tetriHauteur <= tetriHauteur) {
		for (var i=0; i<=tetriHauteur; i++) {
			for (var j=0; j<=tetriLargeur; j++) {
				plateau[i+absTetri][j] = tetrimino1[i][j]; // à modifier car si autre piece dans le voisinage ça ne fonctionne pas
			}
		}
	}
	else
		stop = true; // quand la premiere piece est en bas, arret. A modifier apres
	return plateau, absTetri, stop
}

// Piece à droite

function pieceDroite() {
}

// Piece à gauche

function pieceGauche() {
}
			