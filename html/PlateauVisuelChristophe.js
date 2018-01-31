
/*----------------------------------------------------------------------------- Fonctions ----------------------------------------------------------------*/

/*--------------------------------------------------------- Creation de pieces visuelles à une coordonéee précise ----------------------------------------*/

function createPiece(posX, posY) {

	var myPiece = $('<piece />');
	//myPiece.css("left", posX*40);
	//myPiece.css("top", 560-posY*40);
	myPiece.css("left", posY*40);
	myPiece.css("top", posX*40);
	$('section[class="plateau"]').append(myPiece);
}

// même fonction, mais avec la gestion de la couleur en plus
function createColoredPiece(posX, posY, color) {

	var myPiece = $('<piece />');
	//myPiece.css("left", posX*40);
	//myPiece.css("top", 560-posY*40);
	myPiece.css("left", posY*40);
	myPiece.css("top", posX*40);
	myPiece.css("background-color", color);
	$('section[class="plateau"]').append(myPiece);
}

/*---------------------------------------------- Fonctions qui convertissent une matrice en tableau visuel ----------------------------------------------------*/

// matrice plateau: 0=vide, 1=piece
function afficherPlateau(plateau) {

	clearPlateau();
	for (let i=0; i<plateau.length; i++)
		for (let j=0; j<plateau[i].length; j++)
			if (plateau[i][j]!=0)
				createPiece(i,j);

}

// meme fonction, mais avec un code de couleur : 1=jaune, 2=rouge, 3=vert, 4=violet, 5=bleu
function afficherPlateauCouleur(plateau) {

	clearPlateau();
	for (let i=0; i<plateau.length; i++)
		for (let j=0; j<plateau[i].length; j++) {
			if (plateau[i][j]==1)
				createColoredPiece(i, j, "#ffe62d");
			else if (plateau[i][j]==2)
				createColoredPiece(i, j, "#ff0000");
			else if (plateau[i][j]==3)
				createColoredPiece(i, j, "#00ff2a");
			else if (plateau[i][j]==4)
				createColoredPiece(i, j, "#ff00e5");
			else if (plateau[i][j]==5)
				createColoredPiece(i, j, "#0077ff");
		}
}

/*----------------------------------------- Fonction qui remet le plateau visuel vide (supprime toutes les pieces) -------------------------------------------------*/

function clearPlateau() {
	$('piece').remove();
}

/*------------------------------------------------------- Fonction qui affiche le score ----------------------------------------------------------------------------*/

function afficherScore(score) {
	
	$('p[class="score"]').remove();
	var myParagraph = $('<p class="score">'+score+'<p/>');
	$('div[class="score"]').append(myParagraph);
}
