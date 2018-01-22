package tetris.model.piece;

import static org.junit.Assert.*;

import org.junit.Test;

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
	
	@Test
	public void stringToArrayTest() {
		String str = "1,1,1,1/1,0,0,0/1,0,0,0";
		rot = new RotationTetrimino("test1", "jaune",str);
		String[][] tab = rot.stringToArray(str);
		
		String[][] valeurAttendue = {{"1","1","1","1"},{"1","0","0","0"},{"1","0","0","0"}};
		
		for (int i=0; i<tab.length; i++)
			for (int j=0; j<tab[0].length; j++)
				assertEquals(tab[i][j], valeurAttendue[i][j]);
	}
	
	@Test
	public void rotation90SensHoraire() {
		String str = "1,1,1,1/1,0,0,0/1,0,0,0";
		rot = new RotationTetrimino("test1", "jaune",str);
		String[][] tab = {{"1","1","1","1"},{"1","0","0","0"},{"1","0","0","0"}};
		String[][] resultat = rot.rotation90SensHoraire(tab);
		
		String[][] valeurAttendue = {{"1","1","1"},{"0","0","1"},{"0","0","1"},{"0","0","1"}};
		
		for (int i=0; i<resultat.length; i++)
			for (int j=0; j<resultat[0].length; j++)
				assertEquals(resultat[i][j], valeurAttendue[i][j]);
	}

	
	@Test
	public void arrayToStringTest() {
		String str = "1,1,1,1/1,0,0,0/1,0,0,0";
		rot = new RotationTetrimino("test1", "jaune",str);
		String[][] tab = {{"1","1","1","1"},{"1","0","0","0"},{"1","0","0","0"}};
		String valeurAttendue = "1,1,1,1/1,0,0,0/1,0,0,0";
		
		String resultat = rot.arrayToString(tab);
		
		assertEquals(resultat,valeurAttendue);
	}
	
}
