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
	private Graphe new_graphe;
	
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
		
		HashMap<Sommet,Set<Sommet>> acces = new HashMap<Sommet,Set<Sommet>>();
		
		for(Sommet s : this.new_graphe.getSommets()) {
		    Set<Sommet> vs = new HashSet<Sommet>();
		    vs.add(s);
		    acces.put(s, vs);
		}
		
		// Initialisation : triage des arêtes selon le poids
		Collections.sort(this.les_aretes,new AreteComparator());
		
		while(true) {
			// On prend la premiere arete (= poids max)
		    Arete arete = this.les_aretes.remove(0);

		    // On récupère les acces du sommet d'arrivée et d'origine
		    Set<Sommet> acces_arrivee = acces.get(arete.getArrivee());
		    Set<Sommet> acces_origine = acces.get(arete.getOrigine());
		    
		    // Si identique alors on ajoute pas
		    if(acces_arrivee.equals(acces_origine))
		        continue;
		   
		    // Sinon on ajoute et on met acces a jour
		    this.new_graphe.ajoutArete(arete);
		    acces_arrivee.addAll(acces_origine);
		    
		    for(Sommet i : acces_arrivee)
		        acces.put(i, acces_arrivee);
		    
		    // On arrete quand on a placé tous les sommets
		    if(acces_arrivee.size()== this.new_graphe.getSommets().size())
		        break;
		}
		
		// On retourne l'ensemble des arêtes selectionnées que l'on transforme en nouveau graphe
		return this.new_graphe;	
	}
		
}
