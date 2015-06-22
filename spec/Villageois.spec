service : Villageois
enum Race {HUMAN, ORC}
enum Side {PLAYER, ENEMY}

observators :
	const race    : [Villageois] → Race
	const side    : [Villageois] → Side
	const largeur : [Villageois] → int
	const hauteur : [Villageois] → int
	const force   : [Villageois] → int
	const vitesse : [Villageois] → double
	pointsDeVie   : [Villageois] → int
	quantiteOr    : [Villageois] → int
	estMort       : [Villageois] → boolean

Constructors :
	init : Race × Side × int × int × int × double × int → [Villageois]
		pre init(race, side, largeur,hauteur,force,vitesse,pointsVie) require 
		largeur%2=1 ∧ hauteur%2=1 ∧ largeur > 1 ∧ hauteur > 1 ∧ force ≥ 0 ∧ vitesse≥0 ∧ pointsDeVie≥0

Operators :
	retrait : [Villageois] × int → [Villageois]
		pre retrait(V,s) require ¬estMort(V) ∧ s>0
	viderPoches : [Villageois] → [Villageois]
		pre viderPoches(V) require ¬estMort(V)
	recupere : [Villageois] × int → [Villageois]
		pre recupere(V, s) require ¬estMort(V) ∧ s>0
		
Observations :
[invariants]
		estMort(V) =(min) pointsDeVie(V) ≤ 0
		quantiteOr(V) ≥ 0
[init]
	race(init(r,s,l,h,f,v,p))=r
	side(init(r,s,l,h,f,v,p))=s
	largeur(init(r,s,l,h,f,v,p))=l
	hauteur(init(r,s,l,h,f,v,p))=h
	force(init(r,s,l,h,f,v,p))=f
	vitesse(init(r,s,l,h,f,v,p))=v
	pointsDeVie(init(r,s,l,h,f,v,p))=p
	quantiteOr(init(r,s,l,h,f,v,p))=0
[retrait]
	pointsDeVie(retrait(V,s))=pointsDeVie(V) - s
	quantiteOr(retrait(V,s))=quantiteOr(V)
[viderPoches]
	pointsDeVie(viderPoches(V))=pointsDeVie(V)
	quantiteOr(viderPoches(V))=0
[recupere]
	pointsDeVie(recupere(V,s))=pointsDeVie(V)
	quantiteOr(recupere(V,s))=quantiteOr(V)+s
