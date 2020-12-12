
public class Rectangle extends Object implements Shape, Polygon
{
	private double breadth;
	private double length;
	
	public Rectangle(double length, double breadth)
	{
		this.length = length;
		this.breadth = breadth;
	}
	@Override
	public double getLongestDiagonal() {
		return Math.sqrt((Math.pow(length, 2)) + (Math.pow(breadth, 2)));
	}

	@Override
	public double getLongestSide() {
		if (this.length >= this.breadth)
		{
			return length;
		}
		else
		{
			return breadth;
		}
	}

	@Override
	public int getNumberOfDiagonals() {
		return 2;
	}

	@Override
	public int getNumberOfSides() {
		return 4;
	}

	@Override
	public boolean isRegularPolygon() {
		if (this.length == this.breadth)
		{
			return true;
		}
		else 
		{
			return false;
		}
	}

	@Override
	public double calculateArea() {
		return length * breadth;
	}

	@Override
	public double calculatePerimeter() {
		return (2 * this.length + this.breadth);
	}

	@Override
	public String getName() {
		return "Rectangle";
	}
	
}
