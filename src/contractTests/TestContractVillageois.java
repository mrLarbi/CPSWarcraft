package contractTests;

import implementations.VillageoisImpl;

import org.junit.Before;
import org.junit.Test;

import tools.Race;
import tools.Side;
import contract.VillageoisContract;
import error.PreConditionError;

public class TestContractVillageois extends AbstractVillageoisTest {
	
	@Override
	@Before
	public void beforeTesting() {
		villageois = new VillageoisContract(new VillageoisImpl(Race.HUMAN, Side.PLAYER, 15, 35, 55, 20, 10));
	}
	
	/**
	 * Init --------------------------------------------------------------------
	 * @param race
	 * @param side
	 * @param largeur
	 * @param hauteur
	 * @param force
	 * @param vitesse
	 * @param pointsDeVie
	 */
	@Test(expected=PreConditionError.class)
	public void villageois_Init_5() {				
		villageois.init(Race.HUMAN, Side.PLAYER, 16, 35, 55, 20, 10);				
	}
	
	@Test(expected=PreConditionError.class)
	public void villageois_Init_6() {				
		villageois.init(Race.HUMAN, Side.PLAYER, 1, 35, 55, 20, 10);		
	}
	
	@Test(expected=PreConditionError.class)
	public void villageois_Init_7() {				
		villageois.init(Race.HUMAN, Side.PLAYER, 15, 34, 55, 20, 10);		
	}
	
	@Test(expected=PreConditionError.class)
	public void villageois_Init_8() {				
		villageois.init(Race.HUMAN, Side.PLAYER, 15, 1, 55, 20, 10);		
	}
	
	@Test(expected=PreConditionError.class)
	public void villageois_Init_9() {				
		villageois.init(Race.HUMAN, Side.PLAYER, 15, 35, -1, 20, 10);		
	}
	
	@Test(expected=PreConditionError.class)
	public void villageois_Init_10() {				
		villageois.init(Race.HUMAN, Side.PLAYER, 15, 35, 55, -1, 10);		
	}
	
	@Test(expected=PreConditionError.class)
	public void villageois_Init_11() {				
		villageois.init(Race.HUMAN, Side.PLAYER, 15, 35, 55, 20, -1);		
	}	
	
	/**
	 * Retrait -----------------------------------------------------------------
	 * @param degat
	 */
	@Test(expected=PreConditionError.class)
	public void villageois_Retrait_4() {					
		villageois.retrait(10);
		villageois.retrait(2);
	}
	
	@Test(expected=PreConditionError.class)
	public void villageois_Retrait_5() {				
		villageois.retrait(0);
	}
	
	/**
	 * ViderPoches -------------------------------------------------------------
	 */
	@Test(expected=PreConditionError.class)
	public void villageoisViderPoches3() {						
		villageois.retrait(10);
		villageois.viderPoches();
	}
	
	/**
	 * Recupere ----------------------------------------------------------------
	 * @param retire
	 */
	@Test(expected=PreConditionError.class)
	public void villageois_Recupere_3() {						
		villageois.retrait(10);
		villageois.recupere(20);
	}
	
	public void villageois_Recupere_4() {						
		villageois.recupere(0);
	}
}