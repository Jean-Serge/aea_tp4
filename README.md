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
+ GrapheAleatoire	: représente un graphe
+ Sommet 		: un sommet du graphe (identifié par un numéro)
+ Arete 		: une arête entre 2 sommets du graphe (identifié par 2 sommets d'un graphe)

Écriture des tests correspondants à ces classes.

Écriture d'une classe héritant de Random (et ses tests) afin de pouvoir produire
des entiers strictement positifs ou nulls.


Étape 2 :
=========
Implémentation d'une classe Graphe permettant de manipuler un graphe.

Création des classes suivantes :
+ AbstractGraphe 	: réprésentation abstraite d'un Graphe générique
+ Graphe		: répresente un Graphe dont on peut modifier les sommets et les arcs


Ajout de la notion de valeur pour une Arete.


Implémentation des algorithmes :
================================

+ Algorithme de Kruskal
On démarre l'algorithme en créant un ensemble vide qui contiendra par la suite des arêtes.
On tri ensuite par ordre croissant les arêtes du graphe. Les arêtes étant contenues dans une liste d'arêtes les_arêtes nous avons donc implémenté une classe AreteComparator afin de faire simplement un "Collection.sort".
Une fois ces deux listes initialisées on peux dérouler un algorithme plutôt simple :
1) On prend l'arête de plus petit poids de la liste les_arêtes (la liste étant triée, il faut prendre l'arête d'indice 0).
2) Si l'union de l'ensemble des arêtes contenues dans l'ensemble créé au départ et de l'arête prise à l'étape 1 forme un graphe cyclique (il ne faut donc pas trouver des chemins partant d'un sommet A qui menerait à ce même sommet A), alors on enlève l'arête de les_arêtes. Dans le cas contraire il faut ajouter l'arête à l'ensemble avant de la supprimer de les_arêtes.
3) Si les_arêtes est vide alors on retourne un nouveau graphe composé des arêtes stockées dans l'ensemble sinon on revient à l'étape 1.

TODO :
======
+ Implémentation classe Graphe
+ Implémentation algorithme de Prim
+ Test classe Graphe 
+ Test algo de Prim
+ Faire l'exo 2 du TP ?
