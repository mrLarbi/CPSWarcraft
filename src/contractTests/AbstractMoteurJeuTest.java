package contractTests;

import java.util.ArrayList;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import services.MoteurJeu;
import tools.Commande;
import tools.Race;
import tools.Side;

public abstract class AbstractMoteurJeuTest {
	protected MoteurJeu testMoteurJeu;

	@Before
	public abstract void beforeTesting();
	
	@Test
	public void testMoteurJeuInit1()
	{
		int largeur = 640;
		int hauteur = 480;
		int maxPas = 1000;
		Race playerRace = Race.HUMAN;
		Race enemyRace = Race.ORC;
		testMoteurJeu.init(largeur, hauteur, maxPas, playerRace, enemyRace, "config/map1.json");
		Assert.assertTrue("Moteur jeu test init 1", testMoteurJeu.getLargeurTerrain() == largeur);
		Assert.assertTrue("Moteur jeu test init 1", testMoteurJeu.getHauteurTerrain() == hauteur);
		Assert.assertTrue("Moteur jeu test init 1", testMoteurJeu.getMaxPasJeu() == maxPas);
		Assert.assertTrue("Moteur jeu test init 1", testMoteurJeu.getPlayerRace() == playerRace);
		Assert.assertTrue("Moteur jeu test init 1", testMoteurJeu.getEnemyRace() == enemyRace);
		Assert.assertTrue("Moteur jeu test init 1", testMoteurJeu.getPasJeuCourant() == 0);
		Assert.assertTrue("Moteur jeu test init 1", testMoteurJeu.estInitialise());
	}
	
	@Test
	public void testMoteurJeuInit2()
	{
		int largeur = 640;
		int hauteur = 480;
		int maxPas = 200;
		Race playerRace = Race.ORC;
		Race enemyRace = Race.HUMAN;
		testMoteurJeu.init(largeur, hauteur, maxPas, playerRace, enemyRace, "config/map1.json");
		Assert.assertTrue("Moteur jeu test init 1", testMoteurJeu.getLargeurTerrain() == largeur);
		Assert.assertTrue("Moteur jeu test init 1", testMoteurJeu.getHauteurTerrain() == hauteur);
		Assert.assertTrue("Moteur jeu test init 1", testMoteurJeu.getMaxPasJeu() == maxPas);
		Assert.assertTrue("Moteur jeu test init 1", testMoteurJeu.getPlayerRace() == playerRace);
		Assert.assertTrue("Moteur jeu test init 1", testMoteurJeu.getEnemyRace() == enemyRace);
		Assert.assertTrue("Moteur jeu test init 1", testMoteurJeu.getPasJeuCourant() == 0);
		Assert.assertTrue("Moteur jeu test init 1", testMoteurJeu.estInitialise());
	}
	
	@Test
	public void testMoteurJeuInit3()
	{
		int largeur = 720;
		int hauteur = 560;
		int maxPas = 200;
		Race playerRace = Race.ORC;
		Race enemyRace = Race.HUMAN;
		testMoteurJeu.init(largeur, hauteur, maxPas, playerRace, enemyRace, "config/map1.json");
		Assert.assertTrue("Moteur jeu test init 1", testMoteurJeu.getLargeurTerrain() == largeur);
		Assert.assertTrue("Moteur jeu test init 1", testMoteurJeu.getHauteurTerrain() == hauteur);
		Assert.assertTrue("Moteur jeu test init 1", testMoteurJeu.getMaxPasJeu() == maxPas);
		Assert.assertTrue("Moteur jeu test init 1", testMoteurJeu.getPlayerRace() == playerRace);
		Assert.assertTrue("Moteur jeu test init 1", testMoteurJeu.getEnemyRace() == enemyRace);
		Assert.assertTrue("Moteur jeu test init 1", testMoteurJeu.getPasJeuCourant() == 0);
		Assert.assertTrue("Moteur jeu test init 1", testMoteurJeu.estInitialise());
	}
	
