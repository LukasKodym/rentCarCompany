package pl.lukas.rentCarCompany.domain;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@ToString
@Getter
@Setter
public class Car {

    private String brand;
    private String model;
    private CarTypesEnum carTypesEnum;
    private int productionDate;
    private String colour;
    private int mileage;
    private CarStatusEnum carStatusEnum;
    private double costPerDay;

    public Car(String brand, String model, CarTypesEnum carTypesEnum, int productionDate, String colour, int mileage, CarStatusEnum carStatusEnum, double costPerDay) {
        this.brand = brand;
        this.model = model;
        this.carTypesEnum = carTypesEnum;
        this.productionDate = productionDate;
        this.colour = colour;
        this.mileage = mileage;
        this.carStatusEnum = carStatusEnum;
        this.costPerDay = costPerDay;
    }
}
