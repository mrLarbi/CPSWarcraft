package decorators;

import services.Route;

public class RouteDecorator extends TerrainDecorator implements Route
{
	private Route routeDelegate;
	
	public RouteDecorator(Route r)
	{
		super(r);
		routeDelegate = r;
	}
	
	public void init(int largeur, int hauteur, int facteur)
	{
		routeDelegate.init(largeur, hauteur, facteur);
	}
	
	public int getFacteurMult()
	{
		return routeDelegate.getFacteurMult();
	}
}