	@Test
	public void testMoteurJeuInit4()
	{
		int largeur = 600;
		int hauteur = 400;
		int maxPas = 200;
		Race playerRace = Race.ORC;
		Race enemyRace = Race.HUMAN;
		testMoteurJeu.init(largeur, hauteur, maxPas, playerRace, enemyRace, "config/map1.json");
		Assert.assertTrue("Moteur jeu test init 1", testMoteurJeu.getLargeurTerrain() == largeur);
		Assert.assertTrue("Moteur jeu test init 1", testMoteurJeu.getHauteurTerrain() == hauteur);
		Assert.assertTrue("Moteur jeu test init 1", testMoteurJeu.getMaxPasJeu() == maxPas);
		Assert.assertTrue("Moteur jeu test init 1", testMoteurJeu.getPlayerRace() == playerRace);
		Assert.assertTrue("Moteur jeu test init 1", testMoteurJeu.getEnemyRace() == enemyRace);
		Assert.assertTrue("Moteur jeu test init 1", testMoteurJeu.getPasJeuCourant() == 0);
		Assert.assertTrue("Moteur jeu test init 1", testMoteurJeu.estInitialise());
	}
	
	@Test
	public void testMoteurJeuPasJeu1()
	{
		int largeur = 640;
		int hauteur = 480;
		int maxPas = 1000;
		Race playerRace = Race.ORC;
		Race enemyRace = Race.HUMAN;
		
		testMoteurJeu.init(largeur, hauteur, maxPas, playerRace, enemyRace, "config/testPasJeu.json");
		
		testMoteurJeu.pasJeu(Commande.RIEN, 0, 0);
		
		ArrayList<Integer> positions = new ArrayList<>();
		ArrayList<Integer> pvVillageois = new ArrayList<>();
		ArrayList<Integer> orVillageois = new ArrayList<>();
		
		for(int i : testMoteurJeu.getNumerosVillageois())
		{
			pvVillageois.add(testMoteurJeu.getVillageois(i).getPointsDeVie());
			orVillageois.add(testMoteurJeu.getVillageois(i).getQuantiteOr());
			positions.add(testMoteurJeu.getPositionVillageoisX(i));
			positions.add(testMoteurJeu.getPositionVillageoisY(i));
		}
		
		ArrayList<Integer> orMines = new ArrayList<>();
		ArrayList<Integer> compteurMines = new ArrayList<>();
		
		for(int i : testMoteurJeu.getNumerosMines())
		{
			orMines.add(testMoteurJeu.getMine(i).getOrRestant());
			compteurMines.add(testMoteurJeu.getMine(i).getAbandonCompteur());
		}
		
		ArrayList<Integer> pvMurailles = new ArrayList<>();
		
		for(int i : testMoteurJeu.getNumerosMurailles())
		{
			pvMurailles.add(testMoteurJeu.getMuraille(i).getPointsDeVie());
		}
		
		
		int playerHotelOr = testMoteurJeu.getHotelVille(Side.PLAYER).getOrRestant();
		int enemyHotelOr = testMoteurJeu.getHotelVille(Side.ENEMY).getOrRestant();
		
		
		Assert.assertTrue(testMoteurJeu.getPasJeuCourant() == 1);
		for(int i : positions)
		{
			Assert.assertTrue(i == 300);
		}
		for(int i : orMines)
		{
			Assert.assertTrue(i == 180);
		}
		for(int i : compteurMines)
		{
			Assert.assertTrue(i == 51);
		}
		for(int i : orVillageois)
		{
			Assert.assertTrue(i == 0);
		}
		for(int i : pvVillageois)
		{
			Assert.assertTrue(i == 30);
		}
		for(int i : pvMurailles)
		{
			Assert.assertTrue(i == 20);
		}
		
		Assert.assertTrue(playerHotelOr == 16);
		Assert.assertTrue(enemyHotelOr == 16);
	}
	
