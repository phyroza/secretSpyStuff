package com.tomslabs.exercises.chapter2;

public class Exercise10 {

    public static void main(String[] args) {
        Car toyCar = new Car("toyCar", 7.5, 57.5);
        toyCar.tankFuel(55);
        toyCar.printReadings();

        toyCar.driveCar(250);
        toyCar.printReadings();

        toyCar.driveCar(-350);
        toyCar.printReadings();

        toyCar.driveCar(-210);
        toyCar.printReadings();
    }

    private static class Car {
        String name;
        double posX;
        double odometer;
        double fuelConsumptionLitrePer100km;
        double fuelLevel;
        double fuelCapacity;

        public Car(String name, double fuelConsumptionLiterPer100km, double fuelCapacity) {
            this.name = name;
            this.fuelConsumptionLitrePer100km = fuelConsumptionLiterPer100km;
            this.fuelCapacity = fuelCapacity;
            this.posX = 0;
            this.fuelLevel = 0;
            this.odometer = 0;
        }

        void tankFuel(double fuelAmount) {
            if (fuelAmount > fuelCapacity - fuelLevel)
                throw new IllegalArgumentException("Tanking such amount would cause fuel tank overflow");
            System.out.println("Tanking " + fuelAmount + "l");
            fuelLevel += fuelAmount;
        }

        void driveCar(double kms) {
            double tripFuelLitres = (Math.abs(kms) / 100.0) * fuelConsumptionLitrePer100km;
            if (tripFuelLitres > fuelLevel) {
                throw new IllegalArgumentException("Not enough fuel to go that far " + kms + " kms." +
                        " Estimated fuel cost " + tripFuelLitres + "l current fuel level " + fuelLevel + "l.");
            }
            System.out.println(String.format("Gonna drive for %.2f KMs", kms));

            posX += kms;
            fuelLevel -= tripFuelLitres;
            odometer += Math.abs(kms);
        }

        void printReadings() {
            System.out.println("Position = " + posX);
            System.out.println("Fuel level = " + fuelLevel);
            System.out.println("Odometer = " + odometer);
        }
    }
}
