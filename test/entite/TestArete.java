package entite;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

public class TestArete {

	private Arete a1, a2, a3;

	@Before
	public void setUp(){
		Sommet s1, s2, s3;
		s1 = new Sommet(0);
		s2 = new Sommet(1);
		s3 = new Sommet(2);
		
		a1 = new Arete(s1, s2);
		a2 = new Arete(s1, s3);
		a3 = new Arete(s1, s2);
	}
	
	/**
	 * Vérifie le bon fonctionnement de la fonction equals de la classe Arete.
	 */
	@Test
	public void testEquals(){
		assertTrue(a1.equals(a1));
		assertFalse(a1.equals(a2));
		assertTrue(a1.equals(a3));
		assertTrue(a3.equals(a1));
		assertFalse(a3.equals(a2));
	}
}