	@Test
	public void testMoteurJeuPasJeu2()
	{
		int largeur = 640;
		int hauteur = 480;
		int maxPas = 1000;
		Race playerRace = Race.ORC;
		Race enemyRace = Race.HUMAN;
		
		testMoteurJeu.init(largeur, hauteur, maxPas, playerRace, enemyRace, "config/testPasJeu.json");
		
		testMoteurJeu.pasJeu(Commande.FRAPPERMURAILLE, 0, 0);
		
		ArrayList<Integer> positions = new ArrayList<>();
		ArrayList<Integer> pvVillageois = new ArrayList<>();
		ArrayList<Integer> orVillageois = new ArrayList<>();
		
		for(int i : testMoteurJeu.getNumerosVillageois())
		{
			pvVillageois.add(testMoteurJeu.getVillageois(i).getPointsDeVie());
			orVillageois.add(testMoteurJeu.getVillageois(i).getQuantiteOr());
			positions.add(testMoteurJeu.getPositionVillageoisX(i));
			positions.add(testMoteurJeu.getPositionVillageoisY(i));
		}
		
		ArrayList<Integer> orMines = new ArrayList<>();
		ArrayList<Integer> compteurMines = new ArrayList<>();
		
		for(int i : testMoteurJeu.getNumerosMines())
		{
			orMines.add(testMoteurJeu.getMine(i).getOrRestant());
			compteurMines.add(testMoteurJeu.getMine(i).getAbandonCompteur());
		}
		
		ArrayList<Integer> pvMurailles = new ArrayList<>();
		
		for(int i : testMoteurJeu.getNumerosMurailles())
		{
			pvMurailles.add(testMoteurJeu.getMuraille(i).getPointsDeVie());
		}
		
		
		int playerHotelOr = testMoteurJeu.getHotelVille(Side.PLAYER).getOrRestant();
		int enemyHotelOr = testMoteurJeu.getHotelVille(Side.ENEMY).getOrRestant();
		
		pvMurailles.remove(0);
		
		int pvMuraille0 = testMoteurJeu.getMuraille(0).getPointsDeVie();
		
		Assert.assertTrue(testMoteurJeu.getPasJeuCourant() == 1);
		for(int i : positions)
		{
			Assert.assertTrue(i == 300);
		}
		for(int i : orMines)
		{
			Assert.assertTrue(i == 180);
		}
		for(int i : compteurMines)
		{
			Assert.assertTrue(i == 51);
		}
		for(int i : orVillageois)
		{
			Assert.assertTrue(i == 0);
		}
		for(int i : pvVillageois)
		{
			Assert.assertTrue(i == 30);
		}
		for(int i : pvMurailles)
		{
			Assert.assertTrue(i == 20);
		}
		
		Assert.assertTrue(playerHotelOr == 16);
		Assert.assertTrue(enemyHotelOr == 16);
		
		Assert.assertTrue(pvMuraille0 == 16);
	}
	
