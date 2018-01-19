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
import tetris.model.auth.Personne;
import tetris.model.faq.Faq;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes=AppConfig.class)
public class IFaqDAOTest {

	@Autowired(required=false)
	private IFaqDAO dao;
	
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
	@Rollback(false)
	public void testSave() {
		Faq faq = new Faq();
		faq.setQuestions("Couleur du cheval vert ?");
		dao.save(faq);
		assertNotEquals(0, faq.getId());
	}
	
	@Test
	@Transactional
	@Rollback(false)
	public void testDelete() {
		Optional<Faq> opFaq = dao.findById(1);
		Faq faq;
		
		assertTrue(opFaq.isPresent());
		faq = opFaq.get();
		
		assertNotNull(faq);
		
		dao.delete(faq);
		assertFalse(dao.findById(1).isPresent());
	}
	
	@Test
	@Transactional
	@Rollback(false)
	public void testModifier() {
		Optional<Faq> opFaq = dao.findById(1);
		Faq faq;
		
		assertTrue(opFaq.isPresent());
		faq = opFaq.get();
		
		assertNotNull(faq);
		
		assertNotEquals("Quoi ??", faq.getQuestions());
		
		faq.setQuestions("Quoi ??");
		dao.save(faq);
		
		assertEquals("Quoi ??", dao.findById(1).get().getQuestions());
	}

}
