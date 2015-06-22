package factory;

import services.HotelVille;
import services.Mine;
import services.MoteurJeu;
import services.Muraille;
import services.Route;
import services.Villageois;

import tools.Side;
import tools.Race;


public interface IFactory
{
	public HotelVille makeHotelVille(int largeur, int hauteur, Side side, int orRestant);
	public Mine makeMine(int largeur, int hauteur,  int orRestant);
	public MoteurJeu makeMoteurJeu(int largeur, int hauteur, int maxPas, Race playerRace, Race enemyRace, String fileName);
	public Muraille makeMuraille(int largeur, int hauteur, int pointsDeVie);
	public Route makeRoute(int largeur, int hauteur, int facteur);
	public Villageois makeVillageois(Race race,Side side,int largeur,int hauteur, int force, double vitesse, int pointsVie);
}
