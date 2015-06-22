package services;

public interface Muraille extends Terrain
{
	public int getPointsDeVie();
	public boolean estDetruite();
	
	public void init(int largeur, int hauteur, int pv);
	
	public void frappee(int force);
	
}
