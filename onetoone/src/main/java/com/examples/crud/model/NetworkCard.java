package com.examples.crud.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="network_card")
public class NetworkCard {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="network_card_id")
	private long id;
	
	private String brand;
	
	private String model;
	
	@Column(name="mac_address")
	private String macAddress;
	
//--------------------------------------------------------------
	@OneToOne(mappedBy="networkCard", fetch=FetchType.LAZY)
	private Computer computer;
//--------------------------------------------------------------
	
	public NetworkCard() {
		// TODO Auto-generated constructor stub
	}

	public NetworkCard(String brand, String model, String macAddress) {
		this.brand=brand;
		this.model=model;
		this.macAddress=macAddress;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}
	
	public String getMacAddress() {
		return macAddress;
	}

	public void setMacAddress(String macAddress) {
		this.macAddress = macAddress;
	}

	public Computer getComputer() {
		return computer;
	}

	public void setComputer(Computer computer) {
		this.computer = computer;
	}

	@Override
	public String toString() {
		return "NetworkCard [id=" + id + ", brand=" + brand + ", model=" + model + ", macAddress=" + macAddress
				+ "]";
	}
	
}
