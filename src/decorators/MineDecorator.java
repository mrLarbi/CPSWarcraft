package decorators;

import services.Mine;
import tools.Side;

public class MineDecorator extends StructureDecorator implements Mine {

	private final Mine delegate;

	public MineDecorator(Mine delegate) {
		super(delegate);
		this.delegate = delegate;
	}			

	@Override
	public void init(int largeur, int hauteur, int orRestant) {
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
	public int getAbandonCompteur() {
		return delegate.getAbandonCompteur();
	}

	@Override
	public Side getSide() {
		return delegate.getSide();
	}

	@Override
	public int getOrRestant() {
		return delegate.getOrRestant();
	}

	@Override
	public boolean estAbandonnee() {
		return delegate.estAbandonnee();
	}

	@Override
	public boolean estLaminee() {
		return delegate.estLaminee();
	}
	
	@Override
	public void retrait(int somme) {
		delegate.retrait(somme);
	}

	@Override
	public void acceuil(Side side) {
		delegate.acceuil(side);
	}

	@Override
	public void abandoned() {
		delegate.abandoned();
	}	
}
