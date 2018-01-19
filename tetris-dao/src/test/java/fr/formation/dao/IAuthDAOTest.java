package fr.formation.dao;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

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

}
