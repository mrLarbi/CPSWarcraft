service : MoteurJeu
types : enum RESULTAT{GAGNE, PERDU, EGALITE}, enum COMMANDE{RIEN, DEPLACER, ENTRERMINE, FRAPPERMURAILLE, ENTRERHOTELVILLE}
			enum Side {PLAYER, ENEMY, NONE}, enum Race {HUMAN, ORC}

observators :
	const largeurTerrain : [MoteurJeu] → int
	
	const hauteurTerrain : [MoteurJeu] → int
	
	const maxPasJeu : [MoteurJeu] → int
	
	pasJeuCourant : [MoteurJeu] → int
	
	const playerRace : [MoteurJeu] → Race
	
	const enemyRace : [MoteurJeu] → Race
	
	estFini : [MoteurJeu] → boolean
	
	estInitialise : [MoteurJeu] → boolean
	
	resultatFinal : [MoteurJeu] → RESULTAT
		pre resultatFinal(M) require estFini(M)
	
	const numerosVillageois : [MoteurJeu] → Set<int>
	
	getVillageois : [MoteurJeu] × int → Villageois
		pre getVillageois(M,num) require num ∈ numerosVillageois(M,num)
	
	positionVillageoisX : [MoteurJeu] × int → int
		pre positionVillageoisX(M,num) require num ∈ numerosVillageois(M,num)
	
	positionVillageoisY : [MoteurJeu] × int → int
		pre positionVillageoisY(M,num) require num ∈ numerosVillageois(M,num)
	
	const numerosMine : [MoteurJeu] → Set<int>
	
	getMine : [MoteurJeu] × int → Mine
		pre getMine(M,num) require num ∈ numerosMine(M,num)
	
	const positionMineX : [MoteurJeu] × int → int
		pre positionMineX(M,num) require num ∈ numerosMine(M,num)
	
	const positionMineY : [MoteurJeu] × int → int
		pre positionMineY(M,num) require num ∈ numerosMine(M,num)
	
	const numerosRoute : [MoteurJeu] → Set<int>
	
	const getRoute : [MoteurJeu] × int → Route
		pre getRoute(M,num) require num ∈ numerosRoute(M,num)
	
	const positionRouteX : [MoteurJeu] × int → int
		pre positionRouteX(M,num) require num ∈ numerosRoute(M,num)
	
	const positionRouteY : [MoteurJeu] × int → int
		pre positionRouteY(M,num) require num ∈ numerosRoute(M,num)
	
	const numerosMuraille : [MoteurJeu] → Set<int>
	
	getMuraille : [MoteurJeu] × int → Muraille
		pre getMuraille(M,num) require num ∈ numerosMuraille(M,num)
	
	const positionMurailleX : [MoteurJeu] × int → int
		pre positionMurailleX(M,num) require num ∈ numerosMuraille(M,num)
	
	const positionMurailleY : [MoteurJeu] × int → int
		pre positionMurailleY(M,num) require num ∈ numerosMuraille(M,num)
	
	hotelDeVille : [MoteurJeu] × Side → HôtelVille
	
	const positionHotelVilleX : [MoteurJeu] × Side → int
	
	const positionHotelVilleY : [MoteurJeu] × Side → int
	
	peutEntrer : [MoteurJeu] × int × int → boolean
		pre peutEntrer(M,numVillageois,numMine) require numVillageois ∈ numeroesVillageois(M)
																		∧ numMine ∈ numeroesMine(M)
																		
	peutEntrerHotelVille : [MoteurJeu] × int → boolean
		pre peutEntrerHotelVille(M,numVillageois, s) require numVillageois ∈ numeroesVillageois(M)

	peutFrapperMuraille : [MoteurJeu] × int × int → boolean
		pre peutFrapperMuraille(M, numVillageois, numMuraille) require numVillageois ∈ numeroesVillageois(M)
																				∧ numMuraille ∈ numerosMuraille(M)
																		
	estVillageoisDansRoute : [MoteurJeu] × int → Route
			pre estVillageoisDansRoute(M, v) require v ∈ numeroesVillageois(M)
			
