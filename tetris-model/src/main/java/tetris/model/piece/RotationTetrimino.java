package tetris.model.piece;

import java.util.Optional;

import javax.persistence.*;

@Entity
@Table(name="rotationTetrimino")
@PrimaryKeyJoinColumn(name="ROT_ID", referencedColumnName="TET_ID")
public class RotationTetrimino extends Tetrimino {
	
	@Column(name="ROT_90")
	private String tetrimino90;
	
	@Column(name="ROT_180")
	private String tetrimino180;
	
	@Column(name="ROT_270")
	private String tetrimino270;
	
	public RotationTetrimino() {
	}
	
	public RotationTetrimino(Optional<Tetrimino> t) {
//		this.tetrimino90 = arrayToString(rotation90SensHoraire(stringToArray(tetrimino.str)));
//		this.tetrimino180 = arrayToString(rotation90SensHoraire(stringToArray(this.tetrimino90)));
//		this.tetrimino270 = arrayToString(rotation90SensHoraire(stringToArray(this.tetrimino180)));
	}

	public String getTetrimino90() {
		return tetrimino90;
	}

	public void setTetrimino90(String tetrimino90) {
		this.tetrimino90 = tetrimino90;
	}

	public String getTetrimino180() {
		return tetrimino180;
	}

	public void setTetrimino180(String tetrimino180) {
		this.tetrimino180 = tetrimino180;
	}

	public String getTetrimino270() {
		return tetrimino270;
	}

	public void setTetrimino270(String tetrimino270) {
		this.tetrimino270 = tetrimino270;
	}
}

