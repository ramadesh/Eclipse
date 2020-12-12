
public class Triangle extends Object implements Polygon {
	private double sides[];
	
	public Triangle(double side)
	{
		sides = new double [] {side, side, side};
	}
	
	public Triangle (double side1, double side2, double side3)
	{
		sides = new double []{side1, side2, side3};
	}

	@Override
	public double calculateArea() {
		// TODO Auto-generated method stub
		double s = (sides[0] + sides[1] + sides[2])/2;
		double area = Math.sqrt(s * (s - sides[0]) * (s - sides[1]) * (s - sides[2]));
		return area;
	}

	@Override
	public double calculatePerimeter() {
		// TODO Auto-generated method stub
		return sides[0] + sides[1] + sides[2];
	}

	@Override
	public String getName() {
		return "Triangle";
	}

	@Override
	public double getLongestDiagonal() {
		return 0;
	}

	@Override
	public double getLongestSide() {
		double longest = 0.0;
		for (int i = 0; i < sides.length; i++)
		{
			if(sides[i] > longest)
			{
				longest = sides[i];
			}
		}
		return longest;
	}

	@Override
	public int getNumberOfDiagonals() {
		return 0;
	}

	@Override
	public int getNumberOfSides() {
		return 3;
	}

	@Override
	public boolean isRegularPolygon() {
		if (sides[0] == sides[1] && sides[1] == sides[2])
		{
			return true;
		}
		else
		{
			return false;
		}
	}
}
