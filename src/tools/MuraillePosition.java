package tools;

import services.Muraille;

public class MuraillePosition extends EntityPosition
{
	private Muraille muraille;
	
	public MuraillePosition(Muraille m)
	{
		muraille = m;
	}
	
	public MuraillePosition(Muraille m, int x, int y)
	{
		super(x, y);
		muraille = m;
	}
	
	public Muraille getMuraille()
	{
		return muraille;
	}
}
