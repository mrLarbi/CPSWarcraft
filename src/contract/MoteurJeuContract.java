package contract;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Set;

import services.HotelVille;
import services.MoteurJeu;
import tools.Commande;
import tools.Geometry;
import tools.Race;
import tools.Resultat;
import tools.Side;
import decorators.MoteurJeuDecorator;
import error.ContractError;
import error.ErrorHandler;
import error.InvariantError;
import error.PostConditionError;
import error.PreConditionError;

public class MoteurJeuContract extends MoteurJeuDecorator
{
	public MoteurJeuContract(MoteurJeu mj)
	{
		super(mj);
	}
	
	public void checkInvariants() throws InvariantError
	{
		if(super.getPasJeuCourant() < 0)
		{
			throw new InvariantError("getPasJeuCourant() < 0");
		}
		if(super.getPasJeuCourant() > super.getMaxPasJeu())
		{
			throw new InvariantError("getPasJeuCourant() > getMaxPasJeu()");
		}
		if(super.estFini() != (super.getPasJeuCourant() == super.getMaxPasJeu() 
					|| (super.getHotelVille(Side.PLAYER).getOrRestant() >= 1664) 
					|| (super.getHotelVille(Side.ENEMY).getOrRestant() >= 1664)))
		{
			throw new InvariantError("wrong min estFini()");
		}
		if(super.getResultatFinal() == Resultat.GAGNE)
		{
			if(!(super.getHotelVille(Side.PLAYER).getOrRestant() >= 1664 && super.getHotelVille(Side.ENEMY).getOrRestant() < 1664))
			{
				throw new InvariantError("!(super.getHotelVille(Side.PLAYER).getOrRestant() >= 1664 " +
						"&& super.getHotelVille(Side.ENEMY).getOrRestant() < 1664)");
			}
		}
		if(super.getResultatFinal() == Resultat.PERDU)
		{
			if(!(super.getHotelVille(Side.ENEMY).getOrRestant() >= 1664 && super.getHotelVille(Side.PLAYER).getOrRestant() < 1664))
			{
				throw new InvariantError("!(super.getHotelVille(Side.ENEMY).getOrRestant() >= 1664 " +
						"&& super.getHotelVille(Side.PLAYER).getOrRestant() < 1664)");
			}
		}
		if(super.getResultatFinal() == Resultat.EGALITE)
		{
			if(super.getResultatFinal() == Resultat.GAGNE || super.getResultatFinal() == Resultat.PERDU)
			{
				throw new InvariantError("super.getResultatFinal() == Resultat.GAGNE " +
						"|| super.getResultatFinal() == Resultat.PERDU");
			}
		}
		if(super.getHotelVille(Side.PLAYER).getOrRestant() >= 1664 
				&& super.getHotelVille(Side.ENEMY).getOrRestant() < 1664)
		{
			if(super.getResultatFinal() != Resultat.GAGNE)
			{
				throw new InvariantError("super.getResultatFinal() != Resultat.GAGNE");
			}
		}
		if(super.getHotelVille(Side.ENEMY).getOrRestant() >= 1664 
				&& super.getHotelVille(Side.PLAYER).getOrRestant() < 1664)
		{
			if(super.getResultatFinal() != Resultat.PERDU)
			{
				throw new InvariantError("super.getResultatFinal() != Resultat.PERDU");
			}
		}
		if(super.getResultatFinal() != Resultat.GAGNE && super.getResultatFinal() != Resultat.PERDU)
		{
			if(super.getResultatFinal() != Resultat.EGALITE)
			{
				throw new InvariantError("super.getResultatFinal() != Resultat.EGALITE");
			}
		}
		for(Integer vill : super.getNumerosVillageois())
		{
			for(Integer m : super.getNumerosMines())
			{
				if(super.peutEntrer(vill, m) != (Geometry.distance(super.getPositionVillageoisX(vill), super.getPositionVillageoisY(vill)
						, super.getPositionMineX(m), super.getPositionMineY(m)) <= 51))
				{
					throw new InvariantError("super.peutEntrer(vill, m) != " +
							"(Geometry.distance(getPositionVillageoisX(vill), getPositionVillageoisY(vill)"+
						", getPositionMineX(m), getPositionMineY(m)) <= 51)");
				}
			}
			HotelVille hp = (super.getVillageois(vill).getSide() == Side.PLAYER) 
					? super.getHotelVille(Side.PLAYER) : super.getHotelVille(Side.ENEMY);
			Side side = hp.getSide();
			if(super.peutEntrerHotelVille(vill) != Geometry.distance(super.getPositionVillageoisX(vill), super.getPositionVillageoisY(vill)
					, super.getPositionHotelVilleX(side), super.getPositionHotelVilleY(side)) <= 51)
			{
				throw new InvariantError("super.peutEntrerHotelVille(vill) " +
						"!= Geometry.distance(super.getPositionVillageoisX(vill), super.getPositionVillageoisY(vill)" +
					", super.getPositionHotelVilleX(side), super.getPositionHotelVilleY(side)) <= 51");
			}
		}
		ArrayList<Integer> enemies = new ArrayList<>();
		ArrayList<Integer> players = new ArrayList<>();
		for(Integer i : super.getNumerosVillageois())
		{
			if(super.getVillageois(i).getSide() == Side.PLAYER)
			{
				players.add(i);
			}
			if(super.getVillageois(i).getSide() == Side.ENEMY)
			{
				enemies.add(i);
			}
		}
		if(super.estInitialise() != (super.getHotelVille(Side.PLAYER) !=null && super.getHotelVille(Side.ENEMY) !=null 
				&& super.getNumerosMines().size() >= 3 && enemies.size() >= 3 && players.size() >= 3))
		{
			throw new InvariantError("min estInitialise");
		}
	}
	
