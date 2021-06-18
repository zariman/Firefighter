package main.firefighters;

import java.util.ArrayList;
import java.util.List;

import main.api.*;
import main.api.exceptions.NoFireFoundException;
import main.api.exceptions.NoFirefightersFoundException;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;

public class FireDispatchImpl implements FireDispatch {

  private City city;
  private List<Firefighter> firefighters;

  public FireDispatchImpl(City city) {
    this.city = city;
  }

  @Override
  public void setFirefighters(int numFirefighters) {
    firefighters = new ArrayList<>();

    for (int i = 0; i < numFirefighters; i++) {
      firefighters.add(new FirefighterImpl(city));
    }
  }

  @Override
  public List<Firefighter> getFirefighters() {
    return firefighters;
  }

  @Override
  public void dispatchFirefighers(CityNode... burningBuildings) {
    for(CityNode burningBuilding : burningBuildings) {
      try {
        // Dispatch firefighter to the burning building. Throws exception if no closest firefighter is found in the city
        Firefighter closestFireFighter = closestFireFighter(burningBuilding);
        closestFireFighter.setLocation(burningBuilding);

        // Extinguish fire at the burning building
        city.getBuilding(burningBuilding).extinguishFire();

      } catch(NoFireFoundException | NoFirefightersFoundException ex) {
        System.out.println(ex.getMessage());
      }
    }
  }

  // Finds the closest firefighter from the burning building
  private Firefighter closestFireFighter(CityNode burningBuilding) throws NoFirefightersFoundException {
    if(this.firefighters == null) {
      throw new NoFirefightersFoundException();
    }

    int min = Integer.MAX_VALUE;
    Firefighter closestFireFighter = null;

    for(Firefighter firefighter : firefighters) {
      int distance = distanceToFire(firefighter, burningBuilding);

      // Return first firefighter who is only 1 distance away since that is the minimum distance possible
      if(distance == 1) {
        firefighter.setDistanceTraveled(firefighter.distanceTraveled() + 1);
        return firefighter;
      }

      if(distance < min) {
        min = distance;
        closestFireFighter = firefighter;
      }
    }

    // Add distance traveled to the closest firefighter
    if(closestFireFighter == null) {
      throw new NoFirefightersFoundException();
    }

    closestFireFighter.setDistanceTraveled(closestFireFighter.distanceTraveled() + min);
    return closestFireFighter;
  }

  // Measures distance between two coordinates
  private int distanceToFire(Firefighter firefighter, CityNode burningBuilding) {
    return Math.abs(burningBuilding.getX() - firefighter.getLocation().getX()) +
            Math.abs(burningBuilding.getY() - firefighter.getLocation().getY());
  }
}
