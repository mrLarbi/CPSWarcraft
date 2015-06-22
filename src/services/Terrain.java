package services;

public interface Terrain {
	
	/** Observators --------------------------------------------------------- */	
	public int getLargeur();
	public int getHauteur();
	
	/** NO Invariants ------------------------------------------------------- */
	
	/** Constructors -------------------------------------------------------- */	
	/*  
	 *  \pre: (largeur % 2 == 1) && (hauteur % 2 == 1) && (largeur > 1) && (hauteur > 1)
	 *  \post: getLargeur() == largeur
	 *  \post: getHauteur() == hauteur	
	 */
	public void init(int largeur, int hauteur);
	
	/** NO Operators -------------------------------------------------------- */
}
