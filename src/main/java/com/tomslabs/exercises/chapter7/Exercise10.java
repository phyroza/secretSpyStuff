package com.tomslabs.exercises.chapter7;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Set;

public class Exercise10 {
    private record Neighbour(String name, Double distance) {
    }

    static HashMap<String, Set<Neighbour>> roadNetwork = new HashMap<>(Map.of(
            "Krakow", Set.of(new Neighbour("Warsaw", 300.0), new Neighbour("Katowice", 100.0), new Neighbour("Rzeszow", 200.0), new Neighbour("Zakopane", 100.0), new Neighbour("Lodz", 270.0)),
            "Warsaw", Set.of(new Neighbour("Krakow", 300.0), new Neighbour("Lodz", 100.0), new Neighbour("Gdansk", 350.0), new Neighbour("Radom", 100.0)),
            "Katowice", Set.of(new Neighbour("Krakow", 100.0), new Neighbour("Lodz", 250.0), new Neighbour("Wroclaw", 200.0), new Neighbour("Zakopane", 150.0)),
            "Rzeszow", Set.of(new Neighbour("Krakow", 200.0), new Neighbour("Lodz", 250.0), new Neighbour("Zakopane", 150.0), new Neighbour("Radom", 200.0)),
            "Radom", Set.of(new Neighbour("Krakow", 150.0), new Neighbour("Lodz", 200.0), new Neighbour("Rzeszow", 200.0)),
            "Zakopane", Set.of(new Neighbour("Krakow", 100.0), new Neighbour("Katowice", 150.0), new Neighbour("Rzeszow", 150.0)),
            "Wroclaw", Set.of(new Neighbour("Katowice", 200.0), new Neighbour("Lodz", 200.0)),
            "Lodz", Set.of(new Neighbour("Katowice", 250.0), new Neighbour("Wroclaw", 200.0), new Neighbour("Radom", 200.0), new Neighbour("Warsaw", 100.0), new Neighbour("Gdansk", 300.0), new Neighbour("Rzeszow", 320.0), new Neighbour("Krakow", 270.0)),
            "Gdansk", Set.of(new Neighbour("Warsaw", 350.0), new Neighbour("Lodz", 300.0))
    ));

    public static void main(String[] args) {
        // Zakopane -> Gdansk
        String startingCity = "Zakopane";

        if (roadNetwork.containsKey(startingCity)) {
            HashMap<String, List<String>> shortestPathTable = new HashMap<>();
            HashMap<String, Double> distanceTable = new HashMap<>();
            for (String city : roadNetwork.keySet()) {
                distanceTable.put(city, city.equals(startingCity) ? 0 : Double.MAX_VALUE);
                shortestPathTable.put(city, new ArrayList<>(List.of(city)));
            }

            PriorityQueue<String> queue = new PriorityQueue<>((city1, city2) -> {
                if (distanceTable.get(city1) > distanceTable.get(city2))
                    return 1;
                else if (distanceTable.get(city1) == distanceTable.get(city2)) {
                    return 0;
                } else {
                    return -1;
                }
            });
            queue.addAll(roadNetwork.keySet());

            while (!queue.isEmpty()) {
                String nearestCity = queue.remove();
                Set<Neighbour> neighbours = roadNetwork.get(nearestCity);
                for (Neighbour neighbour : neighbours) {
                    if (distanceTable.get(nearestCity) + neighbour.distance() < distanceTable.get(neighbour.name)) {
                        distanceTable.put(neighbour.name, distanceTable.get(nearestCity) + neighbour.distance());
                        shortestPathTable.compute(neighbour.name, (k, v) -> {
                            v.clear();
                            v.addAll(shortestPathTable.get(nearestCity));
                            v.add(k);
                            return v;
                        });
                    }
                }
            }

            for (String destCity : roadNetwork.keySet()) {
                printRouteAndDistance(startingCity, destCity, shortestPathTable, distanceTable);
            }

        }
    }

    private static void printRouteAndDistance(String startingCity, String destinationCity, HashMap<String, List<String>> shortestPathTable, HashMap<String, Double> distanceTable) {
        System.out.println("Shortest path to " + destinationCity + " from " + startingCity + ": "
                + shortestPathTable.get(destinationCity) + " " + distanceTable.get(destinationCity) + " km.");
    }
}
