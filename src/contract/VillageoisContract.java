package contract;

import services.Villageois;
import tools.Race;
import tools.Side;
import decorators.VillageoisDecorator;
import error.ContractError;
import error.ErrorHandler;
import error.InvariantError;
import error.PostConditionError;
import error.PreConditionError;

public class VillageoisContract extends VillageoisDecorator {

	public VillageoisContract(Villageois delegate) {
		super(delegate);		
	}
	
	/**
	 * Init --------------------------------------------------------------------
	 */
	@Override
	public void init(Race race, Side side, int largeur, int hauteur, int force, 
			double vitesse, int pointsDeVie) {
		try {
			checkInitPreConditions(largeur, hauteur, force, vitesse, pointsDeVie);
			checkInvariants();			
			super.init(race, side, largeur, hauteur, force, vitesse, pointsDeVie);
			checkInvariants();
			checkInitPostConditions(race, side, largeur, hauteur, force, vitesse, pointsDeVie);
		} catch (ContractError e) {
			ErrorHandler.printError(e);
			throw e;
		}
	}
	
	private void checkInitPreConditions(int largeur, int hauteur, int force, 
			double vitesse, int pointsDeVie) throws PreConditionError {
		
		if (!(largeur % 2 == 1)) {
			throw new PreConditionError("Init_Villageois : largeur % 2 != 1");
		}
		if (!(largeur > 1)) {
			throw new PreConditionError("Init_Villageois : largeur <= 1");
		}
		if (!(hauteur % 2 == 1)) {
			throw new PreConditionError("Init_Villageois : hauteur % 2 != 1");
		}
		if (!(hauteur > 1)) {
			throw new PreConditionError("Init_Villageois : hauteur <= 1");
		}
		if (!(force >= 0)) {
			throw new PreConditionError("Init_Villageois : force < 0");
		}
		if (!(vitesse >= 0)) {
			throw new PreConditionError("Init_Villageois : vitesse < 0");
		} 
		if (!(pointsDeVie >= 0)) {
			throw new PreConditionError("Init_Villageois : pointsDeVie < 0");
		} 
	}
	
	public void checkInvariants() throws InvariantError {
		checkEstMortInvariant();
		checkQuantiteOrInvariant();
	}

	private void checkEstMortInvariant() throws InvariantError {
		if (!(estMort() == (getPointsDeVie() <= 0))) {
			throw new InvariantError("EstMort : estMort() != (getPointsDeVie() <= 0)");
		}
	}
		
	private void checkQuantiteOrInvariant() throws InvariantError {
		if (!(getQuantiteOr() >= 0)) {
			throw new InvariantError("GetQuantiteOr : getQuantiteOr() < 0");
		}
	}					
	
	private void checkInitPostConditions(Race race, Side side, int largeur, 
			int hauteur, int force, double vitesse, int pointsDeVie) 
			throws PostConditionError {
				
		if (!(getRace() == race)) {
			throw new PostConditionError("Init_Villageois : getRace() != race");
		}		
		if (!(getSide() == side)) {
			throw new PostConditionError("Init_Villageois : getSide() != side");
		}		
		if (!(getLargeur() == largeur)) {
			throw new PostConditionError("Init_Villageois : getLargeur() != largeur");
		}		 
		if (!(getHauteur() == hauteur)) {
			throw new PostConditionError("Init_Villageois : getHauteur() != hauteur");
		}		
		if (!(getForce() == force)) {
			throw new PostConditionError("Init_Villageois : getForce() != force");
		}		
		if (!(getVitesse() == vitesse)) {
			throw new PostConditionError("Init_Villageois : getVitesse() != vitesse");
		}
		if (!(getPointsDeVie() == pointsDeVie)) {
			throw new PostConditionError("Init_Villageois : getPointsDeVie() != pointsDeVie");
		}	
		if (!(getQuantiteOr() == 0)) {
			throw new PostConditionError("Init_Villageois : getQuantiteOr() != 0");
		}
	}
	
