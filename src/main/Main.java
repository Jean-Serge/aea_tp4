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
		 * 	- 	(1000, 1.0)	==> 	Prim 	: 	  243ms 	Kruskal	:	481ms 
		 * 	-	(1000, 0.3)	==>		Prim	:	  171ms		Kruskal	:	160ms
		 * 	-	(1000, 0.7)	==>		Prim	:	  236ms		Kruskal	:	318ms
		 * 	- 	(1000, 0.5)	==> 	Prim 	: 	  240ms 	Kruskal	:	262ms 
		 * 
		 * 	- 	(2000, 1.0)	==> 	Prim 	: 	  1610ms 	Kruskal	:	9896ms 
		 * 	-	(2000, 0.3)	==>		Prim	:	  973ms		Kruskal	:	1183ms
		 * 	-	(2000, 0.7)	==>		Prim	:	  1579s		Kruskal	:	4239ms
		 * 	- 	(2000, 0.5)	==> 	Prim 	: 	  1114ms 	Kruskal	:	2165ms 
		 */
		
		long deb, fin;
		
		deb = System.currentTimeMillis();
		AbstractGraphe g = new GrapheAleatoire(1000, (float)0.7);
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