	@Test
	public void testMoteurJeuPasJeu3()
	{
		int largeur = 640;
		int hauteur = 480;
		int maxPas = 1000;
		Race playerRace = Race.ORC;
		Race enemyRace = Race.HUMAN;
		
		testMoteurJeu.init(largeur, hauteur, maxPas, playerRace, enemyRace, "config/testPasJeu.json");
		
		testMoteurJeu.pasJeu(Commande.ENTRERMINE, 0, 0);
		
		ArrayList<Integer> positions = new ArrayList<>();
		ArrayList<Integer> pvVillageois = new ArrayList<>();
		ArrayList<Integer> orVillageois = new ArrayList<>();
		
		for(int i : testMoteurJeu.getNumerosVillageois())
		{
			pvVillageois.add(testMoteurJeu.getVillageois(i).getPointsDeVie());
			orVillageois.add(testMoteurJeu.getVillageois(i).getQuantiteOr());
			positions.add(testMoteurJeu.getPositionVillageoisX(i));
			positions.add(testMoteurJeu.getPositionVillageoisY(i));
		}
		
		ArrayList<Integer> orMines = new ArrayList<>();
		ArrayList<Integer> compteurMines = new ArrayList<>();
		
		for(int i : testMoteurJeu.getNumerosMines())
		{
			orMines.add(testMoteurJeu.getMine(i).getOrRestant());
			compteurMines.add(testMoteurJeu.getMine(i).getAbandonCompteur());
		}
		
		ArrayList<Integer> pvMurailles = new ArrayList<>();
		
		for(int i : testMoteurJeu.getNumerosMurailles())
		{
			pvMurailles.add(testMoteurJeu.getMuraille(i).getPointsDeVie());
		}
		
		
		int playerHotelOr = testMoteurJeu.getHotelVille(Side.PLAYER).getOrRestant();
		int enemyHotelOr = testMoteurJeu.getHotelVille(Side.ENEMY).getOrRestant();
		
		orMines.remove(0);
		compteurMines.remove(0);
		int orMine0 = testMoteurJeu.getMine(0).getOrRestant();
		int compteurMine0 = testMoteurJeu.getMine(0).getAbandonCompteur();
		
		orVillageois.remove(0);
		int orVillageois0 = testMoteurJeu.getVillageois(0).getQuantiteOr();
		
		
		Assert.assertTrue(testMoteurJeu.getPasJeuCourant() == 1);
		for(int i : positions)
		{
			Assert.assertTrue(i == 300);
		}
		for(int i : orMines)
		{
			Assert.assertTrue(i == 180);
		}
		for(int i : compteurMines)
		{
			Assert.assertTrue(i == 51);
		}
		for(int i : orVillageois)
		{
			Assert.assertTrue(i == 0);
		}
		for(int i : pvVillageois)
		{
			Assert.assertTrue(i == 30);
		}
		for(int i : pvMurailles)
		{
			Assert.assertTrue(i == 20);
		}
		
		Assert.assertTrue(playerHotelOr == 16);
		Assert.assertTrue(enemyHotelOr == 16);
		
		Assert.assertTrue(orMine0 == 170);
		Assert.assertTrue(compteurMine0 == 0);
		Assert.assertTrue(orVillageois0 == 10);
	}
	
	@Test
	public void testMoteurJeuPasJeu4()
	{
		int largeur = 640;
		int hauteur = 480;
		int maxPas = 1000;
		Race playerRace = Race.ORC;
		Race enemyRace = Race.HUMAN;
		
		testMoteurJeu.init(largeur, hauteur, maxPas, playerRace, enemyRace, "config/testPasJeu.json");
		
		testMoteurJeu.pasJeu(Commande.ENTRERMINE, 0, 0);
		testMoteurJeu.pasJeu(Commande.ENTRERHOTELVILLE, 0, 0);
		
		ArrayList<Integer> positions = new ArrayList<>();
		ArrayList<Integer> pvVillageois = new ArrayList<>();
		ArrayList<Integer> orVillageois = new ArrayList<>();
		
		for(int i : testMoteurJeu.getNumerosVillageois())
		{
			pvVillageois.add(testMoteurJeu.getVillageois(i).getPointsDeVie());
			orVillageois.add(testMoteurJeu.getVillageois(i).getQuantiteOr());
			positions.add(testMoteurJeu.getPositionVillageoisX(i));
			positions.add(testMoteurJeu.getPositionVillageoisY(i));
		}
		
		ArrayList<Integer> orMines = new ArrayList<>();
		ArrayList<Integer> compteurMines = new ArrayList<>();
		
		for(int i : testMoteurJeu.getNumerosMines())
		{
			orMines.add(testMoteurJeu.getMine(i).getOrRestant());
			compteurMines.add(testMoteurJeu.getMine(i).getAbandonCompteur());
		}
		
		ArrayList<Integer> pvMurailles = new ArrayList<>();
		
		for(int i : testMoteurJeu.getNumerosMurailles())
		{
			pvMurailles.add(testMoteurJeu.getMuraille(i).getPointsDeVie());
		}
		
		
		int playerHotelOr = testMoteurJeu.getHotelVille(Side.PLAYER).getOrRestant();
		int enemyHotelOr = testMoteurJeu.getHotelVille(Side.ENEMY).getOrRestant();
		
		orMines.remove(0);
		compteurMines.remove(0);
		int orMine0 = testMoteurJeu.getMine(0).getOrRestant();
		int compteurMine0 = testMoteurJeu.getMine(0).getAbandonCompteur();
		
		orVillageois.remove(0);
		int orVillageois0 = testMoteurJeu.getVillageois(0).getQuantiteOr();
		
		
		Assert.assertTrue(testMoteurJeu.getPasJeuCourant() == 2);
		for(int i : positions)
		{
			Assert.assertTrue(i == 300);
		}
		for(int i : orMines)
		{
			Assert.assertTrue(i == 180);
		}
		for(int i : compteurMines)
		{
			Assert.assertTrue(i == 51);
		}
		for(int i : orVillageois)
		{
			Assert.assertTrue(i == 0);
		}
		for(int i : pvVillageois)
		{
			Assert.assertTrue(i == 30);
		}
		for(int i : pvMurailles)
		{
			Assert.assertTrue(i == 20);
		}
		
		Assert.assertTrue(playerHotelOr == 26);
		Assert.assertTrue(enemyHotelOr == 16);
		
		Assert.assertTrue(orMine0 == 170);
		Assert.assertTrue(compteurMine0 == 1);
		Assert.assertTrue(orVillageois0 == 0);
	}
	
