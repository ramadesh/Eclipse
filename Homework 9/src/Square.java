
public class Square extends Rectangle {
	private double side;
	
	public Square(double side) {
		super(side, side);
	}
	
	@Override
	public String getName()
	{
		return "Square";
	}
}
