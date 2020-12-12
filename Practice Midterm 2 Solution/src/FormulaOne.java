/**
 * [CS18000] Practice Midterm 2 Solution
 *
 * @author kedarabhyankar
 * @version 10/31/2020
 */
public class FormulaOne extends Thread implements Car {

    private String team;
    private String driver;
    private double speed;
    private long lapTime;

    public FormulaOne(String team, String driver, double speed, double trackLength) {
        this.team = team;
        this.driver = driver;
        this.speed = speed;
        this.lapTime = calculateLapTime(trackLength);
    }

    @Override
    public void printInfo() {
        System.out.println("Driver: " + this.driver);
        System.out.println("Team: " + this.team);
        System.out.printf("Speed: %.2f KPH%n", this.speed);
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

    public void setTeam(String team){
        this.team = team;
    }

    public String getTeam(){
        return this.team;
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
