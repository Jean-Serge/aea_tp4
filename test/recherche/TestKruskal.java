package recherche;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import recherche.Kruskal;
import entite.Arete;
import entite.Graphe;
import entite.Sommet;

public class TestKruskal {
	
	Kruskal k;
	Graphe g = new Graphe();
	
	Sommet s0 = new Sommet(0);
	Sommet s1 = new Sommet(1);
	Sommet s2 = new Sommet(2);
	Sommet s3 = new Sommet(3);
	Sommet s4 = new Sommet(4);
	Sommet s5 = new Sommet(5);
	Sommet s6 = new Sommet(6);
	Sommet s7 = new Sommet(7);
	Sommet s8 = new Sommet(8);
	
	Arete a1 = new Arete(s0,s1,1);
	Arete a2 = new Arete(s0,s2,7);
	Arete a3 = new Arete(s1,s2,3);
	Arete a4 = new Arete(s2,s3,4);
	Arete a5 = new Arete(s1,s8,4);
	Arete a6 = new Arete(s3,s4,5);
	Arete a7 = new Arete(s4,s5,2);
	Arete a8 = new Arete(s4,s7,7);
	Arete a9 = new Arete(s5,s7,8);
	Arete a10 = new Arete(s5,s6,3);
	Arete a11 = new Arete(s6,s8,6);
	Arete a12 = new Arete(s7,s8,9);

	@Before
	public void setUp() {
		
		g.ajoutSommet(s0);
		g.ajoutSommet(s1);
		g.ajoutSommet(s2);
		g.ajoutSommet(s3);
		g.ajoutSommet(s4);
		g.ajoutSommet(s5);
		g.ajoutSommet(s6);
		g.ajoutSommet(s7);
		g.ajoutSommet(s8);
		
		g.ajoutArete(a1);
		g.ajoutArete(a2);
		g.ajoutArete(a3);
		g.ajoutArete(a4);
		g.ajoutArete(a5);
		g.ajoutArete(a6);
		g.ajoutArete(a7);
		g.ajoutArete(a8);
		g.ajoutArete(a9);
		g.ajoutArete(a10);
		g.ajoutArete(a11);
		g.ajoutArete(a12);
		
		k = new Kruskal(g);
	}
	
	@Test
	public void test_Kruskal() {
		
		assertEquals(59,g.SommePoids());
		
		Graphe result = (Graphe) k.executeKruskal();
		
		assertEquals(29,result.SommePoids());
	}
}
