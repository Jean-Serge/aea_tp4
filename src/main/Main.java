package main;

import recherche.Kruskal;
import recherche.Prim;
import entite.AbstractGraphe;
import entite.GrapheAleatoire;

public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		/*
		 * Résultat rencontrés :
		 * 	- 	(1000, 1.0)	==> 	Prim 	: 	  254ms 	Kruskal	:	 
		 * 	-	(5000, 1.0)	==>		Prim	:	18397ms		Kruskal	:	
		 */
		long deb, fin;
		
		deb = System.currentTimeMillis();
		AbstractGraphe g = new GrapheAleatoire(10, (float)1);
		fin = System.currentTimeMillis() - deb;
		
		System.out.println("La création du graphe a pris " + fin + " ms.");
		
		deb = System.currentTimeMillis();
		new Prim(g).rechercheMST();
		fin = System.currentTimeMillis() - deb;
		
		System.out.println("L'algorithme de Prim a pris " + fin + " ms.");
		
		deb = System.currentTimeMillis();
		new Kruskal(g).executeKruskal();
		fin = System.currentTimeMillis() - deb;

		System.out.println("L'algorithme de Kruskal a pris " + fin + " ms.");
	}

}
