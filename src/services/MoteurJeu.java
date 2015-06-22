package services;

import java.util.Set;

import tools.Commande;
import tools.Race;
import tools.Resultat;
import tools.Side;

public interface MoteurJeu
{
	//Observators
	public int getLargeurTerrain();
	public int getHauteurTerrain();
	public int getMaxPasJeu();
	public int getPasJeuCourant();
	public boolean estFini();
	// \pre: estFini() == true
	public boolean estInitialise();
	public Resultat getResultatFinal();
	public Set<Integer> getNumerosVillageois();
	// \pre: EXISTS numVillageois IN getNumerosVillageois()
	public Villageois getVillageois(int numVillageois);
	// \pre: EXISTS numVillageois IN getNumerosVillageois()
	public int getPositionVillageoisX(int numVillageois);
	// \pre: EXISTS numVillageois IN getNumerosVillageois()
	public int getPositionVillageoisY(int numVillageois);
	public Set<Integer> getNumerosMines();
	// \pre: EXISTS numMine IN getNumerosMines()
	public Mine getMine(int numMine);
	// \pre: EXISTS numMine IN getNumerosMines()
	public int getPositionMineX(int numMine);
	// \pre: EXISTS numMine IN getNumerosMines()
	public int getPositionMineY(int numMine);
	public Set<Integer> getNumerosRoutes();
	// \pre: EXISTS numRoute IN getNumerosRoutes()
	public Route getRoute(int numRoute);
	// \pre: EXISTS numRoute IN getNumerosRoutes()
	public int getPositionRouteX(int numRoute);
	// \pre: EXISTS numRoute IN getNumerosRoutes()
	public int getPositionRouteY(int numRoute);
	public Set<Integer> getNumerosMurailles();
	// \pre: EXISTS numMuraille IN getNumerosMurailles()
	public Muraille getMuraille(int numMuraille);
	// \pre: EXISTS numMuraille IN getNumerosMurailles()
	public int getPositionMurailleX(int numMuraille);
	// \pre: EXISTS numMuraille IN getNumerosMurailles()
	public int getPositionMurailleY(int numMuraille);
	public HotelVille getHotelVille(Side side);
	public int getPositionHotelVilleX(Side side);
	public int getPositionHotelVilleY(Side side);
	// \pre: EXISTS numVillageois IN getNumerosVillageois()
	// 	&& EXISTS numMine IN getNumerosMines()
	public boolean peutEntrer(int numVillageois, int numMine);
	// \pre: EXISTS numVillageois IN getNumerosVillageois()
	public boolean peutEntrerHotelVille(int numVillageois);
// \pre: EXISTS numVillageois IN getNumerosVillageois()
	// 	&& EXISTS numMuraille IN getNumerosMurailles()
	public boolean peutFrapperMuraille(int numVillageois, int numMuraille);
	// \pre: EXISTS numVillageois IN getNumerosVillageois()
	public Route estVillageoisDansRoute(int numVillageois);
	
	
	//Constructors
	// \pre: largeur >= 600
	// 	&& hauteur >= 400
	//		&& maxPas >= 0
	public void init(int largeur, int hauteur, int maxPas, Race playerRace, Race enemyRace, String fileName);
	
	
	//Operators
	public void pasJeu(Commande commande, int numVillageois, int argument);
	
	public Race getPlayerRace();
	public Race getEnemyRace();
	
	
}
