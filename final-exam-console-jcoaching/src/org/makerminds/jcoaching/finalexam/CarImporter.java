package org.makerminds.jcoaching.finalexam;

import java.util.ArrayList;
import java.util.List;

public class CarImporter {
	
	public List<Car> importToJavaObjects(String[] carListAsArray) {
		List<Car> carList = new ArrayList<Car>();
		for(String carAsString : carListAsArray) {
			String[] carAsArray = carAsString.split(",");
			
			int id = getIdFromArray(carAsArray);
			Manufacturer manufacturer= getManufacturerFromArray(carAsArray);
			String model = getModelFromArray(carAsArray);
			int horsePower = getHorsePowerFromArray(carAsArray);
			double price = getPriceFromArray(carAsArray);
			Color color = getColorFromArray(carAsArray);
			int mileage = getMileageFromArray(carAsArray);
			int productionYear = getManufacturerYearFromArray(carAsArray);
			FuelType fuelType = getFuelTypeFromArray(carAsArray);
			Transmission transmission = getTransmissionFromArray(carAsArray);
			
			Car car = new Car();
			car.setId(id);
			car.setManufacturer(manufacturer);
			car.setModel(model);
			car.setHorsePower(horsePower);
			car.setPrice(price);
			car.setColor(color);
			car.setMileage(mileage);
			car.setProductionYear(productionYear);
			car.setFuelType(fuelType);
			car.setTransmission(transmission);
			
			carList.add(car);
		}
		return carList;
	}
	
	private Transmission getTransmissionFromArray(String[] carAsArray) {
		return getTransmissionFromString(carAsArray[9]);
	}

	private FuelType getFuelTypeFromArray(String[] carAsArray) {
		return getFuelTypeFromString(carAsArray[8]);
	}

	private int getManufacturerYearFromArray(String[] carAsArray) {
		return Integer.parseInt(carAsArray[7]);
	}

	private int getMileageFromArray(String[] carAsArray) {
		return Integer.parseInt(carAsArray[6]);
	}
	
	private Color getColorFromArray(String[] carAsArray) {
		return getColorFromString(carAsArray[5]);
	}

	private double getPriceFromArray(String[] carAsArray) {
		return Double.parseDouble(carAsArray[4]);
	}

	private int getHorsePowerFromArray(String[] carAsArray) {
		return Integer.parseInt(carAsArray[3]);
	}

	private String getModelFromArray(String[] carAsArray) {
		return carAsArray[2];
	}

	private Manufacturer getManufacturerFromArray(String[] carLikeArray) {
		return getManufacturerFromString(carLikeArray[1]);
	}
	
	private int getIdFromArray(String[] carLikeArray) {
		return Integer.parseInt(carLikeArray[0]);
	}

	private Manufacturer getManufacturerFromString(String manufacturerLikeString) {
		for(Manufacturer Manufacturer : Manufacturer.values()) {
			if(Manufacturer.name().equals(manufacturerLikeString)) {
				return Manufacturer;
			}
		}
		
		throw new IllegalArgumentException("Car brand like String is not valid: " + manufacturerLikeString);
	}
	
	private Color getColorFromString(String colorLikeString) {
		for(Color color : Color.values()) {
			if(color.name().equals(colorLikeString)) {
				return color;
			}
		}
		
		throw new IllegalArgumentException("Car color like String is not valid: " + colorLikeString);
	}
	
	private FuelType getFuelTypeFromString(String fuelTypeLikeString) {
		for(FuelType fuel : FuelType.values()) {
			if(fuel.name().equals(fuelTypeLikeString)) {
				return fuel;
			}
		}
		
		throw new IllegalArgumentException("Car fuel like String is not valid: " + fuelTypeLikeString);
	}
	
	private Transmission getTransmissionFromString(String transmissionAsString) {
		for(Transmission transmission : Transmission.values()) {
			if(transmission.name().equals(transmissionAsString)) {
				return transmission;
			}
		}
		
		throw new IllegalArgumentException("Car transmission like String is not valid: " + transmissionAsString);
	}
}
