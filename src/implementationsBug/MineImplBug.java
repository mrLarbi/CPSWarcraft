package implementationsBug;

import services.Mine;
import tools.Side;

public class MineImplBug extends StructureImplBug implements Mine {
	
	private int abandonCompteur;	
	private Side side;
	
	public MineImplBug() {
		super();
		side = Side.NONE;
		abandonCompteur = 51;
	}
	
	public MineImplBug(int largeur, int hauteur, int orRestant) {	
		this.init(largeur, hauteur, orRestant);
	}		

	@Override
	public void init(int largeur, int hauteur, int orRestant) {
		super.init(largeur, hauteur, orRestant);		
		abandonCompteur = 51;
	}

	@Override
	public boolean estAbandonnee() {		
		return getAbandonCompteur() == 100; // <-- Bug!
	}

	@Override
	public int getAbandonCompteur() {		
		return abandonCompteur;
	}

	@Override
	public Side getSide() {
		return estAbandonnee()? side: Side.NONE; // <-- Bug!	
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
