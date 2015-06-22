service : HotelVille
refine : Structure
enum Side {PLAYER, ENEMY, NONE}

observators :
	const side : [HotelVille] → Side

Constructors :
	init : int × int × Side × int → [HotelVille]
		pre init(largeur,hauteur,side,orRestant) require largeur%2=1 ∧ hauteur%2=1 ∧ largeur>1 ∧ hauteur>1  ∧ orRestant>0 ∧ side!=NONE

Operators :
	depot : [HotelVille] × int → [HotelVille]
		pre depot(H,somme) require somme>0		

Observations :
[init]
	Terrain.largeur(init(l,h,s,o)) = l
	Terrain.hauteur(init(l,h,s,o)) = h
	Structure.orRestant(init(l,h,s,o)) = orRestant
	side(init(l,h,s,o)) = s
[depot]
	Structure::orRestant(depot(H,somme)) = orRestant(H)+somme
[retrait]
	Structure::orRestant(retrait(S,somme)) = orRestant(S)-somme
