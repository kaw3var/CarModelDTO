package org.entity;

import javax.persistence.*;

@Entity
@Table(name = "Car")
public class CarEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "car_model_id", nullable = false)
    private CarModelEntity carModel;

    @ManyToOne
    @JoinColumn(name = "dealer_center_id", nullable = false)
    private DealerEntity dealerCenter;

    @Column(name = "car_status", nullable = false, length = 50)
    private String carStatus;

    @Column(name = "configuration", length = 100)
    private String configuration;

    @Column(name = "color", length = 50)
    private String color;

    @Column(name = "price")
    private Double price;

    // Getters and Setters
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public CarModelEntity getCarModel() {
        return carModel;
    }

    public void setCarModel(CarModelEntity carModel) {
        this.carModel = carModel;
    }

    public DealerEntity getDealerCenter() {
        return dealerCenter;
    }

    public void setDealerCenter(DealerEntity dealerCenter) {
        this.dealerCenter = dealerCenter;
    }

    public String getCarStatus() {
        return carStatus;
    }

    public void setCarStatus(String carStatus) {
        this.carStatus = carStatus;
    }

    public String getConfiguration() {
        return configuration;
    }

    public void setConfiguration(String configuration) {
        this.configuration = configuration;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }
}
