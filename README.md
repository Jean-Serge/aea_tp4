# aea_tp4
# Jean-Serge Monbailly
# Thibaud Verbaere

aea TP2 - Graphes 

Ce TP consiste à implanter les algorithmes de Prim et de Kruskal
sur des graphes générés aléatoirement et de comparer leurs temps
d'exécution en fonction du nombre d'arêtes et de sommets du graphe.

Étape 1 :
=========
Implémentation d'une classe GrapheAleatoire permettant de générer un 
graphe aléatoire connaissant le nombre de sommet et d'arêtes de celui-ci.

Création des classes suivantes :
+ GrapheAleatoire.java 	: représente un graphe
+ Sommet 		: un sommet du graphe (identifié par un numéro)
+ Arete 		: une arête entre 2 sommets du graphe (identifié par 2 sommets d'un graphe)

Écriture des tests correspondants à ces classes.

Écriture d'une classe héritant de Random (et ses tests) afin de pouvoir produire
des entiers strictement positifs ou nulls.
