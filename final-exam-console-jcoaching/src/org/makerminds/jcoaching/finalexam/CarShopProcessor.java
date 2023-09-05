package org.makerminds.jcoaching.finalexam;

import java.util.Iterator;
import java.util.List;

public class CarShopProcessor {
	
	public void sellCars(List<Car> carsList, int carChosenId) {
		Iterator<Car> iterator = carsList.iterator();
		while(iterator.hasNext()) {
			Car car = iterator.next();
			int id = car.getId();
			if(id == carChosenId) {
				iterator.remove();
			}
		}
	}
}
