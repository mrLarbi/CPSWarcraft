package services;

public interface Route extends Terrain
{
	public int getFacteurMult();
	
	public void init(int largeur, int hauteur, int facteur);
	
}
