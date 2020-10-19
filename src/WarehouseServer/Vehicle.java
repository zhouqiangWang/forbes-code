import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * A named vehicle with a sequence of pings.
 */
final class Vehicle {

  private final String name;
  private final List<Ping> pings;

  Vehicle(String name) {
    this.name = name;
    this.pings = new ArrayList<Ping>();
  }

  /**
   * Determines the total distance covered by the pings.
   */
  static double getTotalDistance(List<Ping> pings) {
    // if pings contains less 2 Pings, return 0, the Vehicle does not move.
      if (pings.size() < 2) {
          return 0.0;
      }
    return Position
        .getDistance(pings.get(pings.size() - 1).getPosition(), pings.get(0).getPosition());
  }

  /**
   * The name of the vehicle.
   */
  String getName() {
    return this.name;
  }

  /**
   * The pings for the vehicle, in chronological order (earliest first).
   */
  List<Ping> getPings() {
    return this.pings;
  }

  public String toString() {
    return this.name + ": " + this.pings;
  }

  /**
   * Determines the total distance traveled by the vehicle.
   */
  double getTotalDistance() {
    return getTotalDistance(this.pings);
  }

  /**
   * Determines the average speed of the vehicle.
   */
  double getAverageSpeed() {
    return getTotalDistance() / ((pings.get(pings.size() - 1).getTimestamp() - pings.get(0)
        .getTimestamp()));
  }

  /**
   * Return the traveled distance since the give timestamp.
   *
   * @param timestamp the starting timestamp, including.
   * @return traveled distance.
   */
  double getTraveledSince(long timestamp) {
      if (pings.size() < 2) return 0.0;
      // binary search, O(logN), N = pings.length().
    int idx = Collections.binarySearch(pings, new Ping(0, 0, timestamp),
        (p1, p2) -> (int) (p1.getTimestamp() - p2.getTimestamp()));

    Position lastPos = pings.get(pings.size() - 1).getPosition();

    if (idx >= 0) {
      // find exactly math.
        return Position
            .getDistance(lastPos, pings.get(idx).getPosition());
    }

    // not find the exactly math.
    int insPos = -idx - 1;
    if (insPos == 0) {
      return getTotalDistance();
    }
    if (insPos >= pings.size()) {
      return 0.0;
    }

    Ping prev = pings.get(insPos - 1);
    Ping next = pings.get(insPos);

    // use the most closed ping as the start position.
    if ((timestamp - next.getTimestamp()) <= (timestamp - prev.getTimestamp())) {
      return Position.getDistance(lastPos, next.getPosition());
    } else {
      return Position.getDistance(lastPos, prev.getPosition());
    }
  }
}
