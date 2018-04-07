package ooad.parkinglot.parking;

import ooad.parkinglot.enums.VehicleType;

import java.util.List;

public class ParkingManagerUtils {
    public static boolean checkAvailableSlot(List<ParkingLot> parkingLots, VehicleType vehicleType) {
        switch (vehicleType) {

            case CAR:
                break;
            case BIKE:
                return checkAvailableForBike(parkingLots);
            case BUS:
                break;
        }
        return false;
    }

    private static boolean checkAvailableForBike(List<ParkingLot> parkingLots) {
        boolean available = false;
        for (ParkingLot parkingLot : parkingLots) {
            available = available || ParkingLotUitl.checkAvailableSlot(parkingLot.getParkingSpace());
        }
        return false;
    }
}
