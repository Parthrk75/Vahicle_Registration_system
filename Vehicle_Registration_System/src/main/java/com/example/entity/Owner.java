package com.example.entity;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
public class Owner {

	    @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private Long id;
	    private String name;
	    private String email;
	    private String address;
	    
	    @OneToMany(mappedBy = "owner",cascade = CascadeType.ALL)
	    private List<Vehicle> vehicles = new ArrayList<>();

		public Owner() {
			super();
			// TODO Auto-generated constructor stub
		}

		public Owner(Long id, String name, String email, String address, List<Vehicle> vehicles) {
			super();
			this.id = id;
			this.name = name;
			this.email = email;
			this.address = address;
			this.vehicles = vehicles;
		}

		public Owner(String name, String email, String address, List<Vehicle> vehicles) {
			super();
			this.name = name;
			this.email = email;
			this.address = address;
			this.vehicles = vehicles;
		}

		public Long getId() {
			return id;
		}

		public void setId(Long id) {
			this.id = id;
		}

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

		public String getEmail() {
			return email;
		}

		public void setEmail(String email) {
			this.email = email;
		}

		public String getAddress() {
			return address;
		}

		public void setAddress(String address) {
			this.address = address;
		}

		public List<Vehicle> getVehicles() {
			return vehicles;
		}

		public void setVehicles(List<Vehicle> vehicles) {
			this.vehicles = vehicles;
		}

		@Override
		public String toString() {
			return "Owner [id=" + id + ", name=" + name + ", email=" + email + ", address=" + address + ", vehicles="
					+ vehicles + "]";
		}
	    
	    
}
