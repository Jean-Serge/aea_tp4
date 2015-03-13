package entite;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

public class TestSommet {

	private Sommet s1, s2, s3;
	
	@Before
	public void setUp(){
		s1 = new Sommet(0);
		s2 = new Sommet(0);
		s3 = new Sommet(1);
	}
	
	/**
	 * Vérifie le bon fonctionnement de la fonction equals.
	 * Notez que la fonction equals appelée est celle de la classe Object,
	 * c'est pourquoi 2 objets différents ayant les mêmes attributs ne seront pas égaux.
	 */
	@Test
	public void testEquals(){
		assertTrue(s1.equals(s1));
		assertFalse(s1.equals(s2));
		assertFalse(s1.equals(s3));
	}
}
