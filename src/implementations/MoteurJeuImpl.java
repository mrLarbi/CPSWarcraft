package implementations;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Set;

import org.json.JSONArray;
import org.json.JSONObject;

import preset.HotelVillePreset;
import preset.MinePreset;
import preset.MuraillePreset;
import preset.RoutePreset;
import preset.VillageoisHumanPreset;
import preset.VillageoisOrcPreset;
import services.HotelVille;
import services.Mine;
import services.MoteurJeu;
import services.Muraille;
import services.Route;
import services.Villageois;
import tools.Commande;
import tools.Geometry;
import tools.HotelVillePosition;
import tools.MinePosition;
import tools.MuraillePosition;
import tools.Race;
import tools.Resultat;
import tools.RoutePosition;
import tools.Side;
import tools.VillageoisPosition;


public class MoteurJeuImpl implements MoteurJeu
{
	private int largeurTerrain;
	private int hauteurTerrain;
	private int maxPasJeu;
	
	private Race playerRace;
	private Race enemyRace;
	
	private int pasCourant;
	private HotelVillePosition playerHotelVille = null;
	private HotelVillePosition enemyHotelVille = null;
	
	private HashMap<Integer, VillageoisPosition> villageois = new HashMap<>();
	private HashMap<Integer, MinePosition> mines = new HashMap<>();
	private HashMap<Integer, RoutePosition> routes = new HashMap<>();
	private HashMap<Integer, MuraillePosition> murailles = new HashMap<>();
	
	public MoteurJeuImpl(int largeur, int hauteur, int maxPas, Race playerRace, Race enemyRace, String fileName)
	{
		init(largeur, hauteur, maxPas, playerRace, enemyRace, fileName);
	}
	
	public MoteurJeuImpl() {
		largeurTerrain = 600;
		hauteurTerrain = 400;
		maxPasJeu = 500;
		playerRace = Race.HUMAN;
		enemyRace = Race.HUMAN;
		initiailizeMap("config/map1.json");
	}

	public int getLargeurTerrain()
	{
		return largeurTerrain;
	}

	public int getHauteurTerrain()
	{
		return hauteurTerrain;
	}

	public int getMaxPasJeu()
	{
		return maxPasJeu;
	}

	public int getPasJeuCourant()
	{
		return pasCourant;
	}

	public boolean estFini()
	{
		return (getPasJeuCourant() == getMaxPasJeu() 
					|| (getHotelVille(Side.PLAYER).getOrRestant() >= 1664) 
					|| (getHotelVille(Side.ENEMY).getOrRestant() >= 1664)) ;
	}

	public Resultat getResultatFinal()
	{
		if(getHotelVille(Side.PLAYER).getOrRestant() >= 1664 && getHotelVille(Side.ENEMY).getOrRestant() < 1664)
		{
			return Resultat.GAGNE;
		}
		if(getHotelVille(Side.ENEMY).getOrRestant() >= 1664 && getHotelVille(Side.PLAYER).getOrRestant() < 1664)
		{
			return Resultat.PERDU;
		}
		return Resultat.EGALITE;
	}

	public Set<Integer> getNumerosVillageois()
	{
		return villageois.keySet();
	}

	public Villageois getVillageois(int numVillageois)
	{
		VillageoisPosition v =  villageois.get(numVillageois);
		return v.getVillageois();
	}

	public int getPositionVillageoisX(int numVillageois)
	{
		VillageoisPosition v =  villageois.get(numVillageois);
		return v.positionX;
	}

	public int getPositionVillageoisY(int numVillageois)
	{
		VillageoisPosition v =  villageois.get(numVillageois);
		return v.positionY;
	}

	public Set<Integer> getNumerosMines()
	{
		return mines.keySet();
	}

	public Mine getMine(int numMine)
	{
		MinePosition m = mines.get(numMine);
		return m.getMine();
	}

	public int getPositionMineX(int numMine)
	{
		MinePosition m = mines.get(numMine);
		return m.positionX;
	}

	public int getPositionMineY(int numMine)
	{
		MinePosition m = mines.get(numMine);
		return m.positionY;
	}
	
	
	public Set<Integer> getNumerosRoutes()
	{
		return routes.keySet();
	}
	
	public Route getRoute(int numRoute)
	{
		RoutePosition r = routes.get(numRoute);
		return r.getRoute();
	}
	
	public int getPositionRouteX(int numRoute)
	{
		RoutePosition r = routes.get(numRoute);
		return r.positionX;
	}
	
	public int getPositionRouteY(int numRoute)
	{
		RoutePosition r = routes.get(numRoute);
		return r.positionX;
	}
	