Constructors :
	init : int × int × int × Race × Race × string → [MoteurJeu]
		pre init(largeur,hauteur,maxPas, r1, r2, fileName) require largeur≥ 600 ∧ hauteur≥ 400 ∧ maxPas> 0 ∧ fileName!=""

Operators :
	pasJeu : [MoteurJeu] × COMMANDE × int × int → [MoteurJeu]
		pre pasJeu(M, comm, vill, arg) require vill ∈ numeroesVillageois(M) ∧ ¬estFini(M) ∧ estInitialise(M)
		{
			comm = DEPLACER ⇒ 0 ≤ arg < 360
			comm = ENTRERMINE ⇒ arg ∈ numeroesMine(M) ∧ peutEntrer(M, vill, arg)
			comm = FRAPPERMURAILLE ⇒ arg ∈ numeroesMuraille(M) ∧ peutFrapperMuraille(M, vill, arg) 
			comm = ENTRERHOTELVILLE ⇒ peutEntrerHotelVille(M, vill) 
		}

Observations :
[invariants]
	0 ≤ pasJeuCourant(M) ≤ maxPasJeu(M)
	estFini(M) =(min) HotelVille::orRestant(hotelDeVille(M,PLAYER)) ≥ 1664 ∨ HotelVille::orRestant(hotelDeVille(M, ENEMY)) ≥ 1664 ∨ pasJeuCourant(M)=maxPasJeu(M))
	resultatFinal(M)=GAGNE ⇔ HotelVille::orRestant(hotelDeVille(M, PLAYER)) ≥ 1664 ∧ HotelVille::orRestant(hotelDeVille(M, ENEMY)) < 1664 
	resultatFinal(M)=PERDU ⇔ HotelVille::orRestant(hotelDeVille(M, ENEMY)) ≥ 1664 ∧ HotelVille::orRestant(hotelDeVille(M, PLAYER)) < 1664 
	resultatFinal(M)=EGALITE ⇔ resultatFinal(M) != PERDU ∧ resultatFinal(M) != GAGNE
	
	peutEntrer(M,numVillageois,numMine) =(min) distance(positionVillageoisX(M,numVillageois),positionVillageoisY(M,numVillageois),
	positionMineX(M,numMine),positionMineY(M,numMine)) ≤ 51
	
	peutEntrerHotelVille(M,numVillageois) =(min) distance(positionVillageoisX(M,numVillageois),positionVillageoisY(M,numVillageois), positionHotelVilleX(M, Villageois::side(getVillageois(numVillageois))),positionHotelVilleY(M, Villageois::side(getVillageois(numVillageois)))) ≤ 51 ∧ Villageois::side(getVillageois(numVillageois))
	estInitialise(M) =(min) hotelDeVille(M, PLAYER) != NULL ∧ hotelDeVille(M, ENEMY) != NULL 
								∧ size(numeroesMine(M)) ≥ 3 ∧ size( ∀i ∈ numeroesVillageois(M) / Villageois::side(i) = PLAYER) ≥ 3 
								∧ size(∀i ∈ numeroesVillageois(M) / Villageois::side(i) = ENEMY) ≥ 3
								
	peutFrapperMuraille(M,numVillageois,numMuraille) =(min) distance(positionVillageoisX(M,numVillageois),positionVillageoisY(M,numVillageois), positionMurailleX(M,numMuraille),positionMurailleY(M,numMuraille)) ≤ 51
	
	//Si il existe une route en collision avec le villageois, alors on retourne cette route, sinon on retourne null
	estVillageoisDansRoute(M, numVillageois) =(min) if ∃ r ∈ numerosRoute(M) , collision(r,numVillageois) then r else null
	
