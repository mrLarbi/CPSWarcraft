package nonContractTests;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({
	TestHotelVille.class, 
	TestMine.class, 
	TestMoteurJeu.class, 
	TestMuraille.class, 
	TestRoute.class,
	TestVillageois.class
})

public class TestsWithoutContract {}
