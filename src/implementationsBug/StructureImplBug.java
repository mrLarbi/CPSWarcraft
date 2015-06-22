package implementationsBug;

import implementations.TerrainImpl;
import services.Structure;

public class StructureImplBug extends TerrainImpl implements Structure {

	protected int orRestant;	
	
	public StructureImplBug() {
		this.orRestant = 99;		
	}
	
	public StructureImplBug(int largeur, int hauteur, int orRestant) {
		this.init(largeur, hauteur, orRestant);
	}
	
	@Override
	public void init(int largeur, int hauteur, int orRestant) {
		super.init(largeur, hauteur);
		this.orRestant = orRestant;		
	}

	@Override
	public int getOrRestant() {		
		return this.orRestant;
	}

	@Override
	public boolean estLaminee() {		
		return getOrRestant() > 0; // <-- Bug!
	}

	@Override
	public void retrait(int somme) {
		this.orRestant -= somme;
	}
}
