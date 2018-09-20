package com.examples.crud.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="computer")
public class Computer {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="computer_id")
	private long id;
	
	private String brand;
	
	private String model;
	
	@Column(name="production_date")
	private Date productionDate;

//-----------------------------------------------
	@OneToOne
	@JoinColumn(name="network_card_id")
	private NetworkCard networkCard;
//-----------------------------------------------
	
	public Computer() {

	}

	public Computer(String brand, String model, Date productionDate, NetworkCard networkCar) {
		this.brand=brand;
		this.model=model;
		this.productionDate=productionDate;
		this.networkCard=networkCar;
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

	public Date getProductionDate() {
		return productionDate;
	}

	public void setProductionDate(Date productionDate) {
		this.productionDate = productionDate;
	}

	public NetworkCard getNetworkCard() {
		return networkCard;
	}

	public void setNetworkCard(NetworkCard networkCard) {
		this.networkCard = networkCard;
	}

	@Override
	public String toString() {
		return "Computer [id=" + id + ", brand=" + brand + ", model=" + model + ", productionDate=" + productionDate
				+ ", networkCard=" + networkCard + "]";
	}
	
}
