package contractTests;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import services.Muraille;

public abstract class AbstractMurailleTest {
	protected Muraille testMuraille;

	@Before
	public abstract void beforeTesting();
	
	@After
	public void afterTesting()
	{
		testMuraille = null;
	}
	
	@Test
	public void testMurailleInit1()
	{
		int largeur = 21;
		int hauteur = 21;
		int pv= 200;
		
		testMuraille.init(largeur, hauteur, pv);
		
		Assert.assertTrue("Test Muraille Init : ", testMuraille.getLargeur() ==  largeur
				&& testMuraille.getHauteur() ==  hauteur && testMuraille.getPointsDeVie() == pv);
	}
	
	@Test
	public void testMurailleInit2()
	{
		int largeur = 21;
		int hauteur = 11;
		int pv= 200;
		
		testMuraille.init(largeur, hauteur, pv);
		
		Assert.assertTrue("Test Muraille Init : ", testMuraille.getLargeur() ==  largeur
				&& testMuraille.getHauteur() ==  hauteur && testMuraille.getPointsDeVie() == pv);
	}
	
	@Test
	public void testMurailleInit3()
	{
		int largeur = 11;
		int hauteur = 21;
		int pv= 200;
		
		testMuraille.init(largeur, hauteur, pv);
		
		Assert.assertTrue("Test Muraille Init : ", testMuraille.getLargeur() ==  largeur
				&& testMuraille.getHauteur() ==  hauteur && testMuraille.getPointsDeVie() == pv);
	}
	
	@Test
	public void testMurailleFrappee1()
	{
		int largeur = 21;
		int hauteur = 21;
		int pv= 20;
		int force = 10;
		
		testMuraille.init(largeur, hauteur, pv);
		
		
		testMuraille.frappee(force);
		
		Assert.assertTrue("Test Muraille frappee : ", !testMuraille.estDetruite() && testMuraille.getPointsDeVie() == 10);
	}
	
	@Test
	public void testMurailleFrappee2()
	{
		int largeur = 21;
		int hauteur = 21;
		int pv= 10;
		int force = 10;
		
		testMuraille.init(largeur, hauteur, pv);
		
		testMuraille.frappee(force);
		
		Assert.assertTrue("Test Muraille frappee : ", testMuraille.estDetruite() && testMuraille.getPointsDeVie() == 0);
	}
	
	@Test
	public void testMurailleFrappee3()
	{
		int largeur = 21;
		int hauteur = 21;
		int pv= 10;
		int force = 0;
		
		testMuraille.init(largeur, hauteur, pv);
		
		testMuraille.frappee(force);
		
		Assert.assertTrue("Test Muraille frappee : ", !testMuraille.estDetruite() && testMuraille.getPointsDeVie() == 10);
	}
}
