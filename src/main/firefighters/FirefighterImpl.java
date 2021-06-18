package main.firefighters;

import main.api.City;
import main.api.CityNode;
import main.api.Firefighter;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;

public class FirefighterImpl implements Firefighter {

  private CityNode location;
  private int distanceTraveled = 0;

  public FirefighterImpl(City city) {
    this.location = city.getFireStation().getLocation();
  }

  @Override
  public CityNode getLocation() {
    return location;
  }

  public void setLocation(CityNode cityNode) {
    this.location = cityNode;
  }

  @Override
  public int distanceTraveled() {
    return distanceTraveled;
  }

  public void setDistanceTraveled(int distance){
    this.distanceTraveled = distance;
  }
}
