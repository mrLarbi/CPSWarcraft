service : Mine
refine  : Structure
enum Side {PLAYER, ENEMY, NONE}

observators :
	estAbandonnee   : [Mine] → boolean
	abandonCompteur : [Mine] → int
	side            : [Mine] → Side
		pre side(M) require ¬estAbandonnee(M)
Constructors :
	init : int × int × int → [Mine]
		pre init(largeur,hauteur,orRestant) require largeur%2=1 ∧ hauteur%2=1 ∧ largeur > 1 ∧ hauteur > 1  ∧ orRestant>0

Operators :
	acceuil : [Mine] × Side → [Mine]
	abandoned : [Mine] → [Mine]
		pre abandoned(M) require ¬estAbandonnee(M)
		
Observations :
[Invariants]	
	estAbandonnee(M) =(min) abandonCompteur = 51
	0 ≤abandonCompteur(M) ≤ 51
	side(M) = NONE ⇔ estAbandonnee(M)
[init]
	Terrain::largeur(init(l,h,o)) = l
	Terrain::hauteur(init(l,h,o)) = h
	Structure::orRestant(init(l,h,o)) = 51
	abandonCompteur(init(l,h,o)) = 51
	side(init(l,h,o)) = NONE
[acceuil]
	Structure::orRestant(acceuil(M,s)) = orRestant(M)
	abandonCompteur(accueil(M,s)) = (s=NONE)? 0: 51
	side(acceuil(M,s)) = s
[abandoned]
	Structure::orRestant(abandoned(M)) = orRestant(M)
	abandonCompteur(abandoned(M)) = abandonCompteur()+1
	side(abandoned(M)) = side(M)
[retrait]
	Structure::orRestant(retrait(S,somme)) = orRestant(S)-somme
	abandonCompteur(retrait(S,somme)) = abandonCompteur(S)
	side(Structure.retrait(M, s)) = side(M)
