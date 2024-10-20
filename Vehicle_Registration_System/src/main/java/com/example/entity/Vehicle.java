package com.example.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
@Entity
public class Vehicle {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String licensePlate;
    private String model;
    private String manufacturer;
    private int year;
    
    @ManyToOne
    @JoinColumn(name = "owner_id")
    @JsonIgnore
    private Owner owner;

	public Vehicle() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Vehicle(Long id, String licensePlate, String model, String manufacturer, int year, Owner owner) {
		super();
		this.id = id;
		this.licensePlate = licensePlate;
		this.model = model;
		this.manufacturer = manufacturer;
		this.year = year;
		this.owner = owner;
	}

	public Vehicle(String licensePlate, String model, String manufacturer, int year, Owner owner) {
		super();
		this.licensePlate = licensePlate;
		this.model = model;
		this.manufacturer = manufacturer;
		this.year = year;
		this.owner = owner;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getLicensePlate() {
		return licensePlate;
	}

	public void setLicensePlate(String licensePlate) {
		this.licensePlate = licensePlate;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public String getManufacturer() {
		return manufacturer;
	}

	public void setManufacturer(String manufacturer) {
		this.manufacturer = manufacturer;
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	public Owner getOwner() {
		return owner;
	}

	public void setOwner(Owner owner) {
		this.owner = owner;
	}

	@Override
	public String toString() {
		return "Vehicle [id=" + id + ", licensePlate=" + licensePlate + ", model=" + model + ", manufacturer="
				+ manufacturer + ", year=" + year + ", owner=" + owner + "]";
	}
    
    
}
