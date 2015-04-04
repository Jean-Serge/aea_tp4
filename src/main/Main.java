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
		 * 	- 	(1000, 1.0)	==> 	Prim 	: 	  620ms 	Kruskal	:	13468ms 
		 * 	-	(1000, 0.3)	==>		Prim	:	  426ms		Kruskal	:	9869ms
		 * 	-	(1000, 0.7)	==>		Prim	:	  577ms		Kruskal	:	13188ms
		 * 	- 	(1000, 0.5)	==> 	Prim 	: 	  494ms 	Kruskal	:	14049ms 
		 * 
		 * 	- 	(2000, 1.0)	==> 	Prim 	: 	  2732ms 	Kruskal	:	107177ms 
		 * 	-	(2000, 0.3)	==>		Prim	:	  2685ms	Kruskal	:	107184ms
		 */
		long deb, fin;
		
		deb = System.currentTimeMillis();
		AbstractGraphe g = new GrapheAleatoire(1000, (float)0.3);
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
