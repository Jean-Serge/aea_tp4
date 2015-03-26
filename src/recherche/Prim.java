package recherche;

import java.util.ArrayList;
import java.util.List;

import entite.AbstractGraphe;
import entite.Arete;
import entite.Graphe;
import entite.Sommet;

public class Prim {

	// Le graphe sur lequel effectuer une recherche
	private AbstractGraphe g;
	private AbstractGraphe g_retour;
	private List<Sommet> vus = new ArrayList<Sommet>();

	public Prim(AbstractGraphe g) {
		this.g = g;
		g_retour = new Graphe();
		vus = new ArrayList<Sommet>();
	}

	/**
	 * Recherche l'arbre recouvrant de poids minimal pour ce graphe.
	 * 
	 * @return le graphe représentant le MST du graphe d'origine
	 */
	public AbstractGraphe rechercheMST() {
		Sommet s;
		Arete tmp;

		// On marque le premier sommet de g et on l'ajoute à g_retour
		vus.add(g.getSommets().get(0));
		g_retour.ajoutSommet(g.getSommets().get(0));

		// On ajoutera au maximum nSommets -1 arètes
		for (int i = 0; i < g.getSommets().size() - 1; i++) {
			tmp = prochaineBonneArete();

			// On vérifie qu'une arète à ajouter a été trouvée
			if (null == tmp)
				break;

			// On marque le nouveau sommet et on ajoute le sommet et l'arète au
			// graphe
			s = vus.contains(tmp.getOrigine()) ? tmp.getArrivee() : tmp
					.getOrigine();

			vus.add(s); // On marque le sommet
			g_retour.ajoutArete(tmp); // On ajoute l'arète au graphe
			g_retour.getSommets().add(s); // On ajoute le sommet au graphe
		}

		return g_retour;
	}

	/**
	 * Retourne la prochaine "bonne arète" pour la recherche. i.e : l'Arète de
	 * poids minimal dont l'un des sommets est marqué et l'autre non
	 * 
	 * Retourne null si une telle arète n'est pas trouvée
	 * 
	 * @return la prochaine bonne arete pour la recherche, null si aucune arete
	 *         valide n'est trouvée
	 */
	private Arete prochaineBonneArete() {
		boolean origineVue;
		boolean arriveeVue;

		Arete retour = null;

		for (Arete a : g.getAretes()) {
			origineVue = vus.contains(a.getOrigine());
			arriveeVue = vus.contains(a.getArrivee());
			
			// On cherche l'arete de poids minimale dont seul l'un des sommets
			// est marqué.
			if (origineVue ^ arriveeVue) {
				if (null == retour)
					retour = a;

				// On cherche l'arète de poids minimal
				if (a.getValeur() < retour.getValeur())
					retour = a;
			}
		}

		return retour;
	}

}