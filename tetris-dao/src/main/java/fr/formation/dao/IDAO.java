package fr.formation.dao;

import java.sql.SQLException;
import java.util.List;

public interface IDAO<T> {
	
	public List<T> findAll() throws SQLException;
	public T findByID(int id) throws SQLException;
	public void insert(T t) throws SQLException;
	

}
