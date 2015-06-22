package factory;

import services.HotelVille;
import services.Mine;
import services.MoteurJeu;
import services.Muraille;
import services.Route;
import services.Villageois;

import implementations.HotelVilleImpl;
import implementations.MineImpl;
import implementations.MoteurJeuImpl;
import implementations.MurailleImpl;
import implementations.RouteImpl;
import implementations.VillageoisImpl;


import tools.Side;
import tools.Race;

public class FactoryImpl implements IFactory
{
	public HotelVille makeHotelVille(int largeur, int hauteur, Side side, int orRestant)
	{
		return new HotelVilleImpl(largeur, hauteur, side, orRestant);
	}
	
	public Mine makeMine(int largeur, int hauteur, int orRestant)
	{
		return new MineImpl(largeur, hauteur, orRestant);
	}
	
	public MoteurJeu makeMoteurJeu(int largeur, int hauteur, int maxPas, Race playerRace, Race enemyRace, String fileName)
	{
		return new MoteurJeuImpl(largeur, hauteur, maxPas, playerRace, enemyRace, fileName);
	}
	
	public Muraille makeMuraille(int largeur, int hauteur, int pointsDeVie)
	{
		return new MurailleImpl(largeur, hauteur, pointsDeVie);
	}
	
	public Route makeRoute(int largeur, int hauteur, int facteur)
	{
		return new RouteImpl(largeur, hauteur, facteur);
	}
	
	public Villageois makeVillageois(Race race, Side side, int largeur, 
			int hauteur, int force, double vitesse, int pointsVie) {
		
		return new VillageoisImpl(race, side, largeur, hauteur, force, vitesse, pointsVie);
	}
}
