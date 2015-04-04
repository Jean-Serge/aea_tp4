package recherche;

import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

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
		
	private List<Arete> les_aretes;
	private Set<Sommet> change;
	private Graphe new_graphe;
	
	private HashMap<Sommet,Set<Sommet>> memoire;
	
	/**
	 * Constructeur Kruskal
	 * @param g le graphe sur lequel on veut appliquer l'algorithme de Kruskal
	 */
	public Kruskal(AbstractGraphe g) {
		this.les_aretes = g.getAretes();

		this.new_graphe = new Graphe();
		
		for (Sommet s : g.getSommets()) {
			this.new_graphe.ajoutSommet(s);
		}
	}
	
	/**
	 * Execute l'algorithme de Kruskal, celui-ci retourne l'arbre recouvrant minimal du graphe
	 * @return le graphe (qui est un arbre) recouvrant de poids minimal
	 */
	public Graphe executeKruskal() {

		// On remet a zéro les variables (en cas de recherches successives)
		this.memoire = new HashMap<Sommet,Set<Sommet>>();
		HashSet<Sommet> hs = new HashSet<Sommet>();
		for (Sommet s : this.new_graphe.getSommets()) {
			hs = new HashSet<Sommet>();
			hs.add(s);
			this.memoire.put(s, hs);
		}
		this.change = null;
		
		// Initialisation : triage des arêtes selon le poids
		Collections.sort(this.les_aretes,new AreteComparator());
		
		// Execution de l'algorithme de Kruskal
		for (int i=0; i < this.les_aretes.size(); i++) {
			Arete a = this.les_aretes.get(i);
			
			// Si a U ensemble_des_aretes alors on ajoute dans l'ensemble l'arête a
			this.addSommetsSiAcyclique(a);
			
		}
		// On retourne l'ensemble des arêtes selectionnées que l'on transforme en nouveau graphe
		return this.new_graphe;	
	}
	
	/**
	 * Teste si un ensemble d'arêtes formant un graphe non cyclique auquel on rajoute
	 * une nouvelle arête devient cyclique.
	 * @param arete l'arête que l'on rajoute (ou pas)
	 */
	public void addSommetsSiAcyclique(Arete a) {
		change = this.memoire.get(a.getOrigine());
		
		if ( change.contains(a.getArrivee())) {

			// l'ajout de l'arete créera un cycle. On stoppe !
			return;
		}
		else {
			// On ajoute a dans le graphe
			this.new_graphe.ajoutArete(a);
			// On met a jour memoire
			change.addAll(this.memoire.get(a.getArrivee()));
			
			for (Sommet s : change){
				this.memoire.get(s).addAll(change);
			}
		}
				
	}
	
}
