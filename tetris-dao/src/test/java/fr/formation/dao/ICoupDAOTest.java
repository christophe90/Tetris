package fr.formation.dao;

import static org.junit.Assert.*;

import java.util.Optional;

import javax.transaction.Transactional;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import fr.formation.config.AppConfig;
import tetris.model.jeu.Coup;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes=AppConfig.class)
public class ICoupDAOTest {

	@Autowired(required=false)
	private ICoupDAO dao;
	
	@Test
	public void testDAO() {
		assertNotNull(dao);
	}
	
	@Test
	public void testFindById() {
		assertNotNull(dao.findById(2));
	}
	
	@Test
	@Transactional
	@Rollback(true)
	public void testSave() {
		Coup coup = new Coup();
		coup.setPoints(10000);
		dao.save(coup);
		assertNotEquals(0, coup.getId());
	}
	
	@Test
	@Transactional
	@Rollback(true)
	public void testDelete() {
		Optional<Coup> opCoup = dao.findById(2);
		Coup coup;
		
		assertTrue(opCoup.isPresent());
		coup = opCoup.get();
		
		assertNotNull(coup);
		
		dao.delete(coup);
		assertFalse(dao.findById(2).isPresent());
	}
	
	@Test
	@Transactional
	@Rollback(true)
	public void testModifier() {
		Optional<Coup> opCoup = dao.findById(2);
		Coup coup;
		
		assertTrue(opCoup.isPresent());
		coup = opCoup.get();
		
		assertNotNull(coup);
		
		assertNotEquals(1000, coup.getPoints());
		
		coup.setPoints(1000);
		dao.save(coup);
		
		assertEquals(1000, dao.findById(2).get().getPoints());
	}

}
