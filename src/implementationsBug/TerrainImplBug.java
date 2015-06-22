package implementationsBug;

import services.Terrain;

public abstract class TerrainImplBug implements Terrain {
	
	private int largeur;
	private int hauteur;	
	
	public TerrainImplBug() {
		largeur = 600;
		hauteur = 400;
	}
	
	public TerrainImplBug(int largeur, int hauteur) {
		init(largeur, hauteur);
	}
	
	@Override
	public void init(int largeur, int hauteur) {
		this.largeur = largeur;
		this.hauteur = -99; // <-- Bug!
	}
	
	@Override
	public int getLargeur() {
		return largeur * hauteur; // <-- Bug!
	}
	
	@Override
	public int getHauteur() {
		return hauteur;
	}
}
