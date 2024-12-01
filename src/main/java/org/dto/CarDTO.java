package org.dto;

public class CarDTO {
    private Integer id;
    private CarModelDTO carModel;
    private DealerCenterDTO dealerCenter;
    private String carStatus;
    private String configuration;
    private String color;
    private double price;

    public CarDTO(Integer id, CarModelDTO carModel, DealerCenterDTO dealerCenter, String carStatus, String configuration, String color, double price) {
        this.id = id;
        this.carModel = carModel;
        this.dealerCenter = dealerCenter;
        this.carStatus = carStatus;
        this.configuration = configuration;
        this.color = color;
        this.price = price;
    }

    public CarDTO() {

    }

    public void setId(Integer id) { this.id = id; }

    public void setCarModel(CarModelDTO carModel) { this.carModel = carModel; }

    public void setDealerCenter(DealerCenterDTO dealerCenter) { this.dealerCenter = dealerCenter; }

    public void setCarStatus(String carStatus) { this.carStatus = carStatus; }

    public void setConfiguration(String configuration) { this.configuration = configuration; }

    public void setColor(String color) { this.color = color; }

    public void setPrice(double price) { this.price = price; }

    // Геттеры

    public Integer getId() { return id; }

    public CarModelDTO getCarModel() { return carModel; }

    public DealerCenterDTO getDealerCenter() { return dealerCenter; }

    public String getCarStatus() { return carStatus; }

    public String getConfiguration() { return configuration;  }

    public String getColor() { return color; }

    public double getPrice() { return price; }

    @Override
    public String toString() {
        return String.format("CarDTO{id=%d, model=%s, status='%s', configuration='%s', color='%s', price=%.2f}",
                id, carModel.getModel(), carStatus, configuration, color, price);
    }
}
