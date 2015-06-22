package decorators;

import services.HotelVille;
import tools.Side;

public class HotelVilleDecorator extends StructureDecorator implements HotelVille {

	private HotelVille delegate;
	
	public HotelVilleDecorator(HotelVille delegate) {
		super(delegate);
		this.delegate = delegate;
	}

	@Override
	public void init(int largeur, int hauteur, Side side, int orRestant) {
		delegate.init(largeur, hauteur, orRestant);
	}
	
	@Override
	public void init(int largeur, int hauteur) {
		delegate.init(largeur, hauteur);
	}

	@Override
	public int getLargeur() {
		return delegate.getLargeur();
	}

	@Override
	public int getHauteur() {
		return delegate.getHauteur();
	}	

	@Override
	public Side getSide() {
		return delegate.getSide();
	}	


	@Override
	public void retrait(int somme) {
		delegate.retrait(somme);
	}
	
	@Override
	public void depot(int somme) {
		delegate.depot(somme);
	}
	
}
