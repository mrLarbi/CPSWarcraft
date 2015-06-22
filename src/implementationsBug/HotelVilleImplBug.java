package implementationsBug;

import services.HotelVille;
import tools.Side;

public class HotelVilleImplBug extends StructureImplBug implements HotelVille {

	@SuppressWarnings("unused")
	private Side side;
	
	public HotelVilleImplBug() {
		super();
		side = Side.PLAYER;
	}
	
	public HotelVilleImplBug(int largeur, int hauteur, Side side, int orRestant) {
		init(largeur, hauteur, side, orRestant);
	}

	@Override
	public void init(int largeur, int hauteur, Side side, int orRestant) {
		super.init(largeur, hauteur, orRestant);
		this.side = side;		
	}

	@Override
	public Side getSide() {
		return null; // <-- Bug!
	}	

	@Override
	public void depot(int somme) {
		orRestant += somme;
	}		
}
