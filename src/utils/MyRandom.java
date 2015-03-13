package utils;

import java.util.Random;

public class MyRandom extends Random {

	public int nextPositive(){
		return next(31);
	}
}
