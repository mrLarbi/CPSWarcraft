package tools;

import services.Villageois;

public class VillageoisPosition extends EntityPosition
{
	private Villageois villageois;
	
	public VillageoisPosition(Villageois v)
	{
		villageois = v;
	}
	
	public VillageoisPosition(Villageois v, int x, int y)
	{
		super(x, y);
		villageois = v;
	}
	
	public Villageois getVillageois()
	{
		return villageois;
	}
}
