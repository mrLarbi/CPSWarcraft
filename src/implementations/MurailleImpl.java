package implementations;

import services.Muraille;

public class MurailleImpl extends TerrainImpl implements Muraille
{
	private int pointsDeVie;
	
	public MurailleImpl(int l, int h, int pv)
	{
		super(l, h);
		init(l, h, pv);
	}
	
	public MurailleImpl() {
		super();
		pointsDeVie = 100;
	}

	public void init(int largeur, int hauteur, int pv)
	{
		super.init(largeur, hauteur);
		pointsDeVie = pv;
	}
	
	public void frappee(int force)
	{
		pointsDeVie -= force;
	}
	
	public int getPointsDeVie()
	{
		return pointsDeVie;
	}
	
	public boolean estDetruite()
	{
		return (pointsDeVie <= 0);
	}
}
