package nonContractTests;

import implementationsBug.MoteurJeuImplBug;

import org.junit.Before;

import contractTests.AbstractMoteurJeuTest;

public class TestBugMoteurJeu extends AbstractMoteurJeuTest
{
	@Before
	public void beforeTesting()
	{
		testMoteurJeu = new MoteurJeuImplBug();
	}
}
