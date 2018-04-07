package ooad.parkinglot.parking;

import ooad.parkinglot.vehicles.Vehicle;

import java.util.Date;

public class ParkingSpace {
    private String parkingSpaceNumber;
    private Dimensions dimensions;
    private boolean occupied;
    private Date occupiedTime;
    private Vehicle vehicle;

    public Vehicle getVehicle() {
        return vehicle;
    }

    public void setVehicle(Vehicle vehicle) {
        this.vehicle = vehicle;
    }

    public String getParkingSpaceNumber() {
        return parkingSpaceNumber;
    }

    public void setParkingSpaceNumber(String parkingSpaceNumber) {
        this.parkingSpaceNumber = parkingSpaceNumber;
    }

    public Dimensions getDimensions() {
        return dimensions;
    }

    public void setDimensions(Dimensions dimensions) {
        this.dimensions = dimensions;
    }

    public boolean isOccupied() {
        return occupied;
    }

    public void setOccupied(boolean occupied) {
        this.occupied = occupied;
    }

    public Date getOccupiedTime() {
        return occupiedTime;
    }

    public void setOccupiedTime(Date occupiedTime) {
        this.occupiedTime = occupiedTime;
    }
}
