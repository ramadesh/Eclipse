
public class Scooby implements Halloween {
	private String fullName;
	private double experienceLevel;
	private int age;
	
	public Scooby(double experienceLevel, int age)
	{
		this.experienceLevel = experienceLevel;
		this.age = age;
		this.fullName = "Scoobert Doo";
	}

	@Override
	public void printInfo() 
	{
		System.out.println("Scooby's Name: " + this.fullName);
		System.out.println("Age: " + this.age);
		System.out.printf("Experience Level: %0.2f", this.experienceLevel);
		System.out.println();
		System.out.printf("Speed: %0.2f MPH", calcSpeed());
		
	}
	@Override
	public void printName() 
	{
		System.out.println(this.fullName);
	}
	public double calcSpeed()
	{
		return this.experienceLevel * this.age;
	}
	public String getFullName()
	{
		return this.fullName;
		
	}
	public double getExperienceLevel()
	{
		return this.experienceLevel;
		
	}
	public int getAge()
	{
		return this.age;
		
	}
	public void setFullName(String fullName)
	{
		this.fullName = fullName;
	}
	public void setExperienceLevel(double experienceLevel)
	{
		this.experienceLevel = experienceLevel;
	}
	public void setAge(int age)
	{
		this.age = age;
	}
	
}
