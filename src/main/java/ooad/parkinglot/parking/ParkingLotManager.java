package ooad.parkinglot.parking;

import ooad.parkinglot.enums.VehicleType;
import ooad.parkinglot.vehicles.Bike;
import ooad.parkinglot.vehicles.Vehicle;

import java.util.ArrayList;
import java.util.List;

public class ParkingLotManager {

    private List<ParkingLot> parkingLots = new ArrayList<>();

    public static void main(String[] args) {
        ParkingLotManager parkingLotManager = new ParkingLotManager();

        /**
         * Initialize
         */
        int numberOfLevels = 2;
        int numberOfSlotsPerLevel = 100;
        parkingLotManager.instantiate(numberOfLevels, numberOfSlotsPerLevel);

        /**
         * occupy a slot
         */

        Vehicle vehicle = new Bike();

        if (parkingLotManager.checkAvailability(vehicle.getVehicleType())) {
            parkingLotManager.occupy(vehicle);
        }

    }

    private void instantiate(int numberOfLevels, int numberOfSlotsPerLevel) {
        ParkingLot parkingLot = new ParkingLot();
        for (int i = 0; i < numberOfLevels; i++) {
            parkingLot.setLevel("" + i);
            List<ParkingSpace> parkingSpaceList = new ArrayList<>(numberOfLevels);
            for (int i1 = 0; i1 < numberOfSlotsPerLevel; i1++) {
                parkingSpaceList.add(ParkingSpaceFactory.createParkingSpace("level" + i + "-slotnumber" + i1, 100, 100));
            }
            parkingLot.setParkingSpace(parkingSpaceList);
        }
        parkingLots.add(parkingLot);


    }

    private boolean checkAvailability(VehicleType vehicleType) {

        switch (vehicleType) {
            case CAR:
                break;
            case BIKE:
                return ParkingManagerUtils.checkAvailableSlot(parkingLots, vehicleType);
            case BUS:
                break;
        }
        return true;
    }

    private void occupy(Vehicle vehicle) {
        /**
         * Code for occupying space for vehicle
         */


    }

    private double chargeCustomer(Vehicle vehicle) {
        /**
         * code for charging customer based on time;
         */
        return 0.0;
    }
}
