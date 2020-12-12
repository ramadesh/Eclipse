
public interface Shape {
	
	double calculateArea();
	
	double calculatePerimeter();
	
	default int compareArea(Shape shape)
	{
		if (this.calculateArea() > shape.calculateArea())
		{
			return 1;
		}
		else if (this.calculateArea() < shape.calculateArea())
		{
			return -1;
		}
		else
		{
			return 0;
		}
	}
	
	default int comparePerimeter(Shape shape)
	{
		if (this.calculatePerimeter() > shape.calculatePerimeter())
		{
			return 1;
		}
		else if (this.calculatePerimeter() < shape.calculatePerimeter())
		{
			return -1;
		}
		else
		{
			return 0;
		}
	}
	
	String getName();
}
