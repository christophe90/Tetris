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
import tetris.model.auth.*;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes=AppConfig.class)
public class IAuthDAOTest {

	@Autowired(required=false)
	private IAuthDAO dao;
	
	@Test
	public void test() {
		assertNotNull(dao);
	}
	
	@Test
	public void testFindByLogin() {
		assertNotNull(dao.findByLogin("user1"));
	}
	
	@Test
	public void testFindById() {
		assertNotNull(dao.findById(3));
	}
	
	@Test
	@Transactional
	@Rollback(true)
	public void testSave() {
		Personne p = new Personne();
		p.setPassword("0000");
		dao.save(p);
		assertNotEquals(0, p.getId());
	}
	
	@Test
	@Transactional
	@Rollback(true)
	public void testDelete() {
		Optional<Personne> opPersonne = dao.findById(3);
		Personne p;
		
		assertTrue(opPersonne.isPresent());
		p = opPersonne.get();
		
		assertNotNull(p);
		
		dao.delete(p);
		assertFalse(dao.findById(3).isPresent());
	}
	
	@Test
	@Transactional
	@Rollback(true)
	public void testModifier() {
		Optional<Personne> opPersonne = dao.findById(3);
		Personne p;
		
		assertTrue(opPersonne.isPresent());
		p = opPersonne.get();
		
		assertNotNull(p);
		
		assertNotEquals("ABC", p.getPassword());
		
		p.setPassword("ABC");
		dao.save(p);
		
		assertEquals("ABC", dao.findById(3).get().getPassword());
	}

}
