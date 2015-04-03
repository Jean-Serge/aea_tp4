package recherche;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import utils.AreteComparator;

import entite.AbstractGraphe;
import entite.Arete;
import entite.Graphe;
import entite.Sommet;

/**
 * Classe modélisant l'algorithme de Kruskal.
 * @author verbaere
 *
 */
public class Kruskal {
		
	private List<Arete> ensemble_des_aretes;
	private List<Arete> les_aretes;
	
	/**
	 * Constructeur Kruskal
	 * @param g le graphe sur lequel on veut appliquer l'algorithme de Kruskal
	 */
	public Kruskal(AbstractGraphe g) {
		this.ensemble_des_aretes = new ArrayList<Arete>();
		this.les_aretes = g.getAretes();
		
	}
	
	/**
	 * Execute l'algorithme de Kruskal, celui-ci retourne l'arbre recouvrant minimal du graphe
	 * @return le graphe (qui est un arbre) recouvrant de poids minimal
	 */
	public Graphe executeKruskal() {
		AreteComparator comp = new AreteComparator();
		
		// Initialisation : triage des arêtes selon le poids
		Collections.sort(this.les_aretes,comp);
		
		// Execution de l'algorithme de Kruskal
		for (int i=0; i < this.les_aretes.size(); i++) {
			Arete a = this.les_aretes.get(i);
			
			// Si a U ensemble_des_aretes alors on ajoute dans l'ensemble l'arête a
			this.addSommetsSiAcyclique(a);
			
		}
		// On retourne l'ensemble des arêtes selectionnées que l'on transforme en nouveau graphe
		return new Graphe(this.ensemble_des_aretes);		
	}
	
	/**
	 * Teste si un ensemble d'arêtes formant un graphe non cyclique auquel on rajoute
	 * une nouvelle arête devient cyclique.
	 * @param arete l'arête que l'on rajoute
	 * @return true|false
	 */
	public void addSommetsSiAcyclique(Arete a) {
		if (this.ensemble_des_aretes.size() == 0)
			
		
	}
	
}
