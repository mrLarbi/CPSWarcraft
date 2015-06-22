package nonContractTests;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({
	TestBugHotelVille.class, 
	TestBugMine.class, 
	TestBugMoteurJeu.class, 
	TestBugMuraille.class, 
	TestBugRoute.class,
	TestBugVillageois.class})
public class TestBugWithoutContract {

}
