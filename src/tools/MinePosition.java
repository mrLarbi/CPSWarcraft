package tools;

import services.Mine;

public class MinePosition extends EntityPosition
{
	private Mine mine;
	
	public MinePosition(Mine m)
	{
		mine = m;
	}
	
	public MinePosition(Mine m, int x, int y)
	{
		super(x, y);
		mine = m;
	}
	
	public Mine getMine()
	{
		return mine;
	}
}