	/**
	 * Retrait -----------------------------------------------------------------
	 */
	@Override
	public void retrait(int degat) {
		try {
			checkRetraitPreConditions(degat);
			checkInvariants();
			int getPointsDeVie_atPre = getPointsDeVie();
			int getQuantiteOr_atPre = getQuantiteOr();					
			super.retrait(degat);
			checkInvariants();	
			checkRetraitPostConditions(getPointsDeVie_atPre, getQuantiteOr_atPre, degat);
		} catch (ContractError e) {
			ErrorHandler.printError(e);
			throw e;
		}
	}
	
	private void checkRetraitPreConditions(int degat) throws PreConditionError {
		if (!(!estMort())) {
			throw new PreConditionError("Retrait : estMort()");
		}
		if (!(degat > 0)) {
			throw new PreConditionError("Retrait : degat <= 0");
		}
	}
	
	private void checkRetraitPostConditions(int getPointsDeVie_atPre, 
			int getQuantiteOr_atPre, int degat) throws PostConditionError {
		
		if (!(getPointsDeVie() == getPointsDeVie_atPre - degat)) {
			throw new PostConditionError("Retrait : getPointsDeVie() != " +
					"getPointsDeVie()@pre - degat");
		}																	
		if (!(getQuantiteOr() == getQuantiteOr_atPre)) {
			throw new PostConditionError("Retrait : getQuantiteOr() != " +
					"getQuantiteOr()@pre");
		}
	}
	
	/**
	 * ViderPorches ------------------------------------------------------------
	 */
	@Override
	public void viderPoches() {
		try {			
			checkViderPochesPreConditions();
			checkInvariants();
			int getPointsDeVie_atPre = getPointsDeVie(); 			
			super.viderPoches();
			checkInvariants();	
			checkViderPochesPostConditions(getPointsDeVie_atPre);
		} catch (ContractError e) {
			ErrorHandler.printError(e);
			throw e;
		}
	}

	private void checkViderPochesPreConditions() throws PreConditionError {
		if (!(!estMort())) {
			throw new PreConditionError("ViderPoches : estMort()");
		}		
	}

	private void checkViderPochesPostConditions(int getPointsDeVie_atPre) 
			throws PostConditionError {
		
		if (!(getPointsDeVie() == getPointsDeVie_atPre)) {
			throw new PostConditionError("ViderPoches : getPointsDeVie() != " +
					"getPointsDeVie()@pre");
		}																	
		if (!(getQuantiteOr() == 0)) {
			throw new PostConditionError("ViderPoches : getQuantiteOr() != 0");
		}
	}
	
	/**
	 * Recupere ----------------------------------------------------------------
	 */
	@Override
	public void recupere(int retire) {
		try {
			checkRecuperePreConditions(retire);
			checkInvariants();
			int getPointsDeVie_atPre = getPointsDeVie();
			int getQuantiteOr_atPre = getQuantiteOr();					
			super.recupere(retire);
			checkInvariants();	
			checkRecuperePostConditions(getPointsDeVie_atPre, getQuantiteOr_atPre, retire);
		} catch (ContractError e) {
			ErrorHandler.printError(e);
			throw e;
		}
	}
	
	private void checkRecuperePreConditions(int retire) throws PreConditionError {
		if (!(!estMort())) {
			throw new PreConditionError("Recupere : estMort()");
		}
		if (!(retire > 0)) {
			throw new PreConditionError("retire <= 0)");
		}
	}
	
	private void checkRecuperePostConditions(int getPointsDeVie_atPre, 
			int getQuantiteOr_atPre, int retire) throws PostConditionError {
		
		if (!(getPointsDeVie() == getPointsDeVie_atPre)) {
			throw new PostConditionError("Recupere : getPointsDeVie() != " +
					"getPointsDeVie()@pre");
		}																	
		if (!(getQuantiteOr() == getQuantiteOr_atPre + retire)) {
			throw new PostConditionError("Recupere : getQuantiteOr() != " +
					"getQuantiteOr()@pre + retire");
		}
	}	
}
