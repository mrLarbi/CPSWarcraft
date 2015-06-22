package decorators;

import services.Terrain;

public abstract class TerrainDecorator implements Terrain {
	
	private Terrain terrainDelegate;
	
	public TerrainDecorator(Terrain t) {
		terrainDelegate = t;
	}
	
	@Override
	public void init(int largeur, int hauteur) {
		terrainDelegate.init(largeur, hauteur);
	}
	
	@Override
	public int getLargeur() {
		return terrainDelegate.getLargeur();
	}
	
	@Override
	public int getHauteur() {
		return terrainDelegate.getHauteur();
	}
}
