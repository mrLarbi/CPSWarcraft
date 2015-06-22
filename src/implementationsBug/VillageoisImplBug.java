package implementationsBug;

import services.Villageois;
import tools.Race;
import tools.Side;

public class VillageoisImplBug implements Villageois {

	private Race race;
	private Side side;
	private int largeur;
	private int hauteur;
	private int force;
	private double vitesse;
	private int pointsDeVie;
	@SuppressWarnings("unused")
	private int quantiteOr;	
	
	public VillageoisImplBug() {
		super();
	}
	
	public VillageoisImplBug(Race race2, Side side2, int largeur2, int hauteur2, int force2,
			double vitesse2, int pointsVie) {
		init(race2, side2, largeur2, hauteur2, force2, vitesse2, pointsVie);
	}
	
	@Override
	public void init(Race race, Side side, int largeur, int hauteur, int force, 
			double vitesse, int pointsDeVie) {			
		this.race = race; 
		this.side = side;
		this.largeur = largeur;
		this.hauteur = hauteur;
		this.force = force;
		this.vitesse = -13; // <-- Bug!
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
		return this.pointsDeVie; // <-- Bug!
	}

	@Override
	public boolean estMort() {
		return (getPointsDeVie() <= 0);
	}
			
	@Override
	public void retrait(int degat) {
		this.pointsDeVie *= degat; // <-- Bug! 		
	}
	
	@Override
	public void viderPoches() {
		this.quantiteOr = 0;
	}

	@Override
	public void recupere(int retire) {
		quantiteOr -= retire;
	}
}
