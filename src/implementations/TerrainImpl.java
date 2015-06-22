package implementations;

import services.Terrain;

public abstract class TerrainImpl implements Terrain {
	
	private int largeur;
	private int hauteur;	
	
	public TerrainImpl() {
		largeur = 600;
		hauteur = 400;
	}
	
	public TerrainImpl(int largeur, int hauteur) {
		init(largeur, hauteur);
	}

	@Override
	public void init(int largeur, int hauteur) {
		this.largeur = largeur;
		this.hauteur = hauteur;
	}
	
	@Override
	public int getLargeur() {
		return largeur;
	}
	
	@Override
	public int getHauteur() {
		return hauteur;
	}
}
