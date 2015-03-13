package entite;

/**
 * Classe permettant de générer un Graphe aélatoire pour un nombre
 * de sommets et d'arêtes fixés.
 * 
 * @author Jean-Serge Monbailly
 * @author Thibaud Verbaere
 *
 */
public class GrapheAleatoire {
	
	private Sommet[] sommets;
	private Arete[] aretes;
	
	// 	========================================================================================= 
	//	Constructeurs
	// 	=========================================
	
	/**
	 * Permet d'initialiser un graphe connaissant son nombre de sommets
	 * et d'arêtes.
	 * @param nSommets le nombre de sommets du graphe
	 * @param nAretes le nombre d'arêtes du graphe.
	 */
	public GrapheAleatoire(int nSommets, int nAretes) {
		super();
		this.sommets = new Sommet[nSommets];
		this.aretes = new Arete[nAretes];
		
		this.generereGrapheAleatoire();
	}
	
	// 	========================================================================================= 
	//	Génération du graphe
	// 	=========================================
	
	/**
	 * Génère le graphe aléatoirement.
	 */
	private void generereGrapheAleatoire(){
		
	}
	
}
