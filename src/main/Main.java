package main;

import recherche.MSTPrim;
import entite.GrapheAleatoire;

public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		GrapheAleatoire g = new GrapheAleatoire(10, 30);
		System.out.println(g);
		System.out.println(new MSTPrim(g).rechercheMST());
		
	}

}