	public Set<Integer> getNumerosMurailles()
	{
		return murailles.keySet();
	}
	
	public Muraille getMuraille(int numMuraille)
	{
		MuraillePosition m = murailles.get(numMuraille);
		return m.getMuraille();
	}
	
	public int getPositionMurailleX(int numMuraille)
	{
		MuraillePosition m = murailles.get(numMuraille);
		return m.positionX;
	}
	
	public int getPositionMurailleY(int numMuraille)
	{
		MuraillePosition m = murailles.get(numMuraille);
		return m.positionY;
	}

	public HotelVille getHotelVille(Side side)
	{
		return side == Side.PLAYER ? playerHotelVille.getHotelVille() : enemyHotelVille.getHotelVille();
	}

	public int getPositionHotelVilleX(Side side)
	{
		return side == Side.PLAYER ? playerHotelVille.positionX : enemyHotelVille.positionX;
	}

	public int getPositionHotelVilleY(Side side)
	{
		return side == Side.PLAYER ? playerHotelVille.positionY : enemyHotelVille.positionY;
	}

	public boolean peutEntrer(int numVillageois, int numMine)
	{
		return (Geometry.distance(getPositionVillageoisX(numVillageois), getPositionVillageoisY(numVillageois)
				, getPositionMineX(numMine), getPositionMineY(numMine)) <= 51);
	}
	
	@Override
	public Route estVillageoisDansRoute(int numVillageois) {
		for(Integer i : getNumerosRoutes())
		{
			Route r = getRoute(i);
			Villageois v = getVillageois(numVillageois);
			if(Geometry.isCollision(getPositionRouteX(i), getPositionRouteY(i), r.getLargeur(), r.getHauteur()
					,getPositionVillageoisX(i), getPositionVillageoisY(i), v.getLargeur(), v.getHauteur()))
			{
				return r;
			}
		}
		return null;
	}
	
	@Override
	public boolean peutFrapperMuraille(int numVillageois, int numMuraille) {
		return (Geometry.distance(getPositionVillageoisX(numVillageois), getPositionVillageoisY(numVillageois)
				, getPositionMurailleX(numMuraille), getPositionMurailleY(numMuraille)) <= 51);
	}

	public boolean peutEntrerHotelVille(int numVillageois)
	{
		HotelVillePosition hp = (getVillageois(numVillageois).getSide() == Side.PLAYER) ? playerHotelVille : enemyHotelVille;
		Side side = hp.getHotelVille().getSide();
		return (Geometry.distance(getPositionVillageoisX(numVillageois), getPositionVillageoisY(numVillageois)
				, getPositionHotelVilleX(side), getPositionHotelVilleY(side)) <= 51);
	}

	public void init(int largeur, int hauteur, int maxPas, Race playerRace, Race enemyRace, String fileName)
	{
		largeurTerrain = largeur;
		hauteurTerrain = hauteur;
		maxPasJeu = maxPas;
		pasCourant = 0;
		this.playerRace = playerRace;
		this.enemyRace = enemyRace;
		playerHotelVille = null;
		enemyHotelVille = null;
		villageois = new HashMap<>();
		mines = new HashMap<>();
		routes = new HashMap<>();
		murailles = new HashMap<>();
		initiailizeMap(fileName);
	}

	public void pasJeu(Commande commande, int numVillageois, int argument)
	{
		pasCourant++;
		VillageoisPosition vp = villageois.get(numVillageois);
		for(Integer i : getNumerosMines())
		{
			Mine m = getMine(i);
			if(!m.estAbandonnee()){
				m.abandoned();
			}
		}
		switch(commande)
		{
		case RIEN:
			break;
		case DEPLACER:
			double radArgument = Math.toRadians(argument);
			int facteur = 1;
			Route r = estVillageoisDansRoute(numVillageois);
			if(r != null)
			{
				facteur = r.getFacteurMult();
			}
			int newX = (int) (vp.getVillageois().getVitesse() * facteur * Math.cos(radArgument))+getPositionVillageoisX(numVillageois);
			int newY = (int) (vp.getVillageois().getVitesse() * facteur * Math.sin(radArgument))+getPositionVillageoisY(numVillageois);
			vp.positionX = newX;
			vp.positionY = newY;
			break;
		case ENTRERMINE:
			Mine mineToEnter = getMine(argument);
			if(mineToEnter != null)
			{
				if(peutEntrer(numVillageois, argument)){
					int retire = 10;
					mineToEnter.acceuil(vp.getVillageois().getSide());
					if(!mineToEnter.estLaminee())
					{
						int recupere;
						if(mineToEnter.getOrRestant() < retire)
						{
							recupere = mineToEnter.getOrRestant();
						}
						else
						{
							recupere = retire;
						}
						mineToEnter.retrait(recupere);
						vp.getVillageois().recupere(recupere);
					}
				}
			}
			break;
		case ENTRERHOTELVILLE:
			Side side = getVillageois(numVillageois).getSide();
			if(peutEntrerHotelVille(numVillageois))
			{
				getHotelVille(side).depot(getVillageois(numVillageois).getQuantiteOr());
				getVillageois(numVillageois).viderPoches();
			}
			break;
		case FRAPPERMURAILLE:
			Muraille murailleToHit = getMuraille(argument);
			if(murailleToHit != null)
			{
				murailleToHit.frappee(getVillageois(numVillageois).getForce());
			}
			break;
		}
		enemyPlay();
	}

