package contractTests;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import services.HotelVille;
import tools.Side;

public abstract class AbstractHotelVilleTest {
	
	protected HotelVille hotelVille;
	
	@Before
	public abstract void beforeTesting();
	
	@After
	public void afterTesting() {
		hotelVille = null;
	}
	
	/**
	 * Init --------------------------------------------------------------------
	 */
	@Test
	public void mine_Init_1() {
		testMineInitWith(17, 23, Side.PLAYER, 100);						 					
	}
	
	@Test
	public void mine_Init_2() {
		testMineInitWith(15, 43, Side.PLAYER, 150);						 					
	}
	
	private void testMineInitWith(int largeur, int hauteur, Side side, 
			int orRestant) {			
		
		hotelVille.init(largeur, hauteur, side, orRestant);
		
		Assert.assertTrue("Test HotelVille Init : ",
				hotelVille.getLargeur() ==  largeur
			 && hotelVille.getHauteur() ==  hauteur 
			 && hotelVille.getOrRestant() == orRestant			
			 && hotelVille.getSide() == side
		);
	}
	
	/**
	 * Depot -------------------------------------------------------------------
	 */	
	@Test
	public void hotelVille_Depot_1() {		
		testHotelVilleDepotWith(17, 23, Side.PLAYER, 100, 20);						 					
	}	
	
	private void testHotelVilleDepotWith(int largeur, int hauteur, Side side,
			int orRestant, int somme) {			
		
		hotelVille.init(largeur, hauteur, side, orRestant);
		int getOrRestant_atPre = hotelVille.getOrRestant();
		hotelVille.depot(somme);		
				
		Assert.assertTrue("Test HotelVille Dépot : ",
				hotelVille.getOrRestant() == getOrRestant_atPre + somme
		);
	}
	
	/**
	 * Retrait -----------------------------------------------------------------
	 */
	@Test
	public void hotelVille_Retrait_1() {		
		testHotelVilleRetraitWith(0, 60, false);						 					
	}
	
	@Test
	public void hotelVille_Retrait_2() {		
		testHotelVilleRetraitWith(0, 100, false);					 					
	}
	
	@Test
	public void hotelVille_Retrait_3() {		
		testHotelVilleRetraitWith(0, 120, false);					 					
	}
	
	@Test
	public void mine_Retrait4() {		
		testHotelVilleRetraitWith(40, 60, true);					 					
	}
	
	private void testHotelVilleRetraitWith(int sommeDepot, int sommeRetrait,
			boolean appelDepot) {			
				
		if (appelDepot) hotelVille.depot(sommeDepot);
		int getOrRestant_atPre = hotelVille.getOrRestant();
		hotelVille.retrait(sommeRetrait);
		
		Assert.assertTrue("Test Mine Retrait : ",
				hotelVille.getOrRestant() == getOrRestant_atPre - sommeRetrait
		);
	}
}
