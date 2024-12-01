package org.dto;

import java.util.List;

public class DealerCenterDTO {
    private Integer id;
    private String name;
    private String location;
    private List<CarDTO> cars;

    public DealerCenterDTO(Integer id, String name, String location, List<CarDTO> cars) {
        this.id = id;
        this.name = name;
        this.location = location;
        this.cars = cars;
    }

    public void setId(Integer id) { this.id = id; }

    public void setName(String name) { this.name = name; }

    public void setLocation(String location) { this.location = location; }

    public void setCars(List<CarDTO> cars) { this.cars = cars; }

    // Геттеры

    public Integer getId() { return id; }

    public String getName() { return name; }

    public String getLocation() { return location; }

    public List<CarDTO> getCars() { return cars; }

    @Override
    public String toString() {
        return String.format("DealerCenterDTO{id=%d, name='%s', location='%s', carsCount=%d}",
                id, name, location, cars.size());
    }
}
