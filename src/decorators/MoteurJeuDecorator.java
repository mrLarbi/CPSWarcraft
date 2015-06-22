package decorators;

import services.MoteurJeu;
import services.Mine;
import services.Villageois;
import services.Route;
import services.Muraille;
import services.HotelVille;

import tools.Resultat;
import tools.Commande;
import tools.Side;
import tools.Race;

import java.util.Set;

public class MoteurJeuDecorator implements MoteurJeu
{
	private MoteurJeu moteurJeuDelegate;
	
	public MoteurJeuDecorator(MoteurJeu mj)
	{
		moteurJeuDelegate = mj;
	}
	
	public int getLargeurTerrain()
	{
		return moteurJeuDelegate.getLargeurTerrain();
	}

	public int getHauteurTerrain()
	{
		return moteurJeuDelegate.getHauteurTerrain();
	}

	public int getMaxPasJeu()
	{
		return moteurJeuDelegate.getMaxPasJeu();
	}

	public int getPasJeuCourant()
	{
		return moteurJeuDelegate.getPasJeuCourant();
	}

	public boolean estFini()
	{
		return moteurJeuDelegate.estFini();
	}

	public Resultat getResultatFinal()
	{
		return moteurJeuDelegate.getResultatFinal();
	}

	public Set<Integer> getNumerosVillageois()
	{
		return moteurJeuDelegate.getNumerosVillageois();
	}

	public Villageois getVillageois(int numVillageois)
	{
		return moteurJeuDelegate.getVillageois(numVillageois);
	}

	public int getPositionVillageoisX(int numVillageois)
	{
		return moteurJeuDelegate.getPositionVillageoisX(numVillageois);
	}

	public int getPositionVillageoisY(int numVillageois)
	{
		return moteurJeuDelegate.getPositionVillageoisY(numVillageois);
	}

	public Set<Integer> getNumerosMines()
	{
		return moteurJeuDelegate.getNumerosMines();
	}

	public Mine getMine(int numMine)
	{
		return moteurJeuDelegate.getMine(numMine);
	}

	public int getPositionMineX(int numMine)
	{
		return moteurJeuDelegate.getPositionMineX(numMine);
	}
	
	public int getPositionMineY(int numMine)
	{
		return moteurJeuDelegate.getPositionMineY(numMine);
	}

	
	public Set<Integer> getNumerosRoutes()
	{
		return moteurJeuDelegate.getNumerosRoutes();
	}

	public Route getRoute(int numRoute)
	{
		return moteurJeuDelegate.getRoute(numRoute);
	}

	public int getPositionRouteX(int numRoute)
	{
		return moteurJeuDelegate.getPositionRouteX(numRoute);
	}

	public int getPositionRouteY(int numRoute)
	{
		return moteurJeuDelegate.getPositionRouteY(numRoute);
	}
	
	public Set<Integer> getNumerosMurailles()
	{
		return moteurJeuDelegate.getNumerosMurailles();
	}

	public Muraille getMuraille(int numMuraille)
	{
		return moteurJeuDelegate.getMuraille(numMuraille);
	}

	public int getPositionMurailleX(int numMuraille)
	{
		return moteurJeuDelegate.getPositionMurailleX(numMuraille);
	}

	public int getPositionMurailleY(int numMuraille)
	{
		return moteurJeuDelegate.getPositionMurailleY(numMuraille);
	}

	public HotelVille getHotelVille(Side side)
	{
		return moteurJeuDelegate.getHotelVille(side);
	}

	public int getPositionHotelVilleX(Side side)
	{
		return moteurJeuDelegate.getPositionHotelVilleX(side);
	}

	public int getPositionHotelVilleY(Side side)
	{
		return moteurJeuDelegate.getPositionHotelVilleY(side);
	}

	public boolean peutEntrer(int numVillageois, int numMine)
	{
		return moteurJeuDelegate.peutEntrer(numVillageois, numMine);
	}

	@Override
	public boolean peutFrapperMuraille(int numVillageois, int numMuraille) {
		return moteurJeuDelegate.peutFrapperMuraille(numVillageois, numMuraille);
	}
	
	public boolean peutEntrerHotelVille(int numVillageois)
	{
		return moteurJeuDelegate.peutEntrerHotelVille(numVillageois);
	}
	
	@Override
	public Route estVillageoisDansRoute(int numVillageois) {
		return moteurJeuDelegate.estVillageoisDansRoute(numVillageois);
	}

	public void init(int largeur, int hauteur, int maxPas, Race playerRace, Race enemyRace, String fileName)
	{
		moteurJeuDelegate.init(largeur, hauteur, maxPas, playerRace, enemyRace, fileName);
	}

	public void pasJeu(Commande commande, int numVillageois, int argument)
	{
		moteurJeuDelegate.pasJeu(commande, numVillageois, argument);
	}

	@Override
	public Race getPlayerRace() {
		return moteurJeuDelegate.getPlayerRace();
	}

	@Override
	public Race getEnemyRace() {
		return moteurJeuDelegate.getEnemyRace();
	}

	@Override
	public boolean estInitialise() {
		return moteurJeuDelegate.estInitialise();
	}
	
}
