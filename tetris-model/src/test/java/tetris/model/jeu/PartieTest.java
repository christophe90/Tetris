package tetris.model.jeu;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

public class PartieTest {

	@Test
	public void test() {
		Partie p = new Partie();
		assertNotNull(p);
	}
	
	@Test
	public void testCalculScore() {
		Coup c1 = new Coup();
		c1.setPoints(30);
		
		Coup c2 = new Coup();
		c1.setPoints(10);
		
		List<Coup> listeCoups = new ArrayList<Coup>();
		listeCoups.add(c1);
		listeCoups.add(c2);
		
		Partie p = new Partie();
		p.setListCoups(listeCoups);
		
		assertEquals(c1.getPoints() + c2.getPoints(), p.getScore());
	}

}
