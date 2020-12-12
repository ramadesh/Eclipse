
public class Nascar extends Thread implements Car {
	private String make;
	private String driver;
	private double speed;
	private long lapTime;
	
	public Nascar(String make, String driver, double speed, double trackLength)
	{
		this.make = make;
		this.driver = driver;
		this.speed = speed;
		this.lapTime = calculateLapTime(trackLength);	
	}

	@Override
	public void printInfo() {
		System.out.println("Driver: " + driver);
		System.out.println("Make: " + make);
		System.out.printf("Speed: %0.2f", speed);
		
	}

	@Override
	public long calculateLapTime(double trackLength) {
		return Double.valueOf((speed/trackLength)/60).longValue();
	}

	@Override
	public void setDriver(String driver) {
		this.driver = driver;
	}

	@Override
	public String getDriver() {
		return driver;
	}

	@Override
	public void setSpeed(double speed) {
		this.speed = speed;
		
	}

	@Override
	public double getSpeed() {
		return speed;
	}

	@Override
	public void setLapTime(long lapTime) {
		this.lapTime = lapTime;
	}

	@Override
	public long getLapTime() {
		return lapTime;
	}
	
	public void run()
	{
		try {
			Thread.sleep(lapTime * 1500);
			System.out.println(driver + " has finished!");
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
	}
	
	
	
}
