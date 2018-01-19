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

import fr.formation.auth.Personne;
import fr.formation.auth.User;
import fr.formation.config.AppConfig;
import fr.formation.dao.*;

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
		assertNotNull(dao.findByLogin("admin1"));
	}
	
	@Test
	public void testFindById() {
		assertNotNull(dao.findById(1));
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
		Optional<Personne> opPersonne = dao.findById(1);
		Personne p;
		
		assertTrue(opPersonne.isPresent());
		p = opPersonne.get();
		
		assertNotNull(p);
		
		dao.delete(p);
		assertFalse(dao.findById(1).isPresent());
	}
	
	@Test
	@Transactional
	@Rollback(true)
	public void testModifier() {
		Optional<Personne> opPersonne = dao.findById(1);
		Personne p;
		
		assertTrue(opPersonne.isPresent());
		p = opPersonne.get();
		
		assertNotNull(p);
		
		assertNotEquals("ABCD", p.getPassword());
		
		p.setPassword("ABCD");
		dao.save(p);
		
		assertEquals("ABCD", dao.findById(1).get().getPassword());
	}

}
