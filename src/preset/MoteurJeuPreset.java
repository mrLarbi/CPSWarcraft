package preset;

import org.json.JSONObject;

import services.MoteurJeu;
import tools.Race;

public class MoteurJeuPreset extends AbstractEntityPreset {
	
	private static 	int largeur;
	private static 	int hauteur;
	private static 	int maxPas;
	private static 	Race playerRace;
	private static 	Race enemyRace;
	private static boolean isInitialized = false;
	
	public static MoteurJeu getMoteurJeu(String fileName)
	{
		if(!isInitialized)
		{
			parseMoteurJeu();
		}
		return factory.makeMoteurJeu(largeur, hauteur, maxPas, playerRace, enemyRace, fileName);
	}
	
	private static void parseMoteurJeu() {
		configure();
		JSONObject rootObjet = new JSONObject(configuration);
		JSONObject gameObject = rootObjet.getJSONObject("Jeu");
		largeur = gameObject.getInt("largeur");
		hauteur = gameObject.getInt("hauteur");
		maxPas = gameObject.getInt("maxPas");
		String playerRaceString = gameObject.getString("playerRace");
		playerRace = playerRaceString.equals("HUMAN") ? Race.HUMAN : Race.ORC;
		String enemyRaceString = gameObject.getString("enemyRace");
		enemyRace = enemyRaceString.equals("HUMAN") ? Race.HUMAN : Race.ORC;
		isInitialized = true;
	}
}
