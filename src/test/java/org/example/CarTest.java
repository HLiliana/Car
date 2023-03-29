package org.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CarTest {
    Car car = new Logan(48, "DL12563");
    int gear;

    @Test
    void startEngine() {
        car.startEngine();
        car.drive(124);
        assertEquals(124, 124);
        car.stopEngine();
        car.startEngine();
        assertEquals(0, car.numberOfKm);
    }

    @Test
    void stopEngine() {
        car.startEngine();
        car.drive(18);
        car.shiftGear(2);
        car.stopEngine();
        car.fuelTankSize = 68;
        assertEquals(20, car.fuelConsumed());

    }

}