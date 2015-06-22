package contractTests;

import implementations.MineImpl;

import org.junit.Before;
import org.junit.Test;

import tools.Side;

import contract.MineContract;
import error.PreConditionError;

public class TestContractMine extends AbstractMineTest {
	
	@Override
	@Before
	public void beforeTesting() {
		mine = new MineContract(new MineImpl(17, 23, 100));
	}
	
	/**
	 * Init --------------------------------------------------------------------
	 * @param largeur
	 * @param hauteur
	 * @param orRestant
	 */
	@Test(expected=PreConditionError.class)
	public void mine_Init_3() {		
		mine.init(18,43,150);					
	}
	
	@Test(expected=PreConditionError.class)
	public void mine_Init_4() {				
		mine.init(1,43,150);		
	}	
	
	@Test(expected=PreConditionError.class)
	public void mine_Init_5() {				
		mine.init(19,44,150);		
	}
	
	@Test(expected=PreConditionError.class)
	public void mine_Init_6() {				
		mine.init(19,1,150);		
	}
	
	@Test(expected=PreConditionError.class)
	public void mine_Init_7() {				
		mine.init(19,43,0);		
	}
	
	/**
	 * Abandoned --------------------------------------------------------------- 
	 */
	@Test(expected=PreConditionError.class)
	public void mine_Abandoned_3() {						
		mine.acceuil(Side.NONE);
		mine.abandoned();
	}
	
	@Test(expected=PreConditionError.class)
	public void mine_Abandoned_4() {						
		mine.abandoned();
	}
	
	/**
	 * Retrait -----------------------------------------------------------------
	 * @param somme
	 */
	@Test(expected=PreConditionError.class)
	public void mine_Retrait_5() {						
		mine.retrait(100);
		mine.retrait(60);
	}
	
	@Test(expected=PreConditionError.class)
	public void mine_Retrait_6() {						
		mine.retrait(-10);
	}
}