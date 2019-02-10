package pl.lukas.rentCarCompany.domain;

import java.time.LocalDate;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Return {

    private Employee employee;
    private LocalDate returnDate;
    private Reservation reservation;
    private double extraCost;
    private String additionalInfo;
}
