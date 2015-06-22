package factory;

import services.HotelVille;
import services.Mine;
import services.MoteurJeu;
import services.Muraille;
import services.Route;
import services.Villageois;

import implementationsBug.HotelVilleImplBug;
import implementationsBug.MineImplBug;
import implementationsBug.MoteurJeuImplBug;
import implementationsBug.MurailleImplBug;
import implementationsBug.RouteImplBug;
import implementationsBug.VillageoisImplBug;

import tools.Side;
import tools.Race;

public class FactoryImplBug implements IFactory
{
	public HotelVille makeHotelVille(int largeur, int hauteur, Side side, int orRestant)
	{
		return new HotelVilleImplBug(largeur, hauteur, side, orRestant);
	}
	
	public Mine makeMine(int largeur, int hauteur, int orRestant)
	{
		return new MineImplBug(largeur, hauteur, orRestant);
	}
	
	public MoteurJeu makeMoteurJeu(int largeur, int hauteur, int maxPas, Race playerRace, Race enemyRace, String fileName)
	{
		return new MoteurJeuImplBug(largeur, hauteur, maxPas, playerRace, enemyRace, fileName);
	}
	
	public Muraille makeMuraille(int largeur, int hauteur, int pointsDeVie)
	{
		return new MurailleImplBug(largeur, hauteur, pointsDeVie);
	}
	
	public Route makeRoute(int largeur, int hauteur, int facteur)
	{
		return new RouteImplBug(largeur, hauteur, facteur);
	}
	
	public Villageois makeVillageois(Race race, Side side, int largeur, 
			int hauteur, int force, double vitesse, int pointsVie) {
		
		return new VillageoisImplBug(race, side, largeur, hauteur, force, vitesse, pointsVie);
	}
}
