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

alert(plateau);
console.log(plateau);

// Creation d'un premier tetrimino
var tetrimino1 = new Array();
var tetriHauteur = 2;
var tetriLargeur = 3;

tetrimino1 = [[0,1,0],[1,1,1]];

// Placememt du tetrimino en début de descente

for (var i=0; i<=tetriHauteur; i++) {
	for (var j=0; j<=tetriLargeur; j++) {
		
	}
}