package pl.lukas.rentCarCompany.domain;

import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
public class Car {

    private String brand;
    private String model;
    private CarTypEnum carTypeEnum;
    private int productionDate;
    private String colour;
    private int mileage;
    private CarStatusEnum carStatusEnum;
    private double costPerDay;



}
