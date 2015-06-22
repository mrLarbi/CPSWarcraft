package preset;

import org.json.JSONObject;

import services.Villageois;

import tools.Race;
import tools.Side;

public class VillageoisHumanPreset extends AbstractEntityPreset
{
	private static int largeur = 20;
	private static int hauteur = 10;
	private static int force = 2;
	private static double vitesse = 2;
	private static int pointsDeVie = 20;
	private static boolean isInitialized = false;
	
	public static Villageois getHumanVillageois(Side side)
	{
		if(!isInitialized)
		{
			parseHumanVillageois();
		}
		return factory.makeVillageois(Race.HUMAN, side, largeur, hauteur, force, vitesse, pointsDeVie);
	}
	
	public static void parseHumanVillageois()
	{
		configure();
		JSONObject rootObject = new JSONObject(configuration);
		JSONObject HumanVillageoisObject = rootObject.getJSONObject("VillageoisHuman");
		largeur = HumanVillageoisObject.getInt("largeur");
		hauteur = HumanVillageoisObject.getInt("hauteur");
		force= HumanVillageoisObject.getInt("force");
		vitesse= HumanVillageoisObject.getDouble("vitesse");
		pointsDeVie= HumanVillageoisObject.getInt("pointsDeVie");
		isInitialized = true;
	}
}
