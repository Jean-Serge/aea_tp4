package entite;

/**
 * Cette classe représente une arête du graphe. Une arête est représentée par
 * son sommet d'origine et celui d'arrivée.
 * 
 * @author Jean-Serge Monbailly
 * @author Thibaud Verbaere
 * 
 */
public class Arete {

	private Sommet origine;
	private Sommet arrivee;

	// 	========================================================================================= 
	//	Constructeurs
	// 	=========================================
	
	/**
	 * 
	 * @param origine
	 * @param arrivee
	 */
	public Arete(Sommet origine, Sommet arrivee) {
		this.origine = origine;
		this.arrivee = arrivee;
	}

	// 	========================================================================================= 
	//	Fonctions utiles
	// 	=========================================
	
	/**
	 * Compare 2 Arete pour savoir si elles sont identique.
	 * i.e : si elles ont le même sommet d'origine et d'arrivée.
	 * 
	 * @param autreArete l'arête à comparer à l'Arête courante
	 * @return true si les 2 Arêtes sont égales
	 */
	public boolean equals(Arete autreArete) {
		return this.origine.equals(autreArete.getOrigine())
				&& this.arrivee.equals(autreArete.getArrivee());
	}

	// 	========================================================================================= 
	//	Accesseurs
	// 	=========================================
	
	public Sommet getOrigine() {
		return origine;
	}

	public Sommet getArrivee() {
		return arrivee;
	}

}