	public void checkInitPre(int largeur, int hauteur, int maxPas, Race playerRace, Race enemyRace, String fileName) 
			throws PreConditionError
	{
		if(largeur < 600)
		{
			throw new PreConditionError("init : largeur < 600");
		}
		if(hauteur < 400)
		{
			throw new PreConditionError("init : hauteur < 400");
		}
		if(maxPas <= 0)
		{
			throw new PreConditionError("init : maxPas <= 0");
		}
		if(fileName.equals(""))
		{
			throw new PreConditionError("init : fileName empty string");
		}
	}
	
	public void checkInitPost(int largeur, int hauteur, int maxPas, Race playerRace, Race enemyRace) throws PostConditionError
	{
		if(largeur != super.getLargeurTerrain())
		{
			throw new PostConditionError("init : largeur != super.getLargeurTerrain()");
		}
		if(hauteur != super.getHauteurTerrain())
		{
			throw new PostConditionError("init : hauteur != super.getHauteurTerrain()");
		}
		if(maxPas != super.getMaxPasJeu())
		{
			throw new PostConditionError("init : maxPas != super.getMaxPasJeu()");
		}
		if(playerRace != super.getPlayerRace())
		{
			throw new PostConditionError("init : playerRace != super.getPlayerRace()");
		}
		if(enemyRace != super.getEnemyRace())
		{
			throw new PostConditionError("init : enemyRace != super.getEnemyRace()");
		}
		if(super.getResultatFinal() != Resultat.EGALITE)
		{
			throw new PostConditionError("init : super.getResultatFinal() != Resultat.EGALITE");
		}
		if(super.getPasJeuCourant() != 0)
		{
			throw new PostConditionError("init : super.getPasJeuCourant() != 0");
		}
	}
	
	public void init(int largeur, int hauteur, int maxPas, Race playerRace, Race enemyRace, String fileName)
	{
		try {
		   checkInvariants();
		   checkInitPre(largeur, hauteur, maxPas, playerRace, enemyRace, fileName);
		   super.init(largeur, hauteur, maxPas, playerRace, enemyRace, fileName);
		   checkInitPost(largeur, hauteur, maxPas, playerRace, enemyRace);
		   checkInvariants();
		} catch (ContractError e) {
		   ErrorHandler.printError(e);
		   throw e;
		}
	}
	