	@Test
	public void testMoteurJeuPasJeu5()
	{
		int largeur = 640;
		int hauteur = 480;
		int maxPas = 1000;
		Race playerRace = Race.ORC;
		Race enemyRace = Race.HUMAN;
		
		testMoteurJeu.init(largeur, hauteur, maxPas, playerRace, enemyRace, "config/testPasJeu.json");
		
		testMoteurJeu.pasJeu(Commande.DEPLACER, 0, 45);
		
		ArrayList<Integer> positionsX = new ArrayList<>();
		ArrayList<Integer> positionsY = new ArrayList<>();
		ArrayList<Integer> pvVillageois = new ArrayList<>();
		ArrayList<Integer> orVillageois = new ArrayList<>();
		
		for(int i : testMoteurJeu.getNumerosVillageois())
		{
			pvVillageois.add(testMoteurJeu.getVillageois(i).getPointsDeVie());
			orVillageois.add(testMoteurJeu.getVillageois(i).getQuantiteOr());
			positionsX.add(testMoteurJeu.getPositionVillageoisX(i));
			positionsY.add(testMoteurJeu.getPositionVillageoisY(i));
		}
		
		ArrayList<Integer> orMines = new ArrayList<>();
		ArrayList<Integer> compteurMines = new ArrayList<>();
		
		for(int i : testMoteurJeu.getNumerosMines())
		{
			orMines.add(testMoteurJeu.getMine(i).getOrRestant());
			compteurMines.add(testMoteurJeu.getMine(i).getAbandonCompteur());
		}
		
		ArrayList<Integer> pvMurailles = new ArrayList<>();
		
		for(int i : testMoteurJeu.getNumerosMurailles())
		{
			pvMurailles.add(testMoteurJeu.getMuraille(i).getPointsDeVie());
		}
		
		
		int playerHotelOr = testMoteurJeu.getHotelVille(Side.PLAYER).getOrRestant();
		int enemyHotelOr = testMoteurJeu.getHotelVille(Side.ENEMY).getOrRestant();

		positionsX.remove(0);
		positionsY.remove(0);
		
		int villageois0X = testMoteurJeu.getPositionVillageoisX(0);
		int villageois0Y = testMoteurJeu.getPositionVillageoisY(0);
		
		Assert.assertTrue(testMoteurJeu.getPasJeuCourant() == 1);
		for(int i : positionsX)
		{
			Assert.assertTrue(i == 300);
		}
		for(int i : positionsY)
		{
			Assert.assertTrue(i == 300);
		}
		for(int i : orMines)
		{
			Assert.assertTrue(i == 180);
		}
		for(int i : compteurMines)
		{
			Assert.assertTrue(i == 51);
		}
		for(int i : orVillageois)
		{
			Assert.assertTrue(i == 0);
		}
		for(int i : pvVillageois)
		{
			Assert.assertTrue(i == 30);
		}
		for(int i : pvMurailles)
		{
			Assert.assertTrue(i == 20);
		}
		
		Assert.assertTrue(playerHotelOr == 16);
		Assert.assertTrue(enemyHotelOr == 16);
		
		Assert.assertTrue(villageois0X == 305);
		Assert.assertTrue(villageois0Y == 305);
	}
	
