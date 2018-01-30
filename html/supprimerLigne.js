
/*------------------------------------------------ Fonction qui vérifie si il y a une ligne à supprimer, et la supprime le cas échéant -----------------------------------*/

// Prend une matrice en paramètre et la ligne à vérifier et supprimer et retrourne une matrice
function verifSupprimerLigne(plateau, numeroLigne) {
	
	console.log(plateau[4][1]);
	
	var count=0;
	
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
	
	for (let i=0; i<plateau.length; i++)
		if (plateau[i][numeroLigne]==0) {
			count++;
		}
	
	if (count==0)
		for (let i=0; i<plateau.length; i++)
			for (let j=numeroLigne; j<plateau[i].length; j++) {
				if (j>=plateau[i].length-1)
					plateauTransforme[i][j] = 0;
				else
					plateauTransforme[i][j] = plateau[i][j+1];
			}
	else
		plateauTransforme = plateau;
	
	return plateauTransforme;
	
}