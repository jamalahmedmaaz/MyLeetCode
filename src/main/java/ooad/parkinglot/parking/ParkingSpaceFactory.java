package ooad.parkinglot.parking;

public class ParkingSpaceFactory {

    public static ParkingSpace createParkingSpace(String parkingSpaceNumber, int height, int width) {
        ParkingSpace parkingSpace = new ParkingSpace();
        parkingSpace.setParkingSpaceNumber(parkingSpaceNumber);
        parkingSpace.setDimensions(createDimension(height, width));
        parkingSpace.setOccupied(false);
        parkingSpace.setOccupiedTime(null);
        parkingSpace.setParkingSpaceNumber(null);
        return parkingSpace;
    }

    private static Dimensions createDimension(int height, int width) {
        Dimensions dimensions = new Dimensions();
        dimensions.setHeight(height);
        dimensions.setWidth(width);
        return dimensions;
    }
}
