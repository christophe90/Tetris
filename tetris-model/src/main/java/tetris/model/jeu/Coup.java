package tetris.model.jeu;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import tetris.model.piece.Tetrimino;

@Entity
@Table(name = "coup")
public class Coup {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "COU_ID")
	private int id;
	
	@ManyToOne
	@JoinColumn(name="COU_PARTIE_ID")
	private Partie partie;
	
	@ManyToOne
	@JoinColumn(name="COU_TETRIMINO_ID")
	private Tetrimino tetrimino;
	
	@Column(name = "COU_POINTS")
	private int points;

	public Coup() {
	}

	public Coup(Partie partie, Tetrimino tetrimino, int points) {
		super();
		this.partie = partie;
		this.tetrimino = tetrimino;
		this.points = points;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Partie getPartie() {
		return partie;
	}

	public void setPartie(Partie partie) {
		this.partie = partie;
	}

	public Tetrimino getTetrimino() {
		return this.tetrimino;
	}

	public void setTetrimino(Tetrimino tetrimino) {
		this.tetrimino = tetrimino;
	}

	public int getPoints() {
		return points;
	}

	public void setPoints(int points) {
		this.points = points;
	}

	public String toString() {
		String rep = "";
		if (id != -1)
			rep = "id : " + id + ", ";

		if (this.partie != null)
			rep += "partie : " + this.partie + ", ";

		if (this.tetrimino != null)
			rep += "tetrimino " + this.tetrimino + ", ";

		rep += "points : " + points;
		return rep;
	}
}
