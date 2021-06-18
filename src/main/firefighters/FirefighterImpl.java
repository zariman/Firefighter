package main.firefighters;

import main.api.CityNode;
import main.api.Firefighter;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;

public class FirefighterImpl implements Firefighter {

  private CityNode location = new CityNode(0, 0);
  private int distanceTraveled = 0;

  @Override
  public CityNode getLocation() {
    // TODO
    return location;
  }

  public void setLocation(CityNode cityNode) {
    this.location = cityNode;
  }

  @Override
  public int distanceTraveled() {
    // TODO
    return distanceTraveled;
  }

  public void setDistanceTraveled(int distance){
    this.distanceTraveled = distance;
  }
}
