package implementations;

import services.HotelVille;
import tools.Side;

public class HotelVilleImpl extends StructureImpl implements HotelVille {

	private Side side;
	
	public HotelVilleImpl() {
		super();
		side = Side.PLAYER;
	}
	
	public HotelVilleImpl(int largeur, int hauteur, Side side, int orRestant) {
		super(largeur, hauteur, orRestant);
		init(largeur, hauteur, side, orRestant);
	}	

	@Override
	public void init(int largeur, int hauteur, Side side, int orRestant) {		
		super.init(largeur, hauteur, orRestant);		
		this.side = side;
	}

	@Override
	public Side getSide() {
		return side;
	}	

	@Override
	public void depot(int somme) {
		orRestant += somme;
	}	
}
