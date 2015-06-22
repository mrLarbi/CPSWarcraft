package preset;

import services.HotelVille;
import tools.Side;
import org.json.*;

public class HotelVillePreset extends AbstractEntityPreset
{
	private static int largeur = 40;
	private static int hauteur = 40;
	private static int orRestant = 16;
	private static boolean isInitialized = false;
	
	public static HotelVille getHotelVille(Side side)
	{
		if(!isInitialized)
		{
			parseHotelVille();
		}
		return factory.makeHotelVille(largeur, hauteur, side, orRestant);
	}
	
	public static void parseHotelVille()
	{
		configure();
		JSONObject rootObject = new JSONObject(configuration);
		JSONObject MineObject = rootObject.getJSONObject("HotelVille");
		largeur = MineObject.getInt("largeur");
		hauteur = MineObject.getInt("hauteur");
		orRestant= MineObject.getInt("orRestant");
		isInitialized = true;
	}
}
