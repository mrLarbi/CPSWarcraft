package services;

import tools.Side;

public interface HotelVille extends Structure {
	
	/** Observators --------------------------------------------------------- */
	public Side getSide();		
	
	/** NO Invariants ------------------------------------------------------- */
	
	/** Constructors -------------------------------------------------------- */
	/*  
	 *  \pre: (largeur % 2 == 1) && (hauteur % 2 == 1) && (orRestant > 0) 
	 *     && (largeur > 1) && (hauteur > 1) && (side != NONE)
	 *  \post: getLargeur() == largeur
	 *  \post: getHauteur() == hauteur
	 *  \post: getType() == TerrainType.HOTELVILLE
	 *  \post: getOrRestant() == orRestant
	 *  \post: getSide() == Side.side
	 */
	public void init(int largeur, int hauteur, Side side, int orRestant);
	
	/** Operators ----------------------------------------------------------- */
	/*  
	 *  \pre: somme > 0
	 *  \post: getOrRestant() == getOrRestant()@pre + somme
	 */
	public void depot(int somme);
}
