package fr.formation.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import tetris.model.piece.Tetrimino;

public interface ITetriminoDAO extends JpaRepository<Tetrimino, Integer>{

}
