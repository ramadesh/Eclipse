public class FordMustang implements Vehicle {
	@Override
    public String getName() {
        return "Ford Mustang";
    }
    @Override
    public String getManufacturer() {
        return "Ford";
    }
    @Override
    public String getModeOfTransport() {
        return "Car";
    }
    @Override
    public double getAveragePrice() {
        return 26000;
    }
    @Override
    public int getMaxSpeed() {
        return 155;
    }
}
