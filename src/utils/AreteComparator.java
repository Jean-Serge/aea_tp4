package utils;

import java.util.Comparator;

import entite.Arete;

/**
 * Classe permettant le tri (sort) des arêtes par rapport au poids dans une liste JAVA.
 * @author verbaere
 *
 */
public class AreteComparator implements Comparator<Arete> {

	/**
	 * Retourne un entier utile à la comparaison de deux arêtes :
	 * 			- (-1) si la seconde arête passée en paramètre est plus grande que la première.
	 * 			- (1) si c'est la première arête qui est la plus grande.
	 * 			- (0) si les deux arêtes ont un poids identique.
	 * 
	 * @param a1 la première arête à comparer
	 * @param a2 la seconde arête à comparer
	 * 
	 */
	public int compare(Arete a1, Arete a2) {

		if (a1.equals(a2))
			// Cas 1 : les arêtes ont un poids identique (return 0)
			return 0;
		else {
			if (a1.getValeur() > a2.getValeur())
				// Cas 2 : a1 a un poids > à a2 (return 1)
				return 1;
			else
				// Dernier Cas
				return -1;
		}
			
	}

}
