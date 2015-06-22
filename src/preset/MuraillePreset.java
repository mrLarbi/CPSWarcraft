package preset;

import org.json.JSONObject;

import services.Muraille;

public class MuraillePreset extends AbstractEntityPreset
{
	private static int largeur = 20;
	private static int hauteur = 10;
	private static int pointsDeVie = 50;
	private static boolean isInitialized = false;
	
	public static Muraille getMuraille()
	{
		if(!isInitialized)
		{
			parseMuraille();
		}
		return factory.makeMuraille(largeur, hauteur, pointsDeVie);
	}
	
	public static void parseMuraille()
	{
		configure();
		JSONObject rootObject = new JSONObject(configuration);
		JSONObject MurailleObject = rootObject.getJSONObject("Muraille");
		largeur = MurailleObject.getInt("largeur");
		hauteur = MurailleObject.getInt("hauteur");
		pointsDeVie= MurailleObject.getInt("pointsDeVie");
		isInitialized = true;
	}
}
