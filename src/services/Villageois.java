package services;

import tools.Race;
import tools.Side;

public interface Villageois {
	
	/** Observators --------------------------------------------------------- */
	public Race getRace();
	public Side getSide();
	public int getLargeur();
	public int getHauteur();
	public int getForce();
	public double getVitesse();
	public int getPointsDeVie();
	public int getQuantiteOr();
	public boolean estMort();
		
	/** Invariants ---------------------------------------------------------- */
	/*  
	 *  \inv: estMort() =(min) getPointsDeVie() <= 0
	 *  \inv: getQuantiteOr() >= 0
	 */
			
	/** Constructors -------------------------------------------------------- */	
	/*  
	 *  \pre: (largeur % 2 == 1) && (largeur > 1) && (hauteur % 2 == 1) && 
	 	(hauteur > 1) && (force >= 0) && (vitesse >= 0) && (pointsDeVie >= 0)
	 *  \post: getRace() == race
	 *  \post: getSide() == side
	 *  \post: getLargeur() == largeur
	 *  \post: getHauteur() == hauteur
	 *  \post: getForce() == force
	 *  \post: getVitesse() == vitesse
	 *  \post: getPointsDeVie() == pointsDeVie
	 *  \post: getQuantiteOr() == 0 
	 */			
	public void init(Race race, Side side, int largeur, int hauteur, int force, 
			double vitesse, int pointsDeVie);
	
	/** Operators ----------------------------------------------------------- */
	/*  
	 *  \pre: !estMort() && degat > 0
 	 *  \post: getPointsDeVie() == getPointsDeVie()@pre - degat
 	 *  \post: getQuantiteOr() == getQuantiteOr()@pre 
 	 */					
	public void retrait(int degat);
	
	/*  
	 *  \pre: !estMort()
	 *  \post: getPointsDeVie() == getPointsDeVie()@pre
	 *  \post: getQuantiteOr() == 0 
	 */
	public void viderPoches();
	
	/*  
	 *  \pre: !estMort() && retire > 0
	 *  \post: getPointsDeVie() == getPointsDeVie()@pre
	 *  \post: getQuantiteOr() == getQuantiteOr()@pre + retire
	 */
	public void recupere(int retire);
}
