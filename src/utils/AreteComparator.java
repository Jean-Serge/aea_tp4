package utils;

import java.util.Comparator;

import entite.Arete;

/**
 * 
 * @author verbaere
 *
 */
public class AreteComparator implements Comparator {

	/**
	 * 
	 */
	public int compare(Object o1, Object o2) {

		if (o1 instanceof Arete && o2 instanceof Arete) {
			
			Arete a1 = (Arete)o1;
			Arete a2 = (Arete)o2;
			
			if (a1.equals(a2))
				return 0;
			else {
				if (a1.getValeur() > a2.getValeur())
					return 1;
				else
					return -1;
			}
		}
			
		return 2;
	}

}
