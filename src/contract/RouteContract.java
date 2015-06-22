package contract;

import services.Route;
import decorators.RouteDecorator;
import error.ContractError;
import error.ErrorHandler;
import error.InvariantError;
import error.PostConditionError;
import error.PreConditionError;

public class RouteContract extends RouteDecorator
{
	public RouteContract(Route r)
	{
		super(r);
	}
	
	public void checkInvariants() throws InvariantError
	{
		
	}
	
	public void checkInitPre(int largeur, int hauteur, int facteur) throws PreConditionError
	{

		if(largeur%2 == 0)
		{
			throw new PreConditionError("init : largeur % 2 == 1");
		}
		if(hauteur%2 == 0)
		{
			throw new PreConditionError("init : hauteur % 2 == 1");
		}
		if(largeur <= 1)
		{
			throw new PreConditionError("init : largeur <= 1");
		}
		if(hauteur <= 1)
		{
			throw new PreConditionError("init : hauteur <= 1");
		}
		if(facteur <= 0)
		{
			throw new PreConditionError("init : facteur <= 0");
		}
		if(facteur > 10)
		{
			throw new PreConditionError("init : facteur > 10");
		}
	}
	
	public void checkInitPost(int largeur, int hauteur, int facteur) throws PostConditionError
	{
		if(super.getLargeur() != largeur)
		{
			throw new PostConditionError("init : Terrain.largeur(init(l,h,f)) != l");	
		}
		if(super.getHauteur() != hauteur)
		{
			throw new PostConditionError("init : Terrain.hauteur(init(l,h,f)) != h");	
		}
		if(super.getFacteurMult() != facteur)
		{
			throw new PostConditionError("init : facteurMult(init(l,h,f)) != f");	
		}
	}
	
	public void init(int largeur, int hauteur, int facteur)
	{
		try {
			checkInvariants();
			checkInitPre(largeur, hauteur, facteur);
			super.init(largeur, hauteur, facteur);
			checkInitPost(largeur, hauteur, facteur);
			checkInvariants();
		}
		catch (ContractError e) {
			ErrorHandler.printError(e);
			throw e;
		}
		
	}
	
}
