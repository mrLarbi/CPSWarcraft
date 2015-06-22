Route
service : Route
refine : Terrain

observators :
	const facteurMult : [Route] → int
	
Constructors :
	init : int × int × int → [Route]
		pre init(largeur,hauteur,facteur) require largeur%2=1 ∧ hauteur%2=1 ∧ largeur > 1 ∧ hauteur > 1  ∧ 0<facteur≤10

Observations :
[init]
	Terrain.largeur(init(l,h,f))=l
	Terrain.hauteur(init(l,h,f))=h
	facteurMult(init(l,h,f))
