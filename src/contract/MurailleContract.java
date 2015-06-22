package contract;

import services.Muraille;
import decorators.MurailleDecorator;
import error.ContractError;
import error.ErrorHandler;
import error.InvariantError;
import error.PostConditionError;
import error.PreConditionError;

public class MurailleContract extends MurailleDecorator
{
	public MurailleContract(Muraille m)
	{
		super(m);
	}
	
	public void checkInvariants() throws InvariantError
	{
		if(super.estDetruite() != (super.getPointsDeVie() <= 0))
		{
			throw new InvariantError("estDetruite(M) =(min) pointsDeVie(M) ≤ 0");
		}
	}
	
	public void checkInitPre(int largeur, int hauteur, int pv) throws PreConditionError
	{
		if(largeur%2 == 0)
		{
			throw new PreConditionError("init : largeur % 2 == 0");
		}
		if(hauteur%2 == 0)
		{
			throw new PreConditionError("init : hauteur % 2 == 0");
		}
		if(largeur <= 1)
		{
			throw new PreConditionError("init : largeur <= 1");
		}
		if(hauteur <= 1)
		{
			throw new PreConditionError("init : hauteur <= 1");
		}
		
		if(pv <= 0)
		{
			throw new PreConditionError("init : pointsDeVie <= 0");
		}
	}
	
	public void checkInitPost(int largeur, int hauteur, int pv) throws PostConditionError
	{
		if(super.getLargeur() != largeur)
		{
			throw new PostConditionError("init : Terrain.largeur(init(l,h,p)) != l");	
		}
		if(super.getHauteur() != hauteur)
		{
			throw new PostConditionError("init : Terrain.hauteur(init(l,h,p)) != h");	
		}
		if(super.getPointsDeVie() != pv)
		{
			throw new PostConditionError("init : pointsDeVie(init(l,h,p)) != p");	
		}		
	}
	
	public void init(int largeur, int hauteur, int pv) 
	{
		try {
			checkInvariants();
			checkInitPre(largeur, hauteur, pv);
			super.init(largeur, hauteur, pv);
			checkInitPost(largeur, hauteur, pv);
			checkInvariants();
		}
		catch (ContractError e) {
			ErrorHandler.printError(e);
			throw e;
		}
	}
	
	public void checkFrappeePre(int force) throws PreConditionError
	{
		if(super.estDetruite())
		{
			throw new PreConditionError("frappee : estDetruite()");
		}
		if(force < 0)
		{
			throw new PreConditionError("frappee : force < 0");
		}
	}
	
	public void checkFrappeePost(int prePv, int force) throws PostConditionError
	{
		if(super.getPointsDeVie() != prePv - force)
		{
			throw new PostConditionError("frappee : pointsDeVie(frappee(M)) != pointsDeVie(M) - f");
		}
	}
	
	public void frappee(int force)
	{
		try {
		   checkInvariants();
			checkFrappeePre(force);
			int prePv = super.getPointsDeVie();
			super.frappee(force);
			checkFrappeePost(prePv, force);
			checkInvariants();
		} catch (ContractError e) {
		   ErrorHandler.printError(e);
			throw e;
		}
		
		
	}
	
}
