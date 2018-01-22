package fr.formation.dao;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import fr.formation.config.AppConfig;
import tetris.model.auth.User;
import tetris.model.jeu.Coup;
import tetris.model.jeu.Partie;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes=AppConfig.class)
public class IPartieDAOTest {

	@Autowired(required=false)
	private IPartieDAO dao;
	
	@Test
	public void testDAO() {
		assertNotNull(dao);
	}
	
	@Test
	public void testFindById() {
		assertNotNull(dao.findById(1));
	}
	
	@Test
	@Transactional
	@Rollback(true)
	public void testSave() {
		Partie part = new Partie();
		dao.save(part);
		assertNotEquals(0, part.getId());
	}
	
	@Test
	@Transactional
	@Rollback(true)
	public void testDelete() {
		Optional<Partie> opPartie = dao.findById(1);
		Partie part;
		
		assertTrue(opPartie.isPresent());
		part = opPartie.get();
		
		assertNotNull(part);
		
		dao.delete(part);
		assertFalse(dao.findById(1).isPresent());
	}
	
	@Test
	@Transactional
	@Rollback(true)
	public void testModifier() {
		Optional<Partie> opPartie = dao.findById(1);
		Partie part;
		
		assertTrue(opPartie.isPresent());
		part = opPartie.get();
		
		assertNotNull(part);
		
		assertNotEquals(1000, part.getScore());
		
		List<Coup> listCoups = new ArrayList<Coup>();
		Coup c1 = new Coup();
		c1.setPoints(1000);
		listCoups.add(c1);
		part.setListCoups(listCoups);
		dao.save(part);
		
		assertEquals(c1.getPoints(), dao.findById(1).get().getScore());
	}

}
