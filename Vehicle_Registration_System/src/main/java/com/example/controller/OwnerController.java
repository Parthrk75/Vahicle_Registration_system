package com.example.controller;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import com.example.entity.Owner;
import com.example.entity.Vehicle;
import com.example.service.OwnerService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;

@RestController
@RequestMapping("/owner")
public class OwnerController {

    @Autowired
    private OwnerService ownerService;

    @Operation(summary = "Get all owners with pagination and sorting")
    @GetMapping("/")
    public Page<Owner> getAllOwners(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size,
            @RequestParam(defaultValue = "name") String sortBy) {
        return ownerService.getAllOwner(page, size, sortBy);
    }

    @Operation(summary = "Get an owner by ID")
    @GetMapping("/{id}")
    public Owner getOwnerById(@Parameter(description = "ID of the owner to be fetched") @PathVariable Long id) {
        return ownerService.getOwnerById(id);
    }

    @Operation(summary = "Create a new owner")
    @PostMapping("/addowner")
    @ResponseStatus(HttpStatus.CREATED)
    public Owner addOwner(@Validated @RequestBody Owner owner) {
        return ownerService.addOwner(owner);
    }

    @Operation(summary = "Update an owner by ID")
    @PutMapping("/updateowner/{id}")
    public Owner updateOwner(@PathVariable Long id, @Validated @RequestBody Owner owner) {
        return ownerService.updateOwner(id, owner);
    }

    @Operation(summary = "Delete an owner by ID")
    @DeleteMapping("/delete/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteOwner(@PathVariable Long id) {
        ownerService.deleteOwner(id);
    }

    @Operation(summary = "Get all vehicles for a specific owner by owner ID")
    @GetMapping("/{id}/vehicles")
    public List<Vehicle> getVehiclesByOwner(@PathVariable Long id) {
        return ownerService.getOwnerById(id).getVehicles();
    }
}
