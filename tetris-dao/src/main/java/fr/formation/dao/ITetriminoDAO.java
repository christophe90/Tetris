package fr.formation.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

public interface ITetriminoDAO extends JpaRepository<Tetrimino, Integer>{

}
