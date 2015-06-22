package implementationsBug;

import implementations.TerrainImpl;
import services.Route;

public class RouteImplBug extends TerrainImpl implements Route
{
	public int facteurMult;
	
	public RouteImplBug(int largeur, int hauteur, int facteur)
	{
		super(largeur, hauteur);
		init(largeur, hauteur, facteur);
	}
	
	public RouteImplBug() {
		super();
		facteurMult = 2;
	}

	public int getFacteurMult()
	{
		return facteurMult*4;
	}
	
	public void init(int largeur, int hauteur, int facteur)
	{
		super.init(largeur, hauteur);
		facteurMult = facteur*2;
	}	
}
