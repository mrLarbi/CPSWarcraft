package tools;

import services.HotelVille;

public class HotelVillePosition extends EntityPosition
{
	private HotelVille hotelVille;
	
	public HotelVillePosition(HotelVille h)
	{
		hotelVille = h;
	}
	
	public HotelVillePosition(HotelVille h, int x, int y)
	{
		super(x, y);
		hotelVille = h;
	}
	
	public HotelVille getHotelVille()
	{
		return hotelVille;
	}
}
