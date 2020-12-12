
public interface Polygon extends Shape
{
	double getLongestDiagonal();
	
	double getLongestSide();
	
	int getNumberOfDiagonals();
	
	int getNumberOfSides();
	
	boolean isRegularPolygon();
	
}
