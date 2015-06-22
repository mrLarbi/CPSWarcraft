package services;

import tools.Side;

public interface Mine extends Structure {
	
	/** Observators --------------------------------------------------------- */	
	public boolean estAbandonnee();	
	public int getAbandonCompteur();	
	// \pre: !estAbandonnee()
	public Side getSide();		
	
	/** Invariants ---------------------------------------------------------- */
	/*
	 *  \inv: estAbandonnee() =(min) getAbandonCompteur() == 51
	 *  \inv: (0 <= getAbandonCompteur()) && (getAbandonCompteur() <= 51)
	 *  \inv: (getSide() == Side.NONE) <==> estAbandonnee()
	 */
		
	/** Constructors -------------------------------------------------------- */
	/*  
	 *  \pre: (largeur % 2 == 1) && (hauteur % 2 == 1) && (orRestant > 0)
	 *  \post: getLargeur() == largeur
	 *  \post: getHauteur() == hauteur
	 *  \post: getType() == TerrainType.MINE
	 *  \post: getOrRestant() == 51
	 *  \post: getAbandonCompteur() == 51
	 *  \post: getSide() == Side.NONE
	 */
	public void init(int largeur, int hauteur, int orRestant); 
	
	/** Operators ----------------------------------------------------------- */
	/*  
	 *  \post: getOrRestant() == super().getOrRestant()@pre
	 *  \post: getAbandonCompteur() == 0
	 *  \post: getSide() == side
	 */	
	public void acceuil(Side side);
	
	/*  
	 *  \pre: !estAbandonnee()
	 *  \post: getOrRestant() == super().getOrRestant()@pre
	 *  \post: getAbandonCompteur() == getAbandonCompteur()@pre + 1
	 *  \post: getSide() == getSide()@pre
	 */
	public void abandoned();
	
	/*  
	 *  \post: getAbandonCompteur() == getAbandonCompteur()@pre
	 *  \post: getSide() == getSide()@pre
	 */
	public void retrait(int somme);			
}
