package contract;

import services.Mine;
import tools.Side;
import decorators.MineDecorator;
import error.ContractError;
import error.ErrorHandler;
import error.InvariantError;
import error.PostConditionError;
import error.PreConditionError;

public class MineContract extends MineDecorator {
	
	public MineContract(Mine delegate) {
		super(delegate);
	}
	
	/**
	 * Init --------------------------------------------------------------------
	 */
	@Override
	public void init(int largeur, int hauteur, int orRestant) {
		try {
			checkInitPreConditions(largeur, hauteur, orRestant);
			checkInvariants();				
			super.init(largeur, hauteur, orRestant);
			checkInvariants();
			checkInitPostConditions(largeur, hauteur, orRestant);
		} catch (ContractError e) {
			ErrorHandler.printError(e);
			throw e;
		}		
	}
	
	private void checkInitPreConditions(int largeur, int hauteur, int orRestant) 
			throws PreConditionError {
		
		if (!(largeur % 2 == 1)) {
			throw new PreConditionError("Init_Mine : largeur % 2 != 1");
		}
		if (!(largeur > 1)) {
			throw new PreConditionError("Init_Mine : largeur <= 1");
		}
		if (!(hauteur % 2 == 1)) {
			throw new PreConditionError("Init_Mine : hauteur % 2 != 1");
		}
		if (!(hauteur > 1)) {
			throw new PreConditionError("Init_Mine : hauteur <= 1");
		}
		if (!(orRestant > 0)) {
			throw new PreConditionError("Init_Mine : orRestant <= 0");
		}		
	}

	public void checkInvariants() throws InvariantError {
		checkEstAbandonneeInvariant();
		checkGetAbandonCompteurInvariant();
		checkGetSideInvariant();		
	}
	
	private void checkEstAbandonneeInvariant() throws InvariantError {
		if (!(estAbandonnee() == (getAbandonCompteur() == 51))) {
			throw new InvariantError("EstAbandonnee : estAbandonnee() != " +
					"(getAbandonCompteur() == 51");
		}
	}
	
	private void checkGetAbandonCompteurInvariant() throws InvariantError {
		if (!((0 <= getAbandonCompteur()) && (getAbandonCompteur() <= 51))) {
			throw new InvariantError("GetAbandonCompteur : " +
					"!((0 <= getAbandonCompteur()) && (getAbandonCompteur() <= 51))");
		}
	}
	
	private void checkGetSideInvariant() throws InvariantError {
			
		boolean equivalent = true;
		
		if (estAbandonnee() && getSide() != Side.NONE) {
			equivalent = false;
		}
						
		if (!equivalent) {			
			throw new InvariantError("GetSide : estAbandonnee() !<==> " +
					"(getSide() == Side.NONE)");
		}
	}
	
	private void checkInitPostConditions(int largeur, int hauteur, int orRestant) 
			throws PostConditionError {
		
		if (!(super.getLargeur() == largeur)) {
			throw new PostConditionError("Init_Mine : getLargeur() != largeur");
		}		 
		if (!(super.getHauteur() == hauteur)) {
			throw new PostConditionError("Init_Mine : getHauteur() != hauteur");
		}
		if (!(super.getOrRestant() == orRestant)) {
			throw new PostConditionError("Init_Mine : getOrRestant() != orRestant");
		}		
		if (!(getAbandonCompteur() == 51)) {
			throw new PostConditionError("Init_Mine : getAbandonCompteur() != 51");
		}
		if (!(getSide() == Side.NONE)) {
			throw new PostConditionError("Init_Mine : getSide() != Side.NONE");
		}
	}
	
	/**
	 * Acceuil -----------------------------------------------------------------
	 */
	@Override
	public void acceuil(Side side) {
		try {			
			checkInvariants();			
			int getOrRestant_atPre = getOrRestant();					
			super.acceuil(side);
			checkInvariants();	
			checkAcceuilPostConditions(getOrRestant_atPre, side);
		} catch (ContractError e) {
			ErrorHandler.printError(e);
			throw e;
		}		
	}	
	
	private void checkAcceuilPostConditions(int getOrRestant_atPre, Side side) 
			throws PostConditionError {
		
		if (!(super.getOrRestant() == getOrRestant_atPre)) {
			throw new PostConditionError("Acceuil : super.getOrRestant() != " +
					"getOrRestant()@pre");
		}				
		int abandonCompteur = (side != Side.NONE)? 0: 51;
		if (!(getAbandonCompteur() == abandonCompteur)) {
			throw new PostConditionError("Acceuil : getAbandonCompteur() != " + abandonCompteur);
		}
		if (!(getSide() == side)) {
			throw new PostConditionError("Acceuil : getSide() != side");
		}
	}
	
	/**
	 * Abandoned ---------------------------------------------------------------
	 */
	@Override
	public void abandoned() {
		try {
			checkAbandonedPreConditions();
			checkInvariants();			
			int getOrRestant_atPre = super.getOrRestant();
			int getAbandonCompteur_atPre = super.getAbandonCompteur();
			Side getSide_atPre = getSide();
			super.abandoned();
			checkInvariants();	
			checkAbandonedPostConditions(getOrRestant_atPre, 
					getAbandonCompteur_atPre, getSide_atPre);
		} catch (ContractError e) {
			ErrorHandler.printError(e);
			throw e;
		}		
	}	

	private void checkAbandonedPreConditions() throws PreConditionError {		
		if (!(!estAbandonnee())) {
			throw new PreConditionError("Abandoned : estAbandonnee()");
		}	
	}
	
	private void checkAbandonedPostConditions(int getOrRestant_atPre, 
			int getAbandonCompteur_atPre, Side getSide_atPre) throws PostConditionError {
		
		if (!(getOrRestant() == getOrRestant_atPre)) {
			throw new PostConditionError("Abandoned : getOrRestant() != " +
					"getOrRestant()@pre");
		}				
		if (!(getAbandonCompteur() == getAbandonCompteur_atPre+1)) {
			throw new PostConditionError("Abandoned : getAbandonCompteur() != " +
					"getAbandonCompteur()@pre+1");
		}
		if (!(getSide() == getSide_atPre)) {
			throw new PostConditionError("Abandoned : getSide() != getSide()@pre");
		}
	}
	
	/**
	 * Retrait -----------------------------------------------------------------
	 */
	@Override
	public void retrait(int somme) {		
		try {					
			checkRetraitPreConditions(somme);
			checkInvariants();			
			int getAbandonCompteur_atPre = getAbandonCompteur();
			Side getSide_atPre = getSide();			
			super.retrait(somme);
			checkInvariants();	
			checkRetraitPostConditions(getAbandonCompteur_atPre, getSide_atPre);
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
	
	private void checkRetraitPostConditions(int getAbandonCompteur_atPre, Side getSide_atPre) 
			throws PostConditionError {
		
		if (!(getAbandonCompteur() == getAbandonCompteur_atPre)) {
			throw new PostConditionError("Retrait : getAbandonCompteur() " +
					"!= getAbandonCompteur()@pre");
		}	
		if (!(getSide() == getSide_atPre)) {
			throw new PostConditionError("Retrait : getSide() != getSide()@pre");
		}
	}
}