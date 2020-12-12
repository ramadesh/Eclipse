
public class Vampire extends Monster {
	private String favoriteDrink;
	private double transformationSpeed;
	
	public Vampire(String name, double monsterPowerRating, String favoriteDrink, double transformationSpeed)
	{
		super(name, monsterPowerRating);
		this.setDeadOrAlive("Alive");
		this.favoriteDrink = favoriteDrink;
		this.transformationSpeed = transformationSpeed;
	}
	@Override
	public void printInfo()
	{
		System.out.println("Monster: Vampire");
		System.out.println("Name: " + getName());
		System.out.printf("Power Rating: %0.2f", getMonsterPowerRating());
		System.out.println();
		System.out.println("Dead or Alive: " + getDeadOrAlive());
		System.out.println("Favorite Drink: " + this.favoriteDrink);
		System.out.printf("Flight Speed: %0.2f MPH", calcFlightSpeed());
	}
	public double calcFlightSpeed()
	{
		double speedy = (this.getMonsterPowerRating() * 5) - this.transformationSpeed;
		return speedy;
	}
	public String getFavoriteDrink()
	{
		return favoriteDrink;
		
	}
	public double getTransformationSpeed()
	{
		return transformationSpeed;
		
	}
	public void setFavoriteDrink(String favoriteDrink)
	{
		this.favoriteDrink = favoriteDrink;
	}
	public void setTransformationSpeed(double transformationSpeed)
	{
		this.transformationSpeed = transformationSpeed;
	}
	
}
