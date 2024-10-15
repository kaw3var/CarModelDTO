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
        return carList.stream()
                .map(CarModelDTO::getBrand)
                .collect(Collectors.toSet());
    }

    public List<CarModelDTO> getModelsByBrand(String brand) {
        return carList.stream()
                .filter(car -> car.getBrand().equalsIgnoreCase(brand))
                .collect(Collectors.toList());
    }

    public Map<String, Integer> groupByBrand() {
        return carList.stream()
                .collect(Collectors.groupingBy(CarModelDTO::getBrand, Collectors.summingInt(c -> 1)));
    }
}