	private void enemyPlay() {
		//Enemy don't play yet
	}

	private void initiailizeMap(String configFile)
	{
		String configuration  = configure(configFile);
		parseMap(configuration);
	}

	private void parseMap(String configuration)
	{
		JSONObject rootObjet = new JSONObject(configuration);
		JSONArray configObject = rootObjet.getJSONArray("configuration");
		int size = configObject.length();
		for(int i = 0 ; i < size ; i++)
		{
			JSONObject configElement = (JSONObject) configObject.get(i);
			parseConfigElement(configElement);
		}
	}
	
	private void parseConfigElement(JSONObject configElement) {
		int x = configElement.getInt("x");
		int y = configElement.getInt("y");
		String type = configElement.getString("type");
		switch(type)
		{
		case "HotelVille1":
			HotelVille h1 = HotelVillePreset.getHotelVille(Side.PLAYER);
			playerHotelVille = new HotelVillePosition(h1,x,y);
			break;
		case "HotelVille2":
			HotelVille h2 = HotelVillePreset.getHotelVille(Side.ENEMY);
			enemyHotelVille = new HotelVillePosition(h2,x,y);
			break;
		
		case "Villageois1":
			Villageois v1 = playerRace == Race.HUMAN ? VillageoisHumanPreset.getHumanVillageois(Side.PLAYER) 
					: VillageoisOrcPreset.getOrcVillageois(Side.PLAYER);
			villageois.put(villageois.size(), new VillageoisPosition(v1, x, y));
			break;
		
		case "Villageois2":
			Villageois v2 = enemyRace== Race.HUMAN ? VillageoisHumanPreset.getHumanVillageois(Side.ENEMY) 
					: VillageoisOrcPreset.getOrcVillageois(Side.ENEMY);
			villageois.put(villageois.size(), new VillageoisPosition(v2, x, y));
			break;
		case "Mine":
			Mine mine = MinePreset.getMine();
			mines.put(mines.size(), new MinePosition(mine, x, y));
			break;
		case "Muraille":
			Muraille muraille = MuraillePreset.getMuraille();
			murailles.put(murailles.size(), new MuraillePosition(muraille, x, y));
			break;
		case "Route":
			Route r = RoutePreset.getRoute();
			routes.put(routes.size(), new RoutePosition(r, x, y));
			break;
		}
	}

	private String configure(String configFile)
	{
		StringBuilder configBuilder = new StringBuilder();
		try {
			BufferedReader reader = new BufferedReader(new FileReader(configFile));
			
			String line = null;
			String lineSep = System.getProperty("line.separator");
			while( ( line = reader.readLine() ) != null ) {
				configBuilder .append( line );
				configBuilder .append(lineSep );
		    }
			reader.close();
		} catch (FileNotFoundException e) {
			System.err.println("JSON file not found");
		} catch (IOException e) {
			e.printStackTrace();
		}
		return configBuilder.toString();
	}

	public Race getPlayerRace() {
		return playerRace;
	}

	@Override
	public Race getEnemyRace() {
		return enemyRace;
	}

	@Override
	public boolean estInitialise() {
		ArrayList<Integer> enemies = new ArrayList<>();
		ArrayList<Integer> players = new ArrayList<>();
		for(Integer i : getNumerosVillageois())
		{
			if(getVillageois(i).getSide() == Side.PLAYER)
			{
				players.add(i);
			}
			if(getVillageois(i).getSide() == Side.ENEMY)
			{
				enemies.add(i);
			}
		}
		return getHotelVille(Side.PLAYER) !=null && getHotelVille(Side.ENEMY) !=null 
				&& getNumerosMines().size() >= 3 && enemies.size() >= 3 && players.size() >= 3;
	}
}