	public void checkPasJeuPre(Commande commande, int numVillageois, int argument) throws PreConditionError
	{
		if(super.estFini())
		{
			throw new PreConditionError("pasJeu : super.estFini()");
		}
		if(!super.getNumerosVillageois().contains(numVillageois))
		{
			throw new PreConditionError("pasJeu : !super.getNumerosVillageois().contains(numVillageois)");
		}
		switch(commande)
		{
		case DEPLACER:
			if(argument > 360 || argument < 0)
			{
				throw new PreConditionError("pasJeu : DEPLACER : arg > 360 || arg < 0");
			}
			break;
		case ENTRERHOTELVILLE:
			if(!super.peutEntrerHotelVille(numVillageois))
			{
				throw new PreConditionError("pasJeu : ENTRERHOTELVILLE : !super.peutEntrerHotelVille(numVillageois)");
			}
			break;
		case ENTRERMINE:
			if(!super.getNumerosMines().contains(argument) || !super.peutEntrer(numVillageois, argument))
			{
				throw new PreConditionError("pasJeu : ENTRERMINE: !super.getNumerosMines().contains(arg) " +
						"|| !super.peutEntrer(numVillageois, arg)");
			}
			break;
		case FRAPPERMURAILLE:
			if(!super.getNumerosMurailles().contains(argument) || !super.peutFrapperMuraille(numVillageois, argument))
			{
				throw new PreConditionError("pasJeu : FRAPPERMURAILLE: !super.getNumerosMurailles().contains(arg) " +
						"|| !super.peutEntrer(numVillageois, arg)");
			}
			break;
		case RIEN:
			break;
		default:
			break;
		}
	}
	
