
(function() {	

	// variables
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
	
	//alert(plateau);
	
	function depart() {
		// Creation d'un premier tetrimino
		var tetrimino ={
			matrice: new Array(),
			hauteur: 1,
			largeur: 2,
			topTetri: 0 // hauteur du tetrimino dans le tableau (0 =  haut du tableau)
		};
		
		tetrimino.matrice = [[0,1,0],[1,1,1]];

		// Placememt du tetrimino dans le plateau en début de descente 

		for (var i=0; i<=tetrimino.hauteur; i++) {
			for (var j=0; j<=tetrimino.largeur; j++) {
				plateau[i+tetrimino.topTetri][j] = tetrimino.matrice[i][j];
			}
		}
		
		console.log(plateau);
		
		// Lancement du mouvement
		var mouvement = setInterval(function(){ mouvementPiece(tetrimino, plateau)}, 5000);
		
	}
	
	// départ de la partie
	$('#depart').bind('click', depart);
	
	
 	// Gestion du clavier (touche down et up)
	$(document).keydown(function(e) {
		clavier[e.keyCode] = true;
	});


	// Mouvement de la piece
	function mouvementPiece(tetrimino, plateau) { // faire bouger la piece quand pas de clavier
		
		console.log("début mouvement");
		
		if (clavier[39] == true) // fleche droite
		{
			//pieceDroite();
			console.log("fleche droite activée");
			clavier[39] = false;
		}
		else if (clavier[37] == true) // fleche gauche
		{
			//pieceGauche();
			console.log("fleche gauche activée");
			clavier[37] = false;
		}
		else if (clavier[38] == true) // fleche haut
		{
			console.log("fleche haut activée");
			clavier[38] = false;
		}
		else if (clavier[40] == true) // fleche bas
		{
			console.log("fleche bas activée");
			clavier[40] = false;
			//descentePiece(); // implementer une descente plus rapide
		}
		else // descente piece automatique sinon
		{
			console.log("descente normale");
			//descentePiece(); // implementer une descente plus rapide
		}
	}
	
	// Descente du tetrimino

	function descentePiece() {
		// mise à zero de l'ancien emplacement du tetrimino
		for (var i=0; i<=tetrimino.hauteur; i++) {
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

})();