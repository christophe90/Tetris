package fr.formation.model;

public class Tetrimino {
	
	private int id=-1;
	private String nom;
	private String couleur;
	private String matrice;
	
	public Tetrimino() {
	}
	
	public Tetrimino(String nom, String couleur, String matrice) {
		this.nom = nom;
		this.couleur = couleur;
		this.matrice = matrice;
	}
	
	public String[][] stringToArray() {
	
		String[] ligne = this.matrice.split("/");
		String[][] tab = new String[ligne.length][];
		
		for (int i=0; i<ligne.length; i++) {
			tab[i] = ligne[i].split(",");
		}
		return tab;
	}
	
	public void ArrayToString(String[][] tab) {
		
		String reponse = "";
		
		for (int i=0; i<tab.length; i++) {
			for (int j=0; j<tab[0].length; j++)
				reponse += tab[i][j] + ",";
			reponse += "/";
		}
		
		this.matrice = reponse;
	}
	
	public String[][] Rotation90SensHoraire() {
		
		String[][] tab = stringToArray();
		String[][] rotationTab = new String[tab[0].length][tab.length];
		
		for (int i=0; i<tab.length; i++)
			for (int j=0; j<tab[0].length; j++)
				rotationTab[i][j] = tab[j][tab.length-i+1];
			
		return rotationTab;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getCouleur() {
		return couleur;
	}

	public void setCouleur(String couleur) {
		this.couleur = couleur;
	}

	public String getMatrice() {
		return matrice;
	}

	public void setMatrice(String matrice) {
		this.matrice = matrice;
	}

	public String toString() {
		String rep = "";
		if (id!=-1)
			rep = "id : " + id + ", ";
		rep += "nom : " + nom + ", couleur : " + couleur;
		return rep;
	}
}
