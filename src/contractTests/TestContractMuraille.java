package contractTests;

import implementations.MurailleImpl;

import org.junit.Before;
import org.junit.Test;

import contract.MurailleContract;
import error.PreConditionError;

public class TestContractMuraille extends AbstractMurailleTest
{
	@Override
	@Before
	public void beforeTesting() {
		testMuraille = new MurailleContract(new MurailleImpl());
	}
	
	@Test(expected=PreConditionError.class)
	public void testMurailleInit4()
	{
		int largeur = 20;
		int hauteur = 15;
		int pointDeVie = 200;
		
		testMuraille.init(largeur, hauteur, pointDeVie);
		
	}
	
	@Test(expected=PreConditionError.class)
	public void testMurailleInit5()
	{
		int largeur = 15;
		int hauteur = 20;
		int pointDeVie = 200;
		
		testMuraille.init(largeur, hauteur, pointDeVie);
		
	}
	
	@Test(expected=PreConditionError.class)
	public void testMurailleInit6()
	{
		int largeur = 15;
		int hauteur = -5;
		int pointDeVie = 200;
		
		testMuraille.init(largeur, hauteur, pointDeVie);
		
	}
	
	@Test(expected=PreConditionError.class)
	public void testMurailleInit7()
	{
		int largeur = 21;
		int hauteur = 15;
		int pointDeVie = -5;
		
		testMuraille.init(largeur, hauteur, pointDeVie);
		
	}
	
	@Test(expected=PreConditionError.class)
	public void testMurailleInit8()
	{
		int largeur = 21;
		int hauteur = 15;
		int pointDeVie = 0;
		
		testMuraille.init(largeur, hauteur, pointDeVie);
		
	}
	
	@Test(expected=PreConditionError.class)
	public void testMurailleFrappee4()
	{
		int largeur = 21;
		int hauteur = 15;
		int pointDeVie = 20;
		
		int force = -5;
		
		testMuraille.init(largeur, hauteur, pointDeVie);
		
		testMuraille.frappee(force);	
		
	}
	
	@Test(expected=PreConditionError.class)
	public void testMurailleFrappee5()
	{
		int largeur = 21;
		int hauteur = 15;
		int pointDeVie = 10;
		
		int force = 10;
		
		testMuraille.init(largeur, hauteur, pointDeVie);
		
		testMuraille.frappee(force);
		testMuraille.frappee(force);
	}
	
}