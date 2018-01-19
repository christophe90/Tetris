package fr.formation.auth;

import static org.junit.Assert.*;

import javax.transaction.Transactional;

import org.junit.Test;
import org.springframework.test.annotation.Rollback;

public class AdminTest {

	@Test
	@Transactional
	@Rollback(true)
	public void testAdmin() {
		Admin adm = new Admin();
		assertNotNull(adm);
	}

}
