package fa.training.entities;

import java.util.ArrayList;
import java.util.List;

public class Airport {
    private String id;
    private String name;
    private double runwaySize;
    private int maxFixedwingParkingPlace;
    private List<String> fixedwingIDs;
    private int maxRotatedwingParkingPlace;
    private List<String> helicopterIDs;

    public Airport(String id, String name, double runwaySize, int maxFixedwingParkingPlace, int maxRotatedwingParkingPlace) {
        this.id = id;
        this.name = name;
        this.runwaySize = runwaySize;
        this.maxFixedwingParkingPlace = maxFixedwingParkingPlace;
        this.maxRotatedwingParkingPlace = maxRotatedwingParkingPlace;
        this.fixedwingIDs = new ArrayList<>();
        this.helicopterIDs = new ArrayList<>();
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public double getRunwaySize() {
        return runwaySize;
    }

    public int getMaxFixedwingParkingPlace() {
        return maxFixedwingParkingPlace;
    }

    public List<String> getFixedwingIDs() {
        return fixedwingIDs;
    }

    public int getMaxRotatedwingParkingPlace() {
        return maxRotatedwingParkingPlace;
    }

    public List<String> getHelicopterIDs() {
        return helicopterIDs;
    }
}
