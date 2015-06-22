package test;

import preset.HotelVillePreset;
import preset.MinePreset;
import preset.MoteurJeuPreset;
import preset.MuraillePreset;
import preset.RoutePreset;
import preset.VillageoisHumanPreset;
import preset.VillageoisOrcPreset;
import services.HotelVille;
import services.Mine;
import services.MoteurJeu;
import services.Muraille;
import services.Route;
import services.Villageois;
import tools.Side;

public class TestPreset {
	private static HotelVille hotelVille1 ;
	private static HotelVille hotelVille2 ;
	private static Mine mine ;
	private static Muraille muraille ;
	private static Route route ;
	private static Villageois orc ;
	private static Villageois human ;
	private static MoteurJeu moteurJeu;
	
	private static void testInit()
	{
		hotelVille1 = HotelVillePreset.getHotelVille(Side.PLAYER);
		hotelVille2 = HotelVillePreset.getHotelVille(Side.ENEMY);
		mine = MinePreset.getMine();
		muraille = MuraillePreset.getMuraille();
		route = RoutePreset.getRoute();
		orc = VillageoisOrcPreset.getOrcVillageois(Side.PLAYER);
		human = VillageoisHumanPreset.getHumanVillageois(Side.ENEMY);
		moteurJeu = MoteurJeuPreset.getMoteurJeu("config/map1.json");
	}
	
	private static void testHotelVille(HotelVille hv)
	{
		System.out.println("Largeur : " + hv.getLargeur());
		System.out.println("Hauteur : " + hv.getHauteur());
		System.out.println("Or restant : " + hv.getOrRestant());
		System.out.println("Side : " + hv.getSide());
	}
	
	private static void testMine(Mine m)
	{
		System.out.println("Largeur : " + m.getLargeur());
		System.out.println("Hauteur : " + m.getHauteur());
		System.out.println("Or restant : " + m.getOrRestant());
		System.out.println("Side : " + m.getSide());
		System.out.println("Abandon compteur : " + m.getAbandonCompteur());
	}
	
	private static void testMuraille(Muraille m)
	{
		System.out.println("Largeur : " + m.getLargeur());
		System.out.println("Hauteur : " + m.getHauteur());
		System.out.println("Points de vie : " + m.getPointsDeVie());
	}
	
	private static void testRoute(Route r)
	{
		System.out.println("Largeur : " + r.getLargeur());
		System.out.println("Hauteur : " + r.getHauteur());
		System.out.println("Facteur mult : " + r.getFacteurMult());
	}
	
	private static void testVillageois(Villageois v)
	{
		System.out.println("Largeur : " + v.getLargeur());
		System.out.println("Hauteur : " + v.getHauteur());
		System.out.println("Force : " + v.getForce());
		System.out.println("Vitesse : " + v.getVitesse());
		System.out.println("Points de vie : " + v.getPointsDeVie());
		System.out.println("Race : " + v.getRace());
		System.out.println("Side : " + v.getSide());
	}
	
	private static void testMoteurJeu(MoteurJeu mj)
	{
		System.out.println("Largeur : " + mj.getLargeurTerrain());
		System.out.println("Hauteur : " + mj.getHauteurTerrain());
		System.out.println("maxPas : " + mj.getMaxPasJeu());
		System.out.println("Player race: " + mj.getPlayerRace());
		System.out.println("Enemy race: " + mj.getEnemyRace());
	}
	
	public static void main(String[] args)
	{
		testInit();
		System.out.println("-------------Test Hotel de Ville 1-------------");
		testHotelVille(hotelVille1);
		System.out.println("-------------Test Hotel de ville 2-------------");
		testHotelVille(hotelVille2);
		System.out.println("-------------Test Mine-------------");
		testMine(mine);
		System.out.println("-------------Test Muraille-------------");
		testMuraille(muraille);
		System.out.println("-------------Test Route-------------");
		testRoute(route);
		System.out.println("-------------Test Humain-------------");
		testVillageois(human);
		System.out.println("-------------Test Orc-------------");
		testVillageois(orc);
		System.out.println("-------------Test Moteur jeu-------------");
		testMoteurJeu(moteurJeu);
	}
}
