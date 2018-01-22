package fr.formation.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import tetris.model.auth.*;

public interface IAuthDAO extends JpaRepository<Personne, Integer>{
	
	public Personne findByLogin(String login);
	
	@Query("select a from Admin a where a.login=:log and a.password=:pass")
	public Admin findAdmin(@Param("log") String login, @Param("pass") String password);
	
	@Query("select u from User u where u.login=:log and u.password = :pass")
	public User findUser(@Param("log") String login, @Param("pass") String password);
	
}
