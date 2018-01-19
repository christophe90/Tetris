package tetris.model.auth;

import static org.junit.Assert.*;

import javax.transaction.Transactional;

import org.junit.Test;
import org.springframework.test.annotation.Rollback;

public class PersonneTest {

	@Test
	@Transactional
	@Rollback(true)
	public void testPersonne() {
		Personne pers = new Personne();
		assertNotNull(pers);
	}

}
