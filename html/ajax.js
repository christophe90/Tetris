
(function() {
	
		var myUrl = 'http://localhost:8080/tetris-web/api/admin/tetriminos';
		
		$.ajax({
			method: 'GET',
			url: myUrl,
			success: function(tetriminos) {
				console.log(tetriminos);
				
				var listCouleurs = new Array();
				for (var i=0; i<tetriminos.length; i++) {
					if (tetriminos[i].couleur == 'bleu')
						listCouleurs[i]=1;
					if (tetriminos[i].couleur == 'vert')
						listCouleurs[i]=2;
					if (tetriminos[i].couleur == 'rouge')
						listCouleurs[i]=3;
					if (tetriminos[i].couleur == 'jaune')
						listCouleurs[i]=4;
					if (tetriminos[i].couleur == 'rose')
						listCouleurs[i]=5;
					if (tetriminos[i].couleur == 'orange')
						listCouleurs[i]=6;
					if (tetriminos[i].couleur == 'violet')
						listCouleurs[i]=7;
					console.log(listCouleurs[i]);
				}
				
				function tetri(id) {
					var str1 = tetriminos[id].str;
					var rot1 = stringToArray(str1);
					// rot1 = rot1.map(x => {
						// return x.map(y => {
							// return y * listCouleurs[id];
						// })//
					// });
					
					var str2 = tetriminos[id].tetrimino90;
					var rot2 = stringToArray(str2);
					rot2 = rot2.map(x => x * listCouleurs[id]);
					
					var str3 = tetriminos[id].tetrimino180;
					var rot3 = stringToArray(str3);
					rot3 = rot3.map(x => x * listCouleurs[id]);
					
					var str4 = tetriminos[id].tetrimino270;
					var rot4 = stringToArray(str4);
					rot4 = rot4.map(x => x * listCouleurs[id]);
					
					return [rot1, rot2, rot3, rot4];
				}
				
				// function multiplication(matrice, scalaire) {
					// for (var i=0; i<matrice.length; i++) {
						
					// }
				// }
				
				console.log(tetri(1));
				
			}
		});

})();