[init]
	largeurTerrain(init(l,h,m, r1, r2,f)) = l
	hauteurTerrain(init(l,h,m, r1, r2,f)) = h
	maxPasJeu(init(l,h,m, r1, r2,f))=m
	pasJeuCourant(init(l,h,m, r1, r2,f))=0
	resultatFinal(init(l,h,m, r1, r2,f))=EGALITE
	playerRace(init(l,h,m, r1, r2,f)) = r1
	enemyRace(init(l,h,m, r1, r2,f)) = r2
	//Les autres observateurs sont initialisées à partir d'un fichier de configuration
	//On s'assurera tout de même que les deux hotel de ville sont initialisés et qu'il y'ait tout de même
	//un nombre de villageois au moins égal à 3 pour chaque camp, et un nombre de mine au moins égal à 3 aussi
	initialise(init(l,h,m, r1, r2,f)) = true
[pasJeu]
	pasJeuCourant(pasJeu(M,c,numVillageois,arg))=pasJeuCourant(M) +1
	{
		c = ENTRERMINE ⇒ ∀ i ∈ numeroesMine(M) / arg , ¬Mine::estAbandonnee(getMine(M, i)) ⇒ Mine::abandoned(getMine(M, i))
								∧ Mine::acceuil(getMine(M, arg)) 
								∧ Villageois::recupere(getVillageois(M, numVillageois), min(10, Mine::orRestant(M, arg)))
								∧ Mine::retrait(getMine(M, arg), min(10, Mine::orRestant(M, arg)))
		c != ENTRERMINE ⇒ ∀ i ∈ numeroesMine(M) , ¬Mine::estAbandonnee(getMine(M, i)) ⇒ Mine::abandoned(getMine(M, i))
		c = FRAPPERMURAILLE ⇒ ∀ i ∈ numeroesMuraille(M) / arg 
						, Muraille::pointDeVie(getMuraille(pasJeu(M,c, numVillageois, arg), i)) = Muraille::pointDeVie(getMuraille(M, i))
						∧ Muraille::frappee(getMuraille(M, arg), Villageois::force(getVillageois(M, numVillageois)))
		c != FRAPPERMURAILLE ⇒ ∀ i ∈ numeroesMuraille(M) , getMuraille(pasJeu(M,c, numVillageois, arg), i) = getMuraille(M, i)
		c = ENTRERHOTELVILLE ⇒ HotelVille::depot(hotelDeVille(M, 
																Villageois::side(getVillageois(M, numVillageois)))) 
																,Villageois::quantiteOr(getVillageois(M, numVillageois)))
										∧ Villageois::viderPoches(getVillageois(M, numVillageois))
		c != ENTRERHOTELVILLE ⇒ hotelDeVille(pasJeu(M,c, numVillageois, arg), PLAYER) = hotelDeVille(M, PLAYER)
										∧ hotelDeVille(pasJeu(M,c, numVillageois, arg), ENEMY) = hotelDeVille(M, ENEMY)
		c = DEPLACER ⇒ (∀ i ∈ numeroesVillageois(M) \ arg , positionVillageoisX(pasJeu(M,c, numVillageois, arg), numVillageois) 
																	 			= positionVillageoisX(M, numVillageois) 
																	 ∧ positionVillageoisY(pasJeu(M,c, numVillageois, arg), numVillageois) 
																	 			= positionVillageoisY(M, numVillageois) )
							∧ positionVillageoisX(pasJeu(M,c, numVillageois, arg), numVillageois) 
																	 			= positionVillageoisX(M, numVillageois) 
																	 ∧ positionVillageoisY(pasJeu(M,c, numVillageois, arg), numVillageois) 
																	 			= positionVillageoisY(M, numVillageois) 
		c != DEPLACER ⇒ ∀ i ∈ numeroesVillageois(M) , positionVillageoisX(pasJeu(M,c, numVillageois, arg), i) 
																	 			= positionVillageoisX(M, i) 
																	 positionVillageoisY(pasJeu(M,c, numVillageois, arg), i) 
																	 			= positionVillageoisY(M, i) 	
		c != ENTRERMINE ∧ c != ENTRERHOTELVILLE ⇒ 
		 ∀ i ∈ numeroesVillageois(M) , getVillageois(pasJeu(M,c, numVillageois, arg),i) = getVillageois(M, i)
	}