	public void pasJeu(Commande commande, int numVillageois, int argument)
	{
		try
		{
			checkInvariants();
			checkPasJeuPre(commande, numVillageois, argument);
			int prePasJeuCourant = super.getPasJeuCourant();
			HashMap<Integer, Integer> preVillageoisPV = new HashMap<>();
			HashMap<Integer, Integer> preVillageoisOr = new HashMap<>();
			HashMap<Integer, Integer> preVillageoisX = new HashMap<>();
			HashMap<Integer, Integer> preVillageoisY = new HashMap<>();
			Set<Integer> preNumVillageois = super.getNumerosVillageois();
			for(Integer i : preNumVillageois)
			{
				preVillageoisOr.put(i, super.getVillageois(i).getQuantiteOr());
				preVillageoisPV.put(i, super.getVillageois(i).getPointsDeVie());
				preVillageoisX.put(i, super.getPositionVillageoisX(i));
				preVillageoisY.put(i, super.getPositionVillageoisY(i));
			}
			
			HashMap<Integer, Integer> preMineOr= new HashMap<>();
			HashMap<Integer, Integer> preMineCompteur = new HashMap<>();
			Set<Integer> preNumMine = super.getNumerosMines();
			for(Integer i : preNumMine)
			{
				preMineOr.put(i, super.getMine(i).getOrRestant());
				preMineCompteur.put(i, super.getMine(i).getAbandonCompteur());
			}
			
			HashMap<Integer, Integer> preMuraillePv = new HashMap<>();
			Set<Integer> preNumMuraille = super.getNumerosMurailles();
			for(Integer i : preNumMuraille)
			{
				preMuraillePv.put(i, super.getMuraille(i).getPointsDeVie());
			}
			
			int prePlayerHotelVilleOr = super.getHotelVille(Side.PLAYER).getOrRestant();
			int preEnemyHotelVilleOr = super.getHotelVille(Side.ENEMY).getOrRestant();
			
			super.pasJeu(commande, numVillageois, argument);
			
			if(prePasJeuCourant + 1 != super.getPasJeuCourant())
			{
				throw new PostConditionError("prePasJeuCourant != super.getPasJeuCourant() + 1");
			}
			if(commande == Commande.ENTRERMINE){
				int preMineOrArgument = preMineOr.get(argument);
				int preVillageoisOrArgument = preVillageoisOr.get(numVillageois);
				preMineCompteur.remove(argument);
				preMineOr.remove(argument);
				for(Integer i : preMineCompteur.keySet())
				{
					if(preMineCompteur.get(i) != 51)
					{
						if(preMineCompteur.get(i) + 1 != super.getMine(i).getAbandonCompteur())
						{
							throw new PostConditionError("preMineCompteur.get(i) + 1 != super.getMine(i).getAbandonCompteur()");
						}
					}
				}
				if(super.getMine(argument).getAbandonCompteur() != 0)
				{
					throw new PostConditionError("super.getMine(argument).getAbandonCompteur() != 0");
				}
				if(preMineOrArgument < 10)
				{
					if(super.getMine(argument).getOrRestant() != 0)
					{
						throw new PostConditionError("super.getMine(argument).getOrRestant() != 0");
					}
					if(super.getVillageois(numVillageois).getQuantiteOr() != preVillageoisOrArgument + preMineOrArgument)
					{
						throw new PostConditionError("super.getVillageois(numVillageois).getQuantiteOr() != preVillageoisOrArgument + preMineOrArgument");
					}
				}
				else
				{
					if(super.getMine(argument).getOrRestant() != preMineOrArgument - 10)
					{
						throw new PostConditionError("super.getMine(argument).getOrRestant() != preMineOrArgument - 10");
					}
					if(super.getVillageois(numVillageois).getQuantiteOr() != preVillageoisOrArgument + 10)
					{
						throw new PostConditionError("super.getVillageois(numVillageois).getQuantiteOr() != preVillageoisOrArgument + preMineOrArgument");
					}
				}
				
			}
			if(commande != Commande.ENTRERMINE)
			{
				for(Integer i : preMineCompteur.keySet())
				{
					if(preMineCompteur.get(i) != 51)
					{
						if(preMineCompteur.get(i) + 1 != super.getMine(i).getAbandonCompteur())
						{
							throw new PostConditionError("preMineCompteur.get(i) + 1 != super.getMine(i).getAbandonCompteur()");
						}
					}
				}
			}
			if(commande == Commande.FRAPPERMURAILLE)
			{
				int prePvMurailleArgument = preMuraillePv.get(argument);
				preMuraillePv.remove(argument);
				for(Integer i : preMuraillePv.keySet())
				{
					if(super.getMuraille(i).getPointsDeVie() != preMuraillePv.get(i))
					{
						throw new PostConditionError("super.getMuraille(i).getPointsDeVie() != preMuraillePv.get(i)");
					}
				}
				if(super.getMuraille(argument).getPointsDeVie() != prePvMurailleArgument - super.getVillageois(numVillageois).getForce())
				{
					throw new PostConditionError("super.getMuraille(argument).getPointsDeVie() != prePvMurailleArgument " +
							"- super.getVillageois(numVillageois).getForce()");
				}
			}
			
			if(commande != Commande.FRAPPERMURAILLE)
			{
				for(Integer i : preMuraillePv.keySet())
				{
					if(super.getMuraille(i).getPointsDeVie() != preMuraillePv.get(i))
					{
						throw new PostConditionError("super.getMuraille(i).getPointsDeVie() != preMuraillePv.get(i)");
					}
				}
			}
			if(commande == Commande.ENTRERHOTELVILLE)
			{
				if(super.getHotelVille(Side.PLAYER).getOrRestant() != prePlayerHotelVilleOr + preVillageoisOr.get(numVillageois))
				{
					throw new PostConditionError("super.getHotelVille(Side.PLAYER).getOrRestant() != " +
							"prePlayerHotelVilleOr + preVillageoisOr.get(numVillageois)");
				}
				if(super.getVillageois(numVillageois).getQuantiteOr() != 0)
				{
					throw new PostConditionError("super.getVillageois(numVillageois).getQuantiteOr() != 0");
				}
			}
			if(commande != Commande.ENTRERHOTELVILLE)
			{
				if(super.getHotelVille(Side.PLAYER).getOrRestant() != prePlayerHotelVilleOr + preVillageoisOr.get(numVillageois))
				{
					throw new PostConditionError("super.getHotelVille(Side.PLAYER).getOrRestant() != " +
							"prePlayerHotelVilleOr + preVillageoisOr.get(numVillageois)");
				}
			}
			if(commande != Commande.ENTRERHOTELVILLE && commande != Commande.ENTRERMINE)
			{
				for(Integer i : preVillageoisOr.keySet())
				{
					if(super.getVillageois(numVillageois).getQuantiteOr() != preVillageoisOr.get(i))
					{
						throw new PostConditionError("super.getVillageois(numVillageois).getQuantiteOr() != preVillageoisOr.get(i)");
					}
					if(super.getVillageois(numVillageois).getPointsDeVie() != preVillageoisPV.get(i))
					{
						throw new PostConditionError("super.getVillageois(numVillageois).getPointsDeVie() != preVillageoisPV.get(i)");
					}
				}
			}
			checkInvariants();
		} catch (ContractError e)
		{
			ErrorHandler.printError(e);
			throw e;
		}
	}
}
