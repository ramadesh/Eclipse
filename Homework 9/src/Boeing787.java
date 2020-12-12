public class Boeing787 implements Vehicle {
	@Override
    public String getName() {
        return "Boeing 787 Dreamliner";
    }
    @Override
    public String getManufacturer()
    {
	    return "Boeing";
    }
   	@Override
    public String getModeOfTransport() {
        return "Airplane";
    }
    @Override
    public double getAveragePrice() {
        return 380;
    }
    @Override
    public int getMaxSpeed() {
        return 776;
    }
}
