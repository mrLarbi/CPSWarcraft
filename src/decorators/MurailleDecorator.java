package decorators;

import services.Muraille;

public class MurailleDecorator extends TerrainDecorator implements Muraille
{
	
	private Muraille murailleDelegate;
	
	public MurailleDecorator(Muraille m)
	{
		super(m);
		murailleDelegate = m;
	}
	
	public void init(int largeur, int hauteur, int pv)
	{
		murailleDelegate.init(largeur, hauteur, pv);
	}
	
	public void frappee(int force)
	{
		murailleDelegate.frappee(force);
	}
	
	public int getPointsDeVie()
	{
		return murailleDelegate.getPointsDeVie();
	}
	
	public boolean estDetruite()
	{
		return murailleDelegate.estDetruite();
	}
}
