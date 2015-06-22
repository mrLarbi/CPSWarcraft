package contractTests;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import services.Mine;
import tools.Side;

public abstract class AbstractMineTest {
	
	protected Mine mine;
	
	@Before
	public abstract void beforeTesting();
	
	@After
	public void afterTesting() {
		mine = null;
	}
	
	/**
	 * Init --------------------------------------------------------------------
	 */
	@Test
	public void mine_Init_1() {
		testMineInitWith(17, 23, 100);						 					
	}
	
	@Test
	public void mine_Init_2() {
		testMineInitWith(15, 43, 150);						 					
	}
	
	private void testMineInitWith(int largeur, int hauteur, int orRestant) {			
		
		mine.init(largeur, hauteur, orRestant);
		
		Assert.assertTrue("Test Mine Init : ",
			   mine.getLargeur() ==  largeur
			&& mine.getHauteur() ==  hauteur 
			&& mine.getOrRestant() == orRestant
			&& mine.getAbandonCompteur() == 51
			&& mine.getSide() == Side.NONE
		);
	}
	
	/**
	 * Acceuil -----------------------------------------------------------------
	 */
	@Test
	public void mine_Acceuil_1() {		
		testMineAcceuilWith(17, 23, 100, Side.PLAYER);						 					
	}
	
	@Test
	public void mine_Acceuil_2() {		
		testMineAcceuilWith(17, 23, 100, Side.ENEMY);						 					
	}
	
	@Test
	public void mine_Acceuil_3() {		
		testMineAcceuilWith(17, 23, 100, Side.NONE);						 					
	}
	
	private void testMineAcceuilWith(int largeur, int hauteur, int orRestant,
			Side side) {			
		
		mine.init(largeur, hauteur, orRestant);
		mine.acceuil(side);		
		
		int abandonCompteur = (side != Side.NONE)? 0: 51;
		
		Assert.assertTrue("Test Mine Acceuil : ",
			   mine.getOrRestant() == orRestant
			&& mine.getAbandonCompteur() == abandonCompteur 
			&& mine.getSide() == side
		);
	}
	
	/**
	 * Abandoned ---------------------------------------------------------------
	 */
	@Test
	public void mine_Abandoned_1() {
		
		mine.init(17, 23, 100);
		mine.acceuil(Side.PLAYER);
		int getAbandonCompteur_atPre = mine.getAbandonCompteur();
		mine.abandoned();
		Assert.assertTrue("Test Mine Abandoned : ", assertAbandoned(100, 
				getAbandonCompteur_atPre , Side.PLAYER ));
	}
	
	@Test
	public void mine_Abandoned_2() {
		
		mine.init(17, 23, 100);
		mine.acceuil(Side.ENEMY);
		int getAbandonCompteur_atPre = mine.getAbandonCompteur();
		mine.abandoned();
		Assert.assertTrue("Test Mine Abandoned : ", assertAbandoned(100, 
				getAbandonCompteur_atPre , Side.ENEMY));						 					
	}
	
	private boolean assertAbandoned(int orRestant, int getAbandonCompteur_atPre,
			Side side) {				
				
		return mine.getOrRestant() == orRestant
			&& mine.getAbandonCompteur() == getAbandonCompteur_atPre + 1
			&& mine.getSide() == side;		
	}
	
	/**
	 * Retrait -----------------------------------------------------------------
	 */
	@Test
	public void mine_Retrait_1() {		
		testMineRetraitWith(60, Side.NONE, false);						 					
	}
	
	@Test
	public void mine_Retrait_2() {		
		testMineRetraitWith(120, Side.NONE, false);					 					
	}
	
	@Test
	public void mine_Retrait_3() {		
		testMineRetraitWith(120, Side.PLAYER, true);					 					
	}
	
	@Test
	public void mine_Retrait4() {		
		testMineRetraitWith(120, Side.ENEMY, true);					 					
	}
	
	private void testMineRetraitWith(int somme, Side side, boolean appelAcceuil) {			
		
		mine.init(17, 23, 100);
		if (appelAcceuil) mine.acceuil(side);
		int getOrRestant_atPre = mine.getOrRestant();
		mine.retrait(somme);
		
		Assert.assertTrue("Test Mine Retrait : ",
				mine.getOrRestant() == getOrRestant_atPre - somme
				&& mine.getAbandonCompteur() == mine.getAbandonCompteur()
				&& mine.getSide() == side
		);
	}
}
