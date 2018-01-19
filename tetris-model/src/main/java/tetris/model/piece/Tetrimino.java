package tetris.model.piece;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import tetris.model.jeu.Coup;

@Entity
@Table(name="tetrimino")
@Inheritance(strategy=InheritanceType.JOINED)
public class Tetrimino {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "TET_ID")
	private int id;
	
	@Column(name="TET_NOM")
	private String nom;
	
	@Column(name="TET_COULEUR")
	private String couleur;
	
	@Column(name="TET_STR")
	protected String str;
	
	@OneToMany(mappedBy="Coup")
	private List<Coup> listCoups;
	
	public Tetrimino() {
	}
	
//	public Tetrimino(String nom, String couleur, String str) {
//		this.nom = nom;
//		this.couleur = couleur;
//		this.str = str;
//	}
//	
//	public String[][] stringToArray(String myStr) {
//	
//		String[] ligne = myStr.split("/");
//		String[][] tab = new String[ligne.length][];
//		
//		for (int i=0; i<ligne.length; i++) {
//			tab[i] = ligne[i].split(",");
//		}
//		return tab;
//	}
//	
//	public String arrayToString(String[][] tab) {
//		
//		String reponse = "";
//		
//		for (int i=0; i<tab.length; i++) {
//			for (int j=0; j<tab[0].length; j++)
//				reponse += tab[i][j] + ",";
//			reponse += "/";
//		}
//		
//		return reponse;
//	}
//	
//	public String[][] rotation90SensHoraire(String[][] tab) {
//		
//	
//		String[][] rotationTab = new String[tab[0].length][tab.length];
//		
//		for (int i=0; i<tab.length; i++)
//			for (int j=0; j<tab[0].length; j++)
//				rotationTab[i][j] = tab[j][tab.length-1-i];
//	
//		return rotationTab;
//	}

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
		return rep;
	}
}
