package fr.formation.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import fr.formation.tetrimino.Tetrimino;

@Repository
public class TetriminoDAO implements IDAO<Tetrimino>{

	@Autowired
	private DataSource dataSource;

	public List<Tetrimino> findAll() throws SQLException {
		ResultSet rs;

		rs = dataSource.getConnection().createStatement().executeQuery("SELECT * FROM tetrimino");

		List<Tetrimino> listTetrimino = new ArrayList<Tetrimino>();

		while (rs.next()) {
			Tetrimino t = new Tetrimino();
			t.setId(rs.getInt(1));
			t.setNom(rs.getString(2));
			t.setCouleur(rs.getString(3));
			listTetrimino.add(t);
		}

		return listTetrimino;
	}

	public Tetrimino findByID(int id) throws SQLException {

		ResultSet rs = dataSource.getConnection().createStatement()
				.executeQuery("SELECT * FROM tetrimino WHERE id = " + id);

		Tetrimino t = new Tetrimino();
		if (rs.next()) {
			t.setId(rs.getInt(1));
			t.setNom(rs.getString(2));
			t.setCouleur(rs.getString(3));
		}
		return t;
	}

	public void insert(Tetrimino t) throws SQLException {

		dataSource.getConnection().createStatement()
				.executeUpdate("INSERT INTO tetrimino (nom,couleur) values('" + t.getNom() + "','" + t.getCouleur() + "')");
	}
	
	public void test() {
		
	}
}
