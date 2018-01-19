package fr.formation.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import fr.formation.auth.Personne;

@Repository
public interface IAuthDAO extends JpaRepository<Personne, Integer>{
	
	public Personne findByLogin(String login);
	
}
