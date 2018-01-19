package fr.formation.model;

public class Rotations {
	
	private Tetrimino tetrimino;
	private Tetrimino tetrimino90;
	private Tetrimino tetrimino180;
	private Tetrimino tetrimino270;
	
	public Rotations() {
	}
	
	public Rotations(Tetrimino tetrimino) {
		this.tetrimino  = this.tetrimino90 = this.tetrimino = this.tetrimino270 =tetrimino;
		this.tetrimino90.ArrayToString(this.tetrimino.Rotation90SensHoraire());
		this.tetrimino180.ArrayToString(this.tetrimino90.Rotation90SensHoraire());
		this.tetrimino270.ArrayToString(this.tetrimino180.Rotation90SensHoraire());
	}

	public Tetrimino getTetrimino() {
		return tetrimino;
	}

	public void setTetrimino(Tetrimino tetrimino) {
		this.tetrimino = tetrimino;
	}

	public Tetrimino getTetrimino90() {
		return tetrimino90;
	}

	public void setTetrimino90(Tetrimino tetrimino90) {
		this.tetrimino90 = tetrimino90;
	}

	public Tetrimino getTetrimino180() {
		return tetrimino180;
	}

	public void setTetrimino180(Tetrimino tetrimino180) {
		this.tetrimino180 = tetrimino180;
	}

	public Tetrimino getTetrimino270() {
		return tetrimino270;
	}

	public void setTetrimino270(Tetrimino tetrimino270) {
		this.tetrimino270 = tetrimino270;
	}

	public String toString() {
		String rep = "";
		if (this.tetrimino!=null)
			rep +="tetrimino original° : "+ this.tetrimino + ", ";
		if (this.tetrimino90!=null)
			rep +="tetrimino tourné à 90° : "+ this.tetrimino90 + ", ";
		
		if (this.tetrimino90!=null)
			rep +="tetrimino tourné à 180° : "+ this.tetrimino180 + ", ";
		
		if (this.tetrimino90!=null)
			rep +="tetrimino tourné à 270° : "+ this.tetrimino270 + ", ";
		
		return rep;
	}
}
