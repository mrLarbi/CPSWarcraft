package decorators;

import services.Villageois;
import tools.Race;
import tools.Side;

public class VillageoisDecorator implements Villageois {
	
	private final Villageois delegate;

	public VillageoisDecorator(Villageois delegate) {
		this.delegate = delegate;
	}
	
	@Override
	public void init(Race race, Side side, int largeur, int hauteur, int force,
			double vitesse, int pointsDeVie) {
		delegate.init(race, side, largeur, hauteur, force, vitesse, pointsDeVie);		
	}

	@Override
	public Race getRace() {
		return delegate.getRace();
	}

	@Override
	public Side getSide() {
		return delegate.getSide();
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
	public int getForce() {
		return delegate.getForce();
	}

	@Override
	public double getVitesse() {
		return delegate.getVitesse();
	}

	@Override
	public int getPointsDeVie() {
		return delegate.getPointsDeVie();
	}

	@Override
	public int getQuantiteOr() {
		return delegate.getQuantiteOr();
	}

	@Override
	public boolean estMort() {
		return delegate.estMort();
	}

	@Override
	public void retrait(int degat) {
		delegate.retrait(degat);		
	}

	@Override
	public void viderPoches() {
		delegate.viderPoches();		
	}

	@Override
	public void recupere(int retire) {
		delegate.recupere(retire);
	}		
}
