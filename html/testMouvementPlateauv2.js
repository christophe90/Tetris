
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
	
	alert(plateau);
	
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
		
		alert(plateau);
		
		// Lancement du mouvement
		mouvementPiece(tetrimino, plateau);
		
	}
	
	// départ de la partie
	$('#depart').bind('click', depart);
	
	
	// Gestion du clavier (touche down et up)
	$(document).keydown(function(e) {
		clavier[e.keyCode] = true;
	});


	// Mouvement de la piece
	function mouvementPiece(tetrimino, plateau) { // faire bouger la piece quand pas de clavier
		//while (stop ==false) {
			if (clavier[39] == true) // fleche droite
			{
				//pieceDroite();
				alert("fleche droite activée")
			}
			else if (clavier[37] == true) // fleche gauche
			{
				//pieceGauche();
				alert("fleche gauche activée")
			}
			else if (clavier[38] == true) // fleche haut
			{
				alert("fleche haut activée")
			}
			else if (clavier[40] == true) // fleche bas
			{
				alert("fleche bas activée")
				//descentePiece(); // implementer une descente plus rapide
			}
			else // descente piece automatique sinon
			{
				//descentePiece(); // implementer une descente plus rapide
			}
			//alert(plateau);
		//}
	}

})();