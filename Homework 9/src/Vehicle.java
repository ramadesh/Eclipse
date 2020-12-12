public interface Vehicle {
    String getName();
    
    String getManufacturer();
    
    String getModeOfTransport();

    double getAveragePrice();

    int getMaxSpeed();

    /**
     * Compares the prices of two vehicles.
     * @param vehicle The second vehicle to compare with
     * @return 1, if this vehicle is more expensive than the given vehicle, -1 if this vehicle is less expensive than the given vehicle and
     *         0, if the vehicles have the same price.
     */
    public default int comparePrice(Vehicle vehicle) {
        if (this.getAveragePrice() > vehicle.getAveragePrice()) {
            return 1;
        }
        else if (this.getAveragePrice() < vehicle.getAveragePrice()) {
            return -1;
        }
        else {
            return 0;
        }
        
    }
}
