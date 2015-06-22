package nonContractTests;

import implementations.MurailleImpl;

import org.junit.Before;

import contractTests.AbstractMurailleTest;

public class TestMuraille extends AbstractMurailleTest
{
	
	@Before 
	public void beforeTesting()
	{
		testMuraille = new MurailleImpl();
	}
	
	
}
