package contractTests;

import implementations.MoteurJeuImpl;

import org.json.JSONException;
import org.junit.Before;
import org.junit.Test;

import tools.Commande;
import tools.Race;
import contract.MoteurJeuContract;
import error.PreConditionError;

public class TestContractMoteurJeu extends AbstractMoteurJeuTest
{
	@Override
	@Before
	public void beforeTesting() {
		testMoteurJeu = new MoteurJeuContract(new MoteurJeuImpl());
	}
	
	@Test(expected=PreConditionError.class)
	public void testMoteurJeuInit5()
	{
		int largeur = 400;
		int hauteur = 560;
		int maxPas = 200;
		Race playerRace = Race.ORC;
		Race enemyRace = Race.HUMAN;

		testMoteurJeu.init(largeur, hauteur, maxPas, playerRace, enemyRace, "config/map1.json");

	}
	
	@Test(expected=PreConditionError.class)
	public void testMoteurJeuInit6()
	{
		int largeur = 640;
		int hauteur = 300;
		int maxPas = 200;
		Race playerRace = Race.ORC;
		Race enemyRace = Race.HUMAN;

		testMoteurJeu.init(largeur, hauteur, maxPas, playerRace, enemyRace, "config/map1.json");

	}
	
	@Test(expected=PreConditionError.class)
	public void testMoteurJeuInit7()
	{
		int largeur = 640;
		int hauteur = 500;
		int maxPas = 0;
		Race playerRace = Race.ORC;
		Race enemyRace = Race.HUMAN;

		testMoteurJeu.init(largeur, hauteur, maxPas, playerRace, enemyRace, "config/map1.json");

	}
	
	@Test(expected=PreConditionError.class)
	public void testMoteurJeuInit8()
	{
		int largeur = 640;
		int hauteur = 500;
		int maxPas = -5;
		Race playerRace = Race.ORC;
		Race enemyRace = Race.HUMAN;

		testMoteurJeu.init(largeur, hauteur, maxPas, playerRace, enemyRace, "config/map1.json");

	}
	
	@Test(expected=PreConditionError.class)
	public void testMoteurJeuPasJeu7()
	{
		int largeur = 640;
		int hauteur = 480;
		int maxPas = 1000;
		Race playerRace = Race.ORC;
		Race enemyRace = Race.HUMAN;

		testMoteurJeu.init(largeur, hauteur, maxPas, playerRace, enemyRace, "config/testPasJeu2.json");

		testMoteurJeu.pasJeu(Commande.RIEN, 200, 0);
	}
	
	@Test(expected=PreConditionError.class)
	public void testMoteurJeuPasJeu8()
	{
		int largeur = 640;
		int hauteur = 480;
		int maxPas = 1000;
		Race playerRace = Race.ORC;
		Race enemyRace = Race.HUMAN;

		testMoteurJeu.init(largeur, hauteur, maxPas, playerRace, enemyRace, "config/testPasJeu2.json");

		testMoteurJeu.pasJeu(Commande.ENTRERHOTELVILLE, 0, 0);
	}
	
	@Test(expected=PreConditionError.class)
	public void testMoteurJeuPasJeu9()
	{
		int largeur = 640;
		int hauteur = 480;
		int maxPas = 1000;
		Race playerRace = Race.ORC;
		Race enemyRace = Race.HUMAN;

		testMoteurJeu.init(largeur, hauteur, maxPas, playerRace, enemyRace, "config/testPasJeu2.json");

		for(int i = 0 ; i < 1000 ; i++)
		{
			testMoteurJeu.pasJeu(Commande.RIEN, 0, 0);
		}
		
		testMoteurJeu.pasJeu(Commande.RIEN, 0, 0);
	}
	
	@Test(expected=JSONException.class)
	public void testMoteurJeuPasJeu10()
	{
		int largeur = 640;
		int hauteur = 480;
		int maxPas = 1000;
		Race playerRace = Race.ORC;
		Race enemyRace = Race.HUMAN;

		testMoteurJeu.init(largeur, hauteur, maxPas, playerRace, enemyRace, "config/existepas.json");

		for(int i = 0 ; i < 1000 ; i++)
		{
			testMoteurJeu.pasJeu(Commande.RIEN, 0, 0);
		}
		
		testMoteurJeu.pasJeu(Commande.RIEN, 0, 0);
	}
	
	@Test(expected=PreConditionError.class)
	public void testMoteurJeuPasJeu11()
	{
		int largeur = 640;
		int hauteur = 480;
		int maxPas = 1000;
		Race playerRace = Race.ORC;
		Race enemyRace = Race.HUMAN;

		testMoteurJeu.init(largeur, hauteur, maxPas, playerRace, enemyRace, "config/testPasJeu2.json");

		testMoteurJeu.pasJeu(Commande.FRAPPERMURAILLE, 0, 0);
	}
	
	@Test(expected=PreConditionError.class)
	public void testMoteurJeuPasJeu12()
	{
		int largeur = 640;
		int hauteur = 480;
		int maxPas = 1000;
		Race playerRace = Race.ORC;
		Race enemyRace = Race.HUMAN;

		testMoteurJeu.init(largeur, hauteur, maxPas, playerRace, enemyRace, "config/testPasJeu.json");

		testMoteurJeu.pasJeu(Commande.FRAPPERMURAILLE, 0, 200);
	}
	
	@Test(expected=PreConditionError.class)
	public void testMoteurJeuPasJeu13()
	{
		int largeur = 640;
		int hauteur = 480;
		int maxPas = 1000;
		Race playerRace = Race.ORC;
		Race enemyRace = Race.HUMAN;

		testMoteurJeu.init(largeur, hauteur, maxPas, playerRace, enemyRace, "config/testPasJeu.json");

		testMoteurJeu.pasJeu(Commande.ENTRERMINE, 0, 200);
	}
	
	@Test(expected=PreConditionError.class)
	public void testMoteurJeuPasJeu14()
	{
		int largeur = 640;
		int hauteur = 480;
		int maxPas = 1000;
		Race playerRace = Race.ORC;
		Race enemyRace = Race.HUMAN;

		testMoteurJeu.init(largeur, hauteur, maxPas, playerRace, enemyRace, "config/testPasJeu2.json");

		testMoteurJeu.pasJeu(Commande.ENTRERMINE, 0, 0);
	}
}