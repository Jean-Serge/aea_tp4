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

	/**
	 * 
	 * @param origine
	 * @param arrivee
	 */
	public Arete(Sommet origine, Sommet arrivee) {
		this.origine = origine;
		this.arrivee = arrivee;
	}

	public boolean equals(Arete autreArete) {
		return this.origine.equals(autreArete.getOrigine())
				&& this.arrivee.equals(autreArete.getArrivee());
	}

	public Sommet getOrigine() {
		return origine;
	}

	public Sommet getArrivee() {
		return arrivee;
	}

}
