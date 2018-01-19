package fr.formation.model;

public class Rotation {
	
	private int id;
	private Tetrimino tetrimino90;
	private Tetrimino tetrimino180;
	private Tetrimino tetrimino270;
	
	public Rotation() {
	}
	
	public Rotation(Tetrimino tetrimino) {
		// --------------------------------------- A Implementer
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
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
		if (id!=-1)
			rep = "id : " + id + ", ";
		
		if (this.tetrimino90!=null)
			rep +="tetrimino tourné à 90° : "+ this.tetrimino90 + ", ";
		
		if (this.tetrimino90!=null)
			rep +="tetrimino tourné à 180° : "+ this.tetrimino180 + ", ";
		
		if (this.tetrimino90!=null)
			rep +="tetrimino tourné à 270° : "+ this.tetrimino270 + ", ";
		
		return rep;
	}
}
