
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
	var mouvementAutorisee;
	var nbTetris = 4;

	// Creation du plateau

	var plateau ={
			matrice: new Array(),
			hauteur: 14,
			largeur: 9,
			score: 0,
			nbLignes: 0 
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
	
	function depart() {
		
		// Creation d'un premier tetrimino
		tetrimino = creationTetrimino(tetrimino);
		
		// Placememt du tetrimino dans le plateau en début de descente 
		placementTetrimino(plateau, tetrimino);
		
		//console.log(plateau.matrice);
		afficherPlateauCouleur(plateau.matrice);
		
		// Lancement du mouvement
		mouvement = setInterval(function(){ mouvementPiece(tetrimino, plateau)}, 400);
		return mouvement;
	}
	
	function creationTetrimino(tetrimino) {
		
		tetrimino.rotations = tetri(tetrimino.id);
		tetrimino.rot = 0;
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
		// calcul score et suppression ligne
		var tabScore = verifSupprimerPlusieursLignes(plateau.matrice);
		plateau.score += tabScore[0];
		plateau.nbLignes += tabScore[1];
		afficherScore(plateau.score, plateau.nbLignes);
		
		// Gestion du clavier (touche down et up)
		$(document).keydown(function(e) {
			clavier[e.keyCode] = true;
		});
		
		if (clavier[39] == true) // fleche droite
		{
			//console.log("fleche droite activée");
			clavier[39] = false;
			pieceDroite(tetrimino, plateau);
		}
		else if (clavier[37] == true) // fleche gauche
		{
			//console.log("fleche gauche activée");
			clavier[37] = false;
			pieceGauche(tetrimino, plateau);
		}
		else if (clavier[38] == true) // fleche haut
		{
			//console.log("fleche haut activée");
			clavier[38] = false;
			rotationPiece(plateau, tetrimino);
		}
		else if (clavier[40] == true) // fleche bas
		{
			//console.log("fleche bas activée = descente rapide");
			clavier[40] = false;
			descentePiece(plateau, tetrimino);
			descentePiece(plateau, tetrimino);	// descente plus rapide : descente de 2 au lieu de 1
		}
		else // descente piece automatique sinon
		{
			//console.log("descente normale");
			descentePiece(plateau, tetrimino);
		}
		afficherPlateauCouleur(plateau.matrice);
	}
	
	// Descente du tetrimino

	function descentePiece(plateau, tetrimino) {
		if (tetrimino.topTetri + tetrimino.hauteur < plateau.hauteur) {
			testDescente(plateau, tetrimino);
			if (mouvementAutorisee == true) {
				// mise à zero de l'ancien emplacement du tetrimino
				emplacementZero(plateau, tetrimino);
				
				// modif hauteur du tetrimino
				tetrimino.topTetri += 1;
				
				// placement du tetrimino
				placementTetrimino(plateau, tetrimino);
			}
			else {
				nouvellePiece(plateau, tetrimino)
			}
		}
		else {
			nouvellePiece(plateau, tetrimino)
		}
		return plateau, tetrimino;
	}
	
	function nouvellePiece(plateau, tetrimino) {
		// charge la piece suivante
		tetrimino.id = ((tetrimino.id + 1) % (nbTetris-1)) + 1;
		creationTetrimino(tetrimino);
		
		var tetriTest = testPlacementCreation(plateau, tetrimino);
		var obstacle = [];
		// comparaison
		mouvementAutorisee = true;
		for (var i=0; i<=tetrimino.hauteur; i++) {
			for (var j=0; j<=tetrimino.largeur; j++) {
				if (tetrimino.matrice[i][j]>0 && parseInt(tetrimino.matrice[i][j]) != tetriTest[i][j]) {
					mouvementAutorisee = false;
					obstacle.push(i);
				}
			}
		}
		if (mouvementAutorisee == true)
			placementTetrimino(plateau, tetrimino);
		else {
			var a = obstacle[0];
			var dernierTetri = new Array();
			for (var i=0; i<a; i++) {
				dernierTetri[i] = new Array();
			}
			for (var i=0; i<a; i++) {
				for (var j=0; j<=tetrimino.largeur; j++) {
					dernierTetri[i][j] = tetrimino.matrice[a+i][j];
				}
			}
			for (var i=0; i<a; i++) {
				for (var j=0; j<=tetrimino.largeur; j++) {
					var a = plateau.matrice[i][j];
					var b = dernierTetri[i][j];
					plateau.matrice[i][j] = parseInt(a) + parseInt(b);
				}
			}
			clearInterval(mouvement);
			alert("Fin de la partie");
		}
	}
	
	function emplacementZero(plateau, tetrimino) {
		// suppression du tetrimino
		for (var i=0; i<=tetrimino.hauteur; i++) {
			for (var j=0; j<=tetrimino.largeur; j++) {
				var a = plateau.matrice[i+tetrimino.topTetri][j+tetrimino.leftTetri];
				var b = tetrimino.matrice[i][j];
				plateau.matrice[i+tetrimino.topTetri][j+tetrimino.leftTetri] = parseInt(a) - parseInt(b);
			}
		}
		return plateau, tetrimino;
	}
	
	function placementTetrimino(plateau, tetrimino) {
		// placement du tetrimino
		for (var i=0; i<=tetrimino.hauteur; i++) {
			for (var j=0; j<=tetrimino.largeur; j++) {
				var a = plateau.matrice[i+tetrimino.topTetri][j+tetrimino.leftTetri];
				var b = tetrimino.matrice[i][j];
				plateau.matrice[i+tetrimino.topTetri][j+tetrimino.leftTetri] = parseInt(a) + parseInt(b);
			}
		}
		return plateau, tetrimino;
	}

	// Piece à droite

	function pieceDroite(tetrimino, plateau) {
		if (tetrimino.leftTetri + 1 + tetrimino.largeur <= plateau.largeur) {
			testDroite(plateau, tetrimino);
			if (mouvementAutorisee == true) {
				// mise à zero de l'ancien emplacement du tetrimino
				emplacementZero(plateau, tetrimino);
				// modif position horizontale du tetrimino
				tetrimino.leftTetri += 1;
				// placement du tetrimino
				placementTetrimino(plateau, tetrimino);
			}
			else
				descentePiece(plateau, tetrimino);
		}
		else
			descentePiece(plateau, tetrimino);
		return plateau, tetrimino;
	}

	// Piece à gauche

	function pieceGauche(tetrimino, plateau) {
		if (tetrimino.leftTetri - 1 >= 0) {
			testDroite(plateau, tetrimino);
			if (mouvementAutorisee == true) {
				// mise à zero de l'ancien emplacement du tetrimino
				emplacementZero(plateau, tetrimino)
				// modif position horizontale du tetrimino
				tetrimino.leftTetri -= 1;
				// placement du tetrimino
				placementTetrimino(plateau, tetrimino);
			}
			else
				descentePiece(plateau, tetrimino);
		}
		else
			descentePiece(plateau, tetrimino);
		return plateau, tetrimino;
	}
	
	// Rotation du tetrimino
	
	function rotationPiece(plateau, tetrimino) {
		var modifLeft = false;
		var modifTop = false;
		
		if (tetrimino.hauteur > tetrimino.largeur && tetrimino.largeur + tetrimino.leftTetri == plateau.largeur) { // gestion piece bord droit
			tetrimino.leftTetri -=  tetrimino.hauteur - tetrimino.largeur;
			modifLeft = true;
		}
			
		if (tetrimino.hauteur < tetrimino.largeur && tetrimino.topTetri + tetrimino.hauteur == plateau.hauteur) { // gestion bord inf
			tetrimino.topTetri -= tetrimino.largeur - tetrimino.hauteur;
			modifTop = true;
		}
		
		testRotation(plateau, tetrimino);
		if (mouvementAutorisee == true) {
			// mise à zero de l'ancien emplacement du tetrimino
			emplacementZero(plateau, tetrimino);
			
			// modif du tetrimino
			tetrimino.rot = (tetrimino.rot + 1) % nbTetris;
			tetrimino = propTetrimino(tetrimino);
			
			// placement du tetrimino
			placementTetrimino(plateau, tetrimino);
		}
		else {
			// si piece decalé à gauche pour faire rotation et que la rotation n'a pas été autorisée, on la remet à sa place
			if (modifLeft == true)
				tetrimino.leftTetri +=  tetrimino.hauteur - tetrimino.largeur;
			// si piece montée pour faire rotation et que la rotation n'a pas été autorisée, on la remet à sa place
			if (modifTop == true)
				tetrimino.topTetri += tetrimino.largeur - tetrimino.hauteur;
			descentePiece(plateau, tetrimino); //descente de la pièce dans tout les cas de rotation non autorisée
		}
		
		return plateau, tetrimino;
	}
	
	//Gestion des collisions
	
	function testDescente(plateau, tetrimino) {
		var plateauTest = creationPlateauTest(plateau, tetrimino);
		
		// test de la descente
		var tetriTest = new Array();
		for (var i=0; i<=tetrimino.hauteur; i++) {
			tetriTest[i] = new Array();
		}
		for (var i=0; i<=tetrimino.hauteur; i++) {
			for (var j=0; j<=tetrimino.largeur; j++) {
				var c = plateauTest[i+tetrimino.topTetri+1][j+tetrimino.leftTetri];
				var d = tetrimino.matrice[i][j];
				tetriTest[i][j] = parseInt(c) + parseInt(d);
			}
		}
		
		// comparaison
		mouvementAutorisee = comparaisonTetri(tetrimino, tetriTest);
		return mouvementAutorisee;
	}
	
	function testDroite(plateau, tetrimino) {
		var plateauTest = creationPlateauTest(plateau, tetrimino);
		
		// test de mouvement à droite
		var tetriTest = new Array();
		for (var i=0; i<=tetrimino.hauteur; i++) {
			tetriTest[i] = new Array();
		}
		for (var i=0; i<=tetrimino.hauteur; i++) {
			for (var j=0; j<=tetrimino.largeur; j++) {
				var c = plateauTest[i+tetrimino.topTetri][j+tetrimino.leftTetri+1];
				var d = tetrimino.matrice[i][j];
				tetriTest[i][j] = parseInt(c) + parseInt(d);
			}
		}
		
		// comparaison
		mouvementAutorisee = comparaisonTetri(tetrimino, tetriTest);
		return mouvementAutorisee;
	}
	
	function testGauche(plateau, tetrimino) {
		var plateauTest = creationPlateauTest(plateau, tetrimino);
		
		// test de mouvement à droite
		var tetriTest = new Array();
		for (var i=0; i<=tetrimino.hauteur; i++) {
			tetriTest[i] = new Array();
		}
		for (var i=0; i<=tetrimino.hauteur; i++) {
			for (var j=0; j<=tetrimino.largeur; j++) {
				var c = plateauTest[i+tetrimino.topTetri][j+tetrimino.leftTetri-1];
				var d = tetrimino.matrice[i][j];
				tetriTest[i][j] = parseInt(c) + parseInt(d);
			}
		}
		
		// comparaison
		mouvementAutorisee = comparaisonTetri(tetrimino, tetriTest);
		return mouvementAutorisee;
	}
	
	function testPlacementCreation(plateau, tetrimino) {
		var plateauTest = new Array();
		for (var i=0; i<=plateau.hauteur; i++) {
			plateauTest[i] = new Array();
		}
		for (var i=0; i<=plateau.hauteur; i++) {
			for (var j=0; j<=plateau.largeur; j++) {
				plateauTest[i][j] = plateau.matrice[i][j];
			}
		}
		
		// test placement à la creation
		var tetriTest = new Array();
		for (var i=0; i<=tetrimino.hauteur; i++) {
			tetriTest[i] = new Array();
		}
		for (var i=0; i<=tetrimino.hauteur; i++) {
			for (var j=0; j<=tetrimino.largeur; j++) {
				var c = plateauTest[i][j];
				var d = tetrimino.matrice[i][j];
				tetriTest[i][j] = parseInt(c) + parseInt(d);
			}
		}
		return tetriTest;
	}
	
	function testRotation(plateau, tetrimino) {
		var plateauTest = creationPlateauTest(plateau, tetrimino);
		
		// test de mouvement à droite
		var tetriTest = new Array();
		for (var i=0; i<=tetrimino.largeur; i++) {
			tetriTest[i] = new Array();
		}
		// modif du tetrimino
		rotationTest = (tetrimino.rot + 1) % 4;
		tetriminoMatTest = tetrimino.rotations[rotationTest];
		tetriHauteurTest = tetriminoMatTest.length - 1;
		tetriLargeurTest = tetriminoMatTest[0].length - 1;
		
		for (var i=0; i<=tetriHauteurTest; i++) {
			for (var j=0; j<=tetriLargeurTest; j++) {
				var c = plateauTest[i+tetrimino.topTetri][j+tetrimino.leftTetri];
				var d = tetriminoMatTest[i][j];
				tetriTest[i][j] = parseInt(c) + parseInt(d);
			}
		}
		// comparaison
		mouvementAutorisee = true;
		for (var i=0; i<=tetriHauteurTest; i++) {
			for (var j=0; j<=tetriLargeurTest; j++) {
				if (tetriminoMatTest[i][j]>0 && parseInt(tetriminoMatTest[i][j]) != tetriTest[i][j])
					mouvementAutorisee = false;
			}
		}
		
		return mouvementAutorisee;
		
	}
	
	function creationPlateauTest(plateau, tetrimino) {
		var plateauTest = new Array();
		for (var i=0; i<=plateau.hauteur; i++) {
			plateauTest[i] = new Array();
		}
		for (var i=0; i<=plateau.hauteur; i++) {
			for (var j=0; j<=plateau.largeur; j++) {
				plateauTest[i][j] = plateau.matrice[i][j];
			}
		}
		// calcul du plateau-tetrimino
		for (var i=0; i<=tetrimino.hauteur; i++) {
			for (var j=0; j<=tetrimino.largeur; j++) {
				var a = tetrimino.matrice[i][j];
				var b = plateauTest[i+tetrimino.topTetri][j+tetrimino.leftTetri];
				plateauTest[i+tetrimino.topTetri][j+tetrimino.leftTetri] = parseInt(b) - parseInt(a);
			}
		}
		return plateauTest;
	}
	
	function comparaisonTetri(tetrimino, tetriTest) {
		mouvementAutorisee = true;
		for (var i=0; i<=tetrimino.hauteur; i++) {
			for (var j=0; j<=tetrimino.largeur; j++) {
				if (tetrimino.matrice[i][j]>0 && parseInt(tetrimino.matrice[i][j]) != tetriTest[i][j])
					mouvementAutorisee = false;
			}
		}
		return mouvementAutorisee;
	}

})();