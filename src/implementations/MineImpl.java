package implementations;

import services.Mine;
import tools.Side;

public class MineImpl extends StructureImpl implements Mine {
	
	private int abandonCompteur;	
	private Side side;
	
	public MineImpl() {
		super();
		side = Side.NONE;
		abandonCompteur = 51;
	}
	
	public MineImpl(int largeur, int hauteur, int orRestant) {	
		this.init(largeur, hauteur, orRestant);
	}		

	@Override
	public void init(int largeur, int hauteur, int orRestant) {
		super.init(largeur, hauteur, orRestant);		
		abandonCompteur = 51;
		side = Side.NONE;
	}

	@Override
	public boolean estAbandonnee() {			
		return getAbandonCompteur() == 51;
	}

	@Override
	public int getAbandonCompteur() {		
		return abandonCompteur;
	}

	@Override
	public Side getSide() {
		return estAbandonnee()? Side.NONE: side;  		
	}

	@Override
	public void acceuil(Side side) {		
		abandonCompteur = (side != Side.NONE)? 0: 51; 
		this.side = side;
	}

	@Override
	public void abandoned() {
		abandonCompteur++;			
	}	
}
