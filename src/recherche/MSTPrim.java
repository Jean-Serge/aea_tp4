package recherche;

import java.util.ArrayList;
import java.util.List;

import entite.AbstractGraphe;
import entite.Arete;
import entite.Graphe;
import entite.Sommet;

public class MSTPrim {

	private AbstractGraphe g;

	public MSTPrim(AbstractGraphe g) {
		this.g = g;
	}

	public AbstractGraphe rechercheMST() {
		// Liste des sommet marqués
		List<Sommet> vus = new ArrayList<Sommet>();
		AbstractGraphe g_retour = new Graphe();
		vus.add(g.getSommets().get(0));
		

		Arete tmp = null;
		boolean origineVue = false;
		boolean arriveeVue;

		// On fera au maximum nSommets tours
		for (int i = 0; i < g.getSommets().size(); i++) {
			
			tmp = null; 
			// On cherche l'arete de poids minimale dont l'un des
			// sommets est marqué.
			for (Arete a : g.getAretes()) {
				
				origineVue = vus.contains(a.getOrigine());
				arriveeVue = vus.contains(a.getArrivee());

				if (origineVue ^ arriveeVue){
					// Si on arrive ici, a peut être ajoutée 
					if (null == tmp)
						tmp = a;
				
					// Mais on cherche la plus petite valeur
					if(a.getValeur() < tmp.getValeur())
						tmp = a;
				}
			}
			
			// On vérifie que l'Arete doit être ajoutée
			if(null == tmp){
				System.out.println("null == tmp");
				break;
			}

			// On marque le nouveau sommet et on l'ajoute au graphe 
			if(vus.contains(tmp.getOrigine())){
				vus.add(tmp.getArrivee());
				g_retour.getSommets().add(tmp.getArrivee());
			}else{
				vus.add(tmp.getOrigine());
				g_retour.getSommets().add(tmp.getOrigine());
			}
			
			// On ajoute l'arete au graphe
			g_retour.ajoutArete(tmp);
		}
		
		return g_retour;
	}

}