	@Test
	public void testMoteurJeuPasJeu6()
	{
		int largeur = 640;
		int hauteur = 480;
		int maxPas = 1000;
		Race playerRace = Race.ORC;
		Race enemyRace = Race.HUMAN;
		
		testMoteurJeu.init(largeur, hauteur, maxPas, playerRace, enemyRace, "config/testPasJeu2.json");
		
		testMoteurJeu.pasJeu(Commande.DEPLACER, 0, 45);
		
		ArrayList<Integer> positionsX = new ArrayList<>();
		ArrayList<Integer> positionsY = new ArrayList<>();
		ArrayList<Integer> pvVillageois = new ArrayList<>();
		ArrayList<Integer> orVillageois = new ArrayList<>();
		
		for(int i : testMoteurJeu.getNumerosVillageois())
		{
			pvVillageois.add(testMoteurJeu.getVillageois(i).getPointsDeVie());
			orVillageois.add(testMoteurJeu.getVillageois(i).getQuantiteOr());
			positionsX.add(testMoteurJeu.getPositionVillageoisX(i));
			positionsY.add(testMoteurJeu.getPositionVillageoisY(i));
		}
		
		ArrayList<Integer> orMines = new ArrayList<>();
		ArrayList<Integer> compteurMines = new ArrayList<>();
		
		for(int i : testMoteurJeu.getNumerosMines())
		{
			orMines.add(testMoteurJeu.getMine(i).getOrRestant());
			compteurMines.add(testMoteurJeu.getMine(i).getAbandonCompteur());
		}
		
		ArrayList<Integer> pvMurailles = new ArrayList<>();
		
		for(int i : testMoteurJeu.getNumerosMurailles())
		{
			pvMurailles.add(testMoteurJeu.getMuraille(i).getPointsDeVie());
		}
		
		
		int playerHotelOr = testMoteurJeu.getHotelVille(Side.PLAYER).getOrRestant();
		int enemyHotelOr = testMoteurJeu.getHotelVille(Side.ENEMY).getOrRestant();

		positionsX.remove(0);
		positionsY.remove(0);
		
		int villageois0X = testMoteurJeu.getPositionVillageoisX(0);
		int villageois0Y = testMoteurJeu.getPositionVillageoisY(0);
		
		Assert.assertTrue(testMoteurJeu.getPasJeuCourant() == 1);
		for(int i : positionsX)
		{
			Assert.assertTrue(i == 500);
		}
		for(int i : positionsY)
		{
			Assert.assertTrue(i == 500);
		}
		for(int i : orMines)
		{
			Assert.assertTrue(i == 180);
		}
		for(int i : compteurMines)
		{
			Assert.assertTrue(i == 51);
		}
		for(int i : orVillageois)
		{
			Assert.assertTrue(i == 0);
		}
		for(int i : pvVillageois)
		{
			Assert.assertTrue(i == 30);
		}
		for(int i : pvMurailles)
		{
			Assert.assertTrue(i == 20);
		}
		
		Assert.assertTrue(playerHotelOr == 16);
		Assert.assertTrue(enemyHotelOr == 16);
		
		Assert.assertTrue(villageois0X == 502);
		Assert.assertTrue(villageois0Y == 502);
	}
}
