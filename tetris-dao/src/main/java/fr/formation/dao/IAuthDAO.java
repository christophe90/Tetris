package fr.formation.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import tetris.model.auth.Personne;

public interface IAuthDAO extends JpaRepository<Personne, Integer>{
	
	public Personne findByLogin(String login);
	
}
