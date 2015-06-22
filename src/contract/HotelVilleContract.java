package contract;

import services.HotelVille;
import tools.Side;
import decorators.HotelVilleDecorator;
import error.ContractError;
import error.ErrorHandler;
import error.PostConditionError;
import error.PreConditionError;

public class HotelVilleContract extends HotelVilleDecorator {
	
	public HotelVilleContract(HotelVille delegate) {
		super(delegate);
	}
	
	/**
	 * Init --------------------------------------------------------------------
	 */
	@Override
	public void init(int largeur, int hauteur, Side side, int orRestant) {
		try {
			checkInitPreConditions(largeur, hauteur, side, orRestant);						
			super.init(largeur, hauteur, orRestant);			
			checkInitPostConditions(largeur, hauteur, side, orRestant);
		} catch (ContractError e) {			
			ErrorHandler.printError(e);			
			throw e;			
		}		
	}
	
	private void checkInitPreConditions(int largeur, int hauteur, Side side, int orRestant) 
			throws PreConditionError {
		
		if (!(largeur % 2 == 1)) {
			throw new PreConditionError("Init_HotelVille : largeur % 2 != 1");
		}
		if (!(largeur > 1)) {
			throw new PreConditionError("Init_HotelVille : largeur <= 1");
		}
		if (!(hauteur % 2 == 1)) {
			throw new PreConditionError("Init_HotelVille : hauteur % 2 != 1");
		}		
		if (!(hauteur > 1)) {
			throw new PreConditionError("Init_HotelVille : hauteur <= 1");
		}
		if (!(orRestant > 0)) {
			throw new PreConditionError("Init_HotelVille : orRestant <= 0");
		}		
		if (!(side != Side.NONE)) {
			throw new PreConditionError("Init_HotelVille : side != NONE");
		}
	}	
	
	private void checkInitPostConditions(int largeur, int hauteur, Side side, 
			int orRestant) throws PostConditionError {
		
		if (!(getLargeur() == largeur)) {
			throw new PostConditionError("Init_HotelVille : getLargeur() != largeur");
		}		 
		if (!(getHauteur() == hauteur)) {
			throw new PostConditionError("Init_HotelVille : getHauteur() != hauteur");
		}
		if (!(getOrRestant() == orRestant)) {
			throw new PostConditionError("Init_HotelVille : getOrRestant() != orRestant");
		}
		if (!(getSide() == side)) {
			throw new PostConditionError("Init_HotelVille : getSide() != side");
		}
	}
	
	/**
	 * Depot -------------------------------------------------------------------
	 */
	@Override
	public void depot(int somme) {
		try {					
			checkDepotPreConditions(somme);
			int getOrRestant_atPre = getOrRestant();			
			super.depot(somme);			
			checkDepotPostConditions(getOrRestant_atPre, somme);
		} catch (ContractError e) {
			ErrorHandler.printError(e);
			throw e;
		}		
	}
	
	private void checkDepotPreConditions(int somme) throws PreConditionError {		
		if (!(somme > 0)) {
			throw new PreConditionError("Depot : somme <= 0");
		}
	}
	
	private void checkDepotPostConditions(int getOrRestant_atPre, int somme) 
			throws PostConditionError {
		
		if (!(getOrRestant() == getOrRestant_atPre + somme)) {
			throw new PostConditionError("Depot : getOrRestant() " +
					"!= getOrRestant()@pre + somme");
		}			
	}
	
	/**
	 * Retrait -----------------------------------------------------------------
	 */
	@Override
	public void retrait(int somme) {
		try {
			checkRetraitPreConditions(somme);					
			int getOrRestant_atPre = getOrRestant();					
			super.retrait(somme);			
			checkRetraitPostConditions(getOrRestant_atPre, somme);
		} catch (ContractError e) {
			ErrorHandler.printError(e);
			throw e;
		}		
	}	

	private void checkRetraitPreConditions(int somme) throws PreConditionError {		
		if (!(!estLaminee())) {
			throw new PreConditionError("Retrait : estLaminee()");
		}
		if (!(somme > 0)) {			
			throw new PreConditionError("Retrait : somme <= 0");
		}	
	}
	
	private void checkRetraitPostConditions(int getOrRestant_atPre, int somme) 
			throws PostConditionError {
		
		if (!(getOrRestant() == getOrRestant_atPre - somme)) {
			throw new PostConditionError("Retrait : getOrRestant() != " +
					"getOrRestant()@pre - somme");
		}		
	}
}