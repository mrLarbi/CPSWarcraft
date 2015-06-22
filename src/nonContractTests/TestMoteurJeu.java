package nonContractTests;

import implementations.MoteurJeuImpl;

import org.junit.Before;

import contractTests.AbstractMoteurJeuTest;

public class TestMoteurJeu extends AbstractMoteurJeuTest
{
	@Before
	public void beforeTesting()
	{
		testMoteurJeu = new MoteurJeuImpl();
	}
}
