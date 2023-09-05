package org.makerminds.jcoaching.finalexam;

public class Car {
	
	private int id;
	private Manufacturer manufacturer;
	private String model;
	private int horsePower;
	private double price;
	private Color color;
	private int mileage;
	private int productionYear;
	private Transmission transmission;
	private FuelType fuelType;
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getHorsePower() {
		return horsePower;
	}
	
	public void setHorsePower(int horsePower) {
		this.horsePower = horsePower;
	}
	
	public String getModel() {
		return model;
	}

	public Manufacturer getManufacturer() {
		return manufacturer;
	}

	public void setManufacturer(Manufacturer marks) {
		this.manufacturer = marks;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public Color getColor() {
		return color;
	}

	public void setColor(Color ngjyra) {
		this.color = ngjyra;
	}

	public int getMileage() {
		return mileage;
	}

	public void setMileage(int mileage) {
		this.mileage = mileage;
	}

	public int getProductionYear() {
		return productionYear;
	}

	public void setProductionYear(int productionYear) {
		this.productionYear = productionYear;
	}

	public Transmission getTransmission() {
		return transmission;
	}

	public void setTransmission(Transmission broadcaster) {
		this.transmission = broadcaster;
	}

	public FuelType getFuelType() {
		return fuelType;
	}

	public void setFuelType(FuelType fuel) {
		this.fuelType = fuel;
	}
}
