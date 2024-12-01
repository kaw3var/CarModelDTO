package org.dto;

import java.util.ArrayList;
import java.util.List;

public class DealerCenterDTO {
    private Integer id;
    private String name;
    private String location;
    private List<CarDTO> cars;  // Все автомобили в дилерском центре
    private Integer countShowroomCars = 0;  // Количество автомобилей в шоуруме
    private List<CarDTO> carsInShowroom = new ArrayList<>();  // Список автомобилей в шоуруме

    public DealerCenterDTO(Integer id, String name, String location, List<CarDTO> cars) {
        this.id = id;
        this.name = name;
        this.location = location;
        this.cars = cars;
        this.carsInShowroom = new ArrayList<>();
    }

    // Геттеры и сеттеры
    public Integer getId() { return id; }

    public void setId(Integer id) { this.id = id; }

    public String getName() { return name; }

    public void setName(String name) { this.name = name; }

    public String getLocation() { return location; }

    public void setLocation(String location) { this.location = location; }

    public List<CarDTO> getCars() { return cars; }

    public void setCars(List<CarDTO> cars) { this.cars = cars; }

    public Integer getCountShowroomCars() { return countShowroomCars; }

    public void setCountShowroomCars(Integer countShowroomCars) { this.countShowroomCars = countShowroomCars; }

    public List<CarDTO> getCarsInShowroom() { return carsInShowroom; }

    public void setCarsInShowroom(List<CarDTO> carsInShowroom) { this.carsInShowroom = carsInShowroom; }

    @Override
    public String toString() {
        return String.format("DealerCenterDTO{id=%d, name='%s', location='%s', carsCount=%d, showroomCarsCount=%d} ",
                id, name, location, cars.size(), countShowroomCars);
    }
}
