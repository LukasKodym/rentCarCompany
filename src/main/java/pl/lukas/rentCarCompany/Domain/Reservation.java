package pl.lukas.rentCarCompany.Domain;

import java.time.LocalDate;

public class Reservation {

    private LocalDate reservationDate;
    private Consumer consumer;
    private Car car;
    private LocalDate fromDate;
    private LocalDate toDate;
    private Department startDepartment;
    private Department finishDepartment;
    private double finalCost;

}
