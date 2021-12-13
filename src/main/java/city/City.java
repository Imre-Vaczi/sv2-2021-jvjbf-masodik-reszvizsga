package city;

import java.util.ArrayList;
import java.util.List;

public class City {

    private String name;
    private long fullArea;
    private List<Building> buildings = new ArrayList<>();

    public City(String name, long fullArea) {
        this.name = name;
        this.fullArea = fullArea;
    }

    public String getName() {
        return name;
    }

    public long getFullArea() {
        return fullArea;
    }

    public Building findHighestBuildingInCity() {
        Building temp = buildings.get(0);
        for (Building item : buildings) {
            if (item.getLevels() > temp.getLevels()) {
                temp = item;
            }
        }
        return temp;
    }

    public List<Building> findBuildingsByStreet(String street) {
        List<Building> result = new ArrayList<>();
        for (Building item : buildings) {
            if (item.getAddress().equals(street)) {
                result.add(item);
            }
        }
        return result;
    }

    public boolean isThereBuildingWithMorePeopleThan(int numberOfPeople) {
        for (Building item : buildings) {
            if (item.calculateNumberOfPeopleCanFit() > numberOfPeople) {
                return true;
            }
        }
        return false;
    }
}
