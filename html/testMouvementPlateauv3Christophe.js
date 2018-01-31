
(function() {	

	// variables
	var clavier = [ [37, 38, 39, 40], [false, false, false, false] ];
	var mouvement;
	var tetrimino = {
			id : 1,
			matrice : new Array(),
			rotations : new Array(),
			rot : 0,
			hauteur: 0,
			largeur: 0,
			topTetri: 0, // hauteur du tetrimino dans le plateau (0 =  haut du plateau)
			leftTetri: 0 // position horizontale du tetrimino dans le plateau
		};
	var collision = false;

	// Creation du plateau

	var plateau ={
			matrice: new Array(),
			hauteur: 14,
			largeur: 9,
			score: 0	//-------------------------------------------------------------------------------------------------- modif Christophe
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
		tetrimino = creationTetrimino(tetrimino);
		console.log(tetrimino.matrice);
		
		// Placememt du tetrimino dans le plateau en début de descente 
		placementTetrimino(plateau, tetrimino);
		
		console.log(plateau.matrice);
		afficherPlateauCouleur(plateau.matrice);
		
		// Lancement du mouvement
		mouvement = setInterval(function(){ mouvementPiece(tetrimino, plateau)}, 300);
		return mouvement;
		
	}
	
	function creationTetrimino(tetrimino) {
		
		tetrimino.rotations = tetri(tetrimino.id);
		tetrimino = propTetrimino(tetrimino);
		tetrimino.leftTetri = 0;
		tetrimino.topTetri = 0;
		
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
		
		plateau.score += verifSupprimerPlusieursLignes(plateau.matrice);	//---------------------------------------------- modif Christophe
		afficherScore(plateau.score);	//---------------------------------------------------------------------------------- modif Christophe
		
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
		

		console.log("descente normale"); //----------------------------------------------------------------- modif Christophe: suppression du else
		descentePiece(plateau, tetrimino);

		afficherPlateauCouleur(plateau.matrice);
	}
	
	// Descente du tetrimino

	function descentePiece(plateau, tetrimino) {
		
		if (tetrimino.topTetri + tetrimino.hauteur < plateau.hauteur) {
			
			collision = collisionBas(plateau, tetrimino);
			console.log(collision);
			
			if (collision == false) {
				
				// mise à zero de l'ancien emplacement du tetrimino
				emplacementZero(plateau, tetrimino)
				
				// modif hauteur du tetrimino
				tetrimino.topTetri += 1;
				
				// placement du tetrimino
				placementTetrimino(plateau, tetrimino);
			}
			else {
				
				// charge la piece suivante
				tetrimino.id = ((tetrimino.id + 1) % 3) + 1;
				creationTetrimino(tetrimino);
			}
		}
		else {
			
			// charge la piece suivante
			tetrimino.id = ((tetrimino.id + 1) % 3) + 1;
			creationTetrimino(tetrimino);
		}
		console.log(plateau.matrice);
		collision = false;
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
		// mise à zero de l'ancien emplacement du tetrimino
		emplacementZero(plateau, tetrimino);
		
		if (tetrimino.hauteur > tetrimino.largeur && tetrimino.largeur + tetrimino.leftTetri == plateau.largeur) // gestion piece bord droit
			tetrimino.leftTetri -=  tetrimino.hauteur - tetrimino.largeur;
			
		if (tetrimino.hauteur < tetrimino.largeur && tetrimino.topTetri + tetrimino.hauteur == plateau.hauteur) // gestion bord inf
			tetrimino.topTetri -= tetrimino.largeur - tetrimino.hauteur;
		
		// modif du tetrimino
		tetrimino.rot = (tetrimino.rot + 1) % 4;
		tetrimino = propTetrimino(tetrimino);
		
		// placement du tetrimino
		placementTetrimino(plateau, tetrimino);
		
		console.log(plateau.matrice);
		return plateau, tetrimino;
	}
	
	// Gestion Collisions
	
	function collisionBas(plateau, tetrimino) {
		var emplacement2 = Array();
		for (var j=0; j<=tetrimino.largeur; j++) {
			emplacement2[j] = plateau.matrice[tetrimino.topTetri+tetrimino.hauteur+1][j+tetrimino.leftTetri];
			if (emplacement2[j]>0 && tetrimino.matrice[tetrimino.hauteur][j]>0) {
				collision = true;
			}
		}
		return collision;
	}

})();