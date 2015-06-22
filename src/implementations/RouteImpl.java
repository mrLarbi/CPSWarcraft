package implementations;

import services.Route;

public class RouteImpl extends TerrainImpl implements Route
{
	public int facteurMult;
	
	public RouteImpl(int largeur, int hauteur, int facteur)
	{
		super(largeur, hauteur);
		init(largeur, hauteur, facteur);
	}
	
	public RouteImpl() {
		super();
		facteurMult = 2;
	}

	public int getFacteurMult()
	{
		return facteurMult;
	}
	
	public void init(int largeur, int hauteur, int facteur)
	{
		super.init(largeur, hauteur);
		facteurMult = facteur;
	}
	
}
