
public class Monster implements Halloween {
	private String name;
	private double monsterPowerRating;
	private String deadOrAlive;
	
	public Monster(String name, double monsterPowerRating)
	{
		this.name = name;
		this.monsterPowerRating = monsterPowerRating;
		this.deadOrAlive = "Unknown";
	}
	
	public void printInfo() 
	{
		System.out.println("Name: " + this.name);
		System.out.printf("Power Rating: %0.2f", this.monsterPowerRating);
		System.out.println();
		System.out.println("Dead or Alive: " + this.deadOrAlive);
	}
	@Override
	public void printName() 
	{
		System.out.println(this.name);
	}
	public String getName()
	{
		return this.name;
	}
	public double getMonsterPowerRating()
	{
		return this.monsterPowerRating;
	}
	public String getDeadOrAlive()
	{
		return this.deadOrAlive;
	}
	public void setName(String name)
	{
		this.name = name;
	}
	public void setMonsterPowerRating(double monsterPowerRating)
	{
		this.monsterPowerRating = monsterPowerRating;
	}
	public void setDeadOrAlive(String deadOrAlive)
	{
		this.deadOrAlive = deadOrAlive;
	}
	
}
