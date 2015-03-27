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
		 * 	- (1000, 5000) 	-> 	Kruskal : 7618 	ms	Prim : 1075 ms 
		 * 	- (2000, 10000) -> 	Kruskal : 60247	ms	Prim : 7848 ms
		 * 	- (1000, 999) 	-> 	Kruskal : 948 	ms	Prim : 131	ms
		 */
		AbstractGraphe g = new GrapheAleatoire(1000, 999);
		System.out.println("Nous travaillons avec un graphe généré aléatoirement.\nCelui-ci comport 1000 sommets pour 4750 arètes.");
		long deb, fin;
		
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
