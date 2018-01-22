package tetris.model.auth;

import static org.junit.Assert.*;

import org.junit.Test;

import tetris.model.auth.Admin;

public class AdminTest {

	@Test
	public void testAdmin() {
		Admin adm = new Admin();
		assertNotNull(adm);
	}

}
