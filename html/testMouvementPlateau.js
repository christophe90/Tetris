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

tetrimino1 = [[0,1,0],[1,1,1]];

// Placememt du tetrimino dans le plateau en début de descente 

for (var i=0; i<=tetriHauteur; i++) {
	for (var j=0; j<=tetriLargeur; j++) {
		plateau[i+absTetri][j] = tetrimino1[i][j];
	}
}

alert(plateau);
console.log(plateau);

// Gestion du clavier (touche down et up)

var clavier = {}
$(document).keydown(function(e) {
   clavier[e.keyCode] = true;
});
$(document).keyup(function(e) {
   delete clavier[e.keyCode];
});

// Descente du tetrimino
for (var direction in clavier) {
	if (direction == 40) {
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
	}
}