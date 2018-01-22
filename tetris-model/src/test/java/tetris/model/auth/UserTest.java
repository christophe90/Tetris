package tetris.model.auth;

import static org.junit.Assert.*;

import org.junit.Test;

public class UserTest {

	@Test
	public void testUser() {
		User user = new User();
		assertNotNull(user);
	}

}
