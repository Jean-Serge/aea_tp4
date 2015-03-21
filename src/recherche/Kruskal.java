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
			if (!this.estcycliqueAvec(a,this.ensemble_des_aretes)) {
				this.ensemble_des_aretes.add(a);
			}
			
		}
		// On retourne l'ensemble des arêtes selectionnées que l'on transforme en nouveau graphe
		return this.enGraphe(this.ensemble_des_aretes);		
	}

	/**
	 * Créé un graphe depuis une liste d'arêtes
	 * @param ensemble_des_aretes les arêtes contenues dans le graphe finale
	 * @return le graphe créé
	 */
	public Graphe enGraphe(List<Arete> ensemble_des_aretes) {
		Graphe g = new Graphe();
		
		// Pour chaque arête de la liste on construit le nouveau graphe
		for (Arete a : ensemble_des_aretes) {
			// Si l'origine d'une des arêtes est déja présente, inutile de la réajouter
			if (!g.getSommets().contains(a.getOrigine()))
				g.ajoutSommet(a.getOrigine());
			// Si l'arrivée d'une des arêtes est déja présente, inutile de la réajouter
			if (!g.getSommets().contains(a.getArrivee()))
				g.ajoutSommet(a.getArrivee());
			// Ajout de l'arête
			g.ajoutArete(a);
		}
		
		return g;
	
	}
	
	/**
	 * Teste si un ensemble d'arêtes formant un graphe non cyclique auquel on rajoute
	 * une nouvelle arête devient cyclique.
	 * @param arete l'arête que l'on rajoute
	 * @param ensemble l'ensemble des arêtes formant un graphe non cyclique
	 * @return true|false
	 */
	public boolean estcycliqueAvec(Arete arete,List<Arete> ensemble) {

		List<Arete> dejaPlace = new ArrayList<Arete>();
		List<Sommet> dejaVu = new ArrayList<Sommet>();
		
		// On ajoute dans dejaVu l'origine et l'arrivée de "arete"
		dejaVu.add(arete.getOrigine());
		dejaVu.add(arete.getArrivee());
		
		int memoire;
		
		// Tant qu'on a pas de réponse on continu
		while (true) {
			// memoire = la taille des arêtes déja placées
			memoire = dejaPlace.size();
			
			// On parcours l'ensemble des arêtes
			for (Arete a : ensemble) {
				// Si on tombe sur une arête non placée alors on essaye de la mettre dans le nouvel ensemble :			
				if (!dejaPlace.contains(a)) {
					// Si l'origine de cette arête est deja vue mais pas l'arrivée alors on l'ajoute
					if (dejaVu.contains(a.getOrigine()) && !dejaVu.contains(a.getArrivee())) {
						dejaVu.add(a.getArrivee());
						dejaPlace.add(a);
					}
					// Si l'arrivée de cette arête est deja vue mais pas l'origine alors on l'ajoute
					else if (dejaVu.contains(a.getArrivee()) && !dejaVu.contains(a.getOrigine())) {
						dejaVu.add(a.getOrigine());
						dejaPlace.add(a);
					}
					// Si l'arête que l'on souhaite placée a ses sommets dejaVu alors on a trouvé un chemin cyclique
					else if (dejaVu.contains(a.getArrivee()) && dejaVu.contains(a.getOrigine()))
						return true;
				}
			}
			// Si memoire ne varie pas alors c'est qu'on en a fini et que le graphe n'est pas cyclique
			if (memoire == dejaPlace.size())
				return false;
		}	
	}
	
}
