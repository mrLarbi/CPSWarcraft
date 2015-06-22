package preset;

import org.json.JSONObject;

import services.Villageois;

import tools.Race;
import tools.Side;

public class VillageoisOrcPreset extends AbstractEntityPreset
{
	private static int largeur = 20;
	private static int hauteur = 10;
	private static int force = 2;
	private static double vitesse = 2;
	private static int pointsDeVie = 20;
	private static boolean isInitialized = false;
	
	public static Villageois getOrcVillageois(Side side)
	{
		if(!isInitialized)
		{
			parseOrcVillageois();
		}
		return factory.makeVillageois(Race.ORC, side, largeur, hauteur, force, vitesse, pointsDeVie);
	}
	
	public static void parseOrcVillageois()
	{
		configure();
		JSONObject rootObject = new JSONObject(configuration);
		JSONObject OrcVillageoisObject = rootObject.getJSONObject("VillageoisOrc");
		largeur = OrcVillageoisObject.getInt("largeur");
		hauteur = OrcVillageoisObject.getInt("hauteur");
		force= OrcVillageoisObject.getInt("force");
		vitesse= OrcVillageoisObject.getDouble("vitesse");
		pointsDeVie= OrcVillageoisObject.getInt("pointsDeVie");
		isInitialized = true;
	}
}
