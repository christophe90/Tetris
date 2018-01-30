
(function() {	

	// variables
	var clavier = [ [37, 38, 39, 40], [false, false, false, false] ];
	var mouvement;
	var tetrimino;
	var rotations;

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
		tetrimino = creationTetrimino();
		console.log(tetrimino.matrice);
		
		// Placememt du tetrimino dans le plateau en début de descente 
		placementTetrimino(plateau, tetrimino);
		
		console.log(plateau.matrice);
		afficherPlateauCouleur(plateau.matrice);
		
		// Lancement du mouvement
		mouvement = setInterval(function(){ mouvementPiece(tetrimino, plateau)}, 3000);
		return mouvement;
		
	}
	
	function creationTetrimino() {
		
		tetrimino = {
			matrice: new Array(),
			rotations : new Array(),
			rot : 0,
			hauteur: 0,
			largeur: 0,
			topTetri: 0, // hauteur du tetrimino dans le plateau (0 =  haut du plateau)
			leftTetri: 0 // position horizontale du tetrimino dans le plateau
		};
		
		tetrimino.rotations =	[ [[0,1,0], [1,1,1]],
						[[1,0], [1,1], [1,0]],
						[[1,1,1], [0,1,0]],
						[[0,1], [1,1], [0,1]] ];
					
		tetrimino = propTetrimino(tetrimino);
		
		return tetrimino;
	}
	
	function propTetrimino(tetrimino) {
		tetrimino.matrice = tetrimino.rotations[tetrimino.rot];
		tetrimino.hauteur = tetrimino.matrice.length - 1;
		tetrimino.largeur = tetrimino.matrice[0].length - 1;
		return tetrimino;
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
			rotationPiece(plateau, tetrimino);
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
		if (tetrimino.topTetri + tetrimino.hauteur < plateau.hauteur) {
			
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

	function pieceDroite(tetrimino, plateau) {
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

	function pieceGauche(tetrimino, plateau) {
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
	
	// Rotation du tetrimino
	
	function rotationPiece(plateau, tetrimino) {
		// vérifier que avec la rotation, ça ne dépasse pas du bord
		
		if (tetrimino.hauteur > tetrimino.largeur && tetrimino.largeur + tetrimino.leftTetri == plateau.largeur) // gestion piece bord droit
			tetrimino.leftTetri -=1 ;
			
		if (tetrimino.hauteur < tetrimino.largeur && tetrimino.topTetri + tetrimino.hauteur == plateau.hauteur) // gestion bord inf
			tetrimino.topTetri -= 1;
		
		// mise à zero de l'ancien emplacement du tetrimino
		emplacementZero(plateau, tetrimino);
		
		// modif du tetrimino
		tetrimino.rot = (tetrimino.rot + 1) % 4;
		tetrimino = propTetrimino(tetrimino);
		
		// placement du tetrimino
		placementTetrimino(plateau, tetrimino);
		
		console.log(plateau.matrice);
		return plateau, tetrimino;
	}

})();