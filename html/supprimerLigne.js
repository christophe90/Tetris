
/*------------------------------------------------------------------------- Fonctions ----------------------------------------------------------------------*/

// Fonction qui vérifie pour une ligne donnée si elle est complètes
function verifLigneComplete(plateau, myNumeroLigne) {
	var count=0;
	
	for (let j=0; j<plateau[0].length; j++)
		if (plateau[myNumeroLigne][j]==0) {
			count++;
		}
		
	if (count==0)
		return true;
	else
		return false;
}

// Fonction qui vérifie pour une ligne donnee (numérotées de 0 à 14) si elle est complete, et la supprime le cas échéant
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

// verifie toutes les lignes du plateau et supprime toutes les lignes complètes
function verifSupprimerPlusieursLigne(plateau) {
	
	var plateauFinal = plateau
	
	for (let i=plateau.length-1; i>=0; i--) {
		while (verifLigneComplete(plateauFinal, i)) {
			var nouveauPlateau =  verifSupprimerLigne(plateauFinal, i);
			PlateauFinal = nouveauPlateau;
			afficherPlateauCouleur(PlateauFinal);
		}
	}
	
	return plateauFinal;
}
