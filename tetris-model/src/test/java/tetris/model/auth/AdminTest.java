package tetris.model.auth;

import static org.junit.Assert.*;

import javax.transaction.Transactional;

import org.junit.Test;
import org.springframework.test.annotation.Rollback;

import tetris.model.auth.Admin;

public class AdminTest {

	@Test
	@Transactional
	@Rollback(true)
	public void testAdmin() {
		Admin adm = new Admin();
		assertNotNull(adm);
	}

}
