package tools;

import java.lang.Math;

public class Geometry
{
	public static double distance(int x1, int y1, int x2, int y2)
	{
		return Math.sqrt((x1-x2)*(x1-x2) + (y1-y2)*(y1-y2));
	}
	
	public static boolean isCollision(int x1, int y1, int largeur1, int hauteur1, int x2, int y2, int largeur2, int hauteur2) {
		return x1 == x2 && y1 == y2;
	}
}
