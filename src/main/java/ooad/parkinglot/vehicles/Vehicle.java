package ooad.parkinglot.vehicles;

import ooad.parkinglot.enums.VehicleType;

public interface Vehicle {
    VehicleType getVehicleType();

    void setVehicleType(VehicleType vehicleType);
}
