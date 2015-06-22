package nonContractTests;

import implementations.RouteImpl;
import org.junit.Before;
import contractTests.AbstractRouteTest;

public class TestRoute extends AbstractRouteTest
{
	@Before 
	public void beforeTesting()
	{
		testRoute = new RouteImpl();
	}
}
