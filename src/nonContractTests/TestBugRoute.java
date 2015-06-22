package nonContractTests;

import implementationsBug.RouteImplBug;

import org.junit.Before;

import contractTests.AbstractRouteTest;

public class TestBugRoute extends AbstractRouteTest
{
	@Before 
	public void beforeTesting()
	{
		testRoute = new RouteImplBug();
	}
}
