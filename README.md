# PCF : analyseur syntaxique, interpréteur et typage

## Auteur.trices

- A
- B

## Choix qui dévient des préconisations des sujets de TP

- `Value` (valeurs entières et fermetures), `IceCube` (glaçons) et le type `Env` sont définis dans le paquet `evaluator` et non dans `ast`. Les valeurs relèvent de la sémantique, donc du back end de l'interpréteur, et non de la syntaxe abstraite.
- Les mots-clés (`let`, `in`, `ifz`, `then`, `else`, `fun`, `->`, `fix`) sont des lexèmes implicites de la grammaire, donc prioritaires sur les identificateurs de variables.
- Priorités dans la grammaire, de la plus forte à la plus faible : application (associative à gauche), `*` et `/`, `+` et `-`, puis `let`, `ifz`, `fun` et `fix`. L'application est donc prioritaire sur l'arithmétique, et `fun` est associative à droite.
- Les entiers sont emballés et déballés par les conversions implicites `int2Val` (`Int => Value`) et `val2Int` (`Value => Int`), comme préconisé. `val2Int` lève une `InterpretationException` si la valeur n'est pas un entier.
- Les erreurs d'exécution (variable non définie, division par zéro, application d'un non-fonction, opérande non entier) lèvent une `InterpretationException`. Les erreurs de typage lèvent une `TypeError`.
- Le typage (`typer.Typer`) est appelé avant l'évaluation dans `pcf.main` : un programme mal typé est rejeté sans être évalué.
- Les tests sont regroupés dans le répertoire `test` : `Tests.scala` (scénarios automatiques) et `test0.calc` (un programme exécuté par `pcf.main`).

## Ce qui marche et ce qui ne marche pas ou qui manque

### Ce qui marche

- PCF vert, bleu, rouge et noir : analyse syntaxique (grammaire ANTLR et visiteur), arbre de syntaxe abstraite, évaluation avec environnements immutables, fermetures, appel par valeur et points fixes via les glaçons.
- Les exemples des sujets de TP donnent les résultats attendus, par exemple la factorielle de 3 qui vaut 6.
- Inférence de types avec variables logiques, via `unify.jar` : nombres, opérations arithmétiques, conditionnelles, `let`, fonctions, applications et `fix`. Les programmes corrects reçoivent leur type (par exemple `INT`, ou `(INT -> INT)` pour `fun x -> x + 1`), et les programmes incorrects sont rejetés.
- `Tests.scala` vérifie, pour les quatre pistes, les résultats des programmes corrects, les types inférés, le rejet des programmes mal typés et les erreurs d'exécution. Tous les scénarios passent.

### Ce qui ne marche pas ou qui manque

- Le typage est monomorphe : `let` ne généralise pas le type de la variable liée (voir la réponse à la question ci-dessous).
- Pas de commentaires dans le langage (la grammaire n'en définit pas).
- Pas de règle d'entrée imposant la fin du fichier (`EOF`) dans la grammaire : une entrée dont seule une partie est analysable peut être acceptée sans erreur.
- `fix x x` boucle indéfiniment à l'évaluation, ce qui est le comportement attendu pour ce programme.
- Pas de phase d'analyse sémantique séparée : les variables non définies sont détectées par le typage ou, à défaut, par l'évaluateur.

## Réponse à la question de la section 5 (typage)

Le programme `let id = fun x -> x in ...` applique la même fonction `id` à des arguments de types différents, par exemple `id 1` puis `id (fun y -> y)`.

Le typage de `fun x -> x` donne `a -> a`, où `a` est une unique variable de type, et `id` est enregistrée dans l'environnement avec ce type. Le premier usage, `id 1`, unifie `a` avec `INT`. Le second usage essaie ensuite d'unifier `INT` avec le type d'une fonction, ce qui échoue : le programme est rejeté par une `TypeError`, alors qu'il s'évalue sans problème.

C'est une limite du typage monomorphe : le `let` ne généralise pas le type de `id`, qui garde donc une seule variable de type partagée par tous ses usages. Pour accepter ce programme, il faudrait un schéma de types `∀a. a -> a`, instancié avec une nouvelle variable de type à chaque usage de `id` : c'est le polymorphisme du `let` de l'algorithme de Hindley-Milner complet.

## Utilisation de l'IA générative

Outil utilisé : Claude (claude.ai), ainsi que l'autocomplétion dans IntelliJ. Nous n'avons donc pas limité notre usage au plugin AI Assistant, qui était la préconisation.

Usages :

- aide à la compréhension des sujets de TP ;
- aide à l'écriture du README ;
- autocomplétion dans IntelliJ ;
- génération du fichier `test/Tests.scala` pour les scénarios de test.