package tools;

import services.Route;

public class RoutePosition extends EntityPosition
{
	private Route route;
	
	public RoutePosition(Route r)
	{
		route = r;
	}
	
	public RoutePosition(Route r, int x, int y)
	{
		super(x, y);
		route = r;
	}
	
	public Route getRoute()
	{
		return route;
	}
}
