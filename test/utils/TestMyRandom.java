package utils;


import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;


public class TestMyRandom {

	private MyRandom rand;
	
	@Before
	public void setUp(){
		this.rand = new MyRandom();
	}
	
	
	/**
	 * Ce test permet de vérifier que la fonction nextPositive ne 
	 * retourne que des entiers strictement positifs ou nulls.
	 */
	@Test
	public void testNextPositive(){
		for(int i = 0 ; i < 1000 ; i ++){
			assertTrue(this.rand.nextPositive() >= 0);
		}
	}
}
