package pl.lukas.rentCarCompany.Domain;

import lombok.Getter;
import lombok.Setter;
import sun.util.calendar.LocalGregorianCalendar;


@Getter
@Setter
public class Car {

    private String brand;
    private String model;
    private CarTypEnum carTypeEnum;
    private int productionDate;
    private String colour;
    private int mileage;
    private CarStatuEnum carStatuEnum;
    private double 

}
