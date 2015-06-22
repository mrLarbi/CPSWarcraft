package contractTests;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({
	TestContractHotelVille.class, 
	TestContractMine.class, 
	TestContractMoteurJeu.class, 
	TestContractMuraille.class, 
	TestContractRoute.class,
	TestContractVillageois.class
})

public class TestsWithContract {}