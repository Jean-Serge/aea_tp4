package exercice;

import java.util.ArrayList;
import java.util.List;

import recherche.Kruskal;
import entite.Arete;
import entite.Graphe;
import entite.GrapheAleatoire;
import entite.Sommet;

public class Exercice1 {

	public static void main(String[] argvs){
		
		// MODELISATION DES SALLES :
		
		// 2eme étage
		Sommet Balcon_Grand_Amphi = new Sommet(0);
		Sommet s232 = new Sommet(1);
		Sommet s233 = new Sommet(2);
		Sommet s234 = new Sommet(3);
		Sommet s269 = new Sommet(4);
		Sommet s262 = new Sommet(5);
		Sommet s251 = new Sommet(6);
		Sommet s201 = new Sommet(7);
		Sommet s203 = new Sommet(8);
		// 1ere étage
		Sommet Grand_Amphi = new Sommet(9);
		Sommet Foyer = new Sommet(10);
		Sommet s101 = new Sommet(11);
		Sommet s103 = new Sommet(12);
		Sommet s162 = new Sommet(13);
		Sommet s151 = new Sommet(14);
		// Rez de chaussée
		Sommet Petit_Amphi = new Sommet(15);
		Sommet s8 = new Sommet(16);
		Sommet s7 = new Sommet(17);
		Sommet s32 = new Sommet(18);
		Sommet s33 = new Sommet(19);
		Sommet s34 = new Sommet(20);
		Sommet s69 = new Sommet(21);
		Sommet Galerie = new Sommet(21);
		
		// MODELISATION DES LIENS ENTRE LES SALLES :
		List<Arete> liste = new ArrayList<Arete>();
		
		liste.add(new Arete(Balcon_Grand_Amphi,s201,4));
		liste.add(new Arete(Balcon_Grand_Amphi,s203,4));
		liste.add(new Arete(Balcon_Grand_Amphi,s232,4));
		liste.add(new Arete(Balcon_Grand_Amphi,Foyer,5));
		liste.add(new Arete(Balcon_Grand_Amphi,s8,10));
		liste.add(new Arete(s201,s203,4));
		liste.add(new Arete(s203,s232,4));
		liste.add(new Arete(s232,s233,1));
		liste.add(new Arete(s233,s234,1));
		liste.add(new Arete(s234,s269,1));
		liste.add(new Arete(s269,s262,4));
		liste.add(new Arete(s269,s251,4));
		liste.add(new Arete(s251,s262,4));
		liste.add(new Arete(s232,s234,2));
		liste.add(new Arete(s233,s269,2));
		liste.add(new Arete(s203,s103,5));
		liste.add(new Arete(s201,s101,5));
		liste.add(new Arete(s251,s151,5));
		liste.add(new Arete(s262,s162,5));
		liste.add(new Arete(s262,Petit_Amphi,10));
		liste.add(new Arete(s232,s32,10));
		liste.add(new Arete(s233,s33,10));
		liste.add(new Arete(s234,s34,10));
		liste.add(new Arete(s269,s69,10));
		liste.add(new Arete(Foyer,Grand_Amphi,1));
		liste.add(new Arete(s101,s103,1));
		liste.add(new Arete(Foyer,s101,4));
		liste.add(new Arete(Foyer,s103,4));
		liste.add(new Arete(s151,s162,4));
		liste.add(new Arete(s162,Petit_Amphi,5));
		liste.add(new Arete(Foyer,s8,5));
		liste.add(new Arete(Grand_Amphi,s8,5));
		liste.add(new Arete(s7,s8,1));
		liste.add(new Arete(s32,s7,1));
		liste.add(new Arete(s32,s33,1));
		liste.add(new Arete(s33,s34,1));
		liste.add(new Arete(s34,s69,5));
		liste.add(new Arete(s69,s33,2));
		liste.add(new Arete(s32,s34,5));
		liste.add(new Arete(Galerie,s32,1));
		liste.add(new Arete(Galerie,s7,4));
		liste.add(new Arete(Galerie,s33,1));
		liste.add(new Arete(Galerie,s34,1));
		liste.add(new Arete(Galerie,Petit_Amphi,4));
		liste.add(new Arete(Galerie,s69,2));
		
		Kruskal k = new Kruskal(new GrapheAleatoire(4,4));
		Graphe g = k.enGraphe(liste);
		
		k = new Kruskal(g);
		Graphe res = k.executeKruskal();
		
		// RESULTAT :
		System.out.println("valeur min : "+res.SommePoids());
		// SCORE ACTUEL : 59
		System.out.println(res);
	}
	
}
