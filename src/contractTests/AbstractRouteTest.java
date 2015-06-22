package contractTests;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import services.Route;

public abstract class AbstractRouteTest {
	protected Route testRoute;

	@Before
	public abstract void beforeTesting();
	
	@After
	public void afterTesting()
	{
		testRoute = null;
	}
	
	@Test
	public void testRouteInit1()
	{
		int largeur = 21;
		int hauteur = 21;
		int facteur = 2;
		testRoute.init(largeur, hauteur, facteur);
		Assert.assertTrue("Test Route Init : ", testRoute.getLargeur() ==  largeur
				&& testRoute.getHauteur() ==  hauteur && testRoute.getFacteurMult() == facteur);
	}
	
	@Test
	public void testRouteInit2()
	{
		int largeur = 21;
		int hauteur = 11;
		int facteur = 2;
		testRoute.init(largeur, hauteur, facteur);
		Assert.assertTrue("Test Route Init : ", testRoute.getLargeur() ==  largeur
				&& testRoute.getHauteur() ==  hauteur && testRoute.getFacteurMult() == facteur);
	}
	
	@Test
	public void testRouteInit3()
	{
		int largeur = 11;
		int hauteur = 21;
		int facteur = 2;
		testRoute.init(largeur, hauteur, facteur);
		Assert.assertTrue("Test Route Init : ", testRoute.getLargeur() ==  largeur
				&& testRoute.getHauteur() ==  hauteur && testRoute.getFacteurMult() == facteur);
	}
}
