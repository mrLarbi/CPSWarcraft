Muraille
service : Muraille
refine : Terrain

observators :
	pointsDeVie : [Muraille] → int
	estDetruite : [Muraille] → int
Constructors :
	init : int × int × int → [Muraille]
		pre init(largeur,hauteur, pointsDeVie) require largeur%2=1 ∧ hauteur%2=1 ∧ largeur > 1 ∧ hauteur > 1  ∧ pointsDeVie>0 

Operators :
	frappee : [Muraille] × int → [Muraille]
		pre frappee(M, force) require ¬estDetruite(M) ∧ f >= 0

Observations :
[invariants]
	estDetruite(M) =(min) pointsDeVie(M) ≤ 0
[init]
	Terrain.largeur(init(l,h,p))=l
	Terrain.hauteur(init(l,h,p))=h
	pointsDeVie(init(l,h,p))=p
[frappee]
	pointsDeVie(frappee(M)) = pointsDeVie(M) - f
