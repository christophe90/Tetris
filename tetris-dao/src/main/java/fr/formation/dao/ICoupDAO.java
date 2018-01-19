package fr.formation.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import tetris.model.jeu.Coup;

public interface ICoupDAO extends JpaRepository<Coup, Integer> {

}
