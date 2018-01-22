package tetris.model.piece;

import static org.junit.Assert.assertNotNull;

import org.junit.Test;

public class TetriminoTest {
	
	@Test
	public void testUser() {
		Tetrimino tetrimino= new Tetrimino();
		assertNotNull(tetrimino);
	}
	
}
