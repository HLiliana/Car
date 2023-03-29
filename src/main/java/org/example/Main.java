package org.example;

import java.sql.SQLOutput;

/**
 * create an application based on the following requirements
 * All Vehicles (e.g Car, Bike, Horse, Boat, Plane) have the following behavior: // vehicle, car
 * they can be started, stopped and driven for a number of kilometers // start, stop, driven , number of km
 * <p>
 * Implement a hierarchy of Car classes where:
 * Car is a type of Vehicle
 * properties of a Car model which cannot change: fuelTankSize, // fuelTankSize
 * fuelType (PETROL, DIESEL, etc...),gears (max 6), consumptionPer100Km (e.g 4.7) // fuelType, gear, consumptionPer100km
 * properties that are configurable: availableFuel, tireSize (15, 16, 17, etc...) // availableFuel, tireSize
 * properties that are instance specific: chassisNumber // chassisNumber
 * consumptionPer100Km is the consumption of the car per 100 KM with
 * the smallest tire setting (15) in first gear // firstGear, smallestTire ??
 * <p>
 * Tasks:
 * during a start() and a stop() the car keeps track of the how much it has consumed // keeps track of how much it consumed
 * on every start() the consumption stats are reset // reset, stats
 * a car can be driven for N kms in different gears
 * implement the classes, abstract classes and interfaces according to the given information
 * create at least 2 car brands with 2 models for each // create
 * (e.g Volkswagen: VWGolf, VWPassat; Mercedes: CKlasse, SKlasse)
 * make sure each car has different consumption
 * e.g.
 * <p>
 * Some cars might have a decrease in consumption (x%, you decide the value) // decrease in consumption
 * every time they shift up and the same increase (x%) when they shift down // shift up, increase in consumption
 * Some cars might have an increase in consumption (x%, you decide the value) with larger tires // increase with larger tires.
 * e.g. (more difficult - optional)
 * <p>
 * Some cars might have a 10% decrease every time they shift up // decrease every time they shift up
 * Some cars might have an increase in consumption with larger tires // increase with larger tires
 */
public class Main {
    public static void main(String[] args) {
        //       Car car = new Car(); // this should not compile.

        //       Car car = new Dacia(27, "oiqe0934hkkadsn"); // this should not compile! If I want to create a Dacia car, I will need to create an instance of a Dacia model.

        Car car = new Logan(27, "DL12548"); // Logan can extend from Dacia, while Dacia extends from Car

        Car golf = new VW(54, "VW0101");
        Car polo = new VW(21, "VW0202");
        Car logan = new Dacia(48, "D0101");
        Car sandero = new Dacia(44, "DD0202");
        golf.consumptionPer100km = 5.5;
        golf.tireSize = 15;
        polo.consumptionPer100km = 5.4;
        polo.tireSize = 17;
        polo.gear = 1;
        polo.fuelTankSize = 50;
        logan.consumptionPer100km = 6.8;
        logan.tireSize = 16;
        sandero.consumptionPer100km = 6.3;
        sandero.tireSize = 15;
        if (golf.consumptionPer100km == polo.consumptionPer100km ||
                logan.consumptionPer100km == sandero.consumptionPer100km ||
                polo.consumptionPer100km == sandero.consumptionPer100km) {
            System.out.println("At leas 2 consumptions are equal, so we should stop the code");
        } else {

            polo.startEngine();

            car.shiftGear(1);

            car.drive(0.01); // drives 0.01 KMs

            car.shiftGear(2);

            car.drive(0.02);

            car.shiftGear(3);

            car.drive(0.5);

            car.shiftGear(4);

            car.drive(0.5);

            car.shiftGear(4);

            car.drive(0.5);

            car.shiftGear(5);

            car.drive(10);

            car.shiftGear(4);

            car.drive(0.5);

            car.shiftGear(3);

            car.drive(0.1);

            car.stopEngine();

            polo.stopEngine();

            if (polo.tireSize > 15) ;
            {
                System.out.println("New consumption  with bigger tires for Polo car is :"
                        + polo.increaseConsumption(8.2));
            }


            float availableFuel = car.getAvailableFuel();

            float fuelConsumedPer100Km = car.getAverageFuelConsumption();


            Vehicle vehicle = new VW(30, "VW0303"); // available fuel and chassis number

            vehicle.startEngine();

            vehicle.drive(1);

            vehicle.stopEngine();

            Car car1 = (Car) vehicle;

            float availableFuel1 = car1.getAvailableFuel();

            float fuelConsumedPer100Km1 = car1.getAverageFuelConsumption();
        }
    }
}
