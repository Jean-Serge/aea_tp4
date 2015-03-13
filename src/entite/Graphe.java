package entite;

/**
 * Classe permettant de générer un Graphe aélatoire pour un nombre
 * de sommets et d'arêtes fixés.
 * 
 * @author Jean-Serge Monbailly
 * @author Thibaud Verbaere
 *
 */
public class Graphe {
	
	private int nSommets;
	private int nAretes;
	
	/**
	 * Permet d'initialiser un graphe connaissant son nombre de sommets
	 * et d'arêtes.
	 * @param nSommets le nombre de sommets du graphe
	 * @param nAretes le nombre d'arêtes du graphe.
	 */
	public Graphe(int nSommets, int nAretes) {
		super();
		this.nSommets = nSommets;
		this.nAretes = nAretes;
	}
}
