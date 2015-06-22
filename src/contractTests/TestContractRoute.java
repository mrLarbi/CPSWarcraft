package contractTests;

import implementations.RouteImpl;

import org.junit.Before;
import org.junit.Test;

import contract.RouteContract;
import error.PreConditionError;

public class TestContractRoute extends AbstractRouteTest
{
	@Override
	@Before
	public void beforeTesting() {
		testRoute = new RouteContract(new RouteImpl());
	}
	
	@Test(expected=PreConditionError.class)
	public void testRouteInit4()
	{
		int largeur = 20;
		int hauteur = 15;
		int facteur = 2;
		
		testRoute.init(largeur, hauteur, facteur);
		
	}
	
	@Test(expected=PreConditionError.class)
	public void testRouteInit5()
	{
		int largeur = 15;
		int hauteur = 20;
		int facteur = 2;
		
		testRoute.init(largeur, hauteur, facteur);
		
	}
	
	@Test(expected=PreConditionError.class)
	public void testRouteInit6()
	{
		int largeur = 15;
		int hauteur = -5;
		int facteur = 2;
		
		testRoute.init(largeur, hauteur, facteur);
		
	}
	
	@Test(expected=PreConditionError.class)
	public void testRouteInit7()
	{
		int largeur = 21;
		int hauteur = 15;
		int facteur = -2;
		
		testRoute.init(largeur, hauteur, facteur);
		
	}
	
	@Test(expected=PreConditionError.class)
	public void testRouteInit8()
	{
		int largeur = 21;
		int hauteur = 15;
		int facteur = 0;
		
		testRoute.init(largeur, hauteur, facteur);
		
	}
}