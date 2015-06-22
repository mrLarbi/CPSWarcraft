package preset;

import org.json.JSONObject;

import services.Mine;


public class MinePreset extends AbstractEntityPreset
{
	private static int largeur = 20;
	private static int hauteur = 10;
	private static int orRestant = 51;
	private static boolean isInitialized = false;
	
	public static Mine getMine()
	{
		if(!isInitialized)
		{
			parseMine();
		}
		return factory.makeMine(largeur, hauteur, orRestant);
	}
	
	public static void parseMine()
	{
		configure();
		JSONObject rootObject = new JSONObject(configuration);
		JSONObject hotelVilleObject = rootObject.getJSONObject("Mine");
		largeur = hotelVilleObject.getInt("largeur");
		hauteur = hotelVilleObject.getInt("hauteur");
		orRestant= hotelVilleObject.getInt("orRestant");
		isInitialized = true;
	}
}
