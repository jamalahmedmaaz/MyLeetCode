package ooad.parkinglot.parking;

import java.util.ArrayList;
import java.util.List;

public class ParkingLot {
    private String level;
    private List<ParkingSpace> parkingSpace = new ArrayList<>();

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    public List<ParkingSpace> getParkingSpace() {
        return parkingSpace;
    }

    public void setParkingSpace(List<ParkingSpace> parkingSpace) {
        this.parkingSpace = parkingSpace;
    }

    private int avaiableSlots() {
        return 0;
    }

    private int size() {
        return parkingSpace.size();
    }


}
