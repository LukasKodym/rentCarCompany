package pl.lukas.rentCarCompany.domain;

import java.time.LocalDate;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Rent {

    private Employee employee;
    private LocalDate rentDate;
    private Reservation reservation;
    private String additionalInfo;
}
