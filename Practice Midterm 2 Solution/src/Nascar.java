/**
 * [CS18000] Practice Midterm 2 Solution
 *
 * @author kedarabhyankar
 * @version 10/31/2020
 */
public class Nascar extends Thread implements Car {

    private String make;
    private String driver;
    private double speed;
    private long lapTime;

    public Nascar(String make, String driver, double speed, double trackLength) {
        this.make = make;
        this.driver = driver;
        this.speed = speed;
        this.lapTime = calculateLapTime(trackLength);
    }

    @Override
    public void printInfo() {
        System.out.println("Driver: " + this.driver);
        System.out.println("Make: " + this.make);
        System.out.printf("Speed: %.2f MPH%n", this.speed);
    }

    @Override
    public long calculateLapTime(double trackLength) {
        return Double.valueOf((this.speed / trackLength) / 60).longValue();
    }

    @Override
    public void setDriver(String driver) {
        this.driver = driver;
    }

    @Override
    public String getDriver() {
        return this.driver;
    }

    @Override
    public void setSpeed(double speed) {
        this.speed = speed;
    }

    @Override
    public double getSpeed() {
        return this.speed;
    }

    @Override
    public void setLapTime(long lapTime) {
        this.lapTime = lapTime;
    }

    @Override
    public long getLapTime() {
        return this.lapTime;
    }

    public void setMake(String make) {
        this.make = make;
    }

    public String getMake() {
        return this.make;
    }

    @Override
    public void run() {
        long waitTime = this.lapTime * 1500;
        try {
            Thread.sleep(waitTime);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(this.driver + " has finished!");
    }
}
