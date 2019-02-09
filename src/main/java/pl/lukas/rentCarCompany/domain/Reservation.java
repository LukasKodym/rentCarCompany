package pl.lukas.rentCarCompany.domain;

import java.time.LocalDate;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
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
