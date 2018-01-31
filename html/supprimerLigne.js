
/*------------------------------------------------------------------------- Fonctions ----------------------------------------------------------------------*/

// verifie toutes les lignes du plateau et supprime toutes les lignes complètes
function verifSupprimerPlusieursLignes(plateau) {
	
	var count = 0;
	var score = 0;
	
	for (let i=plateau.length-1; i>=0; i--) {
		while (verifLigneComplete(plateau, i)) {
			var nouveauPlateau =  verifSupprimerLigne(plateau, i);
			plateau = nouveauPlateau;
			count++;
		}
	}
	
	if (count==1)
		score = 40;
	else if (count==2)
		score = 100;
	else if (count==3)
		score = 300;
	else if (count>=4)
		score = 1200;
	
	return score;
}

// Fonction qui vérifie pour une ligne donnee (numérotées de 0 à 14) si elle est complete, et la supprime le cas échéant. Elle retourne le plateau modifié
function verifSupprimerLigne(plateau, numeroLigne) {
	
	// Initialisation du tableau plateauTransforme
	
	var plateauTransforme = new Array();

	var largeur = plateau[0].length;
	var hauteur = plateau.length;

	for (var i=0; i<hauteur; i++) {
		plateauTransforme[i] = new Array();
	}

	for (var i=0; i<hauteur; i++) {
		for (var j=0; j<largeur; j++) {
			plateauTransforme[i][j] = 0;
		}
	}
	
	var verif = verifLigneComplete(plateau, numeroLigne);
	
	plateauTransforme = plateau;
	
	if (verif==true)
		for (let i=numeroLigne; i>=0; i--)
			for (let j=0; j<plateau[i].length; j++) {
				if (i == 0)
					plateauTransforme[i][j] = 0;
				else
					plateauTransforme[i][j] = plateau[i-1][j];
			}

	return plateauTransforme;
}

// Fonction qui vérifie pour une ligne donnée si elle est complète. Elle retourne "true" si la ligne est complète, "false" sinon
function verifLigneComplete(myPlateau, myNumeroLigne) {
	var count=0;
	
	for (let j=0; j<myPlateau[0].length; j++)
		if (myPlateau[myNumeroLigne][j]==0) {
			count++;
		}
		
	if (count==0)
		return true;
	else
		return false;
}