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
import tetris.model.piece.RotationTetrimino;
import tetris.model.piece.Tetrimino;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes=AppConfig.class)
public class ITetriminoDAOTest {

	@Autowired(required=false)
	private ITetriminoDAO dao;
	
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
		Tetrimino t = new Tetrimino();
		t.setNom("toto");
		dao.save(t);
		assertNotEquals(0, t.getId());
	}
	
	@Test
	@Transactional
	@Rollback(true)
	public void testDelete() {
		Optional<Tetrimino> opTetrimino = dao.findById(1);
		Tetrimino t;
		
		assertTrue(opTetrimino.isPresent());
		t = opTetrimino.get();
		
		assertNotNull(t);
		
		dao.delete(t);
		assertFalse(dao.findById(1).isPresent());
	}
	
	@Test
	@Transactional
	@Rollback(true)
	public void testModifier() {
		Optional<Tetrimino> opTetrimino = dao.findById(1);
		Tetrimino t;
		
		assertTrue(opTetrimino.isPresent());
		t = opTetrimino.get();
		
		assertNotNull(t);
		
		assertNotEquals("toto", t.getCouleur());
		
		t.setCouleur("toto");
		dao.save(t);
		
		assertEquals("toto", dao.findById(1).get().getCouleur());
	}
	
}
