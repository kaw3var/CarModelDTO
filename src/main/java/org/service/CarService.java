package org.service;

import org.dto.CarModelDTO;

import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class CarService {
    private List<CarModelDTO> carList;

    public CarService(List<CarModelDTO> carList) {
        this.carList = carList;
    }

    public Set<String> getUniqueBrands() {
        long startTime = System.nanoTime();
        Set<String> result = carList.stream()
                .map(CarModelDTO::getBrand)
                .collect(Collectors.toSet());
        long endTime = System.nanoTime();
        double durationInSeconds = (endTime - startTime) / 1_000_000_000.0;
        System.out.println("getUniqueBrands выполнено за: " + durationInSeconds + " секунд");
        return result;
    }

    public List<CarModelDTO> getModelsByBrand(String brand) {
        long startTime = System.nanoTime();
        List<CarModelDTO> result = carList.stream()
                .filter(car -> car.getBrand().equalsIgnoreCase(brand))
                .collect(Collectors.toList());
        long endTime = System.nanoTime();
        double durationInSeconds = (endTime - startTime) / 1_000_000_000.0;
        System.out.println("getModelsByBrand выполнено за: " + durationInSeconds + " секунд");
        return result;
    }

    public Map<String, Integer> groupByBrand() {
        long startTime = System.nanoTime();
        Map<String, Integer> result = carList.stream()
                .collect(Collectors.groupingBy(CarModelDTO::getBrand, Collectors.summingInt(c -> 1)));
        long endTime = System.nanoTime();
        double durationInSeconds = (endTime - startTime) / 1_000_000_000.0;
        System.out.println("groupByBrand выполнено за: " + durationInSeconds + " секунд");
        return result;
    }

    public CarModelDTO findCarById(CarModelDTO carModel) {
        long startTime = System.nanoTime();
        int index = carList.indexOf(carModel);
        CarModelDTO result = index != -1 ? carList.get(index) : null;
        long endTime = System.nanoTime();
        double durationInSeconds = (endTime - startTime) / 1_000_000_000.0;
        System.out.println("findCarById выполнено за: " + durationInSeconds + " секунд");
        return result;
    }
}
