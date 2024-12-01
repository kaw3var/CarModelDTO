package org.service;

import org.dto.DealerCenterDTO;
import org.dto.CarDTO;

import java.util.List;

public class DealerServiceImpl {

    public void processCar(DealerCenterDTO dealer, List<CarDTO> cars) {
        for (CarDTO car : cars) {
            // Эмулируем обработку автомобиля (например, с задержкой)
            heavyProcessing(car);
            
            // Если автомобиль соответствует критериям, добавляем в шоурум
            if (isNeedAddToShowroom(car)) {
                addToShowroomCars(dealer, car);
            }
        }
    }

    private void addToShowroomCars(DealerCenterDTO dealer, CarDTO car) {
        if (dealer == null || car == null) {
            return;
        }
        synchronized (dealer) {
            dealer.getCarsInShowroom().add(car);
            dealer.setCountShowroomCars(dealer.getCountShowroomCars() + 1);
        }
    }

    private boolean isNeedAddToShowroom(CarDTO car) {
        // Пример условий для добавления в шоурум
        return car.getColor().equals("Black") &&
               car.getCarModel().getBrand().equals("BMW") &&
               car.getCarModel().getModel().equals("X5") &&
               car.getConfiguration().equals("SuperPremium");
    }

    // Эмуляция тяжелой обработки
    private void heavyProcessing(CarDTO car) {
        try {
            Thread.sleep(100); // Задержка 100 миллисекунд на каждое авто
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}
