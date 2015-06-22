package preset;

import org.json.JSONObject;

import services.Route;

public class RoutePreset extends AbstractEntityPreset
{
	private static int largeur = 15;
	private static int hauteur = 15;
	private static int facteur = 2;
	private static boolean isInitialized = false;
	
	public static Route getRoute()
	{
		if(!isInitialized)
		{
			parseRoute();
		}
		return factory.makeRoute(largeur, hauteur, facteur);
	}
	
	public static void parseRoute()
	{
		configure();
		JSONObject rootObject = new JSONObject(configuration);
		JSONObject RouteObject = rootObject.getJSONObject("Route");
		largeur = RouteObject.getInt("largeur");
		hauteur = RouteObject.getInt("hauteur");
		facteur= RouteObject.getInt("facteur");
		isInitialized = true;
	}
}
