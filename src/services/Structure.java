package services;


public interface Structure extends Terrain {
	
	/** Observators --------------------------------------------------------- */	
	public int getOrRestant();	
	public boolean estLaminee();	
	
	/** Invariants ---------------------------------------------------------- */	
	//  \inv: estLaminee() =(min) getOrRestant() <= 0
	
	/** Constructors -------------------------------------------------------- */	
	/*  
	 *  \pre: (largeur % 2 == 1) && (hauteur % 2 == 1) && (orRestant > 0)
	 *     && (largeur > 1) && (hauteur > 1)
	 *  \post: getLargeur() == largeur
	 *  \post: getHauteur() == hauteur
	 *  \post: getType() == TerrainType.NONE
	 *  \post: getOrRestant() == orRestant	
	 */
	public void init(int largeur, int hauteur, int orRestant);
	
	/*  
	 *  \pre: !estLaminee() && somme > 0  
	 *  \post: getOrRestant() == getOrRestant()@pre - somme	
	 */
	public void retrait(int somme);
	
	/** NO Operators -------------------------------------------------------- */
}
