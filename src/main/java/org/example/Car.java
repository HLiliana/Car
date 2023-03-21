package org.example;

/**
 * Car is a parent class.
 */
public abstract class Car implements Vehicle {
    int availableFuel;

    String chassisNumber;
    int fuelTankSize;
    String fuelType;
    int gear;
    double consumptionPer100km;
    int tireSize;
    double tireIncreaseConsumption;
    double numberOfKm;
    public Car (int availableFuel, String chassisNumber ){
        this.availableFuel = availableFuel;
        this.chassisNumber = chassisNumber;
    }
    /**
     * Method startEngine calls reset method and saves consumed fuel through fuelConsumed method.
     */
    public void startEngine() {
        System.out.println("Our car has started ");
        System.out.println("Fuel consumed is "+ fuelConsumed() );
        resetConsumption();
    }

    /**
     * Method stopEngine saves consumed fuel through fuelConsumed method
     */
    public void stopEngine() {
        System.out.println("Our car has stopped " + fuelConsumed());
    }
    /**
     * Method drive return how many km the car has been driven
     */
    @Override
    public double drive(double numberOfKm) {
        this.numberOfKm = numberOfKm;
        System.out.println("Km driven are: " + numberOfKm);
        return numberOfKm;
    }

    /**
     * Method getConsumptionPer100Km checks if we have the smallest consumption for 100 km,
     * through 2 conditions:
     * tire size 15 and
     * gear 1
     */
    public double getConsumptionPer100km() {
        if ( tireSize == 15 && shiftGear(gear)==1) {
            this.consumptionPer100km = consumptionPer100km;
            System.out.println("This is our smallest consumptionPer100km " + consumptionPer100km);
        }
        return 0;
    }

    /**
     * Method shiftGear return the gear in wich the car is driven
     * the gear is provided through parameter
     */
    public int shiftGear(int gear) {
        this.gear=gear;

        return gear;
    }

    /**
     * Method getAverageFuelConsumption should return the average of the fuel consumpition
     * for a number of km driven
     */
    public float getAverageFuelConsumption() {
        return (float) (((fuelTankSize - getAvailableFuel())/drive(284.5))*100);
//        float fuelConsumedPer100Km = car.getAverageFuelConsumption();
    }

    public void resetConsumption(){
        gear =1;
        drive(0);
        this.consumptionPer100km= consumptionPer100km;
        System.out.println("Consumption stats are reset: gear " + gear + ", number of km driven  "
                          + drive(0) + ", smallest consumption  " + consumptionPer100km);
    }

    /**
     * Method fuelConsumed return the fuel used in a trip
     */
    public double fuelConsumed(){
        double fuelConsumed = fuelTankSize - getAvailableFuel();
        return fuelConsumed;
    }

    /**
     * Method decreaseConsumption will return the decrease of consumptionPer100km with a percentage
     * if the gear will shift down
     */
    public double decreaseConsumption(){
        for (gear = 1; gear < 7; gear ++)
        {
            consumptionPer100km *= 0.5;
        }
        return consumptionPer100km;
    }

    /**
     * Method increaseConsumption will raze the consumptionPer100km
     * if the tire size will have increase in dimension
     * the increasePercentage will be provided
     */
    public double increaseConsumption (double increasePercentage) {
        tireIncreaseConsumption = ((consumptionPer100km * increasePercentage) / 100) + consumptionPer100km;
        return tireIncreaseConsumption;
    }

    public float getAvailableFuel() {
        return availableFuel;
    }
}
