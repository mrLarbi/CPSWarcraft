service : Terrain

observators :
	const largeur : [Terrain] → int
	const hauteur : [Terrain] → int

Constructors :
	init : int × int → [Terrain]
		pre init(largeur,hauteur) require largeur%2=1 ∧ hauteur%2=1 ∧ largeur > 1 ∧ hauteur > 1

Observations :	
[init]
	largeur(init(l,h)) = l
	hauteur(init(l,h)) = h
