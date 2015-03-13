package utils;

import java.util.Random;

public class MyRandom extends Random {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4505783718180659211L;

	public int nextPositive(){
		return next(31);
	}
}
