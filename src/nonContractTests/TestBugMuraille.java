package nonContractTests;

import implementationsBug.MurailleImplBug;

import org.junit.Before;

import contractTests.AbstractMurailleTest;

public class TestBugMuraille extends AbstractMurailleTest
{
	
	@Before 
	public void beforeTesting()
	{
		testMuraille = new MurailleImplBug();
	}
	
	
}
