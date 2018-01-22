package fr.formation.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import tetris.model.faq.Faq;

public interface IFaqDAO extends JpaRepository<Faq, Integer> {

}
