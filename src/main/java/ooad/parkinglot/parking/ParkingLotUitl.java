package ooad.parkinglot.parking;

import java.util.List;

public class ParkingLotUitl {
    public static boolean checkAvailableSlot(List<ParkingSpace> parkingSpace) {
        for (ParkingSpace parkingSpace1 : parkingSpace) {
            if (!parkingSpace1.isOccupied()) {
                return true;
            }
        }
        return false;
    }
}
