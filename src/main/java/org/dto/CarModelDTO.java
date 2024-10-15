package org.dto;

import java.util.Objects;

public class CarModelDTO {
    private Integer id;
    private String brand;
    private String model;
    private String countryOrigin;
    private String countryCode;

    public CarModelDTO(Integer id, String brand, String model, String countryOrigin, String countryCode) {
        this.id = id;
        this.brand = brand;
        this.model = model;
        this.countryOrigin = countryOrigin;
        this.countryCode = countryCode;
    }

    public CarModelDTO(String brand, String model, String countryOrigin, String countryCode) {
        this.brand = brand;
        this.model = model;
        this.countryOrigin = countryOrigin;
        this.countryCode = countryCode;
    }

    public Integer getId() {
        return id;
    }

    public String getBrand() {
        return brand;
    }

    public String getModel() {
        return model;
    }

    public String getCountryOrigin() {
        return countryOrigin;
    }

    public String getCountryCode() {
        return countryCode;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public void setCountryOrigin(String countryOrigin) {
        this.countryOrigin = countryOrigin;
    }

    public void setCountryCode(String CountryCode) {
        this.countryCode = countryCode;
    }

    @Override
    public String toString() {
        return String.format("| %-6s | %-15s | %-35s | %-30s | %-12s |",
                id, brand, model, countryOrigin, countryCode);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass()  != o.getClass())
            return false;
        CarModelDTO car = (CarModelDTO) o;
        return id.equals(car.id) && brand.equals(car.brand) && model.equals(car.model) &&
                countryOrigin.equals(car.countryOrigin) && countryCode.equals(car.countryCode);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, brand, model, countryOrigin, countryCode);
    }
}

