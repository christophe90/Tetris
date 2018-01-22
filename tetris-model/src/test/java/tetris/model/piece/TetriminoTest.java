package tetris.model.piece;

import static org.junit.Assert.*;

import javax.transaction.Transactional;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.test.annotation.Rollback;

import tetris.model.auth.Personne;

public class TetriminoTest {

	private static Tetrimino tetrimino;
	
//	@BeforeClass
//	public static void init() {
//		String str = "1,0,0,1/1,0,0,1/1,1,1,1";
//		tetrimino = new Tetrimino("test1","jaune",str);
//	}
	
	@Test
	public void testTetrimino() {
		String str = "1,0,0,1/1,0,0,1/1,1,1,1";
		tetrimino = new Tetrimino("test1","jaune",str);
		assertNotNull(tetrimino);
	}
	
//	@Test
//	public void testToArray() {
//		String str = "1,0,0,1/1,0,0,1/1,1,1,1";
//		String[][] array = { {"1","0","0","1"}, {"1","0","0","1"}, {"1","1","1","1"} };
//		String[][] array2 = tetrimino.stringToArray(str);
//		assertTrue(array.equals(array2));
//	}
	
//	@Test
//	public void rotationTest() {
//		String str = "1,0,0,1/1,0,0,1/1,1,1,1";
//		tetrimino = new Tetrimino("test1","jaune",str);
//		assertNotNull(tetrimino);
//		
//		String test1 = tetrimino.arrayToString(tetrimino.rotation90SensHoraire(tetrimino.stringToArray(tetrimino.getStr())));
//		String result1 = "1,1,1/1,0,0/1,0,0/1,1,1";
//		System.out.println(test1);
//		assertEquals(result1, test1);
//	}
//	
}
