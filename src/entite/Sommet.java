package entite;

/**
 * Cette classe représente un Sommet pour le graphe.
 * @author monbailly
 *
 */
public class Sommet {

	private int id;
	
	// 	========================================================================================= 
	//	Constructeurs
	// 	=========================================
	
	/**
	 * Instancie un nouveau sommet à partir d'un identifiant.
	 * @param id
	 */
	public Sommet(int id) {
		this.id = id;
	}
	
	// 	========================================================================================= 
	//	Fonctions utiles
	// 	=========================================
	
	/**
	 * Cette fonction n'est pas vraiment surchargée car elle permet
	 * de vérifier s'il s'agit bien du bon sommet dans le bon graphe.
	 * @param autreSommet le sommet à comparer au sommet courant
	 * @return true s'il s'agit du même sommet.
	 */
	public boolean equals(Sommet autreSommet){
		return super.equals(autreSommet);
	}
	
	public String toString(){
		return "" + this.id;
	}

}
