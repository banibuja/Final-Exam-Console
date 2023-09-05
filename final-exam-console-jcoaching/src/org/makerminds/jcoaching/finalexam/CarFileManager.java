package org.makerminds.jcoaching.finalexam;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.Iterator;
import java.util.List;

public class CarFileManager {
	
	private String filePath;
	
	public CarFileManager(String filePath) {
		this.filePath = filePath;
	}
	
	public String[] importCarsFromFile(){
		try {			
			Path path = Paths.get(filePath);
			String carListLikeString = new String(Files.readAllBytes(path));
			return carListLikeString.split("\r\n");
		}
		catch (IOException e) {
			throw new RuntimeException("An error occurred while importing.", e);
		}
	}
	
	public void rewriteFile(List<Car> carList) {
		Path path = Paths.get(filePath);
		StringBuffer carStringForRewrite = new StringBuffer();
		Iterator<Car> iterator = carList.iterator();
		while(iterator.hasNext()) {
			Car car = iterator.next();
			prepareTheCarForRewriting(carStringForRewrite, car);
			carStringForRewrite.append("\r\n");
		}
		
		try {
			Files.write(path, carStringForRewrite.toString().getBytes(), StandardOpenOption.WRITE, StandardOpenOption.TRUNCATE_EXISTING);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	private void prepareTheCarForRewriting(StringBuffer carStringForRewrite, Car car) {
		carStringForRewrite.append(car.getId());
		carStringForRewrite.append(",");
		carStringForRewrite.append(car.getManufacturer());
		carStringForRewrite.append(",");
		carStringForRewrite.append(car.getModel());
		carStringForRewrite.append(",");
		carStringForRewrite.append(car.getHorsePower());
		carStringForRewrite.append(",");
		carStringForRewrite.append(car.getPrice());
		carStringForRewrite.append(",");
		carStringForRewrite.append(car.getColor());
		carStringForRewrite.append(",");
		carStringForRewrite.append(car.getMileage());
		carStringForRewrite.append(",");
		carStringForRewrite.append(car.getProductionYear());
		carStringForRewrite.append(",");
		carStringForRewrite.append(car.getFuelType());
		carStringForRewrite.append(",");
		carStringForRewrite.append(car.getTransmission());
	}

}
