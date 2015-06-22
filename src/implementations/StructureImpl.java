package implementations;

import services.Structure;

public class StructureImpl extends TerrainImpl implements Structure {

	protected int orRestant;	
	
	public StructureImpl() {
		super();
		this.orRestant = 100;		
	}
	
	public StructureImpl(int largeur, int hauteur, int orRestant) {
		super(largeur, hauteur);
		init(largeur, hauteur, orRestant);
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
		return getOrRestant() <= 0;
	}

	@Override
	public void retrait(int somme) {		
		this.orRestant -= somme;
	}
}
