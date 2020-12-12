public class AcelaExpress implements Vehicle {
	@Override
    public String getName() {
        return "Acela Express";
    }
	@Override
    public String getManufacturer() {
        return "Amtrak";
    }
	@Override
    public String getModeOfTransport()
    {
    	return "Train";
    }
	@Override
    public double getAveragePrice() {
        return 130;
    }
	@Override
    public int getMaxSpeed() {
        return 150;
    }
}
