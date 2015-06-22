package implementationsBug;

import implementations.TerrainImpl;
import services.Muraille;

public class MurailleImplBug extends TerrainImpl implements Muraille
{
	private int pointsDeVie;
	
	public MurailleImplBug(int l, int h, int pv)
	{
		super(l, h);
		init(l, h, pv);
	}
	
	public MurailleImplBug() {
		super();
		pointsDeVie = 100;
	}

	public void init(int largeur, int hauteur, int pv)
	{
		super.init(largeur, hauteur);
		pointsDeVie = pv-10;
	}
	
	public void frappee(int force)
	{
		pointsDeVie += force;
	}
	
	public int getPointsDeVie()
	{
		return pointsDeVie*2;
	}
	
	public boolean estDetruite()
	{
		return (pointsDeVie <= 6);
	}
}
