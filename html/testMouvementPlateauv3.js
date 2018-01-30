
(function() {	

	// variables
	var clavier = [ [37, 38, 39, 40], [false, false, false, false] ];
	var mouvement;

	// Creation du plateau

	var plateau ={
			matrice: new Array(),
			hauteur: 14,
			largeur: 9
		};

	for (var i=0; i<=plateau.hauteur; i++) {
		plateau.matrice[i] = new Array();
	}

	for (var i=0; i<=plateau.hauteur; i++) {
		for (var j=0; j<=plateau.largeur; j++) {
			plateau.matrice[i][j] = 0;
		}
	}
	
	afficherPlateauCouleur(plateau.matrice);
	
	//alert(plateau);
	
	function depart() {
		// Creation d'un premier tetrimino
		var tetrimino ={
			matrice: new Array(),
			hauteur: 1,
			largeur: 2,
			topTetri: 0, // hauteur du tetrimino dans le plateau (0 =  haut du plateau)
			leftTetri: 0 // position horizontale du tetrimino dans le plateau
		};
		
		tetrimino.matrice = [[0,1,0],[1,1,1]];

		// Placememt du tetrimino dans le plateau en début de descente 

		for (var i=0; i<=tetrimino.hauteur; i++) {
			for (var j=0; j<=tetrimino.largeur; j++) {
				plateau.matrice[i+tetrimino.topTetri][j] = tetrimino.matrice[i][j];
			}
		}
		
		console.log(plateau.matrice);
		afficherPlateauCouleur(plateau.matrice);
		
		// Lancement du mouvement
		mouvement = setInterval(function(){ mouvementPiece(tetrimino, plateau)}, 3000);
		return mouvement;
		
	}
	
	// départ de la partie
	$('#depart').bind('click', depart);
	
	// Gestion du clavier (touche down et up)
	$(document).keydown(function(e) {
		clavier[e.keyCode] = true;
	});
		

	// Mouvement de la piece
	function mouvementPiece(tetrimino, plateau) {
		
		// Gestion du clavier (touche down et up)
		$(document).keydown(function(e) {
			clavier[e.keyCode] = true;
		});
		
		if (clavier[39] == true) // fleche droite
		{
			console.log("fleche droite activée");
			clavier[39] = false;
			pieceDroite(tetrimino, plateau);
		}
		else if (clavier[37] == true) // fleche gauche
		{
			console.log("fleche gauche activée");
			clavier[37] = false;
			pieceGauche(tetrimino, plateau);
		}
		else if (clavier[38] == true) // fleche haut
		{
			console.log("fleche haut activée");
			clavier[38] = false;
		}
		else if (clavier[40] == true) // fleche bas
		{
			console.log("fleche bas activée = descente rapide");
			clavier[40] = false;
			descentePiece(plateau, tetrimino);
			descentePiece(plateau, tetrimino);	// descente plus rapide : descente de 2 au lieu de 1
		}
		else // descente piece automatique sinon
		{
			console.log("descente normale");
			descentePiece(plateau, tetrimino);
		}
		afficherPlateauCouleur(plateau.matrice);
	}
	
	// Descente du tetrimino

	function descentePiece(plateau, tetrimino) {
		if (tetrimino.topTetri + tetrimino.hauteur <= plateau.hauteur) {
			
			// mise à zero de l'ancien emplacement du tetrimino
			emplacementZero(plateau, tetrimino)
			
			// modif hauteur du tetrimino
			tetrimino.topTetri += 1;
			
			// placement du tetrimino
			placementTetrimino(plateau, tetrimino);
		}
		else {
			clearInterval(mouvement);
			console.log("fin de partie"); // quand la premiere piece est en bas, arret. A modifier apres
		}
		console.log(plateau.matrice);
		return plateau, tetrimino;
	}
	
	function emplacementZero(plateau, tetrimino) {
		// mise à zero de l'ancien emplacement du tetrimino
		for (var i=0; i<=tetrimino.hauteur; i++) {
			for (var j=0; j<=tetrimino.largeur; j++) {
				plateau.matrice[i+tetrimino.topTetri][j+tetrimino.leftTetri] = 0; // à modifier car si autre piece dans le voisinage ça ne fonctionne pas
			}
		}
		return plateau, tetrimino;
	}
	
	function placementTetrimino(plateau, tetrimino) {
		// placement du tetrimino
		for (var i=0; i<=tetrimino.hauteur; i++) {
			for (var j=0; j<=tetrimino.largeur; j++) {
				plateau.matrice[i+tetrimino.topTetri][j+tetrimino.leftTetri] = tetrimino.matrice[i][j]; // à modifier car si autre piece dans le voisinage ça ne fonctionne pas
			}
		}
		return plateau, tetrimino;
	}

	// Piece à droite

	function pieceDroite(plateau, tetrimino) {
		if (tetrimino.leftTetri + 1 + tetrimino.largeur <= plateau.largeur) {
			// mise à zero de l'ancien emplacement du tetrimino
			emplacementZero(plateau, tetrimino)
			
			// modif position horizontale du tetrimino
			tetrimino.leftTetri += 1;
			
			// placement du tetrimino
			placementTetrimino(plateau, tetrimino);
		}
		else {
			descentePiece(plateau, tetrimino);
		}
		console.log(plateau.matrice);
		return plateau, tetrimino;
	}

	// Piece à gauche

	function pieceGauche(plateau, tetrimino) {
		if (tetrimino.leftTetri - 1 >= 0) {
			// mise à zero de l'ancien emplacement du tetrimino
			emplacementZero(plateau, tetrimino)
			
			// modif position horizontale du tetrimino
			tetrimino.leftTetri -= 1;
			
			// placement du tetrimino
			placementTetrimino(plateau, tetrimino);
		}
		else {
			descentePiece(plateau, tetrimino);
		}
		console.log(plateau.matrice);
		return plateau, tetrimino;
	}

})();