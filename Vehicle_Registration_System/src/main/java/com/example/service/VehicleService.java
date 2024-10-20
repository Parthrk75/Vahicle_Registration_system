package com.example.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.example.entity.Owner;
import com.example.entity.Vehicle;
import com.example.repository.VehicleRepository;

@Service
public class VehicleService {

    @Autowired
    private VehicleRepository vehicleRepository;

    @Autowired
    private OwnerService ownerService;

    public List<Vehicle> getAllVehicles(Long ownerId) {
        Owner owner = ownerService.getOwnerById(ownerId);
        return owner.getVehicles();
    }

    public Vehicle addVehicle(Long ownerId, Vehicle vehicle) {
        Owner owner = ownerService.getOwnerById(ownerId);
        vehicle.setOwner(owner);
        return vehicleRepository.save(vehicle);
    }

    public Vehicle updateVehicle(Long vehicleId, Vehicle vehicle) {
        Vehicle vehicleDetails = vehicleRepository.findById(vehicleId)
            .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Vehicle not found"));

        vehicleDetails.setLicensePlate(vehicle.getLicensePlate());
        vehicleDetails.setManufacturer(vehicle.getManufacturer());
        vehicleDetails.setModel(vehicle.getModel());
        vehicleDetails.setYear(vehicle.getYear());

        return vehicleRepository.save(vehicleDetails);
    }

    public void deleteVehicle(Long id) {
        Vehicle vehicle = vehicleRepository.findById(id)
            .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Vehicle not found"));
        vehicleRepository.delete(vehicle);
    }
}
