package com.example.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.example.entity.Owner;
import com.example.repository.OwnerRepository;

@Service
public class OwnerService {

    @Autowired
    private OwnerRepository ownerRepository;

    // Get all owners with pagination and sorting
    public Page<Owner> getAllOwner(int page, int size, String sortBy) {
        Pageable pageable = PageRequest.of(page, size, Sort.by(sortBy));
        return ownerRepository.findAll(pageable);
    }

    // Get an owner by ID, throws a NOT_FOUND exception if owner doesn't exist
    public Owner getOwnerById(Long id) {
        return ownerRepository.findById(id)
            .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Owner not found"));
    }

    // Add a new owner
    public Owner addOwner(Owner owner) {
        return ownerRepository.save(owner);
    }

    // Update an existing owner
    public Owner updateOwner(Long id, Owner owner) {
        // Fetch the existing owner or throw NOT_FOUND if it doesn't exist
        Owner existingOwner = ownerRepository.findById(id)
            .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Owner not found"));

        // Update the fields of the existing owner
        existingOwner.setName(owner.getName());
        existingOwner.setEmail(owner.getEmail());
        existingOwner.setAddress(owner.getAddress());

        // Save the updated owner back to the repository
        return ownerRepository.save(existingOwner);
    }

    // Delete an owner by ID
    public void deleteOwner(Long id) {
        Owner owner = ownerRepository.findById(id)
            .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Owner not found"));

        ownerRepository.delete(owner);
    }
}
