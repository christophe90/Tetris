package tetris.model.piece;

import java.io.Serializable;
import java.util.List;

import javax.persistence.*;

import tetris.model.jeu.Coup;

@Entity
@Table(name="tetrimino")
@Inheritance(strategy=InheritanceType.JOINED)
//public abstract class Tetrimino implements Serializable {
public class Tetrimino implements Serializable {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "TET_ID")
	private int id;
	
	@Column(name="TET_NOM")
	protected String nom;
	
	@Column(name="TET_COULEUR")
	protected String couleur;
	
	@Column(name="TET_STR")
	protected String str; // la piece en format String
	
	@OneToMany(mappedBy="tetrimino")
	private List<Coup> listCoups;
	
	@Column(name="TET_ACTIF")
	private boolean actif;
	
	public boolean isActif() {
		return actif;
	}

	public void setActif(boolean actif) {
		this.actif = actif;
	}

	public String[][] stringToArray(String myStr) {
	
		String[] ligne = myStr.split("/");
		String[][] tab = new String[ligne.length][];
		
		for (int i=0; i<ligne.length; i++) {
			tab[i] = ligne[i].split(",");
		}
		return tab;
	}
	
	public String arrayToString(String[][] tab) {
		
		String reponse = "";
		
		for (int i=0; i<tab.length; i++) {
			for (int j=0; j<tab[0].length; j++) {
				reponse += tab[i][j];
				if (j!=tab[0].length-1)
					reponse += ",";
			}
			if (i!=tab.length-1)
				reponse += "/";
		}
		
		return reponse;
	}
	
	public static String[][] rotation90SensHoraire(String[][] tab) {
		
	
		String[][] rotationTab = new String[tab[0].length][tab.length];
		
		for (int i=0; i<tab.length; i++)
			for (int j=0; j<tab[0].length; j++)
				rotationTab[j][tab.length-i-1] = tab[i][j];
	
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

	public String getStr() {
		return str;
	}

	public void setStr(String str) {
		this.str = str;
	}

	public List<Coup> getListCoups() {
		return listCoups;
	}

	public void setListCoups(List<Coup> listCoups) {
		this.listCoups = listCoups;
	}

	public String toString() {
		String rep = "id : " + id + ", ";
		rep += "nom : " + nom + ", couleur : " + couleur;
		rep += ", " + str;
		return rep;
	}
}

