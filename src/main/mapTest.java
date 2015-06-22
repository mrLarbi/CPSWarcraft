package test;

import java.util.Set;

import preset.MoteurJeuPreset;
import services.MoteurJeu;
import tools.Side;

public class mapTest {
	
	public static void main(String[] args)
	{
		MoteurJeu moteurJeu = MoteurJeuPreset.getMoteurJeu("config/map1.json");
		testMoteurJeu(moteurJeu);
	}

	private static void testMoteurJeu(MoteurJeu moteurJeu) {
		Set<Integer> villageois = moteurJeu.getNumerosVillageois();
		Set<Integer> mines = moteurJeu.getNumerosMines();
		Set<Integer> murailles = moteurJeu.getNumerosMurailles();
		Set<Integer> routes = moteurJeu.getNumerosRoutes();
		for(int i : villageois)
		{
			System.out.println("----------------------------");
			System.out.println("VillageoisNumber : " + i);
			System.out.println("Villageois x : " + moteurJeu.getPositionVillageoisX(i));
			System.out.println("Villageois y :: " + moteurJeu.getPositionVillageoisY(i));
			System.out.println("Villageois side : " + moteurJeu.getVillageois(i).getSide());
		}
		for(int i : mines)
		{
			System.out.println("----------------------------");
			System.out.println("MineNumber : " + i);
			System.out.println("Mine x : " + moteurJeu.getPositionMineX(i));
			System.out.println("Mine y :: " + moteurJeu.getPositionMineY(i));
		}
		for(int i : murailles)
		{
			System.out.println("----------------------------");
			System.out.println("MurailleNumber : " + i);
			System.out.println("Muraille x : " + moteurJeu.getPositionMurailleX(i));
			System.out.println("Muraille y :: " + moteurJeu.getPositionMurailleY(i));
		}
		for(int i : routes)
		{
			System.out.println("----------------------------");
			System.out.println("RouteNumber : " + i);
			System.out.println("Route x : " + moteurJeu.getPositionRouteX(i));
			System.out.println("Route y :: " + moteurJeu.getPositionRouteY(i));
		}
		
		System.out.println("----------------------------");
		System.out.println("Player Hotel ville");
		System.out.println("Player Hotel ville x : " + moteurJeu.getPositionHotelVilleX(Side.PLAYER));
		System.out.println("Player Hotel ville y : " + moteurJeu.getPositionHotelVilleY(Side.PLAYER));
		
		System.out.println("----------------------------");
		System.out.println("Enemy Hotel ville");
		System.out.println("Enemy Hotel ville x : " + moteurJeu.getPositionHotelVilleX(Side.ENEMY));
		System.out.println("Enemy Hotel ville y : " + moteurJeu.getPositionHotelVilleY(Side.ENEMY));
		
		
		System.out.println("Is initialised : " + moteurJeu.estInitialise());
	}
	
}
