package main.api;

import java.util.List;

public interface FireDispatch {

  /**
   * Hires a number of firefighters
   * @param numFirefighters
   */
  void setFirefighters(int numFirefighters);

  /**
   * Get the list of firefighters
   * @return
   */
  List<Firefighter> getFirefighters();

  /**
   * The FireDispatch will be notified of burning buildings via this method. It will then dispatch the
   * firefighters and extinguish the fires. We want to optimize for total distance traveled by all firefighters
   * @param burningBuildings list of locations with burning buildings
   */
  void dispatchFirefighers(CityNode... burningBuildings);
}
