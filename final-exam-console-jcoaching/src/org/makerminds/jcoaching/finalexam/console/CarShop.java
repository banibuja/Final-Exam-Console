package org.makerminds.jcoaching.finalexam.console;

import java.util.List;
import java.util.Scanner;

import org.makerminds.jcoaching.finalexam.Car;
import org.makerminds.jcoaching.finalexam.CarFileManager;
import org.makerminds.jcoaching.finalexam.CarImporter;
import org.makerminds.jcoaching.finalexam.CarShopProcessor;

public class CarShop {

	private static CarImporter carImporter = new CarImporter();
    private static final String CAR_LIST_PATH = "carList.txt"; 

	public static void main(String[] args) {
		
		CarFileManager carFileManager = new CarFileManager(CAR_LIST_PATH);
		String[] carListAsArray = carFileManager.importCarsFromFile();
		List<Car> carList = carImporter.importToJavaObjects(carListAsArray);
		
		displayCars(carList);
		Scanner scanner = new Scanner(System.in);
		System.out.println("\n\nPlease enter the number (ID) of the car you want to buy: ");
		int carChosenId = scanner.nextInt();
		 
		CarShopProcessor carShopProcessor = new CarShopProcessor();
		carShopProcessor.sellCars(carList, carChosenId);
		
		carFileManager.rewriteFile(carList);
		
		System.out.println("\n" + "Car with ID " + carChosenId + " was sold.");
		displayCars(carList);
		scanner.close();
	}
	
	public static void displayCars(List<Car> carList){
		StringBuffer header = prepareCarsHeaderForDisplay();
		System.out.println(header);
		for(Car car : carList) {
			StringBuffer carBuffer = prepareCarsStringForDisplay(car);
			System.out.println(carBuffer);
		}
	}

	private static StringBuffer prepareCarsHeaderForDisplay() {
		StringBuffer header = new StringBuffer();
		header.append("\n");
		header.append("CarShop");
		header.append("\n\n");
		header.append("ID:");
		header.append("\t\t");
		header.append("Manufacturer");
		header.append("\t\t");
		header.append("Model");
		header.append("\t\t");
		header.append("Horse-Power");
		header.append("\t\t");
		header.append("Price");
		header.append("\t\t");
		header.append("Color");
		header.append("\t\t");
		header.append("Mileage");
		header.append("\t\t");
		header.append("Production Year");
		header.append("\t\t");
		header.append("Fuel Type");
		header.append("\t\t");
		header.append("Transmission");
		header.append("\n");
		return header;
	}

	private static StringBuffer prepareCarsStringForDisplay(Car car) {
		StringBuffer carBuffer = new StringBuffer();
		carBuffer.append(car.getId()).append(".");
		carBuffer.append("\t\t");
		carBuffer.append(car.getManufacturer());
		carBuffer.append("\t\t\t");
		carBuffer.append(car.getModel());
		carBuffer.append("\t\t");
		carBuffer.append(car.getHorsePower());
		carBuffer.append("\t\t\t");
		carBuffer.append(car.getPrice());
		carBuffer.append("\t\t");
		carBuffer.append(car.getColor());
		carBuffer.append("\t\t");
		carBuffer.append(car.getMileage());
		carBuffer.append("\t\t\t");
		carBuffer.append(car.getProductionYear());
		carBuffer.append("\t\t");
		carBuffer.append(car.getFuelType());
		carBuffer.append("\t\t\t");
		carBuffer.append(car.getTransmission());
		return carBuffer;
	}
}
