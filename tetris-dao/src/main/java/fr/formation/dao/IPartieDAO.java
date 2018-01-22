package fr.formation.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import tetris.model.jeu.Partie;

public interface IPartieDAO extends JpaRepository<Partie, Integer> {

}
