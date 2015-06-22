package contractTests;

import implementations.HotelVilleImpl;

import org.junit.Before;
import org.junit.Test;

import tools.Side;

import contract.HotelVilleContract;
import error.PreConditionError;


public class TestContractHotelVille extends AbstractHotelVilleTest {
	
	@Override
	@Before
	public void beforeTesting() {
		hotelVille = new HotelVilleContract(new HotelVilleImpl(17,23,Side.PLAYER,100));
	}
	
	/**
	 * Init --------------------------------------------------------------------
	 * @param largeur
	 * @param hauteur
	 * @param side
	 * @param orRestant
	 */	
	@Test(expected=PreConditionError.class)
	public void hotelVille_Init_3() {						
		hotelVille.init(18,43,Side.PLAYER,150);		
	}
	
	@Test(expected=PreConditionError.class)
	public void hotelVille_Init_4() {				
		hotelVille.init(18,43,Side.ENEMY,150);		
	}
	
	@Test(expected=PreConditionError.class)
	public void hotelVille_Init_5() {				
		hotelVille.init(1,43,Side.PLAYER,150);		
	}
	
	@Test(expected=PreConditionError.class)
	public void hotelVille_Init_6() {				
		hotelVille.init(1,43,Side.ENEMY,150);		
	}
	
	@Test(expected=PreConditionError.class)
	public void hotelVille_Init_7() {				
		hotelVille.init(19,44,Side.PLAYER,150);		
	}
	
	@Test(expected=PreConditionError.class)
	public void hotelVille_Init_8() {				
		hotelVille.init(19,44,Side.ENEMY,150);		
	}
	
	@Test(expected=PreConditionError.class)
	public void hotelVille_Init_9() {				
		hotelVille.init(25,1,Side.PLAYER,150);		
	}
	
	@Test(expected=PreConditionError.class)
	public void hotelVille_Init_10() {				
		hotelVille.init(25,1,Side.ENEMY,150);		
	}
	
	@Test(expected=PreConditionError.class)
	public void hotelVille_Init_11() {				
		hotelVille.init(19,43,Side.PLAYER,0);		
	}
	
	@Test(expected=PreConditionError.class)
	public void hotelVille_Init_12() {				
		hotelVille.init(19,43,Side.ENEMY,-100);		
	}
	
	@Test(expected=PreConditionError.class)
	public void hotelVille_Init_13() {				
		hotelVille.init(19,43,Side.NONE,-100);		
	}
	
	/**
	 * Depot ------------------------------------------------------------------- 
	 * @param somme
	 */
	@Test(expected=PreConditionError.class)
	public void hotelVille_Depot_2() {						
		hotelVille.depot(-20);
	}
	
	/**
	 * Retrait -----------------------------------------------------------------
	 * @param somme
	 */
	@Test(expected=PreConditionError.class)
	public void hotelVille_Retrait_5() {						
		hotelVille.retrait(100);
		hotelVille.retrait(60);
	}
	
	@Test(expected=PreConditionError.class)
	public void hotelVille_Retrait_6() {							
		hotelVille.retrait(-10);
	}
}