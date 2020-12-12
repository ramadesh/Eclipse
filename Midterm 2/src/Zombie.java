
public class Zombie extends Monster {
	private String favoriteFood;
	private double stamina;
	
	public Zombie(String name, double monsterPowerRating, double stamina)
	{
		super(name, monsterPowerRating);
		this.setDeadOrAlive("Dead");
		this.stamina = stamina;
		this.favoriteFood = "Caesar Salad";
	}
	@Override
	public void printInfo()
	{
		System.out.println("Monster: Zombie");
		System.out.println("Name: " + getName());
		System.out.printf("Power Rating: %0.2f", getMonsterPowerRating());
		System.out.println();
		System.out.println("Dead or Alive: " + getDeadOrAlive());
		System.out.println("Favorite Food: " + this.favoriteFood);
		System.out.printf("Speed: %0.2f MPH", calcRunSpeed());
	}
	public double calcRunSpeed()
	{
		return getMonsterPowerRating() * this.stamina;
		
	}
	public String getFavoriteFood()
	{
		return this.favoriteFood;
		
	}
	public double getStamina()
	{
		return this.stamina;
		
	}
	public void setFavoriteFood(String favoriteFood)
	{
		this.favoriteFood = favoriteFood;
	}
	public void setStamina(double stamina)
	{
		this.stamina = stamina;
	}
}
