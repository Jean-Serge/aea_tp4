package entite;

import java.util.Random;

import utils.MyRandom;

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
	private int nSommets;
	private int nAretes;
	
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
		this.nSommets = nSommets;
		this.nAretes = nAretes;
		this.sommets = new Sommet[nSommets];
		this.aretes = new Arete[nAretes];
		
		this.generereGrapheAleatoire();
	}
	
	// 	========================================================================================= 
	//	Génération du graphe
	// 	=========================================
	
	/**
	 * Génère le graphe aléatoirement.
	 * Commence par générer les sommets du graphe puis génère aléatoirement
	 * le nombre d'arêtes voulu.
	 */
	private void generereGrapheAleatoire(){
		// Génération des sommets
		for(int i = 0 ; i < this.nSommets ; i++){
			this.sommets[i] = new Sommet(i);
		}
		
		MyRandom rand = new MyRandom();
		int cptAretesCrees	 = 0;
		Arete areteACreer;
		int debut, fin;
		while(cptAretesCrees < this.nAretes){
			debut = rand.nextPositive() % this.nSommets;
			fin = rand.nextPositive() % this.nSommets;
			// Pas d'arête d'un sommet vers lui-même
			if(debut == fin)
				continue;
			
			areteACreer = new Arete(this.sommets[debut], this.sommets[fin]);
			for(int i = 0 ; i < cptAretesCrees ; i++){
				// On vérifie que l'arête en question n'existe pas déjà
				if(this.aretes[i].equals(areteACreer)){
					continue;
				}
			}
			
			// Si tout se passe bien on ajoute cet Arête
			this.aretes[cptAretesCrees++] = areteACreer;
		}
		
	}
	
	// 	========================================================================================= 
	//	Accesseurs
	// 	=========================================
	
	public String toString(){
		String retour = "";
		
		retour += "Nombre d'arêtes : " + this.nAretes + "\n";
		retour += "Nombre de sommets : " + this.nSommets + "\n";
		
		retour += "\nListe des arêtes : \n";
		
		for(Arete a : this.aretes)
			retour += a + "\n";

		return retour;
	}
	
}
