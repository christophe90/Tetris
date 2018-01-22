package tetris.model.piece;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

public class RotationTetriminoTest {
	
	RotationTetrimino rot;
	
	@Test
	public void test() {
		String str = "1,1,1,1/1,0,0,0/1,0,0,0";
		rot = new RotationTetrimino("test1", "jaune",str);
		assertNotNull(rot);
		
		String str90 = "1,1,1/0,0,1/0,0,1/0,0,1";
		assertEquals(str90, rot.getTetrimino90());
		
		String str180 = "0,0,0,1/0,0,0,1/1,1,1,1";
		assertEquals(str180, rot.getTetrimino180());
		
		String str270 = "1,0,0/1,0,0/1,0,0/1,1,1";
		assertEquals(str270, rot.getTetrimino270());
	}
}
