package fr.formation.auth;

import static org.junit.Assert.*;

import javax.transaction.Transactional;

import org.junit.Test;
import org.springframework.test.annotation.Rollback;

import tetris.formation.auth.User;

public class UserTest {

	@Test
	@Transactional
	@Rollback(true)
	public void testUser() {
		User user = new User();
		assertNotNull(user);
	}

}
