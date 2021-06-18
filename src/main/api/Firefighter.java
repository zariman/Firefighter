package main.api;

public interface Firefighter {

  /**
   * Get the firefighter's current location. Initially, the firefighter should be at the FireStation
   *
   * @return {@link CityNode} representing the firefighter's current location
   */
  CityNode getLocation();

  /**
   * Set the firefighter's current location. Initially, the firefighter should be at the FireStation
   *
   */
  void setLocation(CityNode cityNode);

  /**
   * Get the total distance traveled by this firefighter. Distances should be represented using TaxiCab
   * Geometry: https://en.wikipedia.org/wiki/Taxicab_geometry
   *
   * @return the total distance traveled by this firefighter
   */
  int distanceTraveled();

  /**
   * Set the total distance traveled by this firefighter.
   *
   */
  void setDistanceTraveled(int distanceTraveled);
}
