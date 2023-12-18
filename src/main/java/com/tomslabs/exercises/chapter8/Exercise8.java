package com.tomslabs.exercises.javaImpatnient.chapter8;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Exercise8 {

    private static class Car {
        String manufacturer;
        String model;
        List<String> features;

        public Car(String name, String model, String... continents) {
            this.manufacturer = name;
            this.model = model;
            this.features = List.of(continents);
        }

        public String getManufacturer() {
            return manufacturer;
        }

        public String getModel() {
            return model;
        }

        public List<String> getFeatures() {
            return features;
        }
    }

    public static void main(String[] args) {
        List<Car> cars = List.of(
                new Car("BMW", "330i", "Heated steering", "ABS", "Automatic gearbox"),
                new Car("BMW", "130i", "M package", "Airbags", "Light alloys"),
                new Car("Fiat", "Panda", "ABS", "Extended warranty"),
                new Car("Dodge", "Towing package", "ABS", "Cruise Control"));

        Map<String, List<List<String>>> notFlatCollected = cars.stream().collect(Collectors.groupingBy(Car::getManufacturer, Collectors.mapping(c -> c.getFeatures(), Collectors.toList())));
        System.out.println("notFlatCollected = " + notFlatCollected);
        Map<String, List<String>> flatCollected = cars.stream().collect(Collectors.groupingBy(Car::getManufacturer, Collectors.flatMapping(c -> c.getFeatures().stream(), Collectors.toList())));
        System.out.println("flatCollected = " + flatCollected);
    }
}
