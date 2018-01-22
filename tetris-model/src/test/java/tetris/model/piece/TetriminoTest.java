package tetris.model.piece;

import static org.junit.Assert.*;

import org.junit.Test;

public class TetriminoTest {
	
	@Test
	public void testTetrimino() {
		RotationTetrimino tetrimino= new RotationTetrimino();
		assertNotNull(tetrimino);
	}
	
}
