package decorators;

import services.Structure;

public abstract class StructureDecorator implements Structure {
	
	private Structure terrainDelegate;
	
	public StructureDecorator(Structure t) {
		terrainDelegate = t;
	}
	
	@Override
	public void init(int largeur, int hauteur, int orRestant) {
		terrainDelegate.init(largeur, hauteur, orRestant);
	}
	
	@Override
	public int getOrRestant() {
		return terrainDelegate.getOrRestant();
	}
	
	@Override
	public boolean estLaminee() {
		return terrainDelegate.estLaminee();
	}
}
