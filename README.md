
M2 MoSEF - BARBEY Charlotte et PRUTKI Lucas <br/>

## Projet Scala - 2021/2022 
<p align="justify">
La société MowItNow a décidé de développer une tondeuse à gazon automatique, destinée aux surfaces rectangulaires. 
La tondeuse peut être programmée pour parcourir l'intégralité de la surface. La position de la tondeuse est représentée par une combinaison de coordonnées `(x,y)` et d'une lettre indiquant l'orientation selon la notation cardinale anglaise `(N,E,W,S)`. La pelouse est divisée en grille pour simplifier la navigation. 
Par exemple, la position de la tondeuse peut être `0, 0, N`, ce qui signifie qu'elle se situe dans le coin inférieur gauche de la pelouse, et orientée vers le Nord. 
Pour contrôler la tondeuse, on lui envoie une séquence simple de lettres. Les lettres possibles sont `D`, `G` et `A`.

`D` et `G` font pivoter la tondeuse de 90° à droite ou à gauche respectivement, sans la déplacer. `A` signifie que l'on avance la tondeuse d'une case dans la direction à laquelle elle fait face, et sans modifier son orientation. 

Si la position après mouvement est en dehors de la pelouse, la tondeuse ne bouge pas, conserve son orientation et traite la commande suivante. 
On assume que la case directement au Nord de la position `(x, y)` a pour coordonnées `(x, y+1)`. 
Pour programmer la tondeuse, on lui fournit un fichier d'entrée construit comme suit : 

- La première ligne correspond aux coordonnées du coin supérieur droit de la pelouse, celles du coin inférieur gauche sont supposées être (0,0). 
- La suite du fichier permet de piloter toutes les tondeuses qui ont été déployées. 

Chaque tondeuse a deux lignes la concernant : 
- la première ligne donne la position initiale de la tondeuse, ainsi que son orientation. La position et l'orientation sont fournies sous la forme de 2 chiffres et une lettre, séparés par un espace. 
- la seconde ligne est une série d'instructions ordonnant à la tondeuse d'explorer la pelouse. Les instructions sont une suite de caractères sans espaces. 
Chaque tondeuse se déplace de façon séquentielle, ce qui signifie que la seconde tondeuse ne bouge que lorsque la première a exécuté intégralement sa série d'instructions. 

Lorsqu'une tondeuse achève une série d'instruction, elle communique sa position et son 
orientation. 
</p>

### Objectif
Concevoir et écrire un programme en Scala, implémentant la spécification ci-dessus et passant le test ci-après. 

### Test
Le fichier suivant est fourni en entrée : 
```
5 5 
1 2 N 
GAGAGAGAA 
3 3 E 
AADAADADDA 
```
On attend le résultat suivant (position finale des tondeuses) : <br/>

Tondeuse 1 : 
```
1 3 N 
```
Tondeuse 2 : 
```
5 1 E 
```
### Exécution 
3 scripts : 
* **ParserFile** : cette classe permet de récupérer la taille du jardin, les instructions de chaque tondeuse `commands et la position de chaque tondeuse `location`.
* **LawnMower** : cette classe permet à la tondeuse de bouger dans le jardin. Elle contient plusieurs fonctions qui permettent de tourner, d'avancer, d'exécuter l'ensemble des ordres et d'indiquer la position de la tondeuse.

* **Run** : C'est un objet qui permet de vérifier que le fichier d'instructions soit bien renseigné et de lancer les tondeuses selon les instructions fournis.

A noter que les exceptions sont traitées.

### Résultat fourni par le programme 

Le fichier d'input est `consignes.txt`

```
Above, the content of the instruction file : 
5 5
1 2 N
GAGAGAGAA
3 3 E
AADAADADDA
 
The size of the garden is : 5,5.
 
Mower : 1
********************************************************************************
********************************************************************************
At the beginning, the location of the mower is : (1,2) and his direction is N.
The mower turns left, his location is : (1, 2, W).
The mower goes straight ahead, his location is : (0, 2, W).
The mower turns left, his location is : (0, 2, S).
The mower goes straight ahead, his location is : (0, 1, S).
The mower turns left, his location is : (0, 1, E).
The mower goes straight ahead, his location is : (1, 1, E).
The mower turns left, his location is : (1, 1, N).
The mower goes straight ahead, his location is : (1, 2, N).
The mower goes straight ahead, his location is : (1, 3, N).
 
 
Mower : 2
********************************************************************************
********************************************************************************
At the beginning, the location of the mower is : (3,3) and his direction is E.
The mower goes straight ahead, his location is : (4, 3, E).
The mower goes straight ahead, his location is : (5, 3, E).
The mower turns right, his location is : (5, 3, S).
The mower goes straight ahead, his location is : (5, 2, S).
The mower goes straight ahead, his location is : (5, 1, S).
The mower turns right, his location is : (5, 1, W).
The mower goes straight ahead, his location is : (4, 1, W).
The mower turns right, his location is : (4, 1, N).
The mower turns right, his location is : (4, 1, E).
The mower goes straight ahead, his location is : (5, 1, E).


