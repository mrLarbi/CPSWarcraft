package implementations;

import services.Villageois;
import tools.Race;
import tools.Side;

public class VillageoisImpl implements Villageois {

	private Race race;
	private Side side;
	private int largeur;
	private int hauteur;
	private int force;
	private double vitesse;
	private int pointsDeVie;
	private int quantiteOr;	
	
	public VillageoisImpl() {
		init(Race.HUMAN, Side.PLAYER, 20, 20, 4, 4, 20);
	}
	
	public VillageoisImpl(Race race, Side side, int largeur, int hauteur, int force, 
			double vitesse, int pointsDeVie) {
		
		init(race, side, largeur, hauteur, force, vitesse, pointsDeVie);
	}	

	@Override
	public void init(Race race, Side side, int largeur, int hauteur, int force, 
			double vitesse, int pointsDeVie) {		
		
		this.race = race;
		this.side = side;
		this.largeur = largeur;
		this.hauteur = hauteur;
		this.force = force;
		this.vitesse = vitesse;		
		this.pointsDeVie = pointsDeVie;
		this.quantiteOr = 0;		
	}
	
	@Override
	public Race getRace() {
		return this.race;
	}

	@Override
	public Side getSide() {
		return this.side;
	}

	@Override
	public int getLargeur() {
		return this.largeur;
	}

	@Override
	public int getHauteur() {
		return this.hauteur;
	}

	@Override
	public int getForce() {
		return this.force;
	}

	@Override
	public double getVitesse() {
		return this.vitesse;
	}

	@Override
	public int getPointsDeVie() {
		return this.pointsDeVie;
	}

	@Override
	public int getQuantiteOr() {
		return this.quantiteOr;
	}

	@Override
	public boolean estMort() {
		return (getPointsDeVie() <= 0);
	}
	
	@Override
	public void retrait(int degat) {
		this.pointsDeVie -= degat; 		
	}
	
	@Override
	public void viderPoches() {
		this.quantiteOr = 0;
	}

	@Override
	public void recupere(int retire) {
		quantiteOr += retire;
	}
}
