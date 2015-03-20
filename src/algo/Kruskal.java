package algo;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import utils.AreteComparator;

import entite.AbstractGraphe;
import entite.Arete;
import entite.Graphe;
import entite.Sommet;

/**
 * 
 * @author verbaere
 *
 */
public class Kruskal {
	
	private AbstractGraphe graphe;
	
	private List<Arete> ensemble_des_aretes;
	private List<Arete> les_aretes;
	
	/**
	 * Constructeur Kruskal
	 * @param g le graphe sur lequel on veut appliquer l'algorithme de Kruskal
	 */
	public Kruskal(AbstractGraphe g) {
		this.graphe = g;
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
			if (!this.estcycliqueAvec(a,this.ensemble_des_aretes)) {
				this.ensemble_des_aretes.add(a);
			}
			
		}
		
		return this.enGraphe(this.ensemble_des_aretes);		
	}

	public Graphe enGraphe(List<Arete> ensemble_des_aretes) {
		// TODO Auto-generated method stub
		return null;
	}

	public boolean estcycliqueAvec(Arete arrete,List<Arete> ensemble) {
		// A TERMINER ! renvoie true même quand il a pas visité un des sommets
		Sommet depart = arrete.getOrigine();
		Sommet arrivee = arrete.getArrivee();
		boolean trouve;
			
		while (!depart.equals(arrivee)) {
			trouve = false;
			
			for (Arete a : ensemble) {
				if (a.getOrigine() == arrivee || a.getArrivee() == depart) {
					arrivee = a.getArrivee();
					trouve = true;
				}
				else if (a.getArrivee() == arrivee || a.getOrigine() == depart) {
					arrivee = a.getOrigine();
					trouve = true;
				}
			}
			if (!trouve)
				return false;
		}
		return true;
	}
	
}
