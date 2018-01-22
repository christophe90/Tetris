package fr.formation.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import tetris.model.piece.*;

public interface ITetriminoDAO extends JpaRepository<Tetrimino, Integer>{

}
