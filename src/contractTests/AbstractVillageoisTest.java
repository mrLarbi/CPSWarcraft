package contractTests;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import services.Villageois;
import tools.Race;
import tools.Side;

public abstract class AbstractVillageoisTest {
	
	protected Villageois villageois;

	@Before
	public abstract void beforeTesting();
	
	@After
	public void afterTesting() {
		villageois = null;
	}
	
	/**
	 * Init --------------------------------------------------------------------
	 */
	@Test
	public void villageois_Init_1() {
		testVillageoisInitWith(Race.HUMAN, Side.PLAYER, 15, 35, 55, 20, 10, 0);						 					
	}
	
	@Test
	public void villageois_Init_2() {
		testVillageoisInitWith(Race.ORC, Side.PLAYER, 21, 35, 60, 15, 10, 0);						 					
	}
	
	@Test
	public void villageois_Init_3() {
		testVillageoisInitWith(Race.HUMAN, Side.ENEMY, 15, 35, 55, 20, 10, 0);						 					
	}
	
	@Test
	public void villageois_Init_4() {
		testVillageoisInitWith(Race.ORC, Side.ENEMY, 21, 35, 60, 15, 10, 0);						 					
	}		
		
	private void testVillageoisInitWith(Race race, Side side, int largeur, 
			int hauteur, int force, int vitesse, int pointsDeVie, int quantiteOr) {			
		
		villageois.init(race, side, largeur, hauteur, force, vitesse, pointsDeVie);
		
		Assert.assertTrue("Test Villageois Init : ",
		       villageois.getRace() ==  race
			&& villageois.getSide() ==  side
			&& villageois.getLargeur() ==  largeur
			&& villageois.getHauteur() ==  hauteur 
			&& villageois.getForce() ==  force
			&& villageois.getVitesse() ==  vitesse
			&& villageois.getPointsDeVie() == pointsDeVie
			&& villageois.getQuantiteOr() == quantiteOr
		);
	}
	
	/**
	 * Retrait -----------------------------------------------------------------
	 */
	@Test
	public void villageois_Retrait_1() {
		int[] somme = {2};
		testVillageoisRetraitWith(1, somme, 8, false);						 					
	}
	
	@Test
	public void villageois_Retrait_2() {
		int[] somme = {10};
		testVillageoisRetraitWith(1, somme, 0, true);						 					
	}

	@Test
	public void villageois_Retrait_3() {
		int[] somme = {5, 10};
		testVillageoisRetraitWith(2, somme, -5, true);						 					
	}
	
	private void testVillageoisRetraitWith(int nbrAppel, int[] somme, 
			int pointDeVie, boolean estMort) {			
		
		villageois.init(Race.HUMAN, Side.PLAYER, 15, 35, 55, 20, 10);
		
		for (int i = 0; i < nbrAppel; i++) {
			villageois.retrait(somme[i]);
		}	
	
		Assert.assertTrue("Test Villageois Retrait : ", 
			   villageois.getPointsDeVie() == pointDeVie
			&& villageois.estMort() == estMort
			&& villageois.getQuantiteOr() >= 0 
		);
	}
	
	/**
	 * ViderPoches -------------------------------------------------------------
	 */
	@Test
	public void villageois_ViderPoches_1() {
		villageois.init(Race.HUMAN, Side.PLAYER, 15, 35, 55, 20, 10);
		villageois.viderPoches();
		Assert.assertTrue("Test Villageois ViderPoches : ", assertViderPoches(10));						 					
	}
	
	@Test
	public void villageois_ViderPoches_2() {
		villageois.init(Race.HUMAN, Side.PLAYER, 15, 35, 55, 20, 10);
		villageois.viderPoches();
		villageois.retrait(8);
		Assert.assertTrue("Test Villageois ViderPoches : ", assertViderPoches(2));						 					
	}
	
	private boolean assertViderPoches(int pointDeVie) {		
		return villageois.getPointsDeVie() == pointDeVie
			&& villageois.estMort() == false
			&& villageois.getQuantiteOr() == 0; 		
	}
	
	/**
	 * Recupere ----------------------------------------------------------------
	 */
	@Test
	public void villageois_Recupere_1() {	
		villageois.init(Race.HUMAN, Side.PLAYER, 15, 35, 55, 20, 10);
		int getQuantiteOr_atPre = villageois.getQuantiteOr();
		villageois.recupere(20);
		Assert.assertTrue("Test Villageois Recupere : ", 
				asserRecupere(10, getQuantiteOr_atPre));						 					
	}
		
	@Test
	public void villageois_Recupere_2() {
		villageois.init(Race.HUMAN, Side.PLAYER, 15, 35, 55, 20, 10);
		villageois.retrait(5);
		int getQuantiteOr_atPre = villageois.getQuantiteOr();
		villageois.recupere(20);
		Assert.assertTrue("Test Villageois Recupere : ", 
				asserRecupere(5, getQuantiteOr_atPre));						 					
	}
	
	private boolean asserRecupere(int pointDeVie, int getQuantiteOr_atPre) {
		
		return villageois.getPointsDeVie() == pointDeVie
				&& villageois.estMort() == false
				&& villageois.getQuantiteOr() == getQuantiteOr_atPre + 20;
	}
}