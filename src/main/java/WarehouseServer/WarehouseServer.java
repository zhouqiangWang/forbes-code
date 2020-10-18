import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Set;

final class WarehouseServer {

  // vehicles is a list of vehicle instances
  private List<Vehicle> vehicles;

  WarehouseServer() {
    vehicles = new ArrayList<Vehicle>();
  }

  /**
   * Returns a Map from vehicle name to that vehicle's average speed for all vehicles.
   */
  Map<String, Double> getAverageSpeeds() {
    Map<String, Double> avgSpeeds = new HashMap<>();
    for (Vehicle vehicle : this.vehicles) {
      avgSpeeds.put(vehicle.getName(), vehicle.getAverageSpeed());
    }
    return avgSpeeds;
  }

  /**
   * Returns a sorted array of size max_results of vehicle names corresponding to the vehicles that
   * have traveled the most distance since the given timestamp.
   */
  String[] getMostTraveledSince(int maxResult, long timestamp) {
    String[] res = new String[maxResult];

    Map<String, Double> traveledMap = new HashMap<>();
    // runtime: (N*MlogM), N = number of vehicles. M = number of pings for the vehicle.
    for (Vehicle vehicle : this.vehicles) {
      traveledMap.put(vehicle.getName(), vehicle.getTraveledSince(timestamp));
    }
    // runtime: O(NlogN), N = number of vehicles.
    PriorityQueue<Map.Entry<String, Double>> maxHeap = new PriorityQueue<>(
        (e1, e2) -> (int) (e2.getValue() - e1.getValue()));
    maxHeap.addAll(traveledMap.entrySet());
    for (int i = 0; i < maxResult && !maxHeap.isEmpty(); i++) {
        res[i] = maxHeap.poll().getKey();
    }
    return res;
  }

  /**
   * Returns an array of names identifying vehicles that might have been damaged through any number
   * of risky behaviors, including collision with another vehicle and excessive acceleration.
   */
  String[] checkForDamage() {
    Set<Long> times = new HashSet<>();
    // 1. get all possible timestamps.
    for (Vehicle vehicle : this.vehicles) {
        vehicle.getPings().forEach(t -> times.add(t.getTimestamp()));
    }
    // 2. for each timestamp find all vehicles pos. If there are 2 position equal, add these 2 vihecle into the final result.

      // detect excessive acceleration.
      // calculate all the speed in every 2 pings. if the speed acceleration > threshold, add into final result.

    return new String[0];
  }

  void initializeServer(String fileName) {
    String line = null;
    try {
      FileReader fileReader = new FileReader(fileName);
      BufferedReader bufferedReader = new BufferedReader(fileReader);

      while ((line = bufferedReader.readLine()) != null) {
        String[] parsedLine = line.split(",");
        processPing(
            parsedLine[0],
            Double.parseDouble(parsedLine[1]),
            Double.parseDouble(parsedLine[2]),
            Integer.parseInt(parsedLine[3]));
      }

      bufferedReader.close();
    } catch (IOException ioException) {
      System.out.println("Exception thrown populating data: " + ioException);
    }
  }

  private void processPing(String vehicleName, double x, double y, long timestamp) {
    Ping ping = new Ping(x, y, timestamp);
    if (vehicles.isEmpty() || !vehicles.get(vehicles.size() - 1).getName().equals(vehicleName)) {
      vehicles.add(new Vehicle(vehicleName));
    }
    vehicles.get(vehicles.size() - 1).getPings().add(ping);
  }
}
