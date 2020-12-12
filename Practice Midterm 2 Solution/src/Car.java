/**
 * [CS18000] Practice Midterm 2 Solution
 *
 * @author kedarabhyankar
 * @version 10/31/2020
 */
public interface Car {

    public void printInfo();
    public long calculateLapTime(double trackLength);
    public void setDriver(String driver);
    public String getDriver();
    public void setSpeed(double speed);
    public double getSpeed();
    public void setLapTime(long lapTime);
    public long getLapTime();
}
