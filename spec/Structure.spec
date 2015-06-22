service : Structure
refine  : Terrain

observators : 
	orRestant  : [Structure] → int
	estLaminee : [Structure] → boolean
	
Constructors :
	init : int × int × int → [Structure]
		pre init(largeur, hauteur, orRestant) require largeur%2=1 ∧ hauteur%2=1 ∧ largeur > 1 ∧ hauteur > 1 ∧ orRestant>0

Operators :
	retrait : [Structure] × int → [Structure]
		pre retrait(S,somme) require ¬estLaminee(H) ∧ somme>0

Observations :
[invariants]
	estLaminee(S) =(min) orRestant(S) ≤ 0
[init]
	Terrain::largeur(init(l,h,o)) = l
	Terrain::hauteur(init(l,h,o)) = h
	orRestant(init(l,h,o)) = o
[retrait]
	orRestant(retrait(S,somme)) = orRestant(S)-